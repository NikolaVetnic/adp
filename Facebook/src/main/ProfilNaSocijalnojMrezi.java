package main;

public abstract class ProfilNaSocijalnojMrezi implements CvorUMrezi{
	
	
	ProfilNaSocijalnojMrezi niz[];
	private int popunjeno;
	
	
	public ProfilNaSocijalnojMrezi(int brojPr)
	{
		if (brojPr < 0)
			throw new NumberFormatException("ne moze imati negativan broj prijatelja");
		
		this.niz = new ProfilNaSocijalnojMrezi[brojPr];
	}
	

	@Override
	public boolean sused(CvorUMrezi c) {
		
		ProfilNaSocijalnojMrezi p = (ProfilNaSocijalnojMrezi) c;
		
		for (int i = 0; i < popunjeno; i++)
			if (niz[i].equals(p))
				return true;
		
		return false;
	}
	
	
	public boolean imaMesta() {
		return popunjeno < niz.length;
	}
	
	
	public void dodajPrijatelja(ProfilNaSocijalnojMrezi pr) throws NekonzistentniPodaci
	{
		if (this.imaMesta())
			this.niz[popunjeno++] = pr;
		else
			throw new NekonzistentniPodaci("Previse ih je u " + ((ProfilNaSocijalnojMrezi)this).toString());
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < popunjeno; i++) {
			sb.append(niz[i].toString());
		}
			
		return sb.toString();
	}
}
