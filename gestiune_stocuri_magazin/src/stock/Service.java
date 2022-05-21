package stock;

import products.*;

public class Service implements ServiceInterface{
	
	//1
	@Override
	public void getProductInfo(Stock s, String productId) {
		s.getProductInfo(productId);
	}
	
	//2
	@Override
	public void printCategory(Stock s, int category) {
		s.printCategory(category);
	}

	//3
	@Override
	public void addProduct(Stock s, Product p) {
		s.addProduct(p);
	}

	//4
	@Override
	public void removeProduct(Stock s, String productId) {
		s.removeProduct(productId);
	}

	//5
	@Override
	public void clothesWithSize(Stock s, String m) {
		s.printclothes(m);
	}

	//6
	@Override
	public void applyDiscount(Stock s, int n) {
		s.applyDiscount(n);
	}

	//7
	@Override
	public void distributorProducts(Stock s, int DistributorId) {
		s.distributorProducts(DistributorId);
	}

	//8
	@Override
	public void reduceQty(Stock s, String productId, int qty) {
		s.reduceQty(productId, qty);
	}

	//9
	@Override
	public void productsWithPrice(Stock s, int price) {
		s.productsWithPrice(price);
	}

	//10
	@Override
	public void printBooks(Stock s) {
		s.printBooks();
	}


	
}
