package Creators;

import java.io.IOException;

public class WriterCsvCreator extends WriterCreator {
	public WriterProduct factoryMethod(String t) throws IOException{
		return new WriterCsvProduct();
	}
	
}
