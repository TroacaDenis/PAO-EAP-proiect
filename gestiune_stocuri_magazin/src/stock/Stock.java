package stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import categories.*;
import products.*;

public class Stock {
	private FoodProducts food;
	private ElectronicProducts electronics;
	private ClothesProducts clothes;
	private BookProducts books;
	
	public Stock() {
		this.food = new FoodProducts();
		this.electronics = new ElectronicProducts();
		this.clothes = new ClothesProducts();
		this.books = new BookProducts();
	}
	public Stock(FoodProducts food, ElectronicProducts electronics, ClothesProducts clothes, BookProducts books) {
		this.food = food;
		this.electronics = electronics;
		this.clothes = clothes;
		this.books = books;
	}
	
	public FoodProducts getFood() {
		return food;
	}
	public void setFood(FoodProducts food) {
		this.food = food;
	}
	public ElectronicProducts getElectronics() {
		return electronics;
	}
	public void setElectronics(ElectronicProducts electronics) {
		this.electronics = electronics;
	}
	public ClothesProducts getClothes() {
		return clothes;
	}
	public void setClothes(ClothesProducts clothes) {
		this.clothes = clothes;
	}
	public BookProducts getBooks() {
		return books;
	}
	public void setBooks(BookProducts books) {
		this.books = books;
	}
	
	public void getProductInfo(int productId) {
		for(Food f : food.getProducts()) {
			if(productId == f.getId()) {
				System.out.println(f);
				return;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(productId == e.getId()) {
				System.out.println(e);
				return;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(productId == c.getId()) {
				System.out.println(c);
				return;
			}
		}
		for(Book b : books.getProducts()) {
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
			for(Food f : food.getProducts()) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName());
			}
			break;
			
		case 2:
			for(Electronic e : electronics.getProducts()) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName());
			}
			break;
		case 3:
			for(Book b : books.getProducts()) {
				System.out.println("Id produs: " + b.getId() + ", Nume produs: " + b.getName());
			}
			break;
			
		case 4:
			for(Clothes c : clothes.getProducts()) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName());
			}
			break;
		default:
			System.out.println("Categorie incorecta!");
			break;
		}
	}
	
	public void addProduct(Product p) {
		if(p instanceof Food){
			for(Food f : food.getProducts()) {
				if(p.getId() == f.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			food.addProduct((Food) p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof Electronic){
			for(Electronic e : electronics.getProducts()) {
				if(p.getId() == e.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			electronics.addProduct((Electronic) p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof Clothes){
			for(Clothes c : clothes.getProducts()) {
				if(p.getId() == c.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			clothes.addProduct((Clothes) p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof Book){
			for(Book b : books.getProducts()) {
				if(p.getId() == b.getId()) {
					System.out.println("Produsul cu id-ul " + p.getId() + " exista deja!");
					return;
				}
			}
			books.addProduct((Book) p);
			System.out.println("Produs adaugat");
			return;
		}
	}
	
	public void removeProduct(int productId) {
		for(Food f : food.getProducts()) {
			if(productId == f.getId()) {
				food.removeProduct(f);
				System.out.println("Produs sters");
				return;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(productId == e.getId()) {
				electronics.removeProduct(e);
				System.out.println("Produs sters");
				return;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(productId == c.getId()) {
				clothes.removeProduct(c);
				System.out.println("Produs sters");
				return;
			}
		}
		for(Book b : books.getProducts()) {
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
		for(Clothes c : clothes.getProducts()) {
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
		for(Food f : food.getProducts()) {
			if(DistributorId == f.getDistributor().getId()) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName());
				printResults = true;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(DistributorId == e.getDistributor().getId()) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName());
				printResults = true;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(DistributorId == c.getDistributor().getId()) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName());
				printResults = true;
			}
		}
		for(Book b : books.getProducts()) {
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
		for(Food f : food.getProducts()) {
			if(f.reduceQty(productId, qty)) {
				return;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(e.reduceQty(productId, qty)) {
				return;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(c.reduceQty(productId, qty)) {
				return;
			}
		}
		for(Book b : books.getProducts()) {
			if(b.reduceQty(productId, qty)) {
				return;
			}
		}
		System.out.println("Id invalid!");
	}
	
	public void productsWithPrice(int price) {
		boolean printResults = false;
		for(Food f : food.getProducts()) {
			if(f.getPrice() <= price) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName() + ", Pret: " + f.getPrice() + " lei");
				printResults = true;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(e.getPrice() <= price) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName() + ", Pret: " + e.getPrice() + " lei");
				printResults = true;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(c.getPrice() <= price) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName() + ", Pret: " + c.getPrice() + " lei");
				printResults = true;
			}
		}
		for(Book b : books.getProducts()) {
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
		HashMap<String, ArrayList<Book>> booksByAuthor = new HashMap<String, ArrayList<Book>>();
		for(Book b : books.getProducts()) {
			if(!booksByAuthor.containsKey(b.getAuthor())) {
				ArrayList<Book> aux = new ArrayList<Book>();
				aux.add(b);
				booksByAuthor.put(b.getAuthor(), aux);
			}
			else {
				ArrayList<Book> aux = booksByAuthor.get(b.getAuthor());
				aux.add(b);
				booksByAuthor.put(b.getAuthor(), aux);
			}
		}	
		for(String author : booksByAuthor.keySet()) {
			System.out.println("Autor: " + author);
			System.out.println("Carti: ");
			for(Book book : booksByAuthor.get(author)) {
				System.out.println("Id: " + book.getId() + ", Nume: " + book.getName());
			}
			System.out.print("\n");
		}
	}
	
}
