package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import observer.Observable;
import observer.Observer;
import writer.ConcreteCsvCreator;
import writer.Creator;
import writer.Product;

public class FreizeitbaederModel implements Observable {
	
	private Freizeitbad freizeitbad;
	private static FreizeitbaederModel instance = null ;
	private ArrayList<Observer> observerss = new ArrayList<Observer>();

	private FreizeitbaederModel() {
		
	}
	
	public static FreizeitbaederModel getFrizeitbaederModel() {
		if (instance ==null) {
			instance = new FreizeitbaederModel();
		}
		return instance ;
	}
	public Freizeitbad getFreizeitbad() {
		return freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;
		notifyObservers();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {

		Creator creater = new ConcreteCsvCreator();
		Product writer = creater.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		Creator creater = new ConcreteTxtCreator();
		Product writer = creater.factoryMethod();
		writer.fuegeInDateiHinzu(this.freizeitbad);
		writer.schliesseDatei();
	}

	@Override
	public void addObserver(Observer obs) {
		observerss.add(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observerss.remove(obs);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerss.size(); i++) {
			observerss.get(i).update();
		}
	}


}