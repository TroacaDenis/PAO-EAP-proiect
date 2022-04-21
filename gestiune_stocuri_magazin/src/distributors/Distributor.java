package distributors;

public class Distributor {
	static private int idMaker = 0;
	private int id;
	private String name;
	private String phoneNumber;
	
	public Distributor(String name, String phoneNumber) {
		idMaker++;
		this.id = idMaker;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}