package business.businessSporthallen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import ownUtil.PlausiException;

public class SporthallenModel
{
	
	private ArrayList<Sporthalle> sporthallen = new ArrayList<>();
	private static SporthallenModel shModel;
	
	private SporthallenModel()
	{
		
	} 
	
	public void leseSporthallenAusCsvDatei() throws IOException, PlausiException
	{
			BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			
			while(zeileStr != null)
			{
			String[] zeile = zeileStr.split(";");
		        ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
		        zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}
	
	public void leseSporthallenAusTxtDatei() throws IOException, PlausiException
	{
			BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.txt"));
			ArrayList<Sporthalle> ergebnis = new ArrayList<>(); 
			String zeileStr = ein.readLine();
			
			while(zeileStr != null)
			{
				String[] zeile = zeileStr.split(";");
		        ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
		        zeileStr = ein.readLine();
			}    
		 	ein.close();
		 	this.sporthallen = ergebnis;
		}
	
	public ArrayList<Sporthalle> getSporthallen()
	{
		return sporthallen;
	}
	
	public void addSporthalle(Sporthalle Sporthalle)
	{
		sporthallen.add(Sporthalle);
	}
	
	public static SporthallenModel getInstance()
	{
		if(shModel == null)
		{
			shModel = new SporthallenModel();
		}
		return shModel;
	}
}
