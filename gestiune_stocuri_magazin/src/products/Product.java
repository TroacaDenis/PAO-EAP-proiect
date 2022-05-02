package products;

public class Product {
	static private int idMaker = 0;
	private int id;
	private String name;
	private double price;
	private int qty;
	private int distributorId;
	private int discountPercentage;
	
	public Product(String name, double price, int qty, int distributorId, int discountPercentage) {
		idMaker++;
		this.setId(idMaker);
		this.setName(name);
		this.setPrice(price);
		this.setQty(qty);
		this.setDistributor(distributorId);
		this.setDiscountPercentage(discountPercentage);
	}
	public Product(String name, double price, int qty, int distributorId) {
		this(name, price, qty, distributorId, 0);
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
	
	public int getDistributorId() {
		return distributorId;
	}

	public void setDistributor(int distributorId) {
		this.distributorId = distributorId;
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
			System.out.println("Stoc insuficient. Contactati distribuitorul cu id-ul " + this.distributorId + " pentru a mai achizitiona produse");
		}
		else {
			this.qty -=qty;
			System.out.println("Cantitate modificata");
		}
		return true;
	}
	
	@Override
	public String toString() {
		return ("Nume: " + name + "\nPret: " + price + " lei" + "\nCantitate: " + qty + "\nId distribuitor: " + distributorId);
	}


}
