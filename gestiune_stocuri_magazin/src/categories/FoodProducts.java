package categories;

import java.util.SortedSet;
import java.util.TreeSet;

import products.Food;
import products.Product;
import jdbc.*;

public class FoodProducts extends Category {
	private SortedSet<Food> products; 
	
	public FoodProducts() {
		super();
		this.products = new TreeSet<>();
	}

	public FoodProducts(SortedSet<Food> products) {
		super();
		this.products = products;
	}

	public SortedSet<Food> getProducts() {
		return products;
	}

	public void setProducts(SortedSet<Food> products) {
		this.products = products;
	}

	@Override
	public void addProduct(Product p) {
		products.add((Food) p);
		
	}

	@Override
	public void removeProduct(Product p) {
		products.remove(p);
	}
	
	public void applyDiscount(int n) {
		for(Food p : products) {
			if(p.getDiscountPercentage() == 0) {
				p.setDiscountPercentage(25);
				p.setPrice(3*p.getPrice()/4);
				n--;
				FoodDatabase.updateDiscountPercentage(Integer.parseInt(p.getId().substring(1)), 25);
				if(n == 0) {
					return;
				}
			}
		}
	}
	
}
