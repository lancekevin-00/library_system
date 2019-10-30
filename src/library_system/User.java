package library_system;

public abstract class User {
	protected String Name;
	protected int cardNumber;
	protected String password;
	protected int Age;
	protected double Fees;
	protected Checked_out_itm[] items;
	protected String Address;
	
	public void checkout(Item itm) {
		System.out.println("CHECKING OUT AN ITEM");
	}
	public void changePwd(String pwd) {
		password = pwd;
	}
	public void makePayment(double pmt) {
		Fees = Fees - pmt;
	}
	public int checkReturnDate(int id) {
		for(Checked_out_itm item:items) {
			if (id == item.getId())
				return item.getTime_remaining();
		}
		return -1;
	}
	public void return_itm(int id) {
		System.out.println("RETURNING AN ITEM");
	}
	
	//getters and setters
	public String getName() {
		return Name;
	}
	protected void setName(String name) {
		Name = name;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	protected void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getPassword() {
		return password;
	}
	protected void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return Age;
	}
	protected void setAge(int age) {
		Age = age;
	}
	public double getFees() {
		return Fees;
	}
	protected void setFees(double fees) {
		Fees = fees;
	}
	public String getAddress() {
		return Address;
	}
	protected void setAddress(String address) {
		Address = address;
	}
	public Checked_out_itm[] getItems() {
		return items;
	}
	public void setItems(Checked_out_itm[] items) {
		this.items = items;
	}
	
	
}
