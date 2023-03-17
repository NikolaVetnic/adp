package main;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Facebook {
	
	
	private static final String INFO_SEPARATOR = "\\|";
	private static final String PROFILI = "profili.txt";
	private static final String MATRICA = "matrica.txt";

	
	private FacebookProfil niz[];
	
	
	Facebook(String profiliFajl, String matricaFajl)
	{
		parsirajProfile(profiliFajl);
		parsirajPrijateljstva(matricaFajl);
	}

	
	private void parsirajPrijateljstva(String Matrica) {
		
		try (BufferedReader bf = new BufferedReader(new FileReader(Matrica))) {
			
			for (int i = 0; i < niz.length; i++) {
				
				String[] podaci = bf.readLine().split(INFO_SEPARATOR);
				
				for(int j = i + 1; j < podaci.length; j++) {
					
					if (Integer.parseInt(podaci[j].trim()) == 1) {
						niz[i].dodajPrijatelja(niz[j]);
						niz[j].dodajPrijatelja(niz[i]);					
					}
				}
			}
			
		} catch (IOException | NekonzistentniPodaci e) {
			e.printStackTrace();
		}
	}

	
	private void parsirajProfile(String Profili) {
		
		try (BufferedReader bf = new BufferedReader(new FileReader(Profili))) {
			
			niz = new FacebookProfil[Integer.parseInt(bf.readLine().trim())];
			
			for (int i = 0; i < niz.length; i++)
				niz[i] = new FacebookProfil(bf.readLine().split(INFO_SEPARATOR));
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		for (FacebookProfil fp : niz) {
			sb.append(String.format("%s \nPrijatelji: \n", fp.toString()));
			sb.append(fp.toString());
		}
		
		return sb.toString();
	}
	
	
	public static void main(String[] args)
	{
		Facebook fb = new Facebook(PROFILI, MATRICA);
		System.out.println(fb);
	}
}
