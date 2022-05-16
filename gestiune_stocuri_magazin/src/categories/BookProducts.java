package categories;

import java.util.ArrayList;
import java.util.List;

import products.Book;
import products.Product;

public class BookProducts extends Category {
	private List<Book> products;
	
	public BookProducts() {
		super();
		this.products = new ArrayList<>();
	}
	public BookProducts(List<Book> products) {
		super();
		this.products = products;
	}
	public List<Book> getProducts() {
		return products;
	}
	public void setProducts(List<Book> products) {
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
