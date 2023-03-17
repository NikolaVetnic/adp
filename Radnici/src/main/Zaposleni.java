package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Zaposleni {

	private Radnik[] radnici;

	public Zaposleni(String zaposleni) {

		BufferedReader bf = otvaranjeBf(zaposleni);
		try {
			radnici = new Radnik[Integer.parseInt(bf.readLine().trim())];
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			zatvaranjeBf(bf);
			return;
		}
		for (int i = 0; i < radnici.length; i++) {
			try {
				String[] podaci = bf.readLine().split("\\|");
				for (int j = 0; j < podaci.length; j++)
					podaci[j] = podaci[j].trim();
				Radnik radnik = new Radnik(podaci[0], podaci[1]);
				radnik.setGodineRada(Integer.parseInt(podaci[2]));
				radnik.setMesecnaPlata(Integer.parseInt(podaci[3]));
				if (podaci.length > 4) {
					radnik.setBonus(Integer.parseInt(podaci[4]));
				}
				radnici[i] = radnik;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		zatvaranjeBf(bf);
	}

	public Radnik[] getRadnici() {
		return radnici;
	}

	public void setRadnici(Radnik[] radnici) {
		this.radnici = radnici;
	}

	private BufferedReader otvaranjeBf(String file) {
		BufferedReader bf;
		try {
			bf = new BufferedReader(new FileReader(file));
			return bf;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	private void zatvaranjeBf(BufferedReader bf) {
		try {
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String prikaziPlatu(Radnik r) {
		String s;
		if (r.getIme() != null) {
			s = r.getIme() + " prima " + r.isplata();
		} else {
			s = "Ovo nije radnik!";
		}
		return s;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zaposleni zap = new Zaposleni("zaposleni.txt");
		for (int i = 0; i < zap.getRadnici().length; i++) {
			System.out.println(zap.prikaziPlatu(zap.getRadnici()[i]));
		}

	}

}
