package gui.guiSportstaetten;

import business.FreizeitbaederModel;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import ownUtil.MeldungsfensterAnzeiger;

public class SportstaettenView {

	// Hier ergaenzen
	// private SportstaettenControl sportstaettenControl;
	private FreizeitbaederModel freizeitbaederModel;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitb�der");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(SportstaettenControl sportstaettenControl, FreizeitbaederModel freizeitbaederModel, Stage primaryStage) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportst�tten");
		primaryStage.show();
		// Hier ergaenzen
		this.freizeitbaederModel = freizeitbaederModel;
		// this.sportstaettenControl=sportstaettenControl;

		this.initKomponenten();
		this.initListener();
	}

	private void initKomponenten() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);
		// Textbereich
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);
		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);
	}

	private void initListener() {
		btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});
	}

	void zeigeFreizeitbaederAn() {
		if (freizeitbaederModel.getFreizeitbad() != null) {
			txtAnzeigeFreizeitbaeder.setText(freizeitbaederModel.getFreizeitbad().gibFreizeitbadZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungsfensterAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}

}
