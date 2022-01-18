package Business.businessFreizeitbad;


import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import Creators.ConcreteTxtCreator;
import Creators.WriterCreator;
import Creators.WriterCsvCreator;
import Creators.WriterProduct;
import Pattern.Observer;
import Pattern.Observable;

public class FreizeitbaederModel implements Observable {
	
	//private Freizeitbad freizeitbad;
	private Vector <Observer> observers = new Vector <Observer>();
	public ArrayList <Freizeitbad> freizeitbad = new ArrayList<>(); 
	//private static FreizeitbaederModel fbModel;
	

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
	
	public String getUeberschrift()
	{
		 return "Verwaltung von Freizeitbädern";
	} 

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {

		WriterCreator writerCreator = new ConcreteTxtCreator();
		WriterProduct writerProduct = writerCreator.factoryMethod(null);
		
		for( Freizeitbad fb: freizeitbad) {
			writerProduct.fuegeInDateiHinzu(fb);
		}
		
		writerProduct.schliesseDatei();

	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException{
		WriterCreator writerCreator = new WriterCsvCreator();
		WriterProduct writerProduct = writerCreator.factoryMethod(null);
		
		for( Freizeitbad fb: freizeitbad) {
			writerProduct.fuegeInDateiHinzu(fb);
		}
		
		writerProduct.schliesseDatei();

	}

	public ArrayList <Freizeitbad> getFreizeitbad() {
		return this.freizeitbad;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
		this.notifyObservers();
	}
	
	public void addObserver(Observer obs) {
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
