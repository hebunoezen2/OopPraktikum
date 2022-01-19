package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import pattern.Observable;
import pattern.Observer;
import ownUtil.PlausiException;

public class SporthallenModel implements Observable {

	private Sporthallen sporthallen;
	private ArrayList<Observer> observer = new ArrayList<Observer>();

	public void addObserver(Observer o) {
		// TODO Auto-generated method stub
		observer.add(o);
	}

	public void deleteObserver(Observer o) {
		// TODO Auto-generated method stub
		observer.remove(o);
	}

	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (int i = 0; i < observer.size(); i++) {
			observer.get(i).update();
		}

	}

	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub

	}

	public Sporthallen getSporthallen() {
		return sporthallen;
	}

	public void setSporthallen(Sporthallen sporthallen) {
		this.sporthallen = sporthallen;
	}

	// Singleton
	private SporthallenModel() {
	}

	private static SporthallenModel sporthallenModel;

	public static SporthallenModel getInstance() {
		if (sporthallenModel == null) {
			sporthallenModel = new SporthallenModel();
		}
		return sporthallenModel;
	}

	public Sporthallen leseSporthallenAusCsvDatei() throws IOException, Exception {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthalle.csv"));
		String[] zeile = ein.readLine().split(";");
		Sporthallen ergebnis = new Sporthallen(zeile[0], zeile[1], zeile[2]);
		ein.close();
		return ergebnis;
	}

}
