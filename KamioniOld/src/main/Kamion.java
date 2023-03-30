package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
	private IGuma gume[];
	
	public Kamion(String imeFajla, String proizvodjac, String model, int god, int potrosnja, String toDelete) {
		try (BufferedReader bf = new BufferedReader(new FileReader(imeFajla))) {
			
			this.gume = new IGuma[Integer.parseInt(bf.readLine())];
			
			for (int i = 0; i < this.tockovi.length; i++)
				this.gume[i] = GumaFactory.kreirajGumu(bf.readLine());
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		postaviNajboljeGume();
	}
	
	private void postaviNajboljeGume()
	{
		for(int i = 0; i < gume.length - 1; i++) {
			for(int j = i + 1; j < gume.length; j++) {
				if(!gume[i].jeUpotrebljiva() && gume[j].jeUpotrebljiva())
				{
					IGuma tmp = gume[i];
					gume[i] = gume[j];
					gume[j] = tmp;
				}
			}
		}
	}

	public Kamion(String imeFajla, String proizvodjac, String model, int god, int potrosnja) {
		BufferedReader bf;
		
		try {
			bf = new BufferedReader(new FileReader(imeFajla));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		try{
		tockovi = new Tocak[Integer.parseInt(bf.readLine())];
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			zatvaranjeBf(bf);
			return;
		}
		for(int i=0;i<this.tockovi.length;i++)
		{
			try{
			String ulaz = bf.readLine();
			String[] reci = ulaz.split(",");
			for(int j=0;j<reci.length;j++)
				reci[j] = reci[j].trim();
			int st = Integer.parseInt(reci[0]);
			String tip;
			if(reci.length == 2)
			{
				tip = reci[1];
			}
			else
			{
				tip = "univerzalna";
			}
			Tocak t = new Tocak(st, tip);
			tockovi[i] = t;
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		zatvaranjeBf(bf);
		postaviNajboljeTockove();
		
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.godinaProizvodnje = god;
		this.potrosnja = potrosnja;
	}
	
	private void zatvaranjeBf (BufferedReader bf) {
		try {
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Tocak[] getTockovi() {
		return tockovi;
	}

	public void setTockovi(Tocak[] tockovi) {
		this.tockovi = tockovi;
	}
	
	private void postaviNajboljeTockove()
	{
		for(int i=0;i<tockovi.length;i++)
			for(int j=i+1;j<tockovi.length;j++)
				if(!tockovi[i].upotrebljiv() && tockovi[j].upotrebljiv())
				{
					Tocak q = tockovi[i];
					tockovi[i] = tockovi[j];
					tockovi[j] = q;
				}
	}
	
	public boolean mozeDalje()
	{
		int br = 0;
		for(int i=0;i<10;i++)
			if(tockovi[i].upotrebljiv())
				br++;
		if(br > 5)
			return true;
		return false;		
	}
	
	public boolean vozi()
	{
		Random rand = new Random();
		int brojac = 0;
		if(rand.nextInt(10000) < 5)
			tockovi[rand.nextInt(10)].setPuklaGuma(true);
		for(int t = 0; t < 10; t++){
			if(tockovi[t].upotrebljiv())
				brojac++;
			if(brojac > 5)
				return true;
		}
		return false;
	}

	@Override
	public String toString() {
		String str = infoOKamionu();
		str += "Kamion [tockovi=" + Arrays.toString(tockovi) + "]";
		return str;
	}
	
	public String infoOKamionu() {
		String s = "Proizvodjac kamiona je: " + proizvodjac + " \n";
		s += "Model: " + model + " \n";
		s += "Godina proizvodnje: " + godinaProizvodnje + " \n";
		s += "Prosecna potrosnja goriva: " + potrosnja + " \n";
		return s;
	}
	
	
}
