package neuesPackage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteCsvProduct extends Product {

	BufferedWriter bw;

	public ConcreteCsvProduct() throws IOException {
		bw = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
	}

	public void fuegeInDateiHinzu(Object object) throws IOException {
		bw.write(((Freizeitbad) object).gibFreizeitbadZurueck(';'));

	}

	@Override
	public void schliesseDatei() throws IOException {
		bw.close();
		
	}
}