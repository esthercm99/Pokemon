package vista;

import static keyboard.Keyboard.*;

public class View implements PresentView {
	
	@Override
	public String requestName() {
		return readString("¿Cómo te llamas?: ");		
	}

	@Override
	public int requestOption() {
		System.out.println("\t1. Cambiar Pokémon\n\t2. Luchar\n\t3. Rendirse\n");
		return readRange(1, 3, RangeType.BOTH_INCLUDED);
	}

	@Override
	public int requestAttack(String attacks) {
		System.out.println(attacks);
		return readRange(1, 4, RangeType.BOTH_INCLUDED);
	}

	@Override
	public int requestPokemon(String listaPokemons, int numPokemons) {
		System.out.println(listaPokemons);
		return readRange(1, numPokemons, RangeType.BOTH_INCLUDED);
	}


	@Override
	public void mensajeError(String mensaje) {
		System.out.println(mensaje);
	}

	@Override
	public void showFight(String string) {
		System.out.println(string);		
	}
}
