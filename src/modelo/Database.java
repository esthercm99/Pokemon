package modelo;

import java.util.List;
import java.util.Map;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Database {
	
	INSTANCE;
	
	private Map<Integer, Tipo> tipos = new HashMap<>();
	private Map<Tipo, Map<Tipo, Double>> efectividades = new HashMap<>();
	private Map<Integer, Ataque> ataques = new HashMap<>();
	private Map<Integer, Especie> especies = new HashMap<>();

	Database() {
		loadTipos();
		loadEfectividades();
		loadAtaques();
		//loadEspecies();
	}
	
	public static void main(String[] args) {
		Database d = Database.INSTANCE;
		
		// Tipos
		System.out.println("Tipos");
		for(int i = 1; i <= d.tipos.size(); i++) {
			System.out.printf("%d %s%n", d.tipos.get(i).getIdTipo(), d.tipos.get(i).getNombreTipo());
		}
		
		
		System.out.println("\nEfectividades");
		
		for(int i = 1; i <= d.tipos.size(); i++) {
			for(int j = 1; j <= d.tipos.size(); j++) {
				System.out.printf("%d %d %.1f%n", i, j, d.efectividades.get(d.tipos.get(i)).get(d.tipos.get(j)));
			}
			System.out.println();
		}
		
		
//		Ataques	
		System.out.println("\nAtaques");
		for(int i = 1; i <= d.ataques.size(); i++) {
			d.ataques.get(i).showInformation();
			System.out.println("\n");
		}
	}
	
	private List<String[]> leerFichero(String fichero){
        Stream<String> linea;
        List<String[]> collect = null;
        String pokemons[][] = new String[0][];
        ArrayList<String> listaFichero = new ArrayList<>();
        
        try(BufferedReader objReader=new BufferedReader(new FileReader(fichero))){
            linea = objReader.lines();
            linea.forEach(listaFichero::add);
            
            pokemons = new String[listaFichero.size()][];
            
            for (int i = 0; i < listaFichero.size(); i++) {
                pokemons[i] = listaFichero.get(i).split(";");
            }
            
            collect = Arrays.stream(pokemons).collect(Collectors.toList());            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }         
        
        return collect;
    }
    
    private void loadTipos() {
    	List<String[]> lista = leerFichero("Database/FicheroTipos.csv");
    	
    	for(int i = 0; i < lista.size(); i++) {
    		tipos.put(i+1, new Tipo(lista.get(i)));
    	}
    }    
    private void loadEfectividades() {
    	List<String[]> lista = leerFichero("Database/FicheroEfectividades.csv"); 
 
    	efectividades = lista.stream()
    						 .collect(Collectors.groupingBy(array -> tipos.get(Integer.parseInt(array[0])), 
    								  Collectors.toMap(array -> tipos.get(Integer.parseInt(array[1])), array -> Double.parseDouble(array[2]))));
	}
    private void loadAtaques() {
    	List<String[]> listaMovimientos = leerFichero("Database/FicheroMovimientos.csv");
    	    	
    	for(int i = 0; i < listaMovimientos.size(); i++) {    		
    		ataques.put(i+1, 
    					new Ataque(listaMovimientos.get(i), 														// Cadena con la información
    							   tipos.get(Integer.parseInt(listaMovimientos.get(i)[5])), 						// Tipo
    							   efectividades.get(tipos.get(Integer.parseInt(listaMovimientos.get(i)[5])))));	// Mapa de efectividades
    	}
    }
 
    private void loadEspecies() {
    	List<String[]> lista = leerFichero("Database/FicheroEspecies.csv");
    	//lista.stream().forEach(string -> especies.put(Integer.parseInt(string[0]), new Especie(string)));    	
    }   
}