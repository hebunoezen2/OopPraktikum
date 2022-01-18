package Gui.Gui.Sportstaetten;

import java.io.IOException;

import Business.businessFreizeitbad.FreizeitbaederModel;
import Business.businessSporthalle.Sporthalle;
import Business.businessSporthalle.SporthallenModel;
import Pattern.Observer;
import javafx.stage.Stage;

public class SportstaettenControl implements Observer {

	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenView sportstaettenView;
	private SporthallenModel sporthallenModel;

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(this, freizeitbaederModel, primaryStage, sporthallenModel);
		this.sporthallenModel = SporthallenModel.getTheInstance();
		freizeitbaederModel.addObserver(this);

	}

	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();

	}
	public Sporthalle leseSporthallenAusCsvDatei(){
		Sporthalle ergebnis = null;
		try{
			ergebnis = sporthallenModel.leseSporthallenAusCsvDatei();
		}
		catch(IOException exc){
			sportstaettenView.zeigeFehlermeldungAn(
				"IOException beim Lesen!");
		}
		catch(Exception exc){
			sportstaettenView.zeigeFehlermeldungAn(
				"Unbekannter Fehler beim Lesen!");
		}
		return ergebnis;
	}

}
