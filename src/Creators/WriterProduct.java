package Creators;

import java.io.IOException;

import Business.businessFreizeitbad.Freizeitbad;

public abstract class WriterProduct {
	
	public abstract void fuegeInDateiHinzu(Object object) throws IOException;
	
	
	public abstract void schliesseDatei() throws IOException;

	
}
