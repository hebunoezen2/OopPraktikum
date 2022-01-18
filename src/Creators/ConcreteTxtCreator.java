package Creators;

import java.io.IOException;

import Creators.WriterCreator;
import Creators.WriterProduct;

public class ConcreteTxtCreator extends WriterCreator{
//factory
	public WriterProduct factoryMethod(String t) throws IOException{
		return new ConcreteTxtProduct();
	}
}
