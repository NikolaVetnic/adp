package main;

public class Menadzer extends Radnik {
	
	public Menadzer(String[] podaci) {
		super(podaci);
	}

	@Override
	public double izrPro() {
		return godineRada * 0.15 * mesecnaPlata;
	}

	@Override
	public double isplata() {
		return mesecnaPlata + izrPro() + (0.5 * bonus);
	}
}
