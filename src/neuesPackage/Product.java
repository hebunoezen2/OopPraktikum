package neuesPackage;

import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;

public abstract class Product 
{
	public abstract void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
