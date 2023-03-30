package main;

public class GumaFactory {

	public static IGuma kreirajGumu(String podaci) {
		
		String[] tokens = podaci.split(",");
		
		int starost = Integer.parseInt(tokens[0].trim());
		String tip = "".equals(tokens[1].trim()) ? "" : tokens[1].trim(); 
				
		IGuma novaGuma = null;
		
		switch (tip) {
		case "letnja":
			novaGuma = new Guma(ETipGume.LETNJA, starost);
			break;
		case "zimska":
			novaGuma = new Guma(ETipGume.ZIMSKA, starost);
			break;
		default:
			novaGuma = new Guma(ETipGume.UNIVERZALNA, starost);
			break;
		}
		
		return novaGuma;
	}
}
