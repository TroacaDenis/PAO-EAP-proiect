package stock_categories;

import java.util.ArrayList;

import product_categories.ClothesProduct;
import product_categories.Product;

public class Clothes extends Category {
	private ArrayList<ClothesProduct> products;
	
	public Clothes() {
		super();
		this.products = new ArrayList<ClothesProduct> ();
	}
	public Clothes(ArrayList<ClothesProduct> products) {
		super();
		this.products = products;
	}
	
	public ArrayList<ClothesProduct> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<ClothesProduct> products) {
		this.products = products;
	}

	@Override
	public void addProduct(Product p) {
		products.add((ClothesProduct) p);
	}
	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
		
}
