package Business.businessSporthalle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Pattern.Observable;
import Pattern.Observer;


public class SporthallenModel implements Observable {
	
private ArrayList<Observer> observers=new ArrayList<Observer>(); 

	
	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.remove(o);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i=0; i<observers.size(); i++){
			observers.get(i).update();
		}
			
	}


	private Sporthalle sporthalle;
	private static SporthallenModel getInstance=null;
 		
	private SporthallenModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static SporthallenModel getTheInstance() {
		if(getInstance==null)
		getInstance = new SporthallenModel();
		
		return getInstance;
	}

	public Sporthalle getSporthalle() {
		return this.sporthalle;
	}

	public void setSporthalle(Sporthalle sporthalle) {
		this.sporthalle = sporthalle;

		notifyObservers();
	}

	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		
	}


	public Sporthalle leseSporthallenAusCsvDatei()
			throws IOException, Exception {
		BufferedReader ein = new BufferedReader(
				new FileReader("Sporthalle.csv"));
		String[] zeile = ein.readLine().split(";");
		Sporthalle ergebnis
			= new Sporthalle(zeile[0], zeile[1], zeile[2]);
		ein.close();
		return ergebnis;
	}


}