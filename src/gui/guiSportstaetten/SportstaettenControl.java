package gui.guiSportstaetten;


import Observer.Observer;
import business.FreizeitbaederModel;
import javafx.stage.Stage;

public class SportstaettenControl implements Observer
{
	private SportstaettenView spView;
    private FreizeitbaederModel fbModel;
    
	public SportstaettenControl(Stage primaryStage)
	{
		this.fbModel = FreizeitbaederModel.getInstance();
		this.spView = new SportstaettenView(this, primaryStage, fbModel);
		fbModel.addObserver(this);
	}

	public void update() 
	{
		spView.zeigeFreizeitbaederAn();
	}

}
