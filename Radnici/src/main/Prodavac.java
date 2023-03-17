package main;

public class Prodavac extends Radnik {
	
	public Prodavac(String[] podaci) {
		super(podaci);
	}

	@Override
	public double izrPro() {
		return godineRada * 0.10 * mesecnaPlata;
	}

	@Override
	public double isplata() {
		return mesecnaPlata + izrPro();
	}
}
