package neuesPackage;

import java.io.IOException;

public class ConcreteCsvCreator extends Creator{
	
    public Product factoryMethod(String typ) throws IOException {
    	return new ConcreteCsvProduct();
}
	


}
