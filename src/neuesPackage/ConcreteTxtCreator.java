package neuesPackage;

import java.io.*;
import java.util.ArrayList;

import business.businessFreizeitbad.Freizeitbad;
import business.businessSporthallen.Sporthallen;

public class ConcreteTxtCreator extends Creator {

	public Product factoryMethod(String typ) throws IOException {
		// TODO Auto-generated method stub
		return new ConcreteTxtProduct();
	}

}
