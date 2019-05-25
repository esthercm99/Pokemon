package modelo.factoria;

import modelo.estado.*;
import modelo.pokemon.Ataque;
import modelo.pokemon.Especie;

public class Pokemon {

	private double vida;
	private double velocidad;
	private Especie especie;
	private Ataque actualAtaque;
	private int turnosSinJugar = 0;
	
	private final int NIVEL = 50;
	
	private Estado estado;
	private Sano sano = new Sano();
	private Dormido dormido = new Dormido();
	private Paralizado paralizado = new Paralizado();
	private Envenenado envenenado = new Envenenado();
	
	public Pokemon(Especie especie) {
		this.especie = especie;
		vida = especie.getVida();
		velocidad = especie.getVelocidad();
		estado = sano;
	}
	
	public Estado getEstado() {
		return estado;
	}
	public Especie getEspecie() {
		return especie;
	}
	public double getVida() {
		return vida;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public int getTurnosSinJugar() {
		return turnosSinJugar;
	}
	public int getNivel() {
		return NIVEL;
	}
	
	public void setVida(double vida) {
		this.vida = vida;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public void setTurnosSinJugar(int turnosSinJugar) {
		this.turnosSinJugar = turnosSinJugar;
	}
	
	
	public String atacar(Pokemon oponente, int opcionAtaque) {
		actualAtaque = this.getEspecie().getAtaques().get(opcionAtaque);
		return estado.atacar(this, oponente);
	}
	
	public void moveToSanoState() {
		estado = sano;
	}
	public void moveToParState() {
		estado = paralizado;
	}
	public void moveToDorState() {
		estado = dormido;
	}
	public void moveToEnvState() {
		estado = envenenado;
	}

	public Ataque getActualAtaque() {
		return actualAtaque;
	}

	public void setActualAtaque(Ataque actualAtaque) {
		this.actualAtaque = actualAtaque;
	}
	
	public String toString() {
		return String.format("Pokémon: %s%nVida: %.2f%nVelocidad: %.2f%n", especie.getNombreEspecie(), vida, velocidad);
	}
}