package pizzicato.model;

import pizzicato.model.Pizza;

public class Tilausrivi {

	private int tilausrivi_id;
	private int maara;
	private Pizza pizza;
	private int extramauste;
	private double rivihinta;
	
	
	//construktorit
	
	public Tilausrivi(int tilausrivi_id, int maara, Pizza pizza, int extramauste, double rivihinta) {
		super();
		this.tilausrivi_id = tilausrivi_id;
		this.maara = maara;
		this.pizza = pizza;
		this.extramauste = extramauste;
		this.rivihinta = rivihinta;
	}
	
	public Tilausrivi(){
		super();
		this.tilausrivi_id = 0;
		this.maara = 0;
		this.pizza = null;
		this.extramauste = 0;
		this.rivihinta = 0.0;
	}
	
	//getterit ja setterit
	

	public int getTilausrivi_id() {
		return tilausrivi_id;
	}

	public void setTilausrivi_id(int tilausrivi_id) {
		this.tilausrivi_id = tilausrivi_id;
	}

	public int getMaara() {
		return maara;
	}

	public void setMaara(int maara) {
		this.maara = maara;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getExtramauste() {
		return extramauste;
	}

	public void setExtramauste(int extramauste) {
		this.extramauste = extramauste;
	}

	public double getRivihinta() {
		return rivihinta;
	}

	public void setRivihinta(double rivihinta) {
		this.rivihinta = rivihinta;
	}
	
	
	

	
	
}
