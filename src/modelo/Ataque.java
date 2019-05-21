package modelo;

import java.util.HashMap;
import java.util.Map;
import modelo.categoria.*;

public class Ataque {
	
	private int idAtaque;
	private String nombreAtaque;
	private int potencia;
	private int precision;
	private Tipo tipo;
	private Map <Tipo, Double> efectividades = new HashMap<>();
	
	private Categoria categoria;	
	private final Fisico fisico = new Fisico();
	private final Especial especial = new Especial();
	private final EstadoDormido estDormido = new EstadoDormido();
	private final EstadoParalizado estParalizado = new EstadoParalizado();
	private final EstadoEnvenenado estEnvenedado = new EstadoEnvenenado();
	
	public Ataque(String[] string, Tipo tipo, Map <Tipo, Double> efectividades) {
		idAtaque = Integer.parseInt(string[0]);
		nombreAtaque = string[1];
		potencia = Integer.parseInt(string[2]);
		precision = Integer.parseInt(string[3]);
		categoria = stringToCategoria(string[4]);
		this.tipo = tipo;
		this.efectividades = efectividades;
	}

	public Map <Tipo, Double> getEfectividades() {
		return efectividades;
	}
	public int getIdAtaque() {
		return idAtaque;
	}
	public Tipo getTipo() {
		return tipo;
	}
	
	private Categoria stringToCategoria(String str) {
		Categoria cat = null;
		
		switch(str) {
			case "FISICO":
				cat = (Categoria)fisico;
				break;
			case "ESPECIAL":
				cat = (Categoria)especial;
				break;
			case "ESTADODOR":
				cat = (Categoria)estDormido;
				break;
			case "ESTADOPAR":
				cat = (Categoria)estParalizado;
				break;
			case "ESTADOENV":
				cat = (Categoria)estEnvenedado;
				break;
		}
		
		return cat;
	}
	
	public void showInformation() {
		System.out.printf("IdAtaque: %d%nNombre: %s%nPotencia: %d%nPrecisión: %d%nIdTipo: %d%nCategoría: %s", idAtaque, nombreAtaque, potencia, precision, tipo.getIdTipo(), categoria.getClass().getSimpleName());
	}
}
