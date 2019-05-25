package modelo.combate;

import presentador.Presenter;
import presentador.PresenterUsuario;

public class Usuario extends Entrenador implements PresenterUsuario {
	private Presenter presenter = new Presenter();
	
	@Override
	public void requestName() {
		setNombreEntrenador(presenter.requestName());
	}
	@Override
	public int requestOption() {
		return presenter.requestOption();
	}
	@Override
	public int requestAttack() {
		String str = String.format("\t1. %s%n\t2. %s%n\t3. %s%n\t4. %s%n", getPokemonActual().getEspecie().getAtaques().get(1).getNombreAtaque(),
																		   getPokemonActual().getEspecie().getAtaques().get(2).getNombreAtaque(),
																		   getPokemonActual().getEspecie().getAtaques().get(3).getNombreAtaque(),
																		   getPokemonActual().getEspecie().getAtaques().get(4).getNombreAtaque());
		return presenter.requestAttack(str);
	}
	@Override
	public int requestPokemon(String listaPokemons, int numPokemons) {
		return presenter.requestPokemon(listaPokemons, numPokemons);
	}

	
	@Override
	public String luchar(Entrenador oponente) {
		int option = requestAttack();
		return getPokemonActual().atacar(oponente.getPokemonActual(), option);	
	}
	@Override
	public void cambiar() {
		int option;
		boolean exit = false;	
		String listaPokemons = "";
		for(int i = 0; i < getListaPokemon().size(); i++) {
			listaPokemons = listaPokemons + String.format("\t%d. %s%n", i+1, getListaPokemon().get(i).getEspecie().getNombreEspecie());
		}
		
		do {
			if(getListaPokemon().size() > 1) {
				option = requestPokemon(listaPokemons, getListaPokemon().size())-1;
			} else {
				option = 0;
			}
			
			if (getListaPokemon().get(option).getVida()>0) {
				exit = true;
				setPokemonActual(getListaPokemon().get(option));
			} else {
				presenter.mensajeError("Este pokémon no tiene vida.\n");
			}
		} while(!exit);		
	}
	@Override
	public int seleccionarOpcion() {
		return requestOption();
	}
}