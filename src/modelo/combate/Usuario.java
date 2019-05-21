package modelo.combate;

import presentador.Presenter;
import presentador.PresenterUsuario;

public class Usuario extends Entrenador implements PresenterUsuario {
	private String name;
	private Presenter presenter;
	
	@Override
	public void requestName() {
		name = presenter.requestName();
	}

	@Override
	public int requestOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int requestAttack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int requestPokemon() {
		// TODO Auto-generated method stub
		return 0;
	}

}
