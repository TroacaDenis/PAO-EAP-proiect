package products;


public class Clothes extends Product{
	private String size;
	public Clothes(String id, String name, double price, int qty, int distributorId, int discountPercentage, String size) {
		super("c" + id, name, price, qty, distributorId, discountPercentage);
		this.setSize(size);
	}
	public Clothes(String id, String name, double price, int qty, int distributorId, String size) {
		super("c" + id, name, price, qty, distributorId);
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
