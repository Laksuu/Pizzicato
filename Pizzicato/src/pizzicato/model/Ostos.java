package pizzicato.model;

import pizzicato.model.Pizza;

public class Ostos {

	Pizza pizza;
	int lkm;
	double rivihinta;
	int extramauste;
	boolean oregano;
	boolean valkosipuli;

	public Ostos(Pizza pizza, int lkm, double rivihinta, int extramauste, boolean oregano, boolean valkosipuli) {
		super();
		this.pizza = pizza;
		this.lkm = lkm;
		this.rivihinta = rivihinta;
		this.extramauste = extramauste;
		this.oregano = oregano;
		this.valkosipuli = valkosipuli;
	}

	public Ostos() {
		super();
		this.pizza = null;
		this.lkm = 0;
		this.extramauste = 0;
		this.rivihinta = 0;
		this.oregano = false;
		this.valkosipuli = false;
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

	public int getExtramauste() {
		return extramauste;
	}

	public void setExtramauste(int extramauste) {
		this.extramauste = extramauste;
	}
	
	
	
	public boolean isOregano() {
		return oregano;
	}
	

	public void setOregano(boolean oregano) {
		this.oregano = oregano;
	}
	
	public boolean isValkosipuli() {
		return valkosipuli;
	}
	

	public void setValkosipuli(boolean valkosipuli) {
		this.valkosipuli = valkosipuli;
	}

	@Override
	public String toString() {
		return "Ostos [pizza=" + pizza + ", lkm=" + lkm + ", rivihinta="
				+ rivihinta + ", extramauste=" + extramauste + ", oregano=" + oregano + ", valkosipuli=" + valkosipuli + "]";
	}

}
