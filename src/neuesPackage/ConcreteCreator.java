package neuesPackage;

public class ConcreteCreator extends Creator
{
	public Product factoryMethod()
	{
		return new ConcreteProduct();
	}
}
