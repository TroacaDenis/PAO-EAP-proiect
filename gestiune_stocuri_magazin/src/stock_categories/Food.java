package stock_categories;

import java.util.SortedSet;
import java.util.TreeSet;

import product_categories.FoodProduct;
import product_categories.Product;

public class Food extends Category {
	private SortedSet<FoodProduct> products; 
	
	public Food() {
		super();
		this.products = new TreeSet<FoodProduct>();
	}

	public Food(SortedSet<FoodProduct> products) {
		super();
		this.products = products;
	}

	public SortedSet<FoodProduct> getProducts() {
		return products;
	}

	public void setProducts(SortedSet<FoodProduct> products) {
		this.products = products;
	}

	@Override
	public void addProduct(Product p) {
		products.add((FoodProduct) p);
		
	}

	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	public void applyDiscount(int n) {
		for(FoodProduct p : products) {
			if(p.getDiscountPercentage() == 0) {
				p.setDiscountPercentage(25);
				p.setPrice(3*p.getPrice()/4);
				n--;
				if(n == 0) {
					return;
				}
			}
		}
	}
	
}
