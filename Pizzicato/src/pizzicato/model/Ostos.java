package pizzicato.model;

import pizzicato.model.Pizza;

public class Ostos {

	Pizza pizza;
	int lkm;
	double rivihinta;
	boolean oregano;

	public Ostos(Pizza pizza, int lkm, double rivihinta, boolean oregano) {
		super();
		this.pizza = pizza;
		this.lkm = lkm;
		this.rivihinta = rivihinta;
		this.oregano = oregano;
	}

	public Ostos() {
		super();
		this.pizza = null;
		this.lkm = 0;
		this.rivihinta = 0;
		this.oregano = false;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	public int getLkm() {
		return lkm;
	}

	public void setLkm(int lkm) {
		this.lkm = lkm;
	}

	public double getRivihinta() {
		return rivihinta;
	}

	public void setRivihinta(double rivihinta) {
		this.rivihinta = rivihinta;
	}

	public boolean isOregano() {
		return oregano;
	}

	public void setOregano(boolean oregano) {
		this.oregano = oregano;
	}

	@Override
	public String toString() {
		return "Ostos [pizza=" + pizza + ", lkm=" + lkm + ", rivihinta="
				+ rivihinta + ", oregano=" + oregano + "]";
	}

}
