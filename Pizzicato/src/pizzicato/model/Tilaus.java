package pizzicato.model;

import java.util.ArrayList;
import java.util.Date;

public class Tilaus {

	/* Asiakas attribuutit ja muu asiakkaaseen liittyvä kommmentteina, jos rekisteröityminen tulee
	 * myöhemmin, älä poista toistaiseksi
	 */
	
	private int tilaus_id;
	// private Asiakas asiakas;
	private Date pvm;
	private boolean toimitus;
	private boolean maksu;
	private ArrayList<Tilausrivi> tilausrivit;
	private String nimi;
	private String osoite;
	private int puh;
	private String sposti;
	
	
	
	public Tilaus(int tilaus_id, Date pvm, boolean toimitus,
			boolean maksu, String nimi, String osoite, int puh, String sposti) {
		super();
		this.tilaus_id = tilaus_id;
	//	this.asiakas = asiakas;
		this.pvm = pvm;
		this.toimitus = toimitus;
		this.maksu = maksu;
		this.tilausrivit = new ArrayList<>();
		this.nimi = nimi;
		this.osoite = osoite;
		this.puh = puh;
		this.sposti = sposti;
	}


	public Tilaus() {
		super();
		this.tilaus_id = 0;
		// this.asiakas = null;
		this.pvm = null;
		this.toimitus = false;
		this.maksu = false;
		this.tilausrivit = new ArrayList<>();
		this.nimi = "";
		this.osoite = "";
		this.puh = 0;
		this.sposti = "";
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


	public int getTilaus_id() {
		return tilaus_id;
	}


	public void setTilaus_id(int tilaus_id) {
		this.tilaus_id = tilaus_id;
	}


	/* public Asiakas getAsiakas() {
		return asiakas;
	}


	public void setAsiakas(Asiakas asiakas) {
		this.asiakas = asiakas;
	}
	*/

	public Date getPvm() {
		return pvm;
	}


	public void setPvm(Date pvm) {
	this.pvm = pvm;
	}


	public boolean isToimitus() {
		return toimitus;
	}


	public void setToimitus(boolean toimitus) {
		this.toimitus = toimitus;
	}


	public boolean isMaksu() {
		return maksu;
	}


	public void setMaksu(boolean maksu) {
		this.maksu = maksu;
	}
	

	public void addTilausrivi(Tilausrivi tilausrivi){
		tilausrivit.add(tilausrivi);
	}
	
	public Tilausrivi getTilausrivi(int index){
		return tilausrivit.get(index);
	}
	
	public int getTilausriviMaara() {
		return tilausrivit.size();
	}
	
	public int getTilausrivi_id(){
		return 0;
	}
	
	//ei periaatteessa tarpeen, mutta laitoin kuitenkin... alla siis
	public ArrayList<Tilausrivi> getTilausrivit(){
		return this.tilausrivit;
	}
	
	public double Laskehinta(){
		
		double tilauksenhinta = 0.0;
		double rivihinta;
		Tilausrivi tilausrivi;
		
		//kysyy aktiiviselta pizzalta hinnan ja kertoo lkm:llä
		for (int i = 0; i < tilausrivit.size(); i++) {
			tilausrivi = tilausrivit.get(i);
			tilauksenhinta+=tilausrivi.getRivihinta();
			
			
			
		}
		return tilauksenhinta;
	}


	@Override
	public String toString() {
		return "Tilaus [tilaus_id=" + tilaus_id + ", pvm=" + pvm
				+ ", toimitus=" + toimitus + ", maksu=" + maksu
				+ ", tilausrivit=" + tilausrivit + ", nimi=" + nimi
				+ ", osoite=" + osoite + ", puh=" + puh + ", sposti=" + sposti
				+ "]";
	}
	
}
