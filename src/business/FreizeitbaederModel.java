package business;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import Observer.Observable;
import Observer.Observer;
import neuesPackage.ConcreteCreator;
import neuesPackage.ConcreteTxtCreator;
import neuesPackage.Creator;
import neuesPackage.Product;
import neuesPackage.TxtCreator;
import neuesPackage.TxtProduct;

public class FreizeitbaederModel implements Observable
{
	private Vector<Observer> observers = new Vector<Observer>();
	private ArrayList<Freizeitbad> freizeitbaeder = new ArrayList<>();
	private static FreizeitbaederModel fbModel;
	
	private FreizeitbaederModel()
	{

	}
	
	public String getUeberschrift()
	{
		 return "Verwaltung von Freizeitbädern";
	} 
	
	public void schreibeFreizeitbaederInCsvDatei() throws IOException
	{
			
			Creator writerCreator = new ConcreteCreator();
		
		
			
			Product writer = writerCreator.factoryMethod();
			
			
			
			this.getFreizeitbaeder().forEach(Freizeitbad -> {
				try 
				{
					writer.fuegeInDateiHinzu(Freizeitbad);
				}catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
			writer.schliesseDatei();
	} 
	
	public void schreibeFreizeitbaederInTxtDatei() throws IOException
	{
		TxtCreator writerCreator = new ConcreteTxtCreator();
		TxtProduct writer = writerCreator.factoryMethod();
		
		this.getFreizeitbaeder().forEach(Freizeitbad -> {
			try 
			{
				writer.fuegeInDateiHinzu(Freizeitbad);
			}catch (IOException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		writer.schliesseDatei();
		writer.schliesseDatei();
	}
	
	public ArrayList<Freizeitbad> getFreizeitbaeder()
	{
		return freizeitbaeder;
	}
	
	public void addFreizeitbad(Freizeitbad freizeitbad)
	{
		freizeitbaeder.add(freizeitbad);
	}
	
	public static FreizeitbaederModel getInstance()
	{
		if(fbModel == null)
		{
			fbModel = new FreizeitbaederModel();
		}
		return fbModel;
	}
	
	public void addObserver(Observer obs)
	{
		this.observers.addElement(obs);
	}
	
	public void removeObserver(Observer obs)
	{
		this.observers.removeElement(obs);
	}
	
	public void notifyObservers()
	{
		for(int i = 0; i<this.observers.size(); i++)
		{
			this.observers.elementAt(i).update();
		}
	}

}
 
