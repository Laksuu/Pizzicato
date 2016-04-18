package pizzicato.model;

import java.util.ArrayList;
import java.util.Date;

public class Tilaus {

	int tilaus_id;
	Asiakas asiakas;
	public Date pvm;
	boolean toimitus;
	boolean maksu;
	public ArrayList<Tilausrivi> tilausrivit;
	
	
	public Tilaus(int tilaus_id, Asiakas asiakas, Date pvm, boolean toimitus,
			boolean maksu) {
		super();
		this.tilaus_id = tilaus_id;
		this.asiakas = asiakas;
		this.pvm = pvm;
		this.toimitus = toimitus;
		this.maksu = maksu;
		this.tilausrivit = new ArrayList<>();
	}


	public Tilaus() {
		super();
		this.tilaus_id = 0;
		this.asiakas = null;
		this.pvm = null;
		this.toimitus = false;
		this.maksu = false;
		this.tilausrivit = new ArrayList<>();
	}


	public int getTilaus_id() {
		return tilaus_id;
	}


	public void setTilaus_id(int tilaus_id) {
		this.tilaus_id = tilaus_id;
	}


	public Asiakas getAsiakas() {
		return asiakas;
	}


	public void setAsiakas(Asiakas asiakas) {
		this.asiakas = asiakas;
	}


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
	
	


	public ArrayList<Tilausrivi> getTilausrivit() {
		return tilausrivit;
	}


	public void setTilausrivit(ArrayList<Tilausrivi> tilausrivit) {
		this.tilausrivit = tilausrivit;
	}


	@Override
	public String toString() {
		return "Tilaus [tilaus_id=" + tilaus_id + ", asiakas=" + asiakas
				+ ", pvm=" + pvm + ", toimitus=" + toimitus + ", maksu="
				+ maksu + "]";
	}

	
}
