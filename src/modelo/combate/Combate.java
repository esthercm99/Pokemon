package modelo.combate;

import java.util.Random;

import presentador.*;

public class Combate implements PresenterCombate {
	
	Presenter presenter = new Presenter();
	
	private Entrenador entrenador1 = new Usuario();
	private Entrenador entrenador2 = new Maquina();
		
	public void partida() {
		boolean isJ1Surrender = false, isJ2Surrender = false, exit = false;
		crearEntrenadores();
		do {
			// Empieza entrenador 1:
			if (comprobarVelocidades(entrenador1, entrenador2)) {
				isJ1Surrender = combate(entrenador1, entrenador2);
				if (!isJ1Surrender) {
					// Empieza entrenador 2:
					if(entrenador2.getPokemonActual().getVida() <= 0.0) {
						presenter.showFight(String.format("%s se ha debilitado.", entrenador2.getPokemonActual().getEspecie().getNombreEspecie()));
						entrenador2.getListaPokemon().remove(entrenador2.getPokemonActual());
						isJ2Surrender = entrenador2.areAllPokemonAlive();
						if (!isJ2Surrender) {
							isJ2Surrender = combate(entrenador2, entrenador1);
							isJ1Surrender = comprobarVida(entrenador1);
						}
					} else {
						isJ2Surrender = combate(entrenador2, entrenador1);
						isJ1Surrender = comprobarVida(entrenador1);
					}
				}
			// Empieza entrenador 2:
			} else {
				isJ2Surrender = combate(entrenador2, entrenador1);
				if (!isJ2Surrender) {
					// Empieza entrenador 1:
					if(entrenador1.getPokemonActual().getVida() <= 0.0) {
						presenter.showFight(String.format("%s se ha debilitado.", entrenador1.getPokemonActual().getEspecie().getNombreEspecie()));
						entrenador1.getListaPokemon().remove(entrenador1.getPokemonActual());
						presenter.showFight("---------------------------------------------------------------------------------------");
						isJ1Surrender = entrenador1.areAllPokemonAlive();
						if (!isJ1Surrender) {
							isJ1Surrender = combate(entrenador1, entrenador2);
							isJ2Surrender = comprobarVida(entrenador2);
						}
					} else {
						isJ1Surrender = combate(entrenador1, entrenador2);
						isJ2Surrender = comprobarVida(entrenador2);
					}
				}
			}
			
			if(isJ1Surrender) {
				exit = true;
				if(entrenador1.getListaPokemon().size() == 0) {
					presenter.showFight(String.format("%s se ha quedado sin pokémons.%n", entrenador1.getNombreEntrenador()));
				} else {
					presenter.showFight(String.format("%s se ha rendido.%n", entrenador1.getNombreEntrenador()));
				}
				presenter.showFight(String.format("Ha ganado %s.", entrenador2.getNombreEntrenador()));
			} else if(isJ2Surrender) {
				exit = true;
				if(entrenador2.getListaPokemon().size() == 0) {
					presenter.showFight(String.format("%s se ha quedado sin pokémons.%n", entrenador2.getNombreEntrenador()));
				} else {
					presenter.showFight(String.format("%s se ha rendido.%n", entrenador2.getNombreEntrenador()));
				}
				presenter.showFight(String.format("Ha ganado %s.", entrenador1.getNombreEntrenador()));
			}
			
		} while(!exit);
		
	}
	
	private void crearEntrenadores() {
		entrenador1.setNombreEntrenador(presenter.requestName());
		entrenador2.setNombreEntrenador("Máquina sin IA");
	}
	
	// Devolver boleean si el entrenador se rinde.
	public boolean combate(Entrenador atacante, Entrenador oponente) {
		boolean isSurrender = false;
		int option;
		
		presenter.showFight(String.format("\n---------------------------------------------------------------------------------------\n                            Turno de %s                                \n---------------------------------------------------------------------------------------\n", atacante.getNombreEntrenador()));
		presenter.showFight(String.format("%n> Pokémon de %s:%n%s%n> Pokémon de %s:%n%s", atacante.getNombreEntrenador(), atacante.getPokemonActual().toString(), oponente.getNombreEntrenador(), oponente.getPokemonActual().toString()));
		
		option = atacante.seleccionarOpcion();
	
		switch(option) {
			case 1:				// Cambiar de pokémon
				atacante.cambiar();
				presenter.showFight("El entrenador ha cambiado de pokémon.\n");
				break;
			case 2:				// Luchar
				presenter.showFight(atacante.luchar(oponente));
				comprobarVida(entrenador2);
				break;
			case 3:				// Rendirse
				isSurrender = atacante.rendirse();
				break;
		}
		
		
		
		return isSurrender;
	}
	
	private boolean comprobarVelocidades(Entrenador e1, Entrenador e2) {
		boolean result = false;
		Random rnd = new Random();
		
		if(e1.getPokemonActual().getVelocidad() > e2.getPokemonActual().getVelocidad()) {
			result = true;
		} else if(e1.getPokemonActual().getVelocidad() == e2.getPokemonActual().getVelocidad()) {
			result = rnd.nextBoolean();
		} else if(e1.getPokemonActual().getVelocidad() < e2.getPokemonActual().getVelocidad()) {
			result = false;
		}
		
		return result;
	}
	
	private boolean comprobarVida(Entrenador entrenador) {
		boolean surrender = false;
		if(entrenador.getPokemonActual().getVida() <= 0.0) {
			presenter.showFight(String.format("%s se ha debilitado.", entrenador.getPokemonActual().getEspecie().getNombreEspecie()));
			entrenador.getListaPokemon().remove(entrenador.getPokemonActual());
			surrender = entrenador.areAllPokemonAlive();
		}
		return surrender;
	}
	
	@Override
	public void showFight(String string) {
		presenter.showFight(string);	
	}
}