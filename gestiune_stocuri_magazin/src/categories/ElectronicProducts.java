package categories;

import java.util.ArrayList;
import java.util.List;

import products.Electronic;
import products.Product;

public class ElectronicProducts extends Category {
	private List<Electronic> products;
	
	public ElectronicProducts() {
		super();
		this.products = new ArrayList<>();
	}
	public ElectronicProducts(List<Electronic> products) {
		super();
		this.products = products;
	}
	
	public List<Electronic> getProducts() {
		return products;
	}
	public void setProducts(List<Electronic> products) {
		this.products = products;
	}
	@Override
	public void addProduct(Product p) {
		products.add((Electronic) p);
	}
	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
}
