package modelo.factoria;

import java.util.Random;

public class FactoryAleatorio extends PokemonFactory {

	@Override
	public Pokemon crearPokemonAleatorio() {
		int num;
		Random rnd = new Random();
		Database data = Database.INSTANCE;
	
		num = rnd.nextInt(data.getListaEspecies().size())+1;
		return new Pokemon(data.getListaEspecies().get(num));
	}
}
