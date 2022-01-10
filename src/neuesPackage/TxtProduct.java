package neuesPackage;

import java.io.IOException;

import business.businessFreizeitbaeder.Freizeitbad;

public abstract class TxtProduct 
{
	public abstract void fuegeInDateiHinzu(Freizeitbad freizeitbad) throws IOException;
	
	public abstract void schliesseDatei() throws IOException;
}
