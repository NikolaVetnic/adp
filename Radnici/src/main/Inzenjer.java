package main;

public class Inzenjer extends Radnik {
	
	public Inzenjer(String[] podaci) {
		super(podaci);
	}
	
	@Override
	public double izrPro() {
		return godineRada * 0.20 * mesecnaPlata;
	}

	@Override 
	public double isplata() {
		return mesecnaPlata + izrPro() + bonus;
	}
}
