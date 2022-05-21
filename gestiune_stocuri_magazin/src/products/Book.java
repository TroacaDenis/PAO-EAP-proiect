package products;

public class Book extends Product {
	private String author;
	public Book(String id, String name, double price, int qty, int distributorId, int discountPercentage, String author) {
		super("b" + id, name, price, qty, distributorId, discountPercentage);
		this.author = author;
	}
	public Book(String id, String name, double price, int qty, int distributorId, String author) {
		super("b" + id, name, price, qty, distributorId);
		this.author = author;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return (super.toString() + "\nAutor: " + author);
	}
	
}
