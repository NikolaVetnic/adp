package main;

public abstract class Radnik {

	protected String ime;
	protected int godineRada;
	protected int mesecnaPlata;
	protected int bonus;

	public Radnik(String[] podaci) {
		this.ime = podaci[0];
		this.godineRada = Integer.parseInt(podaci[2].trim());
		this.mesecnaPlata = Integer.parseInt(podaci[3].trim());
		this.bonus = podaci.length > 4 ? Integer.parseInt(podaci[4].trim()) : 0;
	}

	public Radnik() {

	}

	public String getIme() 			{ return ime; 			}
	public int getGodineRada() 		{ return godineRada; 	}
	public int getMesecnaPlata() 	{ return mesecnaPlata; 	}
	public int getBonus() 			{ return bonus; 		}

	public void setIme(String ime) 					{ this.ime = ime; 					}
	public void setGodineRada(int godineRada) 		{ this.godineRada = godineRada; 	}
	public void setMesecnaPlata(int mesecnaPlata) 	{ this.mesecnaPlata = mesecnaPlata; }
	public void setBonus(int bonus) 				{ this.bonus = bonus; 				}

	public abstract double izrPro();
	public abstract double isplata();
	
	public String prikaziPlatu() {
		return "".equals(ime) ? "Ovo nije radnik!\n" : ime + " prima " + this.isplata() + "\n";
	}
}
