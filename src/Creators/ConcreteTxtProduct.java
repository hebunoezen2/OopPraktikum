package Creators;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import Business.businessFreizeitbad.Freizeitbad;

public class ConcreteTxtProduct extends WriterProduct{

    private BufferedWriter aus;

    public ConcreteTxtProduct() {
    	
        try {
            aus = new BufferedWriter(new FileWriter("Freizeitbad.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void fuegeInDateiHinzu(Object object) throws IOException {
      
        aus.write( "Daten des Freizeitbades\n");
        aus.write("Name des Freitzeitbads:" + "\t\t\t\t" + ((Freizeitbad) object).getName() + "\n");
        aus.write("Oeffnungszeit des Freizeitbads:" + "\t\t" + ((Freizeitbad) object).getGeoeffnetVon() + " - " + ((Freizeitbad) object).getGeoeffnetBis() + "\n");
        aus.write("Beckenlaenge des Freizeitbads:" + "\t\t" + ((Freizeitbad) object).getBeckenlaenge() + "\n");
        aus.write("Wassertemperatur des Freizeitbads:" + "\t" + ((Freizeitbad) object).getTemperatur() + "\n");
        
       
        aus.write("\n");
    }

	public void schliesseDatei() throws IOException{
		aus.close();
	}
	

}