package modelo.pokemon;

public class Efectividad {
	private Tipo ataque;
	private Tipo pokemon;
	private double multiplicador;	
	
	public Efectividad(Tipo ataque, Tipo pokemon, double multiplicador) {
		this.ataque = ataque;
		this.pokemon = pokemon;
		this.multiplicador = multiplicador;
	}

	public Tipo getAtaque() {
		return ataque;
	}
	public Tipo getPokemon() {
		return pokemon;
	}
	public double getMultiplicador() {
		return multiplicador;
	}
}
