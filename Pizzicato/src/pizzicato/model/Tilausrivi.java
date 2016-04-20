package pizzicato.model;

public class Tilausrivi {

	private int tilausrivi_id;
	private int maara;
	private Pizza pizza;
	
	
	//construktorit
	
	public Tilausrivi(int tilausrivi_id, int maara, Pizza pizza) {
		super();
		this.tilausrivi_id = tilausrivi_id;
		this.maara = maara;
		this.pizza = pizza;
	}
	
	public Tilausrivi(){
		super();
		this.tilausrivi_id = 0;
		this.maara = 0;
		this.pizza = null;
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

	
	

	
	
}
