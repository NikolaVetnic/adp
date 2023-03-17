package main;

public class PomocniRadnik extends Radnik {
	
	public PomocniRadnik(String[] podaci) {
		super(podaci);
	}

	public double izrPro() {
		return 0;
	}

	public double isplata() {
		return mesecnaPlata;
	}
}
