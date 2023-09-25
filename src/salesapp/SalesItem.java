package salesapp;

public class SalesItem {
	private String name;
	private double cost;
	private int quantity;
	
	public SalesItem(String name, double cost, int quantity) {
		this.name = name;
		this.cost = (double)Math.round(cost*100)/100;
		this.quantity = quantity;
	}
	
	public String toString() {
		return name + "\t $" + cost + "\t " + quantity;
	}
	
	public double getPrice() {
		return cost*(double)quantity;
	}
}