package app;

public class ValueGeneratorAdapter {

	public static void upload(double value) {
		Stock stock = new Stock(value);
		stock.upload();
	}
}
