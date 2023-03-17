package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Zaposleni {

	private static final String DELIMITER = "\\|";
	
	private Radnik[] radnici;

	public Zaposleni(String zaposleni) {
		try (BufferedReader bf = new BufferedReader(new FileReader(zaposleni))) {
			
			radnici = new Radnik[Integer.parseInt(bf.readLine().trim())];
			
			for (int i = 0; i < radnici.length; i++) {
				String[] podaci = bf.readLine().split(DELIMITER);
				
				for (int j = 0; j < podaci.length; j++)
					podaci[j] = podaci[j].trim();
				
				radnici[i] = RadnikFactory.kreirajRadnika(podaci);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	public Radnik[] getRadnici() {
		return radnici;
	}

	public void setRadnici(Radnik[] radnici) {
		this.radnici = radnici;
	}
	
	public String prikaziPlate() {
		StringBuilder sb = new StringBuilder();
		
		for (Radnik r : radnici)
			sb.append(r.prikaziPlatu());
		
		return sb.toString();
	}

	public static void main(String[] args) {
		Zaposleni zap = new Zaposleni("zaposleni.txt");
		System.out.println(zap.prikaziPlate());
	}
}