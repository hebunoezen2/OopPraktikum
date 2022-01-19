package gui.guiSportstaetten;

import business.businessFreizeitbad.Freizeitbad;
import business.businessFreizeitbad.FreizeitbaederModel;
import business.businessSporthallen.*;
import business.businessSporthallen.SporthallenModel;
import javafx.event.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.*;
import java.io.*;

public class SportstaettenView {

	// Hier ergaenzen
	private SportstaettenControl sportstaettenControl;
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitbäder");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");

	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeSporthallen = new TextArea();
	private Button btnAnzeigeSporthallen = new Button("csv-Import und Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(SportstaettenControl sportstaettenControl, FreizeitbaederModel freizeitbaederModel,
			SporthallenModel sporthallenModel, Stage primaryStage) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportstätten");
		primaryStage.show();
		// Hier ergaenzen
		this.freizeitbaederModel = freizeitbaederModel;
		this.sportstaettenControl = sportstaettenControl;
		this.sporthallenModel = sporthallenModel;

		this.initKomponentenFreizeitbaeder();
		this.initKomponentenSporthallen();
		this.initListener();
	}

	private void initKomponentenFreizeitbaeder() {
		// Label
		Font font = new Font("Arial", 20);
		// Freizeitbad
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);
		//Textbereich
		// Freizeitbad
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);
		// Button
		// Freizeitbad
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);
	}
	
	private void initKomponentenSporthallen() {
		// Label
		Font font = new Font("Arial", 20);
		// Sporthalle
		lblAnzeigeSporthallen.setLayoutX(30);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSporthallen);
		// Textbereich
		// Sporthallen
		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(30);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);
		//Button
		// Sporthallen
		btnAnzeigeSporthallen.setLayoutX(30);
		btnAnzeigeSporthallen.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSporthallen);
	
	}

	private void initListener() {
		// Freizeitbad
		btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbadAn();
			}
		});
		// Sporthalle
		btnAnzeigeSporthallen.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeSporthallenAn();
			}
		});
	}

	public void zeigeFreizeitbadAn() {
		if (freizeitbaederModel.getFreizeitbad() != null) {
			txtAnzeigeFreizeitbaeder.setText(freizeitbaederModel.getFreizeitbad().gibFreizeitbadZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	protected void zeigeSporthallenAn() {
		// TODO Auto-generated method stub
		try {
			sporthallenModel.setSporthallen(sporthallenModel.leseSporthallenAusCsvDatei());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sporthallenModel.getSporthallen() != null) {
			txtAnzeigeSporthallen.setText(sporthallenModel.getSporthallen().gibSporthalleZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}
	
}
