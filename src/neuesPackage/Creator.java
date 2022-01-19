package neuesPackage;

import java.io.*;
import business.businessFreizeitbad.*;
import business.businessSporthallen.*;
import java.util.*;

public abstract class Creator{
	
	public abstract Product factoryMethod(String typ) throws IOException;
}


