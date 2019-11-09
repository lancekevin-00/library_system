package library_system;
public class Librarian extends User{
	private String firstName,lastName;
	private int accountID;
	Librarian(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,int fines,String type) {
		super.Name = firstName+" "+lastName;
		this.firstName = firstName;
		this.lastName = lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		super.type = type;
		is_librarian = true;
		this.accountID = accountID;
	}
	public String toString() {
		return "{\n\"id\":" +cardNumber+",\n\"firstname\":\""+firstName+"\",\n\"lastName\":\""+lastName+"\",\n\"birthdayYear\":"+Age+",\n\"address\":\""+Address+"\",\n\"accountID\":"+accountID+",\n\"password\":\""+password+"\",\n\"type\":\"L\",\n\"fines\":"+Fees + "\n}";
	}
}
	
