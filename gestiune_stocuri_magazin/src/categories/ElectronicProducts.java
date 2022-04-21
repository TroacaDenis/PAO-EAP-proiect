package categories;

import java.util.ArrayList;

import products.Electronic;
import products.Product;

public class ElectronicProducts extends Category {
	private ArrayList<Electronic> products;
	
	public ElectronicProducts() {
		super();
		this.products = new ArrayList<>();
	}
	public ElectronicProducts(ArrayList<Electronic> products) {
		super();
		this.products = products;
	}
	
	public ArrayList<Electronic> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Electronic> products) {
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
