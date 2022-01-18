package Creators;

import java.io.IOException;

public abstract class WriterCreator {

	public abstract WriterProduct factoryMethod(String t) throws IOException;
	
}