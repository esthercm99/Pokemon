package modelo;

import java.util.List;

public class Especie {
	public Especie(String[] string) {
		idEspecie = Integer.parseInt(string[0]);
		nombreEspecie = string[1];
		vida = Integer.parseInt(string[2]);
		velocidad = Integer.parseInt(string[3]);
		ataque = Integer.parseInt(string[4]);
		defensa = Integer.parseInt(string[5]);
		ataqueEsp = Integer.parseInt(string[6]);
		defensaEsp = Integer.parseInt(string[7]);
	}
	
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
	private List<Ataque> ataques;
}
