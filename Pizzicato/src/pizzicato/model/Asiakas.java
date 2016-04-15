package pizzicato.model;

public class Asiakas {

	String etunimi;
	String sukunimi;
	String osoite;
	String postinmr;
	String puh;
	String sposti;

	public Asiakas(String etunimi, String sukunimi, String osoite,
			String postinmr, String puh, String sposti) {
		super();
		this.etunimi = etunimi;
		this.sukunimi = sukunimi;
		this.osoite = osoite;
		this.postinmr = postinmr;
		this.puh = puh;
		this.sposti = sposti;
	}

	public Asiakas() {
		this.etunimi = "";
		this.sukunimi = "";
		this.osoite = "";
		this.postinmr = "";
		this.puh = "";
		this.sposti = "";

	}

	public String getEtunimi() {
		return etunimi;
	}

	public void setEtunimi(String etunimi) {
		this.etunimi = etunimi;
	}

	public String getSukunimi() {
		return sukunimi;
	}

	public void setSukunimi(String sukunimi) {
		this.sukunimi = sukunimi;
	}

	public String getOsoite() {
		return osoite;
	}

	public void setOsoite(String osoite) {
		this.osoite = osoite;
	}

	public String getPostinmr() {
		return postinmr;
	}

	public void setPostinmr(String postinmr) {
		this.postinmr = postinmr;
	}

	public String getPuh() {
		return puh;
	}

	public void setPuh(String puh) {
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
		return "Asiakas [etunimi=" + etunimi + ", sukunimi=" + sukunimi
				+ ", osoite=" + osoite + ", postinmr=" + postinmr + ", puh="
				+ puh + ", sposti=" + sposti + "]";
	}

}