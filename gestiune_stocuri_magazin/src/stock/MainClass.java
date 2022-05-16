package stock;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import csv.*;
import categories.*;
import distributors.*;
import products.*;
public class MainClass {
	public static void main(String[] args) {
		
		CsvReader csvReader = CsvReader.getInstance();
		CsvWriter csvWriter = CsvWriter.getInstance();
		
		//distributors
		List<String[]> distributorRecords = csvReader.readFromCsv("src/csvProducts/distributors.csv");
		List<Distributor> distributors = new ArrayList<>();
		//ignoram prima linie doarece contine doar denumirile coloanelor din fisierul csv
		for (int i = 1; i < distributorRecords.size(); i++) {
			String name = distributorRecords.get(i)[1];
			String phoneNumber = distributorRecords.get(i)[2];
			Distributor d = new Distributor(name, phoneNumber);
			distributors.add(d);
			distributorRecords.get(i)[0] = Integer.toString(d.getId());
		}
		//scriem in fisierul csv pentru a nota si id-urile generate automat de program
		csvWriter.writeToCsv("src/csvProducts/distributors.csv", distributorRecords);
		
		//food
		List<String[]> foodRecords = csvReader.readFromCsv("src/csvProducts/food.csv");
		SortedSet<Food> fproducts = new TreeSet<>();
		for (int i = 1; i < foodRecords.size(); i++) {
			String name = foodRecords.get(i)[1];
			double price = Double.parseDouble(foodRecords.get(i)[2]);
			int qty = Integer.parseInt(foodRecords.get(i)[3]);
			int distributorId = Integer.parseInt(foodRecords.get(i)[4]);
			int discountPercentage = Integer.parseInt(foodRecords.get(i)[5]);
			LocalDate expirationDate = LocalDate.parse(foodRecords.get(i)[6]);
			Food f = new Food(name, price, qty, distributorId, discountPercentage, expirationDate);
			fproducts.add(f);
			foodRecords.get(i)[0] = Integer.toString(f.getId());
		}
		csvWriter.writeToCsv("src/csvProducts/food.csv", foodRecords);
		FoodProducts food = new FoodProducts(fproducts);
		
		//clothes
		List<String[]> clothesRecords = csvReader.readFromCsv("src/csvProducts/clothes.csv");
		List<Clothes> cproducts = new ArrayList<>();
		for (int i = 1; i < clothesRecords.size(); i++) {
			String name = clothesRecords.get(i)[1];
			double price = Double.parseDouble(clothesRecords.get(i)[2]);
			int qty = Integer.parseInt(clothesRecords.get(i)[3]);
			int distributorId = Integer.parseInt(clothesRecords.get(i)[4]);
			int discountPercentage = Integer.parseInt(clothesRecords.get(i)[5]);
			String size = clothesRecords.get(i)[6];
			Clothes c = new Clothes(name, price, qty, distributorId, discountPercentage, size);
			cproducts.add(c);
			clothesRecords.get(i)[0] = Integer.toString(c.getId());
		}
		csvWriter.writeToCsv("src/csvProducts/clothes.csv", clothesRecords);
		ClothesProducts clothes = new ClothesProducts(cproducts);
		
		//electronics
		List<String[]> electronicRecords = csvReader.readFromCsv("src/csvProducts/electronics.csv");
		List<Electronic> eproducts = new ArrayList<>();
		for (int i = 1; i < electronicRecords.size(); i++) {
			String name = electronicRecords.get(i)[1];
			double price = Double.parseDouble(electronicRecords.get(i)[2]);
			int qty = Integer.parseInt(electronicRecords.get(i)[3]);
			int distributorId = Integer.parseInt(electronicRecords.get(i)[4]);
			int discountPercentage = Integer.parseInt(electronicRecords.get(i)[5]);
			int guarantee = Integer.parseInt(electronicRecords.get(i)[6]);
			Electronic e = new Electronic(name, price, qty, distributorId, discountPercentage, guarantee);
			eproducts.add(e);
			electronicRecords.get(i)[0] = Integer.toString(e.getId());
		}
		csvWriter.writeToCsv("src/csvProducts/electronics.csv", electronicRecords);
		ElectronicProducts electronics = new ElectronicProducts(eproducts);
		
		//books
		List<String[]> bookRecords = csvReader.readFromCsv("src/csvProducts/books.csv");
		List<Book> bproducts = new ArrayList<>();
		for (int i = 1; i < bookRecords.size(); i++) {
			String name = bookRecords.get(i)[1];
			double price = Double.parseDouble(bookRecords.get(i)[2]);
			int qty = Integer.parseInt(bookRecords.get(i)[3]);
			int distributorId = Integer.parseInt(bookRecords.get(i)[4]);
			int discountPercentage = Integer.parseInt(bookRecords.get(i)[5]);
			String author = bookRecords.get(i)[6];
			Book b = new Book(name, price, qty, distributorId, discountPercentage, author);
			bproducts.add(b);
			bookRecords.get(i)[0] = Integer.toString(b.getId());
		}
		csvWriter.writeToCsv("src/csvProducts/books.csv", bookRecords);
		BookProducts books = new BookProducts(bproducts);
		
		//services
		Stock s = new Stock(food, electronics, clothes, books);
		Service service = new Service();
		while(true) {
			System.out.println("Alegeti o optiune(numarul ei):");
			System.out.println("1.Afiseaza toate informatiile despre un produs");
			System.out.println("2.Afiseaza toate produsele dintr-o categorie");
			System.out.println("3.Adauga un produs");
			System.out.println("4.Sterge un produs");
			System.out.println("5.Afiseaza haine");
			System.out.println("6.Aplica reducere produselor ce vor expira");
			System.out.println("7.Afiseaza produsele achizitionate de la un distributor");
			System.out.println("8.Modifica cantitate");
			System.out.println("9.Afiseaza produse dupa pret");
			System.out.println("10.Grupeaza cartile dupa autor");
			System.out.println("11.Inchide programul");
			Scanner myScanner = new Scanner(System.in);
			int option = myScanner.nextInt();
			myScanner.nextLine();
			switch (option) {
			case 1:
				System.out.print("Id produs:");
				service.getProductInfo(s, myScanner.nextInt());
				myScanner.nextLine();
				System.out.print("\n");
				break;
			case 2:
				System.out.println("Alegeti o categorie(numarul ei):");
				System.out.println("1.Food");
				System.out.println("2.Electronics");
				System.out.println("3.Clothes");
				System.out.println("4.Books");
				int category = myScanner.nextInt();
				myScanner.nextLine();
				service.printCategory(s, category);
				System.out.print("\n");
				break;
			case 3:
				System.out.println("Alegeti o categorie(numarul ei):");
				System.out.println("1.Food");
				System.out.println("2.Electronics");
				System.out.println("3.Clothes");
				System.out.println("4.Books");
				int productCategory = myScanner.nextInt();
				myScanner.nextLine();
				
				System.out.print("Nume produs:");
				String name = myScanner.nextLine();
				System.out.print("Pret produs:");
				double price = myScanner.nextDouble();
				myScanner.nextLine();
				System.out.print("Cantitate produs:");
				int qty = myScanner.nextInt();
				myScanner.nextLine();
				System.out.println("Alegeti un distribuitor(numarul lui):");
				for (int i = 0; i < distributors.size(); i++) {
					System.out.println((i+1) + "." + distributors.get(i).getName());
				}
				int distributorId = distributors.get(myScanner.nextInt()-1).getId();
				myScanner.nextLine();
				switch (productCategory) {
				case 1:
					System.out.println("Data de expirare:");
					System.out.print("Anul:");
					int expirationYear = myScanner.nextInt();
					myScanner.nextLine();
					System.out.print("Luna:");
					int expirationMonth = myScanner.nextInt();
					myScanner.nextLine();
					System.out.print("Ziua:");
					int expirationDay = myScanner.nextInt();
					myScanner.nextLine();
					service.addProduct(s, new Food(name, price, qty, distributorId, LocalDate.of(expirationYear, expirationMonth, expirationDay)));
					break;
				case 2:
					System.out.print("Ani garantie:");
					int guarantee = myScanner.nextInt();
					myScanner.nextLine();
					service.addProduct(s, new Electronic(name, price, qty, distributorId, guarantee));
					break;
				case 3:
					System.out.print("Marime(S,M,L,XL):");
					String size = myScanner.nextLine();
					service.addProduct(s, new Clothes(name, price, qty, distributorId, size));
					break;
				case 4:
					System.out.print("Autor:");
					String author = myScanner.nextLine();
					service.addProduct(s, new Book(name, price, qty, distributorId, author));
					break;

				default:
					System.out.println("Categoria nu exista");
					System.out.print("\n");
					break;
				}
				System.out.print("\n");
				break;
			case 4:
				System.out.print("Id produs:");
				service.removeProduct(s, myScanner.nextInt());
				myScanner.nextLine();
				System.out.print("\n");
				break;
			case 5:
				System.out.print("Marime:");
				String aux =myScanner.nextLine();
				System.out.println(aux.equals( "M"));
				service.clothesWithSize(s, aux);
				break;
			case 6:
				System.out.print("Nr de produse reduse:");
				service.applyDiscount(s, myScanner.nextInt());
				myScanner.nextLine();
				System.out.print("\n");
				break;
			case 7:
				System.out.println("Alegeti un distribuitor(numarul lui):");
				for (int i = 0; i < distributors.size(); i++) {
					System.out.println((i+1) + "." + distributors.get(i).getName());
				}
				service.distributorProducts(s, distributors.get(myScanner.nextInt()-1).getId());
				myScanner.nextLine();
				System.out.print("\n");
				break;
			case 8:
				System.out.print("Id produs:");
				int productId = myScanner.nextInt();
				myScanner.nextLine();
				System.out.print("Cu cate bucati trebuie redusa cantitatea:");
				int productQty = myScanner.nextInt();
				myScanner.nextLine();
				service.reduceQty(s, productId, productQty);
				System.out.print("\n");
				break;
			case 9:
				System.out.print("Pret maxim:");
				service.productsWithPrice(s, myScanner.nextInt());
				myScanner.nextLine();
				System.out.print("\n");
				break;
			case 10:
				service.printBooks(s);
				System.out.print("\n");
				break;
			case 11:
				System.exit(0);
			default:
				System.out.println("Optiunea nu exista");
				System.out.print("\n");
				break;
			}
		}
	}
}
