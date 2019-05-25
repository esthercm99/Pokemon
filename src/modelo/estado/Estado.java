package modelo.estado;

import modelo.factoria.Pokemon;

public interface Estado {
	public String atacar(Pokemon atacante, Pokemon oponente);
}
