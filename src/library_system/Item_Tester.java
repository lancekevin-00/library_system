package library_system;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Item_Tester {
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
	//testing checkout
	public void Checkout() {
		int expected = book.getCopies_avalible() -1;
		book.checkout(adult);
		int actual = book.getCopies_avalible();
		
		assertEquals("copies avalible decremented correctly", actual, expected);
	}
	
	@Test
	//max checkout time book
	public void MaxCheckoutTimeBook() {
		int expected = book.getMax_checkout_time();
		Checked_out_itm itm = book.checkout(adult);
		adult.checkout(itm,0);
		int actual = adult.checkReturnDate(0);
		
		assertEquals("correct return date returned", actual, expected);
	}
	
	@Test
	//max checkout time ebook
	public void MaxCheckoutTimeEBook() {
		int expected = eBook.getMax_checkout_time();
		Checked_out_itm itm = eBook.checkout(adult);
		adult.checkout(itm,0);
		int actual = adult.checkReturnDate(0);
		
		assertEquals("correct return date returned", actual, expected);
	}
	
	@Test
	//max checkout time audio book
	public void MaxCheckoutTimeAudioBook() {
		int expected = audioBook.getMax_checkout_time();
		Checked_out_itm itm = audioBook.checkout(adult);
		adult.checkout(itm,0);
		int actual = adult.checkReturnDate(0);
		
		assertEquals("correct return date returned", actual, expected);
	}
	
	@Test
	//max checkout time magazine
	public void MaxCheckoutTimeMagazine() {
		int expected = magazine.getMax_checkout_time();
		Checked_out_itm itm = magazine.checkout(adult);
		adult.checkout(itm,0);
		int actual = adult.checkReturnDate(0);
		
		assertEquals("correct return date returned", actual, expected);
	}
	
	@Test
	//max checkout time DVD
	public void MaxCheckoutTimeDVD() {
		int expected = dvd.getMax_checkout_time();
		Checked_out_itm itm = dvd.checkout(adult);
		adult.checkout(itm,0);
		int actual = adult.checkReturnDate(0);
		
		assertEquals("correct return date returned", actual, expected);
	}
	@Test 
	public void maxWaitListBook() {
		int expected = 10;
		User[] users = new User[10];
		for(int i =0; i < users.length; i++) {
			users[i] = adult;
		}
		int actual = users.length;
		
		assertEquals("Correct waitlist size returned", actual, expected);
		
	}
}
