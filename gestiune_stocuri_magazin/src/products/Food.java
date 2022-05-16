package products;

import java.time.LocalDate;

public class Food extends Product implements Comparable<Food>{
	private LocalDate expirationDate;
	
	public Food(String name, double price, int qty, int distributorId, int discountPercentage, LocalDate expirationDate) {
		super(name, price, qty, distributorId, discountPercentage);
		this.setExpirationDate(expirationDate);
	}
	public Food(String name, double price, int qty, int distributorId, LocalDate expirationDate) {
		super(name, price, qty, distributorId);
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
