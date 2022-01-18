package Main;

import Gui.Gui.Freizeitbaeder.*;
import Gui.Gui.Sportstaetten.*;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	
	public void start(Stage primaryStage) {
		
		//Fenster zu Freizeitbaedern
		new FreizeitbaederControl(primaryStage);
		
		//Fenster zu Sportstaetten
		Stage fensterSportstaetten = new Stage();
		new SportstaettenControl(fensterSportstaetten);
	}
	
	
	
	public static void main(String[] args){
		launch(args);
		
	}

}
