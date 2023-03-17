package test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import main.Radnik;

class RadnikTest {

	private static final double MENADZER_KOEFICIJENT_RADA = 0.15;
	private static final double PRODAVAC_KOEFICIJENT_RADA = 0.1;
	private static final double INZENJER_KOEFICIJENT_RADA = 0.2;
	private Radnik radnik;
	private Radnik[] radnici;
	
	@BeforeEach
	void setUp() throws Exception {
		radnik = new Radnik() {
		};
	}
	
	@Test
	void testIzracunajMinuliRad() {
		radnici = new Radnik[3];
		
		String tip1 = "INZENJER";
		int godineRada1 = 2;
		int mesecnaPlata1 = 50000;
		int bonus1 = 6000;
		radnici[0] = new Radnik();
		radnici[0].setTip(tip1);
		radnici[0].setGodineRada(godineRada1);
		radnici[0].setMesecnaPlata(mesecnaPlata1);
		radnici[0].setBonus(bonus1);
		
		String tip2 = "PRODAVAC";
		int godineRada2 = 5;
		int mesecnaPlata2 = 30000;
		radnici[1] = new Radnik();
		radnici[1].setTip(tip2);
		radnici[1].setGodineRada(godineRada2);
		radnici[1].setMesecnaPlata(mesecnaPlata2);
		
		String tip3 = "MENADZER";
		int godineRada3 = 3;
		int mesecnaPlata3 = 70000;
		int bonus3 = 5000;
		radnici[2] = new Radnik();
		radnici[2].setTip(tip3);
		radnici[2].setGodineRada(godineRada3);
		radnici[2].setMesecnaPlata(mesecnaPlata3);
		radnici[2].setBonus(bonus3);
		
		double[] ocekivaneVrednosti = new double[]{godineRada1 * INZENJER_KOEFICIJENT_RADA * mesecnaPlata1, 
				godineRada2 * PRODAVAC_KOEFICIJENT_RADA * mesecnaPlata2, godineRada3 * MENADZER_KOEFICIJENT_RADA * mesecnaPlata3};
		assertArrayEquals(ocekivaneVrednosti, new double[] {radnici[0].izrPro(), radnici[1].izrPro(), radnici[2].izrPro()});
	}
	
	@Test
	void testInzenjerIsplata() {
		String tip = "INZENJER";
		int godineRada = 2;
		int mesecnaPlata = 50000;
		int bonus = 6000;
		radnik.setTip(tip);
		radnik.setGodineRada(godineRada);
		radnik.setMesecnaPlata(mesecnaPlata);
		radnik.setBonus(bonus);
		double minuliRad = radnik.izrPro();
		assertEquals(radnik.isplata(), minuliRad + mesecnaPlata + bonus);
	}
	
	@Test
	void testProdavacIsplata() {
		String tip = "PRODAVAC";
		int godineRada = 5;
		int mesecnaPlata = 30000;
		radnik.setTip(tip);
		radnik.setGodineRada(godineRada);
		radnik.setMesecnaPlata(mesecnaPlata);
		double minuliRad = radnik.izrPro();
		assertEquals(radnik.isplata(), mesecnaPlata + minuliRad);
	}
	
	@Test
	void testMenadzerIsplata() {
		String tip = "MENADZER";
		int godineRada = 3;
		int mesecnaPlata = 70000;
		int bonus = 5000;
		radnik.setTip(tip);
		radnik.setGodineRada(godineRada);
		radnik.setMesecnaPlata(mesecnaPlata);
		radnik.setBonus(bonus);
		double minuliRad = radnik.izrPro();
		assertEquals(radnik.isplata(), mesecnaPlata + minuliRad + (bonus * 0.5));
	}
	
	@Test()
	void testNeispravanTipIsplata() {
		String tip = "DOSTAVLJAC";
		int godineRada = 3;
		int mesecnaPlata = 20000;
		radnik.setTip(tip);
		radnik.setGodineRada(godineRada);
		radnik.setMesecnaPlata(mesecnaPlata);
		Assertions.assertThrows(RuntimeException.class, () ->
			radnik.isplata()
		);
	}

	@Test
	void testIsplataVecaOdNule() {
		String tip = "MENADZER";
		int godineRada = 3;
		int mesecnaPlata = 70000;
		radnik.setTip(tip);
		radnik.setGodineRada(godineRada);
		radnik.setMesecnaPlata(mesecnaPlata);
		assertTrue(radnik.isplata() > 0, "Plata radnika " + radnik.isplata() + " bi trebalo da je veca od 0");
	}
}
