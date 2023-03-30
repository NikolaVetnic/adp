package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Kamion {

	private String proizvodjac;
	private String model;
	private int godinaProizvodnje;
	private int potrosnja;
	private Tocak tockovi[];

	public Kamion(String imeFajla, String proizvodjac, String model, int god, int potrosnja) {
		try (BufferedReader bf = new BufferedReader(new FileReader(imeFajla))) {

			this.tockovi = new Tocak[Integer.parseInt(bf.readLine())];

			for (int i = 0; i < this.tockovi.length; i++)
				this.tockovi[i] = TocakFactory.kreirajTocak(bf.readLine());

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

		postaviNajboljeTockove();
	}

	private void postaviNajboljeTockove() {
		for (int i = 0; i < tockovi.length - 1; i++) {
			for (int j = i + 1; j < tockovi.length; j++) {
				if (!tockovi[i].upotrebljiv() && tockovi[j].upotrebljiv()) {
					Tocak tmp = tockovi[i];
					tockovi[i] = tockovi[j];
					tockovi[j] = tmp;
				}
			}
		}
	}

	public Tocak[] getTockovi() {
		return tockovi;
	}

	public void setTockovi(Tocak[] tockovi) {
		this.tockovi = tockovi;
	}

	public boolean mozeDalje() {
		int br = 0;

		for (int i = 0; i < 10; i++) {
			br = tockovi[i].upotrebljiv() ? br + 1 : br;

			if (br > 5)
				return true;
		}

		return false;
	}

	public boolean vozi() {

		Random rand = new Random();
		int brojac = 0;

		if (rand.nextInt(10000) < 5)
			tockovi[rand.nextInt(10)].setPuklaGuma(true);

		for (int t = 0; t < 10; t++) {
			if (tockovi[t].upotrebljiv())
				brojac++;
			if (brojac > 5)
				return true;
		}

		return false;
	}

	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();

		sb.append(infoOKamionu() + "\n");
		sb.append(String.format("Kamion [tockovi=%s]", Arrays.toString(tockovi)));

		return sb.toString();
	}

	public String infoOKamionu() {

		StringBuilder sb = new StringBuilder();

		sb.append(String.format("Proizvodjac kamiona je: 	%s \n", proizvodjac));
		sb.append(String.format("Model: 					%s \n", model));
		sb.append(String.format("Godina proizvodnje: 		%d \n", godinaProizvodnje));
		sb.append(String.format("Prosecna potrosnja goriva: %d   ", potrosnja));

		return sb.toString();
	}
}
