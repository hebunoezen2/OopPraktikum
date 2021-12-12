package guiSportstaetten;

import business.Freizeitbad;
import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.Observer;

public class SportstaettenControl implements Observer {
	private SportstaettenView view;
	private FreizeitbaederModel model;

	public SportstaettenControl(Stage fensterSportstaetten) {
		this.model = FreizeitbaederModel.getFrizeitbaederModel();
		model.addObserver(this);
		this.view = new SportstaettenView(this, model, fensterSportstaetten);

	}

	@Override
	public void update() {
		view.zeigeFreizeitbaederAn();
	}
}
