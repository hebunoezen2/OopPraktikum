package gui.guiFeizeitbaeder;

import java.io.IOException;
import Observer.Observer;
import business.Freizeitbad;
import business.FreizeitbaederModel;
import gui.guiSportstaetten.SportstaettenControl;
import javafx.stage.Stage; 
import ownUtil.PlausiException;

public class FreizeitbaederControl implements Observer
{
	private FreizeitbaederView view;
	private FreizeitbaederModel model;
    
	public FreizeitbaederControl(Stage primaryStage)
	{
		this.model = FreizeitbaederModel.getInstance();
		this.view = new FreizeitbaederView(this, primaryStage, model);
		model.addObserver(this);
	}
	
    public void nehmeFreizeitbadAuf(String name, String von, String bis, String laenge, String temperatur)
    {
    	try{
    		model.addFreizeitbad(new Freizeitbad(name, von, bis, laenge, temperatur));
    		model.notifyObservers();
       	}
       	catch(PlausiException exc){
       		view.zeigeFehlermeldungsfensterAn(exc.getPlausiTyp() + "er ", exc.getMessage());
     	}
    }
    
    void schreibeFreizeitbaederInDatei(String typ)
    {
    	 try{
    		 if("csv".equals(typ))
    		 {
    			 model.schreibeFreizeitbaederInCsvDatei();
    		 }
    		 else
    	 	{
    		 model.schreibeFreizeitbaederInTxtDatei();
    	 	}
    	 	}
    	
    	 catch(IOException exc)
    	 {
    		 view.zeigeFehlermeldungsfensterAn(exc.getCause() + "er ", "IOException beim Speichern!");
    	 }
    	catch(Exception exc)
    	 {
    		view.zeigeFehlermeldungsfensterAn(exc.getCause() + "er ", "Unbekannter Fehler beim Speichern!");
    	}
    }
    
    public void update()
    {
    	view.zeigeFreizeitbaederAn();
    }
}
