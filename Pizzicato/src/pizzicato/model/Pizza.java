package pizzicato.model;

import java.util.ArrayList;

import pizzicato.model.dao.TayteDAO;


public class Pizza {

int pizza_id;
String nimi;
double hinta;
private ArrayList<Tayte> taytteet;


//construktori
public Pizza(int pizza_id, String pizza_nimi, double hinta) {
	super();
	this.pizza_id = pizza_id;
	this.nimi = pizza_nimi;
	this.hinta = hinta;
	this.taytteet = new ArrayList<>(); 
}


//construktori superi
public Pizza() {
	super();
	this.pizza_id = 0;
	this.nimi = "";
	this.hinta = 0.00;
	this.taytteet = new ArrayList<>();
	
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

public void addTayte(Tayte tayte){
	taytteet.add(tayte);
}

public Tayte getTayte(int index){
	return taytteet.get(index); 
}

public int getTayteMaara(){
	return taytteet.size();
}
//To_String
public String toString() {
	return "Pizzat [pizza_id=" + pizza_id + ", nimi=" + nimi
			+ ", hinta=" + hinta + "]";
}

}