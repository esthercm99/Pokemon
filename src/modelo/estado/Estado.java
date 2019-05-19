package modelo.estado;

import modelo.Especie;

public interface Estado {
	void dormido(Especie pokemon);
	void paralizado(Especie pokemon);
	void envenenado(Especie pokemon);
}
