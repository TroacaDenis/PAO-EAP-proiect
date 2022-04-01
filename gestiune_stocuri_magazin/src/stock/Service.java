package stock;

import product_categories.*;

public class Service implements ServiceInterface{

	@Override
	public void getProductInfo(Stock s, int productId) {
		s.getProductInfo(productId);
	}
	
	@Override
	public void printCategory(Stock s, int category) {
		s.printCategory(category);
		
	}

	@Override
	public void addProduct(Stock s, Product p) {
		s.addProduct(p);
	}

	@Override
	public void removeProduct(Stock s, int productId) {
		s.removeProduct(productId);
		
	}

	@Override
	public void clothesWithSize(Stock s, String m) {
		s.printclothes(m);
	}

	@Override
	public void applyDiscount(Stock s, int n) {
		s.applyDiscount(n);
		
	}

	@Override
	public void distributorProducts(Stock s, int DistributorId) {
		s.distributorProducts(DistributorId);
		
	}

	@Override
	public void reduceQty(Stock s, int productId, int qty) {
		s.reduceQty(productId, qty);
		
	}

	@Override
	public void productsWithPrice(Stock s, int price) {
		s.productsWithPrice(price);
		
	}

	@Override
	public void printBooks(Stock s) {
		s.printBooks();
	}


	
}
