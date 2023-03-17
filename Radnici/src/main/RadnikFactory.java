package main;

public class RadnikFactory {

	public static Radnik kreirajRadnika(String[] podaci) {
		Radnik noviRadnik = null;
		String tip = podaci[1];
		
		switch (tip) {
		case "INZENJER":
			noviRadnik = new Inzenjer(podaci);
			break;
		case "PRODAVAC":
			noviRadnik = new Prodavac(podaci);
			break;
		case "MENADZER":
			noviRadnik = new Menadzer(podaci);
			break;
		case "POMOCNI RADNIK":
			noviRadnik = new PomocniRadnik(podaci);
			break;
		default:
			throw new RuntimeException("Neispravan tip zaposlenog");
		}
		
		return noviRadnik;
	}
}
