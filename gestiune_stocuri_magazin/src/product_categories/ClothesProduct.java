package product_categories;

import distributors.Distributor;

public class ClothesProduct extends Product{
	private String size;
	public ClothesProduct(String name, double price, int qty, Distributor distributor, int discountPercentage, String size) {
		super(name, price, qty, distributor, discountPercentage);
		this.setSize(size);
	}
	public ClothesProduct(String name, double price, int qty, Distributor distributor, String size) {
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
