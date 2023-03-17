package main;

public class NekonzistentniPodaci extends Exception {
	
	private static final long serialVersionUID = 1L;

	NekonzistentniPodaci(String poruka)
	{
		super(poruka);
	}
}
