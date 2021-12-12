package guiFreizeitbaeder;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;
import observer.Observer;

public class FreizeitbaederControl implements Observer {

	private FreizeitbaederView freizeitbaederView;
	private FreizeitbaederModel model;

	public FreizeitbaederControl(Stage primaryStage) {
		this.model = FreizeitbaederModel.getFrizeitbaederModel();
		model.addObserver(this);
		this.freizeitbaederView = new FreizeitbaederView(this, model, primaryStage);
	}

	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				model.schreibeFreizeitbaederInCsvDatei();
				freizeitbaederView.zeigeInformationsfensterAn("wurde gespeichert");
			}
			if ("txt".equals(typ)) {
				model.schreibeFreizeitbaederInTxtDatei();
				freizeitbaederView.zeigeInformationsfensterAn("Wurde gespeichert");
			} else {
				freizeitbaederView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("IO", "IOException beim Speichern!");
		} catch (Exception exc) {
			freizeitbaederView.zeigeFehlermeldungsfensterAn("Ex", "Unbekannter Fehler beim Speichern!");
		}

	}
	
	@Override
	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
	}
}
