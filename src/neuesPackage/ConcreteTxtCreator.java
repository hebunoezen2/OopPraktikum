package neuesPackage;

public class ConcreteTxtCreator extends TxtCreator
{
	public TxtProduct factoryMethod()
	{
		return new ConcreteTxtProduct();
	}
}
