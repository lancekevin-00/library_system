package library_system;

public class Adult extends User {
	Child[] children;
	
	Adult(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines, Child[] children) {
		super.Name = firstName+" "+lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		
		this.children = new Child[children.length];
		for (int i=0;i<this.children.length;i++) {
			this.children[i] = children[i];
		}
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
}
