package product_categories;

import distributors.Distributor;

public class FoodProduct extends Product implements Comparable<FoodProduct>{
	private String expirationDate;
	
	public FoodProduct(String name, double price, int qty, Distributor distributor, int discountPercentage, String expirationDate) {
		super(name, price, qty, distributor, discountPercentage);
		this.setExpirationDate(expirationDate);
	}
	public FoodProduct(String name, double price, int qty, Distributor distributor, String expirationDate) {
		super(name, price, qty, distributor);
		this.setExpirationDate(expirationDate);
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public int compareTo(FoodProduct p) {
		if (this.expirationDate.equals(p.getExpirationDate())){
			return super.getId() - p.getId();
		}
		int thisExpiration = Integer.parseInt(this.expirationDate.substring(6, 10) + this.expirationDate.substring(3, 5) + this.expirationDate.substring(0, 2));
		int pExpiration = Integer.parseInt(p.getExpirationDate().substring(6, 10) + p.getExpirationDate().substring(3, 5) + p.getExpirationDate().substring(0, 2));
		return thisExpiration - pExpiration;
	}

	@Override
	public String toString() {
		return (super.toString() + "\nData de expirare: " + expirationDate);
	}

	
}
