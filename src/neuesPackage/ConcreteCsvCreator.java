package neuesPackage;

import java.io.BufferedWriter;
import java.io.IOException;

public class ConcreteCsvCreator extends Creator {

@Override
	public Product factoryMethod() throws IOException {
	return new ConcreteCsvProduct();
	}

}
