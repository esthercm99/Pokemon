package vista;

import modelo.combate.Pokemon;

public interface PresentView {
	String requestName();
	int requestOption();
	int requestAttack();
	int requestPokemon();
	void showPokemon(Pokemon pokemon);
}
