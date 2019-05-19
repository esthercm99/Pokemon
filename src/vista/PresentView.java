package vista;

import modelo.Pokemon;

public interface PresentView {
	String requestName();
	int requestOption();
	int requestAttack();
	int requestPokemon();
	void showPokemon(Pokemon pokemon);
}
