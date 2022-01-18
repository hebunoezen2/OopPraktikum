package Gui.Gui.Sportstaetten;

import java.io.IOException;
import Business.businessFreizeitbad.Freizeitbad;
import Business.businessFreizeitbad.FreizeitbaederModel;
import Business.businessSporthalle.SporthallenModel;
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

	private SportstaettenControl sportstaettenControl;
	private FreizeitbaederModel fbModel;
	private SporthallenModel sporthallenModel;

	private Pane pane = new Pane();

	private Label lblAnzeigeFr = new Label("Anzeige Freizeitbäder");
	private Label lblAnzeigeSp = new Label("Anzeige Sporthallen");

	private TextArea txtAnzeigeFr = new TextArea();
	private TextArea txtAnzeigeSp = new TextArea();

	private Button btnAnzeigeFr = new Button("Anzeige");
	private Button btnAnzeigeSp = new Button("csv-Import und Anzeige");

////
	public SportstaettenView(SportstaettenControl sportstaettenControl, FreizeitbaederModel freizeitbaederModel,
			Stage primaryStage, SporthallenModel sporthallenModel) {
		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportstätten");
		primaryStage.show();

		this.fbModel = freizeitbaederModel;
		this.sporthallenModel = sporthallenModel;
		this.sportstaettenControl = sportstaettenControl;

		this.initKomponentenSporthallen();
		this.initKomponentenFreizeitbaeder();
		this.initListenerFreizeitbaeder();
		this.initListenerSporthallen();
		//this.initListener();

	}

	private void initKomponentenSporthallen() {
		Font font = new Font("Arial", 20);
		lblAnzeigeSp.setLayoutX(20);
		lblAnzeigeSp.setLayoutY(40);
		lblAnzeigeSp.setFont(font);
		lblAnzeigeSp.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSp);

		txtAnzeigeSp.setEditable(false);
		txtAnzeigeSp.setLayoutX(20);
		txtAnzeigeSp.setLayoutY(90);
		txtAnzeigeSp.setPrefWidth(220);
		txtAnzeigeSp.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSp);

		btnAnzeigeSp.setLayoutX(20);
		btnAnzeigeSp.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSp);
	}

	private void initKomponentenFreizeitbaeder() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeFr.setLayoutX(310);
		lblAnzeigeFr.setLayoutY(40);
		lblAnzeigeFr.setFont(font);
		lblAnzeigeFr.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFr);

		// Textbereich
		txtAnzeigeFr.setEditable(false);
		txtAnzeigeFr.setLayoutX(310);
		txtAnzeigeFr.setLayoutY(90);
		txtAnzeigeFr.setPrefWidth(220);
		txtAnzeigeFr.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFr);

		// Button
		btnAnzeigeFr.setLayoutX(310);
		btnAnzeigeFr.setLayoutY(290);
		btnAnzeigeSp.setLayoutX(20);
		btnAnzeigeSp.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFr);
	}

	/*
	 * private void initListener() { /* btnAnzeige.setOnAction(new
	 * EventHandler<ActionEvent>() {
	 * 
	 * @Override public void handle(ActionEvent e) { zeigeFreizeitbaederAn(); } });
	 * 
	 * 
	 * btnAnzeigeFr.setOnAction(e -> zeigeFreizeitbaederAn());
	 * 
	 * btnAnzeigeSp.setOnAction(e -> { zeigeSporthallenAn(); });
	 * 
	 * }
	 */

	private void initListenerFreizeitbaeder() {
		btnAnzeigeFr.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});
	}

	private void initListenerSporthallen() {
		btnAnzeigeSp.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeSporthallenAn();
			}
		});
	}

	public void zeigeFreizeitbaederAn() {

		if (fbModel.getFreizeitbad() != null) {
			StringBuffer text = new StringBuffer();
			for (Freizeitbad fzb : fbModel.freizeitbad)

				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");

			this.txtAnzeigeFr.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}

	}

	public void zeigeSporthallenAn() {
	
		try {
			sporthallenModel.setSporthalle(sporthallenModel.leseSporthallenAusCsvDatei());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (sporthallenModel.getSporthalle() != null) {
			txtAnzeigeSp.setText(sporthallenModel.getSporthalle().gibSporthalleZurueck(' '));
		} else {
			zeigeInformationsfensterAn("Bisher wurde keine Sporthalle aufgenommen!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungAn(String fehlertyp) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", fehlertyp).zeigeMeldungsfensterAn();
	}

}