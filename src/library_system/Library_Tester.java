package library_system;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Library_Tester {
	final String USERID = "100";
	@Test
	public void testCheckout1(){
	    System.out.println("main");
	    String[] args = new String[]{USERID};
	    final InputStream original = System.in;
	    FileInputStream fips;
		try {
			fips = new FileInputStream(new File("test_files/checkout1.txt"));
			System.setIn(fips);
			Library.main(args);
		    Scanner file;
		    String[][] data;
			try {
				file = new Scanner(new File("test_data.txt"));
				int lines = 0;
				while(file.hasNextLine()) {
					++lines;
				}
				data = new String[lines][7];
				for(int i = 0; i < lines; i++) {
					String line = file.nextLine();
					String[] temp = line.split(", ");
					if(temp.length == 7)
						data[i] = temp;
					else
						System.out.println("there was an error reading the file");
				}
				file.close();
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
			
		    System.setIn(fips);
		    System.out.println(args.length);
		    
		    boolean found = false;
		    for(int i=0;i<data.length;i++) {
		    	if(data[i][0].equals("C") && Integer.parseInt(data[i][1]) == 12 && Integer.parseInt(data[i][2]) == Integer.parseInt(USERID));
		    		found = true;
		    }
		    
		    assertTrue(found);
		    System.setIn(original);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	    
	}
}
