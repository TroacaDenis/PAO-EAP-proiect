package stock_categories;


import product_categories.*;

public abstract class Category {
	public Category() {
	}
	public abstract void addProduct(Product p);
	public abstract void removeProduct(Product p);
	
	
}
