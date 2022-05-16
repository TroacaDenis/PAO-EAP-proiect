package stock;

import products.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import csv.CsvReader;
import csv.*;
import csv.CsvWriter;

public class Service implements ServiceInterface{

	private CsvAudit csvAudit = CsvAudit.getInstance();
	private void registerAction(String action){
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String timestamp = LocalDateTime.now().format(format);
		String [] record = {action, timestamp};
		csvAudit.auditCsv("src/csvActions/actiuniRealizate.csv", record);
	}
	
	
	@Override
	public void getProductInfo(Stock s, int productId) {
		registerAction("Afiseaza toate informatiile despre un produs");
		s.getProductInfo(productId);
	}
	
	@Override
	public void printCategory(Stock s, int category) {
		registerAction("Afiseaza toate produsele dintr-o categorie");
		s.printCategory(category);
	}

	@Override
	public void addProduct(Stock s, Product p) {
		registerAction("Adauga produs");
		s.addProduct(p);
	}

	@Override
	public void removeProduct(Stock s, int productId) {
		registerAction("Sterge produs");
		s.removeProduct(productId);
	}

	@Override
	public void clothesWithSize(Stock s, String m) {
		registerAction("Afiseaza haine");
		s.printclothes(m);
	}

	@Override
	public void applyDiscount(Stock s, int n) {
		registerAction("Aplica reducere produselor ce vor expira");
		s.applyDiscount(n);
	}

	@Override
	public void distributorProducts(Stock s, int DistributorId) {
		registerAction("Afiseaza produsele achizitionate de la un distributor");
		s.distributorProducts(DistributorId);
	}

	@Override
	public void reduceQty(Stock s, int productId, int qty) {
		registerAction("Modifica cantitate");
		s.reduceQty(productId, qty);
	}

	@Override
	public void productsWithPrice(Stock s, int price) {
		registerAction("Afiseaza produse dupa pret");
		s.productsWithPrice(price);
	}

	@Override
	public void printBooks(Stock s) {
		registerAction("Grupeaza cartile dupa autor");
		s.printBooks();
	}


	
}
