package products;

import java.time.LocalDate;

import distributors.Distributor;

public class Food extends Product implements Comparable<Food>{
	private LocalDate expirationDate;
	
	public Food(String name, double price, int qty, Distributor distributor, int discountPercentage, LocalDate expirationDate) {
		super(name, price, qty, distributor, discountPercentage);
		this.setExpirationDate(expirationDate);
	}
	public Food(String name, double price, int qty, Distributor distributor, LocalDate expirationDate) {
		super(name, price, qty, distributor);
		this.setExpirationDate(expirationDate);
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate expirationDate) {
		this.expirationDate = expirationDate;
	}

	@Override
	public int compareTo(Food p) {
		if (this.expirationDate.isEqual(p.getExpirationDate())){
			return super.getId() - p.getId();
		}
		else
			if(this.expirationDate.isAfter(p.getExpirationDate()))
				return 1;
			else
				return -1;
	}

	@Override
	public String toString() {
		return (super.toString() + "\nData de expirare: " + expirationDate);
	}

	
}
