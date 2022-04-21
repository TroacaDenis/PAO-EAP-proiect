package categories;

import java.util.ArrayList;

import products.Book;
import products.Product;

public class BookProducts extends Category {
	private ArrayList<Book> products;
	
	public BookProducts() {
		super();
		this.products = new ArrayList<>();
	}
	public BookProducts(ArrayList<Book> products) {
		super();
		this.products = products;
	}
	public ArrayList<Book> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Book> products) {
		this.products = products;
	}
	
	@Override
	public void addProduct(Product p) {
		products.add((Book) p);
	}
	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	
}
