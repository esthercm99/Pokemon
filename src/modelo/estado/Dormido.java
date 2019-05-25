package modelo.estado;

import modelo.factoria.Pokemon;

public class Dormido implements Estado {
	@Override
	public String atacar(Pokemon atacante, Pokemon oponente) {
		String resultado;
		
		if (atacante.getTurnosSinJugar() != 0) {
			resultado = String.format("%s no puede atacar, está dormido.", atacante.getEspecie().getNombreEspecie());
			atacante.setTurnosSinJugar(atacante.getTurnosSinJugar()-1);
			if (atacante.getTurnosSinJugar() == 0) {
				atacante.moveToSanoState();
			}
		} else {
			resultado = atacante.getActualAtaque().getCategoria().atacar(oponente, atacante);
		}
		return resultado;
	}
}
