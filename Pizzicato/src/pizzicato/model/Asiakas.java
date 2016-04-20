package pizzicato.model;

public class Asiakas {

	private int asiakas_id;
	private String nimi;
	private String osoite;
	private int puh;
	private String sposti;
	
	
	public Asiakas(int asiakas_id, String nimi, String osoite, int puh,
			String sposti) {
		super();
		this.asiakas_id = asiakas_id;
		this.nimi = nimi;
		this.osoite = osoite;
		this.puh = puh;
		this.sposti = sposti;
	}


	public Asiakas() {
		super();
		this.asiakas_id = 0;
		this.nimi = null;
		this.osoite = null;
		this.puh = 0;
		this.sposti = null;
	}


	public int getAsiakas_id() {
		return asiakas_id;
	}


	public void setAsiakas_id(int asiakas_id) {
		this.asiakas_id = asiakas_id;
	}


	public String getNimi() {
		return nimi;
	}


	public void setNimi(String nimi) {
		this.nimi = nimi;
	}


	public String getOsoite() {
		return osoite;
	}


	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}


	public int getPuh() {
		return puh;
	}


	public void setPuh(int puh) {
		this.puh = puh;
	}


	public String getSposti() {
		return sposti;
	}


	public void setSposti(String sposti) {
		this.sposti = sposti;
	}


	@Override
	public String toString() {
		return "Asiakas [asiakas_id=" + asiakas_id + ", nimi=" + nimi
				+ ", osoite=" + osoite + ", puh=" + puh + ", sposti=" + sposti
				+ "]";
	}
	
	
	
	

}