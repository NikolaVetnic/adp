package main;

public class TocakFactory {

	public static Tocak kreirajTocak(String podaci) {
		
		String[] tokens = podaci.split(",");
		
		int starost = Integer.parseInt(tokens[0].trim());
		String tip = "".equals(tokens[1].trim()) ? "" : tokens[1].trim(); 
				
		Tocak noviTocak = null;
		
		switch (tip) {
		case "letnja":
			noviTocak = new Tocak(ETipTocka.LETNJI, starost);
			break;
		case "zimska":
			noviTocak = new Tocak(ETipTocka.ZIMSKI, starost);
			break;
		default:
			noviTocak = new Tocak(ETipTocka.UNIVERZALNI, starost);
			break;
		}
		
		return noviTocak;
	}
	
	public static Tocak kreirajTocak(int starost, String tip) {
		return kreirajTocak(String.format("%d, %s", starost, tip));
	}
}
