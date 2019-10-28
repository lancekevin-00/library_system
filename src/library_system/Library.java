package library_system;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Library {
	private ArrayList<User> Users = new ArrayList<User>();
	private Item_DB stock;
	private User curr_user;
	public static void main(String [] args) {
		
		//load users and get an instance of stock
		
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("~~~~~~~~~~~~~~WELCOME TO THE LIBRARY~~~~~~~~~~~~~~");
		System.out.println("enter your card # to login: ");
		int card_num = scan.nextInt();
		System.out.println("please enter your password to continue: ");
		String pwd = scan.next();
		
		System.out.println("Searching for the number " + card_num + " in the user database");
		System.out.println("checking if the password " + pwd + " is correct");

		
		System.out.println("Welcome to the library " + "example name");
				
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
				//if(user.type == "librarian")
				//System.out.println(10: Edit User)

				int choice = scan.nextInt();
				switch(choice) {
				case 1:
					System.out.println("Enter a search term: ");
					String term = scan.next();
					
					System.out.println("Searching through the stock database for the search term");
					System.out.println("Results:");
					
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
							System.out.println("Getting Book Info");
							break;
						case 2:
							System.out.println("Chekckout The Item");
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
					break;
				case 4:
					System.out.println("Return");
					//select a book or books which you are returning
					break;
				case 5:
					System.out.println("You owe: $" + "<users fines>");
					System.out.println("~~~~~~~~~ACTIONS~~~~~~~~~");
					System.out.println("1: Make a payment");
					System.out.println("2: Return to Menu");
					int n = scan.nextInt();
					switch(n) {
					case 1:
						System.out.println("Enter payment amount");
						System.out.print("$");
						int amt = scan.nextInt();
						System.out.println("Thank you for your payment");
						System.out.println("You now owe "+ "new user fines value" + " in fines");
						break;
					case 2:
						break;
					}
;					break;
				case 6:
					System.out.println("Enter payment amount");
					System.out.print("$");
					int amt = scan.nextInt();
					System.out.println("Thank you for your payment");
					System.out.println("You now owe "+ "new user fines value" + " in fines");
					break;
				case 7:
					System.out.println("Enter your new email address: ");
					String new_email = scan.next()
;					//check for validity of new email
					//set users email to the new email
					break;
				case 8:
					System.out.println("Enter your new password:");
					String pwd1 = scan.next();
					System.out.println("Confirm your password:");
					String pwd2 = scan.next();
					if(pwd1.equals(pwd2)) {
						System.out.println("new password confirmed");
						//set users password to the new password
					}
					else {
						System.out.println("passwords do not match");
						System.out.println("new password not confirmed");
					}
					break;
				case 9:
					go_again = false;
					System.out.println("Good bye");
					break;
				case 10:
				//	if(user.type == librarian)
				//  System.out.println("Entering the edit user menu"
				//	else
					System.out.println("Enter A Valid Number");
					break;
				default:
					System.out.println("Enter A Valid Number");
					break;
				}
			}
			scan.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private User login(int card_num, String pwd) {
		return null;
	}
	private void logout() {}
}
