package modelo.estado;

import java.util.Random;

import modelo.factoria.Pokemon;

public class Paralizado implements Estado {
	@Override
	public String atacar(Pokemon atacante, Pokemon oponente) {
		String resultado;
		Random rnd = new Random();
		
		if(rnd.nextInt(100) + 1 <= 25) {
			resultado = String.format("Tu pokémon no puede atacar, está paralizado.");
		} else {
			resultado = atacante.getActualAtaque().getCategoria().atacar(oponente, atacante);

		}
		return resultado;
	}
}
