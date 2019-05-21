package modelo.combate;

import modelo.estado.Estado;
import modelo.pokemon.Especie;

public class Pokemon {
	private Especie especie;
	private int vida;
	private int velocidad;
	private Estado estado;
	private int turnosSinJugar;
	private final int nivel = 50;
	
	
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		this.vida = vida;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public void atacar(int ataque, Pokemon oponente) {
	}
	public void moveToParState() {		
	}
	public void moveToDorState() {
	}
	public void moveToEnvState() {
	}
}