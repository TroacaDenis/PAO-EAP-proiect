package product_categories;


import distributors.Distributor;

public class Product {
	static private int idMaker = 0;
	private int id;
	private String name;
	private double price;
	private int qty;
	private Distributor distributor;
	private int discountPercentage;
	
	public Product(String name, double price, int qty, Distributor distributor, int discountPercentage) {
		idMaker++;
		this.setId(idMaker);
		this.setName(name);
		this.setPrice(price);
		this.setQty(qty);
		this.setDistributor(distributor);
		this.setDiscountPercentage(discountPercentage);
	}
	public Product(String name, double price, int qty, Distributor distributor) {
		this(name, price, qty, distributor, 0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}
	
	public int getDiscountPercentage() {
		return discountPercentage;
	}
	public void setDiscountPercentage(int discountPercentage) {
		this.discountPercentage = discountPercentage;
	}
	
	public boolean reduceQty(int productId, int qty) {
		if(productId != this.id)
			return false;
		if(qty > this.qty) {
			System.out.println("Stoc insuficient. Contactati distribuitorul " + this.distributor.getName() + " pentru a mai achizitiona produse");
		}
		else {
			this.qty -=qty;
			System.out.println("Cantitate modificata");
		}
		return true;
	}
	
	@Override
	public String toString() {
		return ("Nume: " + name + "\nPret: " + price + " lei" + "\nCantitate: " + qty + "\nDistribuitor: " + distributor.getName());
	}


}
