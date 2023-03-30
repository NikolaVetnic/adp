package main;

import java.util.Random;

public class Tocak {
	private int starost;
//	private String tipGume;
//	private boolean puklaGuma;
	
	private IGuma guma;
	
	public Tocak(String podaci) {
		
		String[] tokens = podaci.split(",");
		
		this.starost = Integer.parseInt(tokens[0]);
		this.guma = GumaFactory.kreirajGumu(tokens.length == 1 ? "" : tokens[1]);
	}
	
	public int getStarost() {
		return starost;
	}
	
	public void setStarost(int starost) {
		this.starost = starost;
	}
	
	public String getTipGume() {
//		return tipGume;
		return guma.getTipGume().toString().toLowerCase();
	}

//	public void setTipGume(String tipGume) {
//		this.tipGume = tipGume;
//	}

	public boolean isPuklaGuma() {
//		return puklaGuma;
		return guma.jePuklaGuma();
	}
	
//	public void setPuklaGuma(boolean puklaGuma) {
//		this.puklaGuma = puklaGuma;
//	}
	
//	public Tocak(int starost, String tipGume) {
//		this.starost = starost;
//		this.tipGume = tipGume;
//		this.puklaGuma = verovatnoca(koeficijentPucanja());
//	}
	
	private int koeficijentPucanja(){
//		switch(tipGume){
//		case "letnja":
//			return 5;
//		case "zimska":
//			return 1;
//		default:
//			return 3;
//		}
		return guma.koeficijentPucanja();
	}

	protected boolean verovatnoca(int k) {
		Random r = new Random();
		if(r.nextInt(100)<k)
			return true;
		return false;
	}

	@Override
	public String toString() {
//		return "Tocak [starost=" + starost + " , tipa " + tipGume + ", puklaGuma=" + puklaGuma + "]";
		return "Tocak [starost=" + starost + " , tipa " + getTipGume() + ", puklaGuma=" + isPuklaGuma() + "]";
	}
	
	public boolean upotrebljiv(){
//		switch(tipGume){
//		case "letnja":
//			return !puklaGuma && starost<10;
//		case "zimska":
//			return !puklaGuma && starost<5;
//		default:
//			return !puklaGuma && starost<7;
//		}
		
	}
	
}
