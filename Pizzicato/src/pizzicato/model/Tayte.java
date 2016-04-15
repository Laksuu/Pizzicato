package pizzicato.model;

public class Tayte {

	int tayte_id;
	double tayte_hinta;
	String tayte;

	// construktorit

	public Tayte(int tayte_id, double tayte_hinta, String tayte) {
		super();
		this.tayte_id = tayte_id;
		this.tayte_hinta = tayte_hinta;
		this.tayte = tayte;
	}

	public Tayte() {
		super();
		this.tayte_id = 0;
		this.tayte_hinta = 0.00;
		this.tayte = "";
	}

	// getterit ja setterit

	public int getTayte_id() {
		return tayte_id;
	}

	public void setTayte_id(int tayte_id) {
		this.tayte_id = tayte_id;
	}

	public double getTayte_hinta() {
		return tayte_hinta;
	}

	public void setTayte_hinta(double tayte_hinta) {
		this.tayte_hinta = tayte_hinta;
	}

	public String getTayte() {
		return tayte;
	}

	public void setTayte(String tayte) {
		this.tayte = tayte;
	}

	// tostring

	public String toString() {
		return "Tayte [tayte_id=" + tayte_id + ", tayte_hinta=" + tayte_hinta
				+ ", tayte=" + tayte + "]";
	}

}
