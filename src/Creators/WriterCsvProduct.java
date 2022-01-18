package Creators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Business.businessFreizeitbad.Freizeitbad;

public class WriterCsvProduct extends WriterProduct{
		
	
	
	private BufferedWriter aus;

	public WriterCsvProduct() throws IOException{
		 
			aus= new BufferedWriter(new FileWriter("Freizeitbad.csv"));
		}

	public void fuegeInDateiHinzu(Object object) throws IOException {		
		aus.write(((Freizeitbad) object).gibFreizeitbadZurueck(';'));
		aus.write("\n");

	}


	public void schliesseDatei() throws IOException {
	    aus.close();
	}
}