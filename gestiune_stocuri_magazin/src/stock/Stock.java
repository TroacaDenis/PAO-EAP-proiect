package stock;

import java.util.ArrayList;
import java.util.HashMap;

import categories.*;
import products.*;
import csv.CsvService;

public class Stock {
	private FoodProducts food;
	private ElectronicProducts electronics;
	private ClothesProducts clothes;
	private BookProducts books;
	
	private CsvService csv = CsvService.getInstance();
	
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
			ArrayList<String[]> foodRecords = csv.readFromCsv("src/csvProducts/food.csv");
			foodRecords.add(new String[] {Integer.toString(p.getId()), p.getName(), Double.toString(p.getPrice()), Integer.toString(p.getQty()), Integer.toString(p.getDistributorId()), Integer.toString(p.getDiscountPercentage()), ((Food) p).getExpirationDate().toString()});
			csv.writeToCsv("src/csvProducts/food.csv", foodRecords);
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
			ArrayList<String[]> foodRecords = csv.readFromCsv("src/csvProducts/food.csv");
			foodRecords.add(new String[] {Integer.toString(p.getId()), p.getName(), Double.toString(p.getPrice()), Integer.toString(p.getQty()), Integer.toString(p.getDistributorId()), Integer.toString(p.getDiscountPercentage()), Integer.toString(((Electronic)p).getGuarantee())});
			csv.writeToCsv("src/csvProducts/food.csv", foodRecords);
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
			ArrayList<String[]> foodRecords = csv.readFromCsv("src/csvProducts/clothes.csv");
			foodRecords.add(new String[] {Integer.toString(p.getId()), p.getName(), Double.toString(p.getPrice()), Integer.toString(p.getQty()), Integer.toString(p.getDistributorId()), Integer.toString(p.getDiscountPercentage()), ((Clothes) p).getSize()});
			csv.writeToCsv("src/csvProducts/clothes.csv", foodRecords);
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
			ArrayList<String[]> foodRecords = csv.readFromCsv("src/csvProducts/food.csv");
			foodRecords.add(new String[] {Integer.toString(p.getId()), p.getName(), Double.toString(p.getPrice()), Integer.toString(p.getQty()), Integer.toString(p.getDistributorId()), Integer.toString(p.getDiscountPercentage()), ((Book) p).getAuthor()});
			csv.writeToCsv("src/csvProducts/food.csv", foodRecords);
			System.out.println("Produs adaugat");
			return;
		}
	}
	
	private void removeFromCsv(int productId, String path) {
		ArrayList<String[]> records = csv.readFromCsv(path);
		for (int i = 1; i < records.size(); i++) {
			if (Integer.parseInt(records.get(i)[0]) == productId) {
				records.remove(i);
				csv.writeToCsv(path, records);
				break;
			}
		}
	}
	public void removeProduct(int productId) {
		for(Food f : food.getProducts()) {
			if(productId == f.getId()) {
				food.removeProduct(f);
				removeFromCsv(productId, "src/csvProducts/food.csv");
				System.out.println("Produs sters");
				return;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(productId == e.getId()) {
				electronics.removeProduct(e);
				removeFromCsv(productId, "src/csvProducts/electronics.csv");
				System.out.println("Produs sters");
				return;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(productId == c.getId()) {
				clothes.removeProduct(c);
				removeFromCsv(productId, "src/csvProducts/clothes.csv");
				System.out.println("Produs sters");
				return;
			}
		}
		for(Book b : books.getProducts()) {
			if(productId == b.getId()) {
				books.removeProduct(b);
				removeFromCsv(productId, "src/csvProducts/books.csv");
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
	
	private void reduceCsvQuantity(int productId, String path, int newQty) {
		ArrayList<String[]> records = csv.readFromCsv(path);
		for (int i = 1; i < records.size(); i++) {
			if (Integer.parseInt(records.get(i)[0]) == productId) {
				records.get(i)[3] = Integer.toString(newQty);
				csv.writeToCsv(path, records);
				break;
			}
		}
	}
	public void reduceQty(int productId, int qty) {
		for(Food f : food.getProducts()) {
			if(f.reduceQty(productId, qty)) {
				reduceCsvQuantity(productId, "src/csvProducts/food.csv", f.getQty());
				return;
			}
		}
		for(Electronic e : electronics.getProducts()) {
			if(e.reduceQty(productId, qty)) {
				reduceCsvQuantity(productId, "src/csvProducts/electronics.csv", e.getQty());
				return;
			}
		}
		for(Clothes c : clothes.getProducts()) {
			if(c.reduceQty(productId, qty)) {
				reduceCsvQuantity(productId, "src/csvProducts/clothes.csv", c.getQty());
				return;
			}
		}
		for(Book b : books.getProducts()) {
			if(b.reduceQty(productId, qty)) {
				reduceCsvQuantity(productId, "src/csvProducts/books.csv", b.getQty());
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
