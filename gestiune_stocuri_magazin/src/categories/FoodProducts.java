package categories;

import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

import products.Food;
import products.Product;
import csv.CsvService;

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
		CsvService csv = CsvService.getInstance();
		ArrayList<String[]> foodRecords = csv.readFromCsv("src/csvProducts/food.csv");
		for(Food p : products) {
			if(p.getDiscountPercentage() == 0) {
				p.setDiscountPercentage(25);
				p.setPrice(3*p.getPrice()/4);
				n--;
				for (int i = 1; i < foodRecords.size(); i++) {
					if (Integer.parseInt(foodRecords.get(i)[0]) == p.getId()) {
						foodRecords.get(i)[2] = Double.toString(p.getPrice());
						foodRecords.get(i)[5] = Integer.toString(p.getDiscountPercentage());
						break;
					}
				}
				if(n == 0) {
					csv.writeToCsv("src/csvProducts/food.csv", foodRecords);
					return;
				}
			}
		}
	}
	
}
