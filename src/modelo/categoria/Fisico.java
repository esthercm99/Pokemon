package modelo.categoria;

import java.util.Random;

import modelo.factoria.Pokemon;
import modelo.pokemon.Ataque;

public class Fisico implements Categoria {

	@Override
	public String atacar(Pokemon oponente, Pokemon atacante) {
		double damage = damage(atacante, oponente);
		oponente.setVida(oponente.getVida() - damage);
		return String.format("%s ha hecho %.2f de daño con un ataque físico a %s.", atacante.getEspecie().getNombreEspecie(), damage, oponente.getEspecie().getNombreEspecie());
	}
	

	private double damage(Pokemon atacante, Pokemon oponente) {
		Random rnd = new Random();
		Ataque ataque = atacante.getActualAtaque();
		double b, e, total;
		int n = oponente.getNivel(), a,	p = ataque.getPotencia(), d, v = rnd.nextInt(15)+85+1;

		a = atacante.getEspecie().getAtaque();
		d = oponente.getEspecie().getDefensa();

		// Si el ataque es del mismo tipo que el pokemon que lo lanza
		if(ataque.getTipo().getIdTipo() == atacante.getEspecie().getTipo().getIdTipo() || ataque.getTipo().getIdTipo() == atacante.getEspecie().getSubTipo().getIdTipo()) {
			b = 1.5;
		} else {
			b = 1;
		}
		
		e = ataque.getEfectividades().get(oponente.getEspecie().getTipo());
		
		total = 0.01 * b * e * v * ( ( ((0.2*n+1)*a*p) / (25 * d) ) + 2);
		
		return total;
	}
}
