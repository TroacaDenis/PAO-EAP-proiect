package products;

import distributors.Distributor;

public class Clothes extends Product{
	private String size;
	public Clothes(String name, double price, int qty, Distributor distributor, int discountPercentage, String size) {
		super(name, price, qty, distributor, discountPercentage);
		this.setSize(size);
	}
	public Clothes(String name, double price, int qty, Distributor distributor, String size) {
		super(name, price, qty, distributor);
		this.setSize(size);
	}
	
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "\nMarime: " + size);
	}
	
}
