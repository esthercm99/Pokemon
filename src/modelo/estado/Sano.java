package modelo.estado;

import modelo.factoria.Pokemon;

public class Sano implements Estado {
	@Override
	public String atacar(Pokemon atacante, Pokemon oponente) {
		return atacante.getActualAtaque().getCategoria().atacar(oponente, atacante);
	}
}
