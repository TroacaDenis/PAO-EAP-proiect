package stock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import categories.*;
import products.*;
import jdbc.*;

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
	
	//1
	public void getProductInfo(String productId) {
		for(Food f : food.getProducts()) {
			if(productId.equals(f.getId())) {
				System.out.println(f);
				return;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(productId.equals(e.getId())) {
				System.out.println(e);
				return;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(productId.equals(c.getId())) {
				System.out.println(c);
				return;
			}
		}
		for(Book b : books.getProducts()) {
			if(productId.equals(b.getId())) {
				System.out.println(b);
				return;
			}
		}
		System.out.println("Id invalid!");
	}
	
	//2
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
			for(Clothes c : clothes.getProducts()) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName());
			}
			break;
		
		case 4:
			for(Book b : books.getProducts()) {
				System.out.println("Id produs: " + b.getId() + ", Nume produs: " + b.getName());
			}
			break;
		default:
			System.out.println("Categorie incorecta!");
			break;
		}
	}
	
	//3
	public void addProduct(Product p) {
		if(p instanceof Food){
			int id = FoodDatabase.insertFood(p.getName(), p.getPrice(), p.getQty(), p.getDistributorId(), p.getDiscountPercentage(), ((Food) p).getExpirationDate());
			p.setId("f" + Integer.toString(id));
			food.addProduct(p);
			System.out.println("Produs adaugat");
			return;
		}
		if(p instanceof Electronic){
			int id = ElectronicsDatabase.insertElectronic(p.getName(), p.getPrice(), p.getQty(), p.getDistributorId(), p.getDiscountPercentage(), ((Electronic) p).getGuarantee());
			p.setId("e" + Integer.toString(id));
			electronics.addProduct(p);
			System.out.println("Produs adaugat");
			return;
			}
		if(p instanceof Clothes){
			int id = ClothesDatabase.insertClothes(p.getName(), p.getPrice(), p.getQty(), p.getDistributorId(), p.getDiscountPercentage(), ((Clothes) p).getSize());
			p.setId("c" + Integer.toString(id));
			clothes.addProduct(p);
			System.out.println("Produs adaugat");
			return;
			}
		if(p instanceof Book){
			int id = BooksDatabase.insertBook(p.getName(), p.getPrice(), p.getQty(), p.getDistributorId(), p.getDiscountPercentage(), ((Book) p).getAuthor());
			p.setId("b" + Integer.toString(id));
			books.addProduct(p);
			System.out.println("Produs adaugat");
			return;
			}
	}
	
	//4 
	public void removeProduct(String productId) {
		if(productId.charAt(0) == 'f') {
			for(Food f : food.getProducts()) {
				if(productId.equals(f.getId())) {
					FoodDatabase.removeFood(Integer.parseInt(productId.substring(1)));
					food.removeProduct(f);
					System.out.println("Produs sters");
					return;
				}
			}
		}
		else if(productId.charAt(0) == 'e')
			for(Electronic e : electronics.getProducts()) {
				if(productId.equals(e.getId())) {
					ElectronicsDatabase.removeElectronic(Integer.parseInt(productId.substring(1)));
					electronics.removeProduct(e);
					System.out.println("Produs sters");
					return;
				}
			}
		else if(productId.charAt(0) == 'c') {
			for(Clothes c : clothes.getProducts()) {
				if(productId.equals(c.getId())) {
					ClothesDatabase.removeClothes(Integer.parseInt(productId.substring(1)));
					clothes.removeProduct(c);
					System.out.println("Produs sters");
					return;
				}
			}
		}
		else if(productId.charAt(0) == 'b') {
			for(Book b : books.getProducts()) {
				if(productId.equals(b.getId())) {
					BooksDatabase.removeBook(Integer.parseInt(productId.substring(1)));
					books.removeProduct(b);
					System.out.println("Produs sters");
					return;
				}
			}
		}
	}
	
	//5
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
	
	//6
	public void applyDiscount(int n) {
		food.applyDiscount(n);
		System.out.println(n + " produse reduse");
	}
	
	//7
	public void distributorProducts(int DistributorId) {
		boolean printResults = false;
		for(Food f : food.getProducts()) {
			if(DistributorId == f.getDistributorId()) {
				System.out.println("Id produs: " + f.getId() + ", Nume produs: " + f.getName());
				printResults = true;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(DistributorId == e.getDistributorId()) {
				System.out.println("Id produs: " + e.getId() + ", Nume produs: " + e.getName());
				printResults = true;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(DistributorId == c.getDistributorId()) {
				System.out.println("Id produs: " + c.getId() + ", Nume produs: " + c.getName());
				printResults = true;
			}
		}
		for(Book b : books.getProducts()) {
			if(DistributorId == b.getDistributorId()) {
				System.out.println("Id produs: " + b.getId() + ", Nume produs: " + b.getName());
				printResults = true;
			}
		}
		if(!printResults) {
			System.out.println("Nu exista produse achizitionate de la distribuitorul " + DistributorId);
		}
	}
	
	//8
	public void reduceQty(String productId, int qty) {
		if(productId.charAt(0) == 'f') {
			for(Food f : food.getProducts()) {
				if(f.reduceQty(productId, qty)) {
					FoodDatabase.updateQty(Integer.parseInt(productId.substring(1)), f.getQty());
					return;
				}
			}
		}
		else if(productId.charAt(0) == 'e') {
			for(Electronic e : electronics.getProducts()) {
				if(e.reduceQty(productId, qty)) {
					ElectronicsDatabase.updateQty(Integer.parseInt(productId.substring(1)), e.getQty());
					return;
				}
			}
		}
		else if(productId.charAt(0) == 'c') {
			for(Clothes c : clothes.getProducts()) {
				if(c.reduceQty(productId, qty)) {
					ClothesDatabase.updateQty(Integer.parseInt(productId.substring(1)), c.getQty());
					return;
				}
			}
		}
		else if(productId.charAt(0) == 'b') {
			for(Book b : books.getProducts()) {
				if(b.reduceQty(productId, qty)) {
					BooksDatabase.updateQty(Integer.parseInt(productId.substring(1)), b.getQty());
					return;
				}
			}
		}
		System.out.println("Id invalid!");
	}
	
	//9
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
	
	//10
	public void printBooks() {
		Map<String, List<Book>> booksByAuthor = new HashMap<>();
		for(Book b : books.getProducts()) {
			if(!booksByAuthor.containsKey(b.getAuthor())) {
				List<Book> aux = new ArrayList<Book>();
				aux.add(b);
				booksByAuthor.put(b.getAuthor(), aux);
			}
			else {
				List<Book> aux = booksByAuthor.get(b.getAuthor());
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
