package test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import main.Tocak;

public class TocakTest {
		
	private static final int LETNJA_STAROST = 10;
	private static final int ZIMSKA_STAROST = 5;
	private static final int UNIVERZALNA_STAROST = 7;
	
	@Test
	void testUpotrebljivLetnjiPukliMladji() {
		Tocak letnji = new Tocak(LETNJA_STAROST - 1, "letnja");
		letnji.setPuklaGuma(true); 
		assertFalse(letnji.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivLetnjiMladji() {
		Tocak letnji = new Tocak(LETNJA_STAROST - 2, "letnja");
		letnji.setPuklaGuma(false); 
		assertTrue(letnji.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivLetnjiStariji() {
		Tocak letnji = new Tocak(LETNJA_STAROST, "letnja");
		letnji.setPuklaGuma(false); 
		assertFalse(letnji.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivZimskiPukliMladji() {
		Tocak zimski = new Tocak(ZIMSKA_STAROST - 1, "zimska");
		zimski.setPuklaGuma(true); 
		assertFalse(zimski.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivZimskiMladji() {
		Tocak zimski = new Tocak(ZIMSKA_STAROST - 2, "zimska");
		zimski.setPuklaGuma(false); 
		assertTrue(zimski.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivZimskiStariji() {
		Tocak zimski = new Tocak(ZIMSKA_STAROST + 1, "zimska");
		zimski.setPuklaGuma(false); 
		assertFalse(zimski.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivUniverzalniPukliMladji() {
		Tocak univerzalni = new Tocak(UNIVERZALNA_STAROST - 1, "un");
		univerzalni.setPuklaGuma(true); 
		assertFalse(univerzalni.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivUniverzalniMladji() {
		Tocak univerzalni = new Tocak(UNIVERZALNA_STAROST - 1, "uni");
		univerzalni.setPuklaGuma(false); 
		assertTrue(univerzalni.upotrebljiv());
	}
	
	@Test
	void testUpotrebljivUniverzalnStariji() {
		Tocak univerzalni = new Tocak(UNIVERZALNA_STAROST, "neka univerzalna");
		univerzalni.setPuklaGuma(false); 
		assertFalse(univerzalni.upotrebljiv());
	}
	
}
