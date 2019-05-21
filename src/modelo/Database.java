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
import java.util.stream.Collector;
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
		//loadAtaques();
		//loadEspecies();
	}
	
	public static void main(String[] args) {
		Database d = Database.INSTANCE;
		
		// Tipos
		System.out.println("Tipos");
		for(int i = 0; i < d.tipos.size(); i++) {
			System.out.printf("%d %s%n", d.tipos.get(i).getIdTipo(), d.tipos.get(i).getNombreTipo());
		}
		
		
		System.out.println("\nEfectividades");
		
		for(int i = 0; i < d.efectividades.size(); i++) {
			for(int j = 0; j < d.tipos.size(); j++) {
				System.out.printf("%d %d %.1f%n", d.efectividades.get(d.tipos.get(i)).getAtaque().getIdTipo(), d.efectividades.get(d.tipos.get(j)).getPokemon().getIdTipo(), d.efectividades.get(d.tipos.get(j)).getMultiplicador());
			}
			System.out.println();
		}
		
		/*
//		Ataques	
		System.out.println("\nAtaques");
		for(int i = 0; i< d.ataques.size(); i++) {
			d.ataques.get(i).mostrarDatos();
			System.out.println();
		}*/
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
    	List<String[]> lista;
    	lista = leerFichero("Database/FicheroTipos.csv");   	
    	for(int i = 0; i < lista.size(); i++) {
    		tipos.put(i+1, new Tipo(lista.get(i)));
    	}
    }    
    private void loadEfectividades() {
    	List<String[]> lista;
    	lista = leerFichero("Database/FicheroEfectividades.csv"); 
    	
    	// No borrar
    	lista.stream()
    		 .collect(Collectors.groupingBy(array -> tipos.get(Integer.parseInt(array[0])), 
    				  	Collectors.toMap(array -> tipos.get(Integer.parseInt(array[1])), 
    				  					 array -> Double.parseDouble(array[2])   )
    				  			)  );
    	
    	
    	
	}
    
    private void loadAtaques() {
    	Tipo tipo;
    	List<String[]> listaMovimientos;
    	
    	listaMovimientos = leerFichero("Database/FicheroMovimientos.csv");
    	
    	for(int i = 0; i < listaMovimientos.size(); i++) {
    		
    		
    		
    		//efectividades.stream()
    		//			   .filter(array -> array[5].equals());
    		//ataques.put(Integer.parseInt(listaMovimientos.get(i)[0]), new Ataque(listaMovimientos.get(i), tipo, )));
    	}
    	
    	/*for(int i = 0; i < listaMovimientos.size(); i++) {
    		
    	}*/
    	
    	
    	// ---- No válido ----
    	
    	
    	/*System.out.println(efectividades.size() + " " + efectividades.get(0)[0].length()  + " " + efectividades.get(0)[1].length() + " " + efectividades.get(0)[2].length());
    	for(int j = 0; j < efectividades.size(); j++) {
    		System.out.println(efectividades.get(j)[0]  + " " + efectividades.get(j)[1] + " " + efectividades.get(j)[2]);
    	}*/	
    	
//		Introducir Efectividades   	   	
    	/*for(int i = 0; i < ataques.size(); i++) {					// i = Ataque
    		for(int j = 0; j < efectividades.size(); j++) {			// j = Efectividad
				for(int k = 0; k < tipos.size(); k++) {				// k = Tipo			
					e1.put(tipos.get(k), efectividades.get(j).getMultiplicador());
					ataques.get(i).setEfectividades(e1);					
				}   
    		}
    	}*/
    	
    	// listaMovimientos.stream().forEach(string -> ataques.add(new Ataque(string)));
    }
 
    private void loadEspecies() {
    	List<String[]> lista;
    	lista = leerFichero("Database/FicheroEspecies.csv");
    	//lista.stream().forEach(string -> especies.put(Integer.parseInt(string[0]), new Especie(string)));    	
    }
    
    
   /* 
    private Map<Integer, Tipo> obtenerTipo() {
    	Map<Integer, Tipo> mapa = new HashMap <>();
    	
    	for (int i = 0; i < tipos.size(); i++) {
    		mapa.put(tipos.get(i).getIdTipo(), tipos.get(i));
    	}
    	
    	return mapa;
    }
    
    private Map<Tipo, Map<Tipo, Double>> obtenerEfectividades() {
    	Map<Integer, Tipo> mapa = new HashMap <>();
    	
    	for (int i = 0; i < efectividades.size(); i++) {
    		mapa.put(efectividades.get(i).getAtaque(), e);
    	}
    	
    	return mapa;
    }*/
}
