package stock;

import stock_categories.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import product_categories.*;

public class Stock {
	private Food food;
	private Electronics electronics;
	private Clothes clothes;
	private Books books;
	
	public Stock() {
		this.food = new Food();
		this.electronics = new Electronics();
		this.clothes = new Clothes();
		this.books = new Books();
	}
	public Stock(Food food, Electronics electronics, Clothes clothes, Books books) {
		this.food = food;
		this.electronics = electronics;
		this.clothes = clothes;
		this.books = books;
	}
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Electronics getElectronics() {
		return electronics;
	}
	public void setElectronics(Electronics electronics) {
		this.electronics = electronics;
	}
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	public Books getBooks() {
		return books;
	}
	public void setBooks(Books books) {
		this.books = books;
	}
	
	public void getProductInfo(int productId) {
		for(FoodProduct f : food.getProducts()) {
			if(productId == f.getId()) {
				System.out.println(f);
				return;
			}
		}
		for(ElectronicsProduct e : electronics.getProducts()) {
			if(productId == e.getId()) {
				System.out.println(e);
				return;
			}
		}
		for(ClothesProduct c : clothes.getProducts()) {
			if(productId == c.getId()) {
				System.out.println(c);
				return;
			}
		}
		for(BooksProduct b : books.getProducts()) {
			if(productId == b.getId()) {
				System.out.println(b);
				return;
			}
		}
		System.out.println("Id invalid!");
	}
	
	public void printCategory(int category) {
		switch (category) {
		case 1:
			for(FoodProduct f : food.getProducts()) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName());
			}
			break;
			
		case 2:
			for(ElectronicsProduct e : electronics.getProducts()) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName());
			}
			break;
		case 3:
			for(BooksProduct b : books.getProducts()) {
				System.out.println("Id produs: " + b.getId() + ", Nume produs: " + b.getName());
			}
			break;
			
		case 4:
			for(ClothesProduct c : clothes.getProducts()) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName());
			}
			break;
		default:
			System.out.println("Categorie incorecta!");
			break;
		}
	}
	
	public void addProduct(Product p) {
		if(p instanceof FoodProduct){
			for(FoodProduct f : food.getProducts()) {
				if(p.getId() == f.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			food.addProduct((FoodProduct) p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof ElectronicsProduct){
			for(ElectronicsProduct e : electronics.getProducts()) {
				if(p.getId() == e.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			electronics.addProduct((ElectronicsProduct) p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof ClothesProduct){
			for(ClothesProduct c : clothes.getProducts()) {
				if(p.getId() == c.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			clothes.addProduct((ClothesProduct) p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof BooksProduct){
			for(BooksProduct b : books.getProducts()) {
				if(p.getId() == b.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			books.addProduct((BooksProduct) p);
			System.out.println("Produs adaugat");
			return;
		}
	}
	
	public void removeProduct(int productId) {
		for(FoodProduct f : food.getProducts()) {
			if(productId == f.getId()) {
				food.removeProduct(f);
				System.out.println("Produs sters");
				return;
			}
		}
		for(ElectronicsProduct e : electronics.getProducts()) {
			if(productId == e.getId()) {
				electronics.removeProduct(e);
				System.out.println("Produs sters");
				return;
			}
		}
		for(ClothesProduct c : clothes.getProducts()) {
			if(productId == c.getId()) {
				clothes.removeProduct(c);
				System.out.println("Produs sters");
				return;
			}
		}
		for(BooksProduct b : books.getProducts()) {
			if(productId == b.getId()) {
				books.removeProduct(b);
				System.out.println("Produs sters");
				return;
			}
		}
		System.out.println("Id invalid!");
	}
	
	public void printclothes(String m) {
		boolean printsResults = false;
		for(ClothesProduct c : clothes.getProducts()) {
			if(m.equals(c.getSize())) {
				System.out.println(c + "\n");
				printsResults = true;
			}
		}
		if(!printsResults) {
			System.out.println("Nu exista haine de marimea " + m + "\n");
		}
	}
	
	public void applyDiscount(int n) {
		food.applyDiscount(n);
		System.out.println(n + " produse reduse");
	}
	
	public void distributorProducts(int DistributorId) {
		boolean printResults = false;
		for(FoodProduct f : food.getProducts()) {
			if(DistributorId == f.getDistributor().getId()) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName());
				printResults = true;
			}
		}
		for(ElectronicsProduct e : electronics.getProducts()) {
			if(DistributorId == e.getDistributor().getId()) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName());
				printResults = true;
			}
		}
		for(ClothesProduct c : clothes.getProducts()) {
			if(DistributorId == c.getDistributor().getId()) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName());
				printResults = true;
			}
		}
		for(BooksProduct b : books.getProducts()) {
			if(DistributorId == b.getDistributor().getId()) {
				System.out.println("Id produs: " + b.getId() + ", Nume produs: " + b.getName());
				printResults = true;
			}
		}
		if(!printResults) {
			System.out.println("Nu exista produse achizitionate de la distribuitorul " + DistributorId);
		}
	}
	
	public void reduceQty(int productId, int qty) {
		for(FoodProduct f : food.getProducts()) {
			if(f.reduceQty(productId, qty)) {
				return;
			}
		}
		for(ElectronicsProduct e : electronics.getProducts()) {
			if(e.reduceQty(productId, qty)) {
				return;
			}
		}
		for(ClothesProduct c : clothes.getProducts()) {
			if(c.reduceQty(productId, qty)) {
				return;
			}
		}
		for(BooksProduct b : books.getProducts()) {
			if(b.reduceQty(productId, qty)) {
				return;
			}
		}
		System.out.println("Id invalid!");
	}
	
	public void productsWithPrice(int price) {
		boolean printResults = false;
		for(FoodProduct f : food.getProducts()) {
			if(f.getPrice() <= price) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName() + ", Pret: " + f.getPrice() + " lei");
				printResults = true;
			}
		}
		for(ElectronicsProduct e : electronics.getProducts()) {
			if(e.getPrice() <= price) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName() + ", Pret: " + e.getPrice() + " lei");
				printResults = true;
			}
		}
		for(ClothesProduct c : clothes.getProducts()) {
			if(c.getPrice() <= price) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName() + ", Pret: " + c.getPrice() + " lei");
				printResults = true;
			}
		}
		for(BooksProduct b : books.getProducts()) {
			if(b.getPrice() <= price) {
				System.out.println("Id produs: " + b.getId() + ", Nume produs: " + b.getName() + ", Pret: " + b.getPrice() + " lei");
				printResults = true;
			}
		}
		if(!printResults) {
			System.out.println("Nu exista produse atat de ieftine");
		}
	}
	
	public void printBooks() {
		HashMap<String, ArrayList<BooksProduct>> booksByAuthor = new HashMap<String, ArrayList<BooksProduct>>();
		for(BooksProduct b : books.getProducts()) {
			if(!booksByAuthor.containsKey(b.getAuthor())) {
				ArrayList<BooksProduct> aux = new ArrayList<BooksProduct>();
				aux.add(b);
				booksByAuthor.put(b.getAuthor(), aux);
			}
			else {
				ArrayList<BooksProduct> aux = booksByAuthor.get(b.getAuthor());
				aux.add(b);
				booksByAuthor.put(b.getAuthor(), aux);
			}
		}	
		for(String author : booksByAuthor.keySet()) {
			System.out.println("Autor: " + author);
			System.out.println("Carti: ");
			for(BooksProduct book : booksByAuthor.get(author)) {
				System.out.println("Id: " + book.getId() + ", Nume: " + book.getName());
			}
			System.out.print("\n");
		}
	}
	
}
