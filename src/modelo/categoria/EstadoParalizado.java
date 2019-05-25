package modelo.categoria;

import modelo.factoria.Pokemon;

public class EstadoParalizado implements Categoria {
	@Override
	public String atacar(Pokemon oponente, Pokemon atacante) {
		String resultado;
		
		if (oponente.getEstado().getClass().getSimpleName().equals("Sano")) {
			oponente.moveToParState();
			oponente.setVelocidad(oponente.getVelocidad()*0.5);
			resultado = String.format("%s se quedó %s.", oponente.getEspecie().getNombreEspecie(), oponente.getEstado().getClass().getSimpleName().toLowerCase());
		} else {
			resultado = String.format("El ataque no le hizo efecto, el pokémon rival está %s", oponente.getEstado().getClass().getSimpleName().toLowerCase());
		}
		return resultado;
	}
}
