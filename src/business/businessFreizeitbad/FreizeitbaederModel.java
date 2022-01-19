package business.businessFreizeitbad;

//import gui.*;
import java.io.*;
import java.util.*;

import pattern.Observable;
import pattern.Observer;
import neuesPackage.*;

public class FreizeitbaederModel implements Observable{

	private Freizeitbad freizeitbad;
	//private ArrayList <Freizeitbad> freizeitbad = new ArrayList<>(); 
	private Vector <Observer> observers = new Vector <Observer>();
	

	/*
	 * public void schreibeFreizeitbaederInCsvDatei(FreizeitbaederView fbView)
	 * throws IOException { BufferedWriter aus = new BufferedWriter(new
	 * FileWriter("Freizeitbaeder.csv", true));
	 * aus.write(fbView.getFreizeitbad().gibFreizeitbadZurueck(';')); aus.close(); }
	 */
	

	//Singleton
	private static FreizeitbaederModel freizeitbaederModel;
	private FreizeitbaederModel() {
		
	}
	public static FreizeitbaederModel getInstance() {
		if(freizeitbaederModel == null)
			freizeitbaederModel= new FreizeitbaederModel();
		
		return freizeitbaederModel;
	}
	

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		Creator txt = new ConcreteTxtCreator();
		Product writer = txt.factoryMethod(null);
		writer.fuegeInDateiHinzu(this.freizeitbad);
		//writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator c = new ConcreteCsvCreator();
		Product writer = c.factoryMethod(null);
		writer.fuegeInDateiHinzu(this.freizeitbad);
		//writer.schliesseDatei();
	}
	
	public Freizeitbad getFreizeitbad() {
		return this.freizeitbad;
	}

	public void setFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad = freizeitbad;

		notifyObservers();
	}
/*
	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
		this.notifyObservers();
	}
	*/
	@Override
	public void addObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.addElement(obs);
	}
	@Override
	public void removeObserver(Observer obs) {
		// TODO Auto-generated method stub
		this.observers.removeElement(obs);
	}
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(Observer obs: observers) {
			obs.update();
		}
		
	}


}
