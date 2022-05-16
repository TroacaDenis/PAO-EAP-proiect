package categories;

import java.util.ArrayList;
import java.util.List;

import products.Clothes;
import products.Product;

public class ClothesProducts extends Category {
	private List<Clothes> products;
	
	public ClothesProducts() {
		super();
		this.products = new ArrayList<> ();
	}
	public ClothesProducts(List<Clothes> products) {
		super();
		this.products = products;
	}
	
	public List<Clothes> getProducts() {
		return products;
	}
	public void setProducts(List<Clothes> products) {
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
