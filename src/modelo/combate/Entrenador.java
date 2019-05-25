package modelo.combate;

import java.util.ArrayList;
import java.util.List;
import modelo.factoria.*;

public abstract class Entrenador {
	private String nombreEntrenador;
	private Pokemon actualPokemon;
	private List<Pokemon> listaPokemon = new ArrayList<>();
	
	public Entrenador() {
		asignarPokemons();
		actualPokemon = listaPokemon.get(0);
	}
	
	public abstract int seleccionarOpcion();
	public abstract String luchar(Entrenador oponente);
	public abstract void cambiar();
	public boolean rendirse() {
		return true;
	}	
	
	private void asignarPokemons() {
		final int NUMPOKEMONS = 3;
		PokemonFactory factoria = new FactoryAleatorio();
		for(int i = 0; i < NUMPOKEMONS; i++) {
			listaPokemon.add(factoria.crearPokemonAleatorio());
		}
	}
	
	public boolean areAllPokemonAlive() {
		int countPokemonDead = 0;
		boolean surrender = false;
		
		for(int i = 0; i < listaPokemon.size(); i++) {
			if(listaPokemon.get(i).getVida() <= 0) {
				countPokemonDead++;
			}
		}
		
		if(countPokemonDead == listaPokemon.size()) {
			surrender = true;
		} else {		
			cambiar();
		}
		return surrender;
	}
	
	public List<Pokemon> getListaPokemon() {
		return listaPokemon;
	} 
	public Pokemon getPokemonActual() {
		return actualPokemon;
	}
	public void setPokemonActual(Pokemon pokemon) {
		actualPokemon = pokemon;
	}
	public String getNombreEntrenador() {
		return nombreEntrenador;
	}
	public void setNombreEntrenador(String nombreEntrenador) {
		this.nombreEntrenador = nombreEntrenador;
	}
}
