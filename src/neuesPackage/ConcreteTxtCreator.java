package neuesPackage;
import java.io.*;

public class ConcreteTxtCreator extends Creator{
	
    public Product factoryMethod(String typ) throws IOException {
        // TODO Auto-generated method stub
        return new ConcreteTxtProduct();
}

}
