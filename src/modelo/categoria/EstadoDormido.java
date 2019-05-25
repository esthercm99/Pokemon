package modelo.categoria;

import java.util.Random;

import modelo.factoria.Pokemon;

public class EstadoDormido implements Categoria {

	@Override
	public String atacar(Pokemon oponente, Pokemon atacante) {
		String resultado;
		Random rnd = new Random();
		
		if (oponente.getEstado().getClass().getSimpleName().equals("Sano")) {
				oponente.moveToDorState();
			oponente.setTurnosSinJugar(rnd.nextInt(5)+1);
			resultado = String.format("%s se quedó %s. Se queda %d turnos sin atacar.", oponente.getEspecie().getNombreEspecie(), oponente.getEstado().getClass().getSimpleName().toLowerCase(), oponente.getTurnosSinJugar());
		} else {
			resultado = String.format("El ataque no le hizo efecto, el pokémon rival está %s", oponente.getEstado().getClass().getSimpleName().toLowerCase());
		}
		return resultado;
	}
	
}
