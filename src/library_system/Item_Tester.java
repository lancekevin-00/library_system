package library_system;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Item_Tester {
	User adult, teacher, librarian;
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
	}
	
	@After
	public void cleanUpStreams() {
		System.setOut(null);
	}
}
