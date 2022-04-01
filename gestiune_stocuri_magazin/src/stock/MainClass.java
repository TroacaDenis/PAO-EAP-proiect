package stock;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

import distributors.*;
import product_categories.*;
import stock_categories.*;
public class MainClass {
	public static void main(String[] args) {
		
		Distributor d1 = new Distributor("distribuitor1", "0749779041");
		Distributor d2 = new Distributor("distribuitor2", "0749779042");
		Distributor d3 = new Distributor("distribuitor3", "0749779043");
		Distributor d4 = new Distributor("distribuitor4", "0749779044");
		Distributor d5 = new Distributor("distribuitor5", "0749779045");
		Distributor d6 = new Distributor("distribuitor6", "0749779046");
		Distributor []distributors = {d1,d2,d3,d4,d5,d6};
		
		FoodProduct fp1 = new FoodProduct("paine", 5, 100, d1, "02-04-2022");
		FoodProduct fp2 = new FoodProduct("carne", 10, 250, d2, "16-05-2022");
		FoodProduct fp3 = new FoodProduct("lapte", 7, 100, d4, "07-04-2022");
		SortedSet<FoodProduct> fproducts = new TreeSet<FoodProduct>();
		fproducts.add(fp1);
		fproducts.add(fp2);
		fproducts.add(fp3);
		Food food = new Food(fproducts);
		
		ClothesProduct cp1 = new ClothesProduct("bluzon", 100, 100, d5, "M");
		ClothesProduct cp2 = new ClothesProduct("tricou", 30, 150, d3, "S");
		ClothesProduct cp3 = new ClothesProduct("blugi", 250, 50, d4, "M");
		ArrayList<ClothesProduct> cproducts = new ArrayList<>();
		cproducts.add(cp1);
		cproducts.add(cp2);
		cproducts.add(cp3);
		Clothes clothes = new Clothes(cproducts);
		
		ElectronicsProduct ep1 = new ElectronicsProduct("frigider", 2000, 10, d1, 5);
		ElectronicsProduct ep2 = new ElectronicsProduct("masina de spalat", 999, 15, d6, 2);
		ElectronicsProduct ep3 = new ElectronicsProduct("casti", 250, 50, d2, 0);
		ArrayList<ElectronicsProduct> eproducts = new ArrayList<>();
		eproducts.add(ep1);
		eproducts.add(ep2);
		eproducts.add(ep3);
		Electronics electronics = new Electronics(eproducts);
		
		BooksProduct bp1 = new BooksProduct("book1", 10, 120, d1, "author1");
		BooksProduct bp2 = new BooksProduct("book2", 12, 123, d4, "author1");
		BooksProduct bp3 = new BooksProduct("book3", 15, 234, d2, "author3");
		ArrayList<BooksProduct> bproducts = new ArrayList<>();
		bproducts.add(bp1);
		bproducts.add(bp2);
		bproducts.add(bp3);
		Books books = new Books(bproducts);
		
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
				for (int i = 0; i < distributors.length; i++) {
					System.out.println((i+1) + "." + distributors[i].getName());
				}
				Distributor distributor = distributors[myScanner.nextInt()-1];
				myScanner.nextLine();
				switch (productCategory) {
				case 1:
					System.out.print("Data de expirare(DD-MM-YYYY):");
					String expirationDate = myScanner.nextLine();
					service.addProduct(s, new FoodProduct(name, price, qty, distributor, expirationDate));
					break;
				case 2:
					System.out.print("Ani garantie:");
					int guarantee = myScanner.nextInt();
					myScanner.nextLine();
					service.addProduct(s, new ElectronicsProduct(name, price, qty, distributor, guarantee));
					break;
				case 3:
					System.out.print("Marime(S,M,L,XL):");
					String size = myScanner.nextLine();
					service.addProduct(s, new ClothesProduct(name, price, qty, distributor, size));
					break;
				case 4:
					System.out.print("Autor:");
					String author = myScanner.nextLine();
					service.addProduct(s, new BooksProduct(name, price, qty, distributor, author));
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
				for (int i = 0; i < distributors.length; i++) {
					System.out.println((i+1) + "." + distributors[i].getName());
				}
				service.distributorProducts(s, distributors[myScanner.nextInt()-1].getId());
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
