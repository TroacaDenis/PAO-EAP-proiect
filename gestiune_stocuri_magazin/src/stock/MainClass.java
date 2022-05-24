package stock;


import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.SortedSet;

import jdbc.*;
import categories.*;
import distributors.*;
import products.*;
public class MainClass {
	public static void main(String[] args) {
		
		//create tables if they don't exist
		DistributorsDatabase.createTable();
		FoodDatabase.createTable();
		ClothesDatabase.createTable();
		ElectronicsDatabase.createTable();
		BooksDatabase.createTable();
		
		//distributors
		List<Distributor> distributors = DistributorsDatabase.getDistributors();
		
		//food
		SortedSet<Food> fproducts = FoodDatabase.getFoodProducts();
		FoodProducts food = new FoodProducts(fproducts);
		
		//clothes
		List<Clothes> cproducts = ClothesDatabase.getClothesProducts();
		ClothesProducts clothes = new ClothesProducts(cproducts);
		
		//electronics
		List<Electronic> eproducts = ElectronicsDatabase.getElectronicProducts();
		ElectronicProducts electronics = new ElectronicProducts(eproducts);
		
		//books
		List<Book> bproducts = BooksDatabase.getBookProducts();
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
				service.getProductInfo(s, myScanner.nextLine());
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
					service.addProduct(s, new Food(null, name, price, qty, distributorId, LocalDate.of(expirationYear, expirationMonth, expirationDay)));
					break;
				case 2:
					System.out.print("Ani garantie:");
					int guarantee = myScanner.nextInt();
					myScanner.nextLine();
					service.addProduct(s, new Electronic(null, name, price, qty, distributorId, guarantee));
					break;
				case 3:
					System.out.print("Marime(S,M,L,XL):");
					String size = myScanner.nextLine();
					service.addProduct(s, new Clothes(null, name, price, qty, distributorId, size));
					break;
				case 4:
					System.out.print("Autor:");
					String author = myScanner.nextLine();
					service.addProduct(s, new Book(null, name, price, qty, distributorId, author));
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
				service.removeProduct(s, myScanner.nextLine());
				System.out.print("\n");
				break;
			case 5:
				System.out.print("Marime:");
				String aux =myScanner.nextLine();
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
				String productId = myScanner.nextLine();
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
				DatabaseConnection.closeDBconnection();
				System.exit(0);
			default:
				System.out.println("Optiunea nu exista");
				System.out.print("\n");
				break;
			}
		}
	}
}
