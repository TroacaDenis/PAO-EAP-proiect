package stock_categories;

import java.util.ArrayList;

import product_categories.BooksProduct;
import product_categories.Product;

public class Books extends Category {
	private ArrayList<BooksProduct> products;
	
	public Books() {
		super();
		this.products = new ArrayList<BooksProduct>();
	}
	public Books(ArrayList<BooksProduct> products) {
		super();
		this.products = products;
	}
	public ArrayList<BooksProduct> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<BooksProduct> products) {
		this.products = products;
	}
	
	@Override
	public void addProduct(Product p) {
		products.add((BooksProduct) p);
	}
	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	
}
