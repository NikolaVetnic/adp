package app;

public class Stock {

	private double stockMarketValue;
	
	public Stock(double stockMarketValue) {
		this.stockMarketValue =  stockMarketValue;
	}

	public void upload() {
		System.out.printf("Value %.2f uploaded! %n", this.stockMarketValue);
	}

	@Override
	public String toString() {
		return "Stock [ " + stockMarketValue + " ]";
	}
}
