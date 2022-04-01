package stock;

import product_categories.*;

public interface ServiceInterface {
	
	//afiseaza toate informatiile despre un produs si ia ca parametru id-ul produsului
	void getProductInfo(Stock s, int productId);
	
	//afiseaza id-ul si numele tuturor produselor dintr-o categorie
	void printCategory(Stock s, int category);
	
	//adauga un produs
	void addProduct(Stock s, Product p);
	
	//sterge un produs primind ca parametru id-ul lui
	void removeProduct(Stock s, int productId);
	
	//afiseaza hainele care au marimea primita ca parametru
	void clothesWithSize(Stock s, String m);
	
	//aplica o reducere de 25% primelor n produse ce urmeaza sa expire si nu sunt deja reduse
	void applyDiscount(Stock s, int n);
	
	//afiseaza id-ul si numele tuturor produselor achizitionate de la un distribuitor
	void distributorProducts(Stock s, int DistributorInt);
	
	//scade cu n cantitate unui produs daca mai sunt suficiente bucati ramase in stoc
	void reduceQty(Stock s, int productId, int qty);
	
	//afiseaza id-ul, numele si pretul tuturor produselor cu pretul mai mic sau egal cu cel transmis ca parametru
	void productsWithPrice(Stock s, int price);
	
	//afiseaza toate cartile, grupate dupa autor
	void printBooks(Stock s);
}

