package main;

public enum ETipGume {
	
	LETNJA(10, 5), 
	ZIMSKA(5, 1), 
	UNIVERZALNA(7, 3);
	
	int granicnaStarost;
	int koeficijentPucanja;
	
	private ETipGume(int starost, int koeficijentPucanja) {
		this.granicnaStarost = starost;
		this.koeficijentPucanja = koeficijentPucanja;
	}

	public int getGranicnaStarost() {
		return granicnaStarost;
	}

	public int getKoeficijentPucanja() {
		return koeficijentPucanja;
	}
}
