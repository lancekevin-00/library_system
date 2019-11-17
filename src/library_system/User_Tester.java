package library_system;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

class User_Tester {
	
	User adult, teacher, librarian;
	private final ByteArrayOutputStream output = new ByteArrayOutputStream();
	
	@Before
	public void setupStreams() {
		System.setOut(new PrintStream(output));
	}
	
	@Before
	public void init_user() {
		adult = new Adult(0, "John", "Doe", 2000, "1234 Example st", 0, "password" , 0, "A");
		teacher = new Teacher(1, "School", "Teacher", 1980, "1 school street", 1, "password", 0, "T");
		librarian = new Librarian(2, "the", "librarian", 0, "1 learning lane", 2, "password", 0, "L");
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
	
	@Test
	public void AdultCheckout1() {
		Checked_out_itm itm = new Checked_out_itm("Harry Potter", new Book(0, "Harry Potter", 1997, "Fiction", "Bloomsbury", "J. K. Rowling", 1, false));
		adult.checkout(itm,1);
		Checked_out_itm[] temp = adult.getItems();
		String actual = temp[1].toString();
		String expected = itm.toString();
		
		assertEquals("harry potter was added correctly", actual, expected);
	}

}
