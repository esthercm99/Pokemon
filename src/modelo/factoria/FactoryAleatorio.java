package modelo.factoria;

import java.util.ArrayList;
import java.util.Random;

public class FactoryAleatorio extends PokemonFactory {
	
	private ArrayList<Integer> noRepetir = new ArrayList<>();
	
	@Override
	public Pokemon crearPokemonAleatorio() {
		int num, count = 0;
		boolean exit = false;
		Random rnd = new Random();
		Database data = Database.INSTANCE;
		
		do {
			count = 0;
			num = rnd.nextInt(data.getListaEspecies().size())+1;
			for(int i = 0; i < noRepetir.size(); i++) {
				if(noRepetir.get(i) == num) {
					count ++;
				}
			}
			
			if(count == 0) {
				exit = true;
			}
			
		} while(!exit);
		
		return new Pokemon(data.getListaEspecies().get(num));
	}
}
