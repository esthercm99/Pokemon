package modelo.categoria;

import modelo.factoria.Pokemon;

public class EstadoEnvenenado implements Categoria {

	@Override
	public String atacar(Pokemon oponente, Pokemon atacante) {
		String resultado;
		
		if (oponente.getEstado().getClass().getSimpleName().equals("Sano")) {
			oponente.moveToEnvState();
			oponente.setVida(oponente.getVida()-(oponente.getVida()*(1/8)));
			oponente.setTurnosSinJugar(5);
			resultado = String.format("%s se quedó %s. Se queda %d turnos sin atacar.", oponente.getEspecie().getNombreEspecie(), oponente.getEstado().getClass().getSimpleName().toLowerCase(), oponente.getTurnosSinJugar());
		} else {
			resultado = String.format("El ataque no le hizo efecto, el pokémon rival está %s", oponente.getEstado().getClass().getSimpleName().toLowerCase());
		}
		return resultado;
	}

}
