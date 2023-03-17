package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import main.Radnik;
import main.RadnikFactory;

class RadnikTest {

	private static final double MENADZER_KOEFICIJENT_RADA = 0.15;
	private static final double PRODAVAC_KOEFICIJENT_RADA = 0.1;
	private static final double INZENJER_KOEFICIJENT_RADA = 0.2;
	private Radnik[] radnici;
	
	@Test
	void testIzracunajMinuliRad() {
		radnici = new Radnik[3];
		
		radnici[0] = RadnikFactory.kreirajRadnika(new String[] {
				"", "INZENJER", "2", "50000", "6000"
		});
		radnici[1] = RadnikFactory.kreirajRadnika(new String[] {
				"", "PRODAVAC", "5", "30000"
		});
		radnici[2] = RadnikFactory.kreirajRadnika(new String[] {
				"", "MENADZER", "3", "70000", "5000"
		});
		
		int godineRada1 = 2;
		int mesecnaPlata1 = 50000;
		
		int godineRada2 = 5;
		int mesecnaPlata2 = 30000;
		
		int godineRada3 = 3;
		int mesecnaPlata3 = 70000;
		
		double[] ocekivaneVrednosti = new double[] {
				godineRada1 * INZENJER_KOEFICIJENT_RADA * mesecnaPlata1, 
				godineRada2 * PRODAVAC_KOEFICIJENT_RADA * mesecnaPlata2, 
				godineRada3 * MENADZER_KOEFICIJENT_RADA * mesecnaPlata3
		};
		
		assertArrayEquals(ocekivaneVrednosti, 
				new double[] {
						radnici[0].izrPro(), 
						radnici[1].izrPro(), 
						radnici[2].izrPro()
				}
		);
	}
	
	@Test
	void testInzenjerIsplata() {
		int godineRada = 2;
		int mesecnaPlata = 50000;
		int bonus = 6000;
		
		String[] podaci = { "", "INZENJER", "" + godineRada, "" + mesecnaPlata, "" + bonus };
		Radnik radnik = RadnikFactory.kreirajRadnika(podaci);
		
		double minuliRad = radnik.izrPro();
		
		assertEquals(radnik.isplata(), minuliRad + mesecnaPlata + bonus);
	}
	
	@Test
	void testProdavacIsplata() {
		int godineRada = 5;
		int mesecnaPlata = 30000;
		
		String[] podaci = { "", "INZENJER", "" + godineRada, "" + mesecnaPlata };
		Radnik radnik = RadnikFactory.kreirajRadnika(podaci);
		
		double minuliRad = radnik.izrPro();
		
		assertEquals(radnik.isplata(), minuliRad + mesecnaPlata);
	}
	
	@Test
	void testMenadzerIsplata() {
		int godineRada = 3;
		int mesecnaPlata = 70000;
		int bonus = 5000;
		
		String[] podaci = { "", "MENADZER", "" + godineRada, "" + mesecnaPlata, "" + bonus };
		Radnik radnik = RadnikFactory.kreirajRadnika(podaci);
		
		double minuliRad = radnik.izrPro();
		
		assertEquals(radnik.isplata(), mesecnaPlata + minuliRad + (bonus * 0.5));
	}
	
	@Test()
	void testNeispravanTipIsplata() {
		int godineRada = 3;
		int mesecnaPlata = 20000;
		
		String[] podaci = { "", "DOSTAVLJAC", "" + godineRada, "" + mesecnaPlata };
		
		Assertions.assertThrows(RuntimeException.class, () ->
			RadnikFactory.kreirajRadnika(podaci)
		);
	}

	@Test
	void testIsplataVecaOdNule() {
		int godineRada = 3;
		int mesecnaPlata = 70000;
		
		String[] podaci = { "", "MENADZER", "" + godineRada, "" + mesecnaPlata };
		Radnik radnik = RadnikFactory.kreirajRadnika(podaci);

		assertTrue(radnik.isplata() > 0, "Plata radnika " + radnik.isplata() + " bi trebalo da je veca od 0");
	}
}
