package library_system;

import java.util.ArrayList;
import java.util.Scanner;
//import java.io.*;

public class Library {

	public static void main(String [] args) {
		
		//load users and get an instance of stock
		ArrayList<User> Users = UserLoader.loadUsers();
		Item_DB stock = new Item_DB();
		User curr_user = null;
		boolean total_logout = false;
		Scanner scan = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~~~~~WELCOME TO THE LIBRARY~~~~~~~~~~~~~~");
			do {
				System.out.println("enter your card # to login: ");
				int card_num = scan.nextInt();	
		
				//login
				System.out.println("Searching for the number " + card_num + " in the user database");
				boolean found = false;
				for(User user: Users) {
					if(user.getCardNumber() == card_num) {
						found = true;
						int pwd_attmpts = 3;
						String pwd;
						do {
							System.out.println("please enter your password to continue: ");
							pwd = scan.next();
							System.out.println("checking if the password " + pwd + " is correct");
							if (user.getPassword().equals(pwd)){
								System.out.println("login successful");
								curr_user = user;
							}
							else {
								System.out.println("incorrect password " + pwd_attmpts + " attempts remaining");
								pwd_attmpts--;
							}
						}
						while(pwd_attmpts > 0 && curr_user == null);
					}
				}
				if (!found) {
					System.out.println("that card number does not exist");
				}
				else {
					System.out.println("you ran out of attempts");
				}
				
			}
			while(curr_user == null);
	
	
			//this is an example user in the system used for testing the menu
			//curr_user = new Adult(001, "Example", "Name", 2000, "1234 Example lane" , 001, " Password", 0.00, new Child[0]);
			
			System.out.println("Welcome to the library " + curr_user.getName());
					
			try {
				boolean go_again = true;
				while(go_again) {
					System.out.println("~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~");
					System.out.println("1: Search");
					System.out.println("2: Check Out");
					System.out.println("3: Check Due Dates");
					System.out.println("4: Return");
					System.out.println("5: Check Fines");
					System.out.println("6: Pay Fines");
					System.out.println("7: Change Email Address");
					System.out.println("8: Change Password");
					System.out.println("9: Log out");
					if(curr_user.is_librarian) {
						System.out.println("10: Edit User");
						System.out.println("11: Add item");
					}
					
	
					int choice = scan.nextInt();
					scan.nextLine();
					switch(choice) {
					case 1:
						System.out.println("Enter a search term: ");
						String term = scan.nextLine();
						System.out.println(term);
						//Create a book arraylist
						ArrayList<Book> bookStock = stock.getBooks();
						//Create a DVD arraylist
						ArrayList<DVD> dvdStock = stock.getDVDs();
						//Create a Magazine arraylist
						ArrayList<Magazine> magazineStock = stock.getMagazines();
						ArrayList<eBook> ebookStock = stock.geteBooks();
						ArrayList<Audio_Book> audiobookStock = stock.getaudioBooks();
						System.out.println("Searching through the stock database for the search term");
						System.out.println("Results:");					
						//All this subject to change once we get them all into one arraylist 
						//Search through the books search terms and print id and title fo the book(can add other stuff later
						for(Book book : bookStock) {
							for(int i = 0; i < 3; i++) {
								if(book.getSearchTerms(i).contains(term)) {
									System.out.println(book.getId() + ": " + book.getTitle());
									i = 4;
								}		
							}
						} 
						//Search throught the dvd search terms
						for(DVD dvd : dvdStock) {
							for(int j = 0; j < 3; j++) {
								if(dvd.getSearchTerms(j).contains(term)) {
									System.out.println(dvd.getId() + ": " + dvd.getTitle());
									j = 4;
								}		
							}
						}
						//Search through the magazine search terms
						for(Magazine magazine : magazineStock) {
							for(int i = 0; i < 3; i++) {
								if(magazine.getSearchTerms(i).contains(term)) {
									System.out.println(magazine.getId() + ": " + magazine.getTitle());
									i = 4;
								}		
							}
						}
						//Search through the eBook stock
						for(eBook ebook : ebookStock) {
							for(int i = 0; i < 3; i++) {
								if(ebook.getSearchTerms(i).contains(term)) {
									System.out.println(ebook.getId() + ": " + ebook.getTitle());
									i = 4;
								}		
							}
						}
						//Search through the audioBook search terms
						for(Audio_Book audiobook : audiobookStock) {
							for(int i = 0; i < 3; i++) {
								if(audiobook.getSearchTerms(i).contains(term)) {
									System.out.println(audiobook.getId() + ": " + audiobook.getTitle());
									i = 4;
								}		
							}
						}
						System.out.println("Select a Result by id# or enter zero to exit:");
						int id = scan.nextInt();
						if(id == 0)
							break;
						
						System.out.println("~~~~~~~~~ACTIONS~~~~~~~~~");
						System.out.println("1: Get Info");
						System.out.println("2: Checkout");
						System.out.println("3: Return to Menu");
						int c = scan.nextInt();
						boolean i = true;
						//while(i) {
						switch(c) {
							case 1:
								System.out.println("Getting Item Info");
							//	System.out.println("Copies Available:" + );
								break;
							case 2:
								System.out.println("Checkout The Item");
								break;
							case 3:
								System.out.println("Return to Menu");
								i = false;
								break;
							}
						//}
						break;
					case 2: //I think we should get rid of this and just leave checkout to the search action
						System.out.println("Checking Out");
						break;
					case 3:
						System.out.println("Check Due Dates");
						Checked_out_itm[] items = curr_user.getItems();
						for(Checked_out_itm item: items) {
							System.out.println(item.getTitle()+": "+item.getTime_remaining()+" days remaining");
						}
						break;
					case 4:
						System.out.println("Return");
						//select a book or books which you are returning
						break;
					case 5:
						System.out.println("You owe: $" + curr_user.getFees());
						System.out.println("~~~~~~~~~ACTIONS~~~~~~~~~");
						System.out.println("1: Make a payment");
						System.out.println("2: Return to Menu");
						int n = scan.nextInt();
						switch(n) {
						case 1:
							System.out.println("Enter payment amount");
							System.out.print("$");
							int amt = scan.nextInt();
							curr_user.makePayment(amt);
							System.out.println("Thank you for your payment");
							System.out.println("You now owe "+ curr_user.getFees() + " in fines");
							break;
						case 2:
							break;
						};
						break;
					case 6:
						System.out.println("Enter payment amount");
						System.out.print("$");
						int amt = scan.nextInt();
						curr_user.makePayment(amt);
						System.out.println("Thank you for your payment");
						System.out.println("You now owe "+ curr_user.getFees() + " in fines");
						break;
					case 7:
						System.out.println("Enter your new email address: ");
						String new_email = scan.next();
						//check for validity of new email
						//set users email to the new email
						break;
					case 8:
						System.out.println("Enter your new password:");
						String pwd1 = scan.next();
						System.out.println("Confirm your password:");
						String pwd2 = scan.next();
						if(pwd1.equals(pwd2)) {
							System.out.println("new password confirmed");
							curr_user.changePwd(pwd2);
						}
						else {
							System.out.println("passwords do not match");
							System.out.println("new password not confirmed");
						}
						break;
					case 9:
						go_again = false;
						curr_user = null;
						System.out.println("Good bye" + curr_user.Name);
						break;
					case 10:
						if(curr_user.is_librarian)
					    System.out.println("Entering the edit user menu");
						else
						System.out.println("Enter A Valid Number");
						break;
					case 11: 
						String title, genre, publisher, author,director;
						String [] actors;
						int year, numCopies,idNum, volume, issue;
						boolean newArrival;
						System.out.println("~~~~~~~~~ACTIONS~~~~~~~~~");
						System.out.println("1: Add a Book");
						System.out.println("2: Add a DVD");
						System.out.println("3: Add a Magazine");
						System.out.println("4: Add an eBook");
						System.out.println("5: Add an Audio Book");
						int add = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter ID #");
						idNum = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter Title"); 
						title = scan.nextLine();
						System.out.println("Enter Year");
						year = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter Genre");
						genre = scan.nextLine();
						System.out.println("Enter Publisher"); 
						publisher = scan.nextLine();
						System.out.println("Enter Author"); 
						author = scan.nextLine();
						System.out.println("Enter number of copies");
						numCopies = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter true if new arrival and false if not"); 
						newArrival = scan.nextBoolean();
						scan.nextLine();
						switch(add) {
						
						case 1: 			
							curr_user.addNewBook(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							break;
						case 2: 
							System.out.println("Enter Directors"); 
							director = scan.nextLine();
							System.out.println("Enter number of actors you would like listed");
							int numOfActors = scan.nextInt();
							scan.nextLine();
							actors = new String[numOfActors];
							for(int x = 0; x < numOfActors;x++ ) {
							System.out.println("Enter Actor"); 
							actors[x] = scan.nextLine();
							}
							curr_user.addNewDVD(idNum,title,year,genre,director,actors,numCopies,newArrival);
							break;
						case 3: 
							System.out.println("Enter Publisher"); 
							publisher = scan.nextLine();
							System.out.println("Enter Volume#"); 
							volume = scan.nextInt();
							scan.nextLine();
							System.out.println("Enter Issue#"); 
							issue = scan.nextInt();
							scan.nextLine();
							curr_user.addNewMagazine(idNum,title,year,genre,publisher,volume,issue,numCopies,newArrival);
							break;
						case 4: 
							curr_user.addNeweBook(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							break;
						case 5: 
							curr_user.addNewAudio_Book(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							break;
							
							
						}
						break;
					case 12:
						System.out.println("EXITING THE SYSTEM");
						total_logout = true;
						break;
					default:
						System.out.println("Enter A Valid Number");
						break;
					}
				}
			}
			catch (Exception e) {
				System.out.println(e);
			}
		}
		while(!total_logout);
		scan.close();
	}
}
