package product_categories;

import distributors.Distributor;

public class BooksProduct extends Product {
	private String author;
	public BooksProduct(String name, double price, int qty, Distributor distributor, int discountPercentage, String author) {
		super(name, price, qty, distributor, discountPercentage);
		this.author = author;
	}
	public BooksProduct(String name, double price, int qty, Distributor distributor, String author) {
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
