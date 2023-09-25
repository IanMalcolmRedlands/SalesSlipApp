package salesapp;

import java.util.ArrayList;

public class SalesSlip {
	private ArrayList<SalesItem> items;
	
	public SalesSlip() {
		items = new ArrayList<SalesItem>();
	}
	
	public void addItem(SalesItem item) {
		items.add(item);
	}
	
	public String toString() {
		String string = "";
		double sales = 0;
		
		for (SalesItem item : items) {
			string += item.toString()+"\n";
			sales += item.getPrice();
		}
		string += "\nTotal: "+sales;
		return string;
	}
}