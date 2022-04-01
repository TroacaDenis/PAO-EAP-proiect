package product_categories;

import distributors.Distributor;

public class ElectronicsProduct extends Product {
	private int guarantee;

	public ElectronicsProduct(String name, double price, int qty, Distributor distributor, int discountPercentage, int guarantee) {
		super(name, price, qty, distributor, discountPercentage);
		this.setGuarantee(guarantee);
	}
	public ElectronicsProduct(String name, double price, int qty, Distributor distributor, int guarantee) {
		super(name, price, qty, distributor);
		this.setGuarantee(guarantee);
	}

	public int getGuarantee() {
		return guarantee;
	}

	public void setGuarantee(int guarantee) {
		this.guarantee = guarantee;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "\nGarantie:" + guarantee + " ani");
	}
	
}
