package library_system;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class User_Tester {
	
	User adult, teacher, librarian;
	Item book, eBook, audioBook, magazine, dvd;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setupStreams() {
		System.setOut(new PrintStream(output));
	}
	
	@Before
	public void init() {
		adult = new Adult(0, "John", "Doe", 2000, "1234 Example st", 0, "password" , 0, "A");
		teacher = new Teacher(1, "School", "Teacher", 1980, "1 school street", 1, "password", 0, "T");
		librarian = new Librarian(2, "the", "librarian", 0, "1 learning lane", 2, "password", 0, "L");
		
		book =  new Book(0, "Harry Potter", 1997, "Fiction", "Bloomsbury", "J. K. Rowling", 1, false);
		eBook = new eBook(0, "Point Break", 1991, "action", "Kathryn Bigelow", "Keanu Reaves", 1, false);
		audioBook = new Audio_Book(0, "Maze Runner", 2009, "Science Fiction", "Dell Publishing", "James Dashner", 1, false);
		magazine = new Magazine(0, "Time Magazine", 2019, "news", "Time", 1000, 1, 1, true);
		dvd = new DVD(0, "Shrek 2", 2004, "Fantasy", "Andrew Adamson", "Mike Meyers", 1, false);
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	@Test
	//creating an adult account
	public void adult() {
		Adult temp = new Adult(0, "temp", "adult", 2000, "1234 temp st", 0, "password", 0, "A");
		String actual = temp.toString();
		String expected = "{\n\"id\":" +0+",\n\"firstname\":\""+"temp"+"\",\n\"lastName\":\""+"adult"+"\",\n\"birthdayYear\":"+"2000"+",\n\"address\":\""+"1234 temp st"+"\",\n\"accountID\":"+0+",\n\"password\":\""+"password"+"\",\n\"type\":\"A\",\n\"fines\":"+0 + "\n}";
		assertEquals("adult instantiated correctly", actual, expected);
	}
	
	@Test
	//creating a teacher account
	public void teacher() {
		Teacher temp = new Teacher(0, "temp", "teacher", 2000, "1234 temp st", 0, "password", 0, "T");
		String actual = temp.toString();
		String expected = "{\n\"id\":" +0+",\n\"firstname\":\""+"temp"+"\",\n\"lastName\":\""+"teacher"+"\",\n\"birthdayYear\":"+"2000"+",\n\"address\":\""+"1234 temp st"+"\",\n\"accountID\":"+0+",\n\"password\":\""+"password"+"\",\n\"type\":\"T\",\n\"fines\":"+0 + "\n}";
		assertEquals("teacher instantiated correctly", actual, expected);
	}
	
	@Test
	//creating a librarian account
	public void librarian() {
		Librarian temp = new Librarian(0, "temp", "librarian", 2000, "1234 temp st", 0, "password", 0, "L");
		String actual = temp.toString();
		String expected = "{\n\"id\":" +0+",\n\"firstname\":\""+"temp"+"\",\n\"lastName\":\""+"librarian"+"\",\n\"birthdayYear\":"+"2000"+",\n\"address\":\""+"1234 temp st"+"\",\n\"accountID\":"+0+",\n\"password\":\""+"password"+"\",\n\"type\":\"L\",\n\"fines\":"+0 + "\n}";
		assertEquals("librarian instantiated correctly", actual, expected);
	}
	
	@Test
	//checking out a book
	public void AdultCheckoutBook() {
		Checked_out_itm itm = new Checked_out_itm("Harry Potter",book);
		adult.checkout(itm,0);
		Checked_out_itm[] temp = adult.getItems();
		String actual = temp[0].toString();
		String expected = itm.toString();
		
		assertEquals("harry potter was added correctly", actual, expected);
	}
	
	@Test
	//checking out a magazine
	public void AdultCheckoutMagazine() {
		Checked_out_itm itm = new Checked_out_itm("Time Magazine", magazine);
		adult.checkout(itm,0);
		Checked_out_itm[] temp = adult.getItems();
		String actual = temp[0].toString();
		String expected = itm.toString();
		
		assertEquals("Time Magazine was added correctly", actual, expected);
	}
	
	@Test
	//checking out a DVD
	public void AdultCheckoutDVD() {
		Checked_out_itm itm = new Checked_out_itm("Shrek 2",dvd);
		adult.checkout(itm,0);
		Checked_out_itm[] temp = adult.getItems();
		String actual = temp[0].toString();
		String expected = itm.toString();
		
		assertEquals("Shrek 2 was added correctly", actual, expected);
	}
	
	@Test
	//checking out an audio book
	public void AdultCheckoutAudioBook() {
		Checked_out_itm itm = new Checked_out_itm("Maze Runner", audioBook);
		adult.checkout(itm,0);
		Checked_out_itm[] temp = adult.getItems();
		String actual = temp[0].toString();
		String expected = itm.toString();
		
		assertEquals("Shrek 2 was added correctly", actual, expected);
	}
	
	@Test
	//checking out an e-book
	public void AdultCheckoutEBook() {
		Checked_out_itm itm = new Checked_out_itm("Point Break",eBook);
		adult.checkout(itm,0);
		Checked_out_itm[] temp = adult.getItems();
		String actual = temp[0].toString();
		String expected = itm.toString();
		
		assertEquals("Shrek 2 was added correctly", actual, expected);
	}
	
	@Test
	//returning an item
	public void ReturnBook() {
		int expected = book.getCopies_avalible();
		Checked_out_itm itm = book.checkout(adult);
		adult.checkout(itm,0);
		adult.return_itm(0);
		
		int actual = book.getCopies_avalible();
		
		assertEquals("the book was properly returned", actual, expected);
	}
	
	@Test
	//changing password
	public void ChangePassword() {
		String expected = "new_password";
		adult.changePwd(expected);
		String actual = adult.getPassword();
		
		assertEquals("password changed correctly", actual, expected);
	}
	
	@Test
	//making payment
	public void makePayment() {
		adult.setFees(5);
		int expected = 0;
		adult.makePayment(5);
		int actual = adult.getFees();
		
		assertEquals("fees paid correctly", actual, expected);
	}
	
	@Test
	//checking return date book
	public void checkingReturnDate() {
		int expected = book.getMax_checkout_time();
		Checked_out_itm itm = book.checkout(adult);
		adult.checkout(itm,0);
		int actual = adult.checkReturnDate(0);
		
		assertEquals("correct return date returned", actual, expected);
	}
	@Test
	//Checking if fees are set
	public void checkingFees() {
		adult.setFees(10);
		int expected = 10;
		int actual = adult.getFees();
		assertEquals("Correct Fee amount returned", actual, expected);	
	}
	@Test 
	//Test updating day on checked out items
	public void testUpdateDay() {
		Checked_out_itm itm = new Checked_out_itm("Harry Potter",book);
		adult.checkout(itm,0);
		int expected = adult.checkReturnDate(0)-1;
		adult.updateDay();
		int actual = adult.checkReturnDate(0);
		
		assertEquals("Updates day correctly", actual, expected);
		
	}
}
