package modelo;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Database {
	
	INSTANCE;
	
	private List<Tipo> tipos;
	private List<Ataque> ataques;
	private List<Efectividad> efectividades;
	private List<Especie> especies;	

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
            
            /*for (String[] strings : collect) {
            System.out.println(Arrays.toString(strings));
        	}*/
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
    	lista.stream().forEach(string -> tipos.add(new Tipo(string)));
    }
    
    private void loadEfectividades() {
    	List<String[]> lista;
    	lista = leerFichero("Database/FicheroEfectividades.csv"); 	
    	for(int i = 0; i < lista.size(); i++) {
    		for(int j = 0; j < tipos.size(); j++) {
    			if(Integer.parseInt(lista.get(i)[0]) == tipos.get(j).getIdTipo()) {    				
    				for(int k = 0; k < tipos.size(); k++) {
    					if(Integer.parseInt(lista.get(i)[1]) == tipos.get(j).getIdTipo()) {
    						efectividades.add(new Efectividad(tipos.get(j), tipos.get(k), Double.parseDouble(lista.get(i)[2])));
    					}
    				}    				
    			}    			
    		}
    	}
	}
    
    private void loadAtaques() {
    	List<String[]> lista;
    	lista = leerFichero("Database/FicheroMovimientos.csv");
    	
    	
    	
    	
    	lista.stream().forEach(string -> ataques.add(new Ataque(string)));
    	
    }
    
    private void loadEspecies() {
    	List<String[]> lista;
    	lista = leerFichero("Database/FicheroEspecies.csv");
    
    	lista.stream().forEach(string -> especies.add(new Especie(string)));
    	
    	
    }

}
