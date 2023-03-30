package main;

public enum ETipTocka {

	LETNJI(10, 5), 
	ZIMSKI(5, 1), 
	UNIVERZALNI(7, 3);
	
	int granicnaStarost;
	int koeficijentPucanja;
	
	private ETipTocka(int starost, int koeficijentPucanja) {
		this.granicnaStarost = starost;
		this.koeficijentPucanja = koeficijentPucanja;
	}

	public int getGranicnaStarost() {
		return granicnaStarost;
	}

	public int getKoeficijentPucanja() {
		return koeficijentPucanja;
	}
	
	@Override
	public String toString() {
		switch (this.ordinal()) {
	        case 0:
	            return "letnji";
	        case 1:
	            return "zimski";
	        case 2:
	            return "univerzalni";
	        default:
	            return null;
	    }
	}
}
