package modelo.combate;

import java.util.Random;

public class Maquina extends Entrenador {

	@Override
	public String luchar(Entrenador oponente) {
		Random rnd = new Random();		
		return getPokemonActual().atacar(oponente.getPokemonActual(), rnd.nextInt(4)+1);
	}
	@Override
	public void cambiar() {
		int option;
		boolean exit = false;
		Random rnd = new Random();
		do {
			option = rnd.nextInt(getListaPokemon().size());
			
			if (getListaPokemon().get(option).getVida()>0) {
				exit = true;
				setPokemonActual(getListaPokemon().get(option));
			}
		} while(!exit);
	}
	@Override
	public int seleccionarOpcion() {
		return 2;
	}
}
