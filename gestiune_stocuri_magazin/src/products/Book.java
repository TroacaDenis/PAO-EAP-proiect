package products;

import distributors.Distributor;

public class Book extends Product {
	private String author;
	public Book(String name, double price, int qty, Distributor distributor, int discountPercentage, String author) {
		super(name, price, qty, distributor, discountPercentage);
		this.author = author;
	}
	public Book(String name, double price, int qty, Distributor distributor, String author) {
		super(name, price, qty, distributor);
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
