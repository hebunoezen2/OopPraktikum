package neuesPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTxtProduct extends Product{
	BufferedWriter bw;
	
	public ConcreteTxtProduct() throws IOException {
		bw = new BufferedWriter(new FileWriter("Freizeitbaeder.txt", true));
	}
	

	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		bw.write("Name "+ ((Freizeitbad) object).gibFreizeitbadZurueck(';'));
		
		
	}
	@Override
	public void schliesseDatei() throws IOException {
		bw.close();
	}


}
