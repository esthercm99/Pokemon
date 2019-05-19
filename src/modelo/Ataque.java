package modelo;

import modelo.categoria.Categoria;

public class Ataque {
	
	private int idAtaque;
	private String nombreAtaque;
	private int potencia;
	private int precision;
	private Categoria categoria;
	private Tipo tipo;
//	Map <Tipo, Double> -> Desaparece Clase Efectividad(?)
//	Map <Integer, Efectividad> -> IdAtaque, Efectividad correspondiente con el tipo
	
	public Ataque(String[] string) {
		idAtaque = Integer.parseInt(string[0]);
		nombreAtaque = string[1];
		potencia = Integer.parseInt(string[2]);
		precision = Integer.parseInt(string[3]);
		
	}
	
	private Categoria IntToCategoria(int num) {
		return categoria;
	}
}
