package Business.businessSporthalle;

import ownUtil.PlausiException;

public class Sporthalle {

	private String name;
	private int qmeter;
	private String bodenbelag;

	Sporthalle(String name, String qmeter, String bodenbelag) throws PlausiException {
		String namenSport = pruefeFormal(name, qmeter, bodenbelag);
		if (namenSport == null) {
			this.name = name;
			this.qmeter = Integer.parseInt(qmeter);
			this.bodenbelag = bodenbelag;
			namenSport = pruefeInhaltlich();
			if (namenSport != null) {
				throw new PlausiException(PlausiException.INHALTLICH, namenSport);
			}
		} else {
			throw new PlausiException(PlausiException.FORMAL, namenSport);
		}
	}

	private String pruefeFormal(String name, String anzahlQuadratmeter, String bodenbelag) {
		String erg = null;
		if (name == null || "".equals(name)) {
			return "Name";
		} else {
			try {
				Integer.parseInt(anzahlQuadratmeter);
			} catch (NumberFormatException exc) {
				return "Anzahl Quadratmeter";
			}
			if (bodenbelag == null || "".equals(bodenbelag)) {
				return "Bodenbelag";
			}
		}
		return erg;
	}
	private String pruefeInhaltlich() {
	String erg = null;
	if(this.qmeter <= 0){
		return "Anzahl Quadratmeter";
	}
		return erg;
		}


	public String gibSporthalleZurueck(char trenner) {
		return this.getName() + trenner + this.getQmeter() + trenner + this.getBodenbelag();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQmeter() {
		return qmeter;
	}

	public void setQmeter(int qmeter) {
		this.qmeter = qmeter;
	}

	public String getBodenbelag() {
		return bodenbelag;
	}

	public void setBodenbelag(String bodenbelag) {
		this.bodenbelag = bodenbelag;
	}

}
