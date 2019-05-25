package modelo.factoria;

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

import modelo.pokemon.Ataque;
import modelo.pokemon.Especie;
import modelo.pokemon.Tipo;

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
		loadEspecies();
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
    	Tipo tipo, subtipo;
    	Map<Integer, Ataque> ataquesPokemon = new HashMap<>();
    	List<String[]> lista = leerFichero("Database/FicheroEspecies.csv");
    	
    	
    	for(int i = 0; i < lista.size(); i++) {
    		
    		ataquesPokemon = new HashMap<>();		// New y no .clear() ya que se sobreescribían los ataque tras crear la especie.
    		
    		ataquesPokemon.put(1, ataques.get(Integer.parseInt(lista.get(i)[10])));    			
    		ataquesPokemon.put(2, ataques.get(Integer.parseInt(lista.get(i)[11])));
    		ataquesPokemon.put(3, ataques.get(Integer.parseInt(lista.get(i)[12])));
    		ataquesPokemon.put(4, ataques.get(Integer.parseInt(lista.get(i)[13])));
    		
    		tipo = tipos.get(Integer.parseInt(lista.get(i)[8]));
    		subtipo = tipos.get(lista.get(i)[9].equals("")?null:tipos.get(Integer.parseInt(lista.get(i)[9])));
    		
    		if(subtipo == null) {
    			especies.put(i+1, new Especie(lista.get(i), tipo, ataquesPokemon));
    		} else {
    			especies.put(i+1, new Especie(lista.get(i), tipo, subtipo, ataquesPokemon));
    		}
    	}    	   	
    }   

    public Map<Integer, Tipo> getListaTipo() {
    	return tipos;
    }
    public Map<Integer, Ataque> getListaAtaque() {
    	return ataques;
    }
    public Map<Integer, Especie> getListaEspecies() {
    	return especies;
    }
}