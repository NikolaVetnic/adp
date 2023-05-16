package app;

import java.util.Random;

public class RndSingleton {

    public static RndSingleton INSTANCE = null;
  
    static { 
    	if (INSTANCE == null)
        	INSTANCE = new RndSingleton();
    }
  
    public static synchronized RndSingleton getInstance() {
        return INSTANCE;
    }
    
    public double getNewValue() {
    	return new Random().nextInt(0, 1000) / 10.0;
    }
}
