package stock_categories;

import java.util.ArrayList;

import product_categories.ElectronicsProduct;
import product_categories.Product;

public class Electronics extends Category {
	private ArrayList<ElectronicsProduct> products;
	
	public Electronics() {
		super();
		this.products = new ArrayList<ElectronicsProduct>();
	}
	public Electronics(ArrayList<ElectronicsProduct> products) {
		super();
		this.products = products;
	}
	
	public ArrayList<ElectronicsProduct> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<ElectronicsProduct> products) {
		this.products = products;
	}
	@Override
	public void addProduct(Product p) {
		products.add((ElectronicsProduct) p);
	}
	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
}
