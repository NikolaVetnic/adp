package main;

import java.util.Random;

public interface IGuma {
	
	ETipGume getTipGume();
	boolean jePuklaGuma();
	boolean jeUpotrebljiva();
	
	default boolean verovatnoca() {
		return new Random().nextInt(100) < getTipGume().koeficijentPucanja;
	}
}
