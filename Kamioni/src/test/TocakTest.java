package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.ETipTocka;
import main.Tocak;
import main.TocakFactory;

public class TocakTest {
		
	private static final int LETNJA_STAROST = 10;
	private static final int ZIMSKA_STAROST = 5;
	private static final int UNIVERZALNA_STAROST = 7;
	
	@Test
	void testUpotrebljivLetnjiPukliMladji() {
		Tocak letnji = new Tocak(ETipTocka.LETNJI, LETNJA_STAROST - 1);
		letnji.setPuklaGuma(true); 
		assertFalse(letnji.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivLetnjiMladji() {
		Tocak letnji = TocakFactory.kreirajTocak(LETNJA_STAROST - 2, "letnja");
		letnji.setPuklaGuma(false); 
		assertTrue(letnji.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivLetnjiStariji() {
		Tocak letnji = TocakFactory.kreirajTocak(LETNJA_STAROST, "letnja");
		letnji.setPuklaGuma(false); 
		assertFalse(letnji.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivZimskiPukliMladji() {
		Tocak zimski = TocakFactory.kreirajTocak(ZIMSKA_STAROST - 1, "zimska");
		zimski.setPuklaGuma(true); 
		assertFalse(zimski.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivZimskiMladji() {
		Tocak zimski = TocakFactory.kreirajTocak(ZIMSKA_STAROST - 2, "zimska");
		zimski.setPuklaGuma(false); 
		assertTrue(zimski.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivZimskiStariji() {
		Tocak zimski = TocakFactory.kreirajTocak(ZIMSKA_STAROST + 1, "zimska");
		zimski.setPuklaGuma(false); 
		assertFalse(zimski.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivUniverzalniPukliMladji() {
		Tocak univerzalni = TocakFactory.kreirajTocak(UNIVERZALNA_STAROST - 1, "un");
		univerzalni.setPuklaGuma(true); 
		assertFalse(univerzalni.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivUniverzalniMladji() {
		Tocak univerzalni = TocakFactory.kreirajTocak(UNIVERZALNA_STAROST - 1, "uni");
		univerzalni.setPuklaGuma(false); 
		assertTrue(univerzalni.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivUniverzalnStariji() {
		Tocak univerzalni = TocakFactory.kreirajTocak(UNIVERZALNA_STAROST, "neka univerzalna");
		univerzalni.setPuklaGuma(false); 
		assertFalse(univerzalni.upotrebljiv());
	}
	
}
