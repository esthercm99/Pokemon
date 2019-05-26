package modelo.estado;

import modelo.factoria.Pokemon;

public class Envenenado implements Estado {
	@Override
	public String atacar(Pokemon atacante, Pokemon oponente) {
		
		String resultado;
		
		resultado = atacante.getActualAtaque().getCategoria().atacar(oponente, atacante);
		
		if (atacante.getTurnosSinJugar() != 0) {
			atacante.setVida(atacante.getVida()-(atacante.getVida()/8));
			resultado = String.format("%s%nA %s le ha bajado la vida a %.2f", resultado, atacante.getEspecie().getNombreEspecie(), atacante.getVida());
			atacante.setTurnosSinJugar(atacante.getTurnosSinJugar()-1);
			if (atacante.getTurnosSinJugar() == 0) {
				atacante.moveToSanoState();
			}
		}
		return resultado;
	}
}
