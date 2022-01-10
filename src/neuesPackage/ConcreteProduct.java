package neuesPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.businessFreizeitbaeder.Freizeitbad;

public class ConcreteProduct extends Product
{
	private BufferedWriter aus;
	
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException 
	{
		aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
		aus.write(freizeitbad.gibFreizeitbadZurueck(';'));
		aus.close();
	}	
	
	public void schliesseDatei() throws IOException 
	{
		aus.close();
	}
	
}
