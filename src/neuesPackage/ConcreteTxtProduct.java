package neuesPackage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import business.Freizeitbad;

public class ConcreteTxtProduct extends TxtProduct
{
	private PrintWriter aus;
	
	public void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException
	{
		aus = new PrintWriter(new FileWriter("Freizeitbaeder.txt", true));
		aus.println("Daten des Freizeitbades");
		aus.println("Name des Freizeitbades:                  " + freizeitbad.getName());
		aus.println("�ffnungszeit des Freizeitbades:          " + freizeitbad.getGeoeffnetVon() + " - " + freizeitbad.getGeoeffnetBis());
		aus.println("Beckenl�nge des Freizeitbades:           " + freizeitbad.getBeckenlaenge());
		aus.println("Wassertemperatur des Freizeitbades:      " + freizeitbad.getTemperatur());
		aus.println();
	}
	
	public void schliesseDatei() throws IOException 
	{
		aus.close();
	}
}
