package library_system;

public class Adult extends User {
	Child[] children;
	private String firstName,lastName;
	private int accountID;
	Adult(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines, Child[] children) {
		super.Name = firstName+" "+lastName;
		this.firstName = firstName;
		this.lastName = lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		this.accountID = accountID;
		this.children = new Child[children.length];
		for (int i=0;i<this.children.length;i++) {
			this.children[i] = children[i];
		}
	}
	Adult(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines) {
		super.Name = firstName+" "+lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		
		children = new Child[0];
	}
	
	private double getChildFees() {
		double total = 0.0;
		for(Child c: children) {
			total += c.getFees();
		}
		return total;
	}
	
	public double getFees(){
		return (Fees + this.getChildFees());
	}
	
	public void addChild(Child c) {
		Child[] tempChildren = new Child[children.length + 1];
		for(int i=0;i<children.length;i++) {
			tempChildren[i] = children[i];
		}
		tempChildren[children.length] = c;
		children = tempChildren;
	}
	
	public void removeChild(String name) {
		boolean before = true;
		Child[] tempChildren = new Child[children.length - 1];
		for(int i=0;i<children.length; i++) {
			if(children[i].Name == name) {
				before = false;
			}
			if(before) {
				tempChildren[i] = children[i];
			}
			else {
				tempChildren[i-1] = children[i];
			}
		}
		children = tempChildren;
	}
	public String toString() {
		return "{\n\"id\":" +cardNumber+",\n\"firstname\":\""+firstName+",\n\"name\":\""+lastName+",\n\"birthdayYear\":"+Age+",\n\"address\":\""+Address+",\n\"accountID\":"+accountID+",\n\"password\":\""+password+",\n\"type\":\"A\",\n\"fines\":"+Fees + "\n}";
	}
}
