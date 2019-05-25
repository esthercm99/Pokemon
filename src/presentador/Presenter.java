package presentador;

import vista.*;

public class Presenter {
	View view = new View();
	
	public String requestName() {
		return view.requestName();
	}
	public int requestOption() {
		return view.requestOption();
	}
	public int requestAttack(String attacks) {
		return view.requestAttack(attacks);
	}
	public int requestPokemon(String listaPokemons, int numPokemons) {
		return view.requestPokemon(listaPokemons, numPokemons);
	}
	public void showFight(String string) {
		view.showFight(string);
	}
	
	public void mensajeError(String mensaje) {
		view.mensajeError(mensaje);
	}
}
