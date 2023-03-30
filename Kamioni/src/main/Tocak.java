package main;

import java.util.Random;

public class Tocak {
	
	private ETipTocka tipTocka;
	private int starost;
	private boolean puklaGuma;
	
	public Tocak(ETipTocka tipTocka, int starost) {
		this.tipTocka = tipTocka;
		this.starost = starost;
		this.puklaGuma = verovatnoca();
	}

	public int getStarost() 		{ return starost; 				}
	public String getTipGume() 		{ return tipTocka.toString(); 	}
	public boolean isPuklaGuma() 	{ return puklaGuma; 			}
	
	public void setStarost(int starost) { 
		this.starost = starost; 
	}

	public void setTipGume(String tipGume) {
		switch (tipGume) {
			case "letnja":
				this.tipTocka = ETipTocka.LETNJI; break;
			case "zimska":
				this.tipTocka = ETipTocka.ZIMSKI; break;
			default:
				this.tipTocka = ETipTocka.UNIVERZALNI;
		}
	}
	
	public void setPuklaGuma(boolean puklaGuma) { 
		this.puklaGuma = puklaGuma; 
	}

	public boolean jePuklaGuma() {
		return puklaGuma;
	}

	public ETipTocka getTipTocka() {
		return tipTocka;
	}
	
	private boolean verovatnoca() {
		return new Random().nextInt(100) < tipTocka.koeficijentPucanja;
	}
	
	@Override
	public String toString() {
		return "Tocak [starost=" + starost + " , tipa " + tipTocka.toString() + ", puklaGuma=" + puklaGuma + "]";
	}
	
	public boolean upotrebljiv() {
		return !jePuklaGuma() && this.starost < tipTocka.granicnaStarost;
	}
}
