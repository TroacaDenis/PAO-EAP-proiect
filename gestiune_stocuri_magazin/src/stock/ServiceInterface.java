package stock;

import products.*;

public interface ServiceInterface {
	
	//1.afiseaza toate informatiile despre un produs si ia ca parametru id-ul produsului
	void getProductInfo(Stock s, String productId);
	
	//2.afiseaza id-ul si numele tuturor produselor dintr-o categorie
	void printCategory(Stock s, int category);
	
	//3.adauga un produs
	void addProduct(Stock s, Product p);
	
	//4.sterge un produs primind ca parametru id-ul lui
	void removeProduct(Stock s, String productId);
	
	//5.afiseaza hainele care au marimea primita ca parametru
	void clothesWithSize(Stock s, String m);
	
	//6.aplica o reducere de 25% primelor n produse ce urmeaza sa expire si nu sunt deja reduse
	void applyDiscount(Stock s, int n);
	
	//7.afiseaza id-ul si numele tuturor produselor achizitionate de la un distribuitor
	void distributorProducts(Stock s, int DistributorId);
	
	//8.scade cu n cantitate unui produs daca mai sunt suficiente bucati ramase in stoc
	void reduceQty(Stock s, String productId, int qty);
	
	//9.afiseaza id-ul, numele si pretul tuturor produselor cu pretul mai mic sau egal cu cel transmis ca parametru
	void productsWithPrice(Stock s, int price);
	
	//10.afiseaza toate cartile, grupate dupa autor
	void printBooks(Stock s);
}

