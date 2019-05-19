package presentador;

import vista.PresentView;

public class Presenter {
	PresentView presenterView;
	
	public String requestName() {
		return presenterView.requestName();
	}
}
