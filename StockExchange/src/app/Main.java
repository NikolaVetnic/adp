package app;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

	public static void main(String[] args) {
		
		while (true) {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			double value = RndSingleton.INSTANCE.getNewValue();
			
			System.out.printf("Value at %s : %.2f %n", dtf.format(LocalDateTime.now()), value);
			ValueGeneratorAdapter.upload(value);
			
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
