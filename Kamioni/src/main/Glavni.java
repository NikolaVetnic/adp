package main;

import java.io.IOException;

public class Glavni {
	
	public static void main(String[] asddas) throws NumberFormatException, IOException {
		Kamion k = new Kamion("tockovi.txt", "Mercedes", "X360", 2015, 15);
		System.out.println(k.toString());
		
		if (!k.mozeDalje()) {
			System.out.println("Ne moze da krene");
			return;
		}
		
		for (int i = 0; i < 500; i++) {
			if (!k.vozi()) {
				System.out.println("Stao na " + i);
				return;
			}
		}
		
		System.out.println("Presao sve");
	}
}
