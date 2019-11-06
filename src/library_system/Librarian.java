package library_system;
import java.util.ArrayList;
public class Librarian extends User{
	Librarian() {}
	Librarian(int id,String firstName,String lastName,int birthdayYear,String address, int accountID,String password ,double fines) {
		super.Name = firstName+" "+lastName;
		super.cardNumber = id;
		super.password = password;
		super.Age = birthdayYear;
		super.Fees = fines;
		super.Address = address;
		super.items = new Checked_out_itm[10];
		is_librarian = true;
	}
	

		
	

	
}
	
