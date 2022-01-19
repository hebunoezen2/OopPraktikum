package gui.guiSportstaetten;

import java.io.IOException;

import business.businessFreizeitbad.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;
//import gui.guiFreizeitbaeder.*;
import business.businessSporthallen.Sporthallen;
import pattern.Observer;

public class SportstaettenControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	private SportstaettenView sportstaettenView;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sporthallenModel = SporthallenModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, freizeitbaederModel, sporthallenModel, primaryStage);
		this.freizeitbaederModel.addObserver(this);
	}
/*
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".contentEquals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");

			} else if ("txt".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");

			}

		} catch (IOException exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("IOException beim Speicher", typ);
		} catch (Exception exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern", typ);
		}
	}
	*/

	public Sporthallen leseSporthallenAusCsvDatei() {
		Sporthallen ergebnis = null;
		try {
			ergebnis = sporthallenModel.leseSporthallenAusCsvDatei();
		} catch (IOException exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("IOException beim Lesen!", null);
		} catch (Exception exc) {
			sportstaettenView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Lesen!", null);
		}
		return ergebnis;
	}

	public void update() {
		sportstaettenView.zeigeFreizeitbadAn();
	}

}
