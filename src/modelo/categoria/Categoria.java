package modelo.categoria;

import modelo.factoria.Pokemon;

public interface Categoria {
	public String atacar(Pokemon oponente, Pokemon atacante);
}