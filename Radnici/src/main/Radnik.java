package main;

public class Radnik {

	private String ime;
	private String tip;
	private int godineRada;
	private int mesecnaPlata;
	private int bonus;

	public Radnik(String ime, String tip) {
		this.setIme(ime);
		this.tip = tip;
	}

	public Radnik() {

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public String getTip() {
		return tip;
	}

	public int getGodineRada() {
		return godineRada;
	}

	public void setGodineRada(int godineRada) {
		this.godineRada = godineRada;
	}

	public int getMesecnaPlata() {
		return mesecnaPlata;
	}

	public void setMesecnaPlata(int mesecnaPlata) {
		this.mesecnaPlata = mesecnaPlata;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public double izrPro() {
		switch (getTip()) {
		case "INZENJER":
			return godineRada * 0.20 * mesecnaPlata;
		case "PRODAVAC":
			return godineRada * 0.10 * mesecnaPlata;
		case "MENADZER":
			return godineRada * 0.15 * mesecnaPlata;
		default:
			throw new RuntimeException("Neispravan tip zaposlenog");
		}
	}

	public double isplata() {
		switch (getTip()) {
		case "INZENJER":
			return mesecnaPlata + izrPro() + bonus;
		case "PRODAVAC":
			return mesecnaPlata + izrPro();
		case "MENADZER":
			return mesecnaPlata + izrPro() + (0.5 * bonus);
		case "POMOCNI RADNIK":
			return mesecnaPlata;
		default:
			throw new RuntimeException("Neispravan tip zaposlenog");
		}
	}
}
