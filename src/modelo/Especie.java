package modelo;

import java.util.HashMap;
import java.util.Map;

public class Especie {	
	private int idEspecie;
	private String nombreEspecie;
	private int vida;
	private int velocidad;
	private int ataque;
	private int defensa;
	private int ataqueEsp;
	private int defensaEsp;
	
	private Tipo tipo;
	private Tipo subtipo;
	private Map<Integer, Ataque> ataques = new HashMap<>();
		
	// Con subtipo:
	public Especie(String[] string, Tipo tipo, Tipo subtipo, Map<Integer, Ataque> ataques) {
		idEspecie = Integer.parseInt(string[0]);
		nombreEspecie = string[1];
		vida = Integer.parseInt(string[2]);
		velocidad = Integer.parseInt(string[3]);
		ataque = Integer.parseInt(string[4]);
		defensa = Integer.parseInt(string[5]);
		ataqueEsp = Integer.parseInt(string[6]);
		defensaEsp = Integer.parseInt(string[7]);
		this.tipo = tipo;
		this.subtipo = subtipo;
		this.ataques = ataques;
	}
	// Sin subtipo:
	public Especie(String[] string, Tipo tipo, Map<Integer, Ataque> ataques) {
		String[] noSub = {"0", "NULL"};
		
		idEspecie = Integer.parseInt(string[0]);
		nombreEspecie = string[1];
		vida = Integer.parseInt(string[2]);
		velocidad = Integer.parseInt(string[3]);
		ataque = Integer.parseInt(string[4]);
		defensa = Integer.parseInt(string[5]);
		ataqueEsp = Integer.parseInt(string[6]);
		defensaEsp = Integer.parseInt(string[7]);
		this.tipo = tipo;
		this.subtipo = new Tipo(noSub);
		this.ataques = ataques;
		
	}
	
	public int getIdEspecie() {
		return idEspecie;
	}
	public String getNombreEspecie() {
		return nombreEspecie;
	}
	public int getVida() {
		return vida;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public int getAtaque() {
		return ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public int getAtaqueEspecial() {
		return ataqueEsp;
	}
	public int getDefensaEspecial() {
		return defensaEsp;
	}
	public Tipo getTipo() {
		return tipo;
	}
	public Tipo getSubTipo() {
		return subtipo;
	}
	public Map<Integer, Ataque> getAtaques() {
		return ataques;
	}
}
