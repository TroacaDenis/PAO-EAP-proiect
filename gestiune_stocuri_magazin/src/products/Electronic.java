package products;


public class Electronic extends Product {
	private int guarantee;

	public Electronic(String name, double price, int qty, int distributorId, int discountPercentage, int guarantee) {
		super(name, price, qty, distributorId, discountPercentage);
		this.setGuarantee(guarantee);
	}
	public Electronic(String name, double price, int qty, int distributorId, int guarantee) {
		super(name, price, qty, distributorId);
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
