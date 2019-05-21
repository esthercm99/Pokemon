package modelo;

public class Tipo {
	private int idTipo;
	private String nombreTipo;
	
	public Tipo(String[] string) {
		idTipo = Integer.parseInt(string[0]);
		nombreTipo = string[1];
	}
	
	public int getIdTipo() {
		return idTipo;
	}
	public String getNombreTipo() {
		return nombreTipo;
	}
	
	public String toString() {
		return String.format("%d", idTipo);
	}
}