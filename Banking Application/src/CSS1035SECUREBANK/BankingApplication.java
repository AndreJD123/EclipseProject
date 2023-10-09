package CSS1035SECUREBANK;

public class BankingApplication {
	private String name;
	private String id;
	private java.util.Date dateCreated;

	public BankingApplication() {

	}

	public BankingApplication(String name, String id) {
		dateCreated = new java.util.Date();
		this.name = name;
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public String getid() {
		return id;
	}

	public java.util.Date getDateCreated() {
		return dateCreated;
	}

	public String toString() {
		return "created on " + dateCreated + "\nname: " + name + " and \nid: " + id;
	}

}
