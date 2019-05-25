package vista;

public interface PresentView {
	String requestName();
	int requestOption();
	int requestAttack(String attacks);
	int requestPokemon(String listaPokemons, int numPokemons);
	void showFight(String string);
	void mensajeError(String mensaje);
}
