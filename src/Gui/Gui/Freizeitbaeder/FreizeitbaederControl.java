package Gui.Gui.Freizeitbaeder;

import Pattern.*;

import java.io.IOException;

import Business.businessFreizeitbad.FreizeitbaederModel;
import javafx.stage.Stage;

public class FreizeitbaederControl implements Observer{
	
	//Objekt erstellen 
	private FreizeitbaederView fbView;
	private FreizeitbaederModel fbModel;

	//Konstruktor 
	public FreizeitbaederControl(Stage primaryStage) {
		this.fbModel = FreizeitbaederModel.getInstance();
		this.fbView = new FreizeitbaederView(primaryStage, fbModel, this);
	
	fbModel.addObserver(this);
	
	}
	
	
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if ("csv".equals(typ)) {
				this.fbModel.schreibeFreizeitbaederInCsvDatei();
				this.fbView.zeigeInformationsfensterAn("Freizeitbäder wurden gespeichert!");
			} 
			
			else if("txt".equals(typ)) {
				fbModel.schreibeFreizeitbaederInTxtDatei();
				fbView.zeigeInformationsfensterAn("Das Freizeitbad wurde gespeichert!");
			}
			
			else {
				fbView.zeigeInformationsfensterAn("Noch nicht implementiert!");
			}
		} catch (IOException exc) {
			fbView.zeigeFehlermeldungsfensterAn( "IOException beim Speichern!",typ);
		} catch (Exception exc) {
			fbView.zeigeFehlermeldungsfensterAn("Unbekannter Fehler beim Speichern!",typ);
		}
	}


	public void update() {
		fbView.zeigeFreizeitbaederAn();
		
	}
}