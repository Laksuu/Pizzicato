package pizzicato.model;

import java.util.HashMap;

public class Ostoskori {

	HashMap<String, Integer> ostokorinpizzat;

	public Ostoskori() {
		ostokorinpizzat = new HashMap<>();
	}

	public HashMap getKoriItems() {
		return ostokorinpizzat;
	}

	public void lisaaostoskoriin(String pizzaid, int hinta) {
		ostokorinpizzat.put(pizzaid, hinta);
	}

}
