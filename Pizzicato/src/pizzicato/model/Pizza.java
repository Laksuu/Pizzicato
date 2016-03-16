package pizzicato.model;


public class Pizza {

int pizza_id;
String nimi;
double hinta;


//construktori
public Pizza(int pizza_id, String pizza_nimi, double hinta) {
	super();
	this.pizza_id = pizza_id;
	this.nimi = pizza_nimi;
	this.hinta = hinta;
}


//construktori superi
public Pizza() {
	super();
	this.pizza_id = 0;
	this.nimi = "";
	this.hinta = 0.00;
	
}


// To_String
public String toString() {
	return "Pizzat [pizza_id=" + pizza_id + ", nimi=" + nimi
			+ ", hinta=" + hinta + "]";
}


//getterit ja setterit


public int getPizza_id() {
	return pizza_id;
}

public void setPizza_id(int pizza_id) {
	this.pizza_id = pizza_id;
}

public String getNimi() {
	return nimi;
}

public void setNimi(String pizza_nimi) {
	this.nimi = pizza_nimi;
}

public double getHinta() {
	return hinta;
}

public void setHinta(double hinta) {
	this.hinta = hinta;
}


}