package gui.guiSportstaetten;


import Observer.Observer;
import business.businessFreizeitbaeder.FreizeitbaederModel;
import business.businessSporthallen.SporthallenModel;
import javafx.stage.Stage;

public class SportstaettenControl implements Observer
{
	private SportstaettenView spView;
    	private FreizeitbaederModel fbModel;
	private SporthallenModel shModel;
    
	public SportstaettenControl(Stage primaryStage)
	{
		this.fbModel = FreizeitbaederModel.getInstance();
		this.shModel = SporthallenModel.getInstance();
		this.spView = new SportstaettenView(this, primaryStage, fbModel, shModel);
		fbModel.addObserver(this);
	}

	public void update() 
	{
		spView.zeigeFreizeitbaederAn();
	}

}
