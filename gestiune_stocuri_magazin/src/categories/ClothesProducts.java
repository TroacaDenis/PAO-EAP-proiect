package categories;

import java.util.ArrayList;

import products.Clothes;
import products.Product;

public class ClothesProducts extends Category {
	private ArrayList<Clothes> products;
	
	public ClothesProducts() {
		super();
		this.products = new ArrayList<> ();
	}
	public ClothesProducts(ArrayList<Clothes> products) {
		super();
		this.products = products;
	}
	
	public ArrayList<Clothes> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Clothes> products) {
		this.products = products;
	}

	@Override
	public void addProduct(Product p) {
		products.add((Clothes) p);
	}
	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
		
}
