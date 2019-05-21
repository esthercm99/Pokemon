package modelo.estado;

import modelo.pokemon.Especie;

public interface Estado {
	void dormido(Especie pokemon);
	void paralizado(Especie pokemon);
	void envenenado(Especie pokemon);
}
