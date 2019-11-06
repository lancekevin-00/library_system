package library_system;

import java.util.ArrayList;
import java.util.Scanner;
public class Library {

	public static void main(String [] args) {

		//load users and get an instance of stock
		ArrayList<User> Users = UserLoader.loadUsers();
		ArrayList<Item> stock = StockLoader.loadDB();
		User curr_user = null;
		Checked_out_itm[] items;
		boolean total_logout = false;
		Scanner scan = new Scanner(System.in);
		
		
		for(Item ffffgee: stock) {
			System.out.println(ffffgee.getId() + "\t" + ffffgee.getTitle());
		}
		
		
		
		
		while(!total_logout){
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
								pwd_attmpts--;
								System.out.println("incorrect password " + pwd_attmpts + " attempts remaining");
							}
						}
						while(pwd_attmpts > 0 && curr_user == null);
						if (pwd_attmpts == 0)
							System.out.println("You ran out of attempts");
					}

				}
				if (!found) {
					System.out.println("that card number does not exist");
				}

			}
			while(curr_user == null);

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

						System.out.println("Searching through the stock database for the search term");
						ArrayList<Item> results = new ArrayList<Item>();
						for(Item itm:stock) {
							String[] terms = itm.getSearchTerms();
							for(int i = 0; i < terms.length; i++) {

								if(terms[i].contains(term) && !results.contains(itm))
									results.add(itm);

							}
						}
						
						
						System.out.println("Results:");
						for(Item itm: results) {
							System.out.println(itm.getId() + ": "+ itm.getTitle());
						}


						System.out.println("Select a Result by id# or enter zero to exit:");
						int id = scan.nextInt();
						if(id <= 0)
							break;
						Item curr_result = null;
						while(curr_result == null) {
							for(int i = 0; i < results.size(); i++) {
								if(results.get(i).getId() == id)
									curr_result = results.get(i);
								}
							System.out.println("Please enter a valid id or 0 to exit");
						}


						System.out.println("~~~~~~~~~ACTIONS~~~~~~~~~");
						System.out.println("1: Get Info");
						System.out.println("2: Checkout");
						System.out.println("3: Return to Menu");
						
						boolean i = true;
						while(i) {
						int c = scan.nextInt();
						switch(c) {
							case 1:
								System.out.println(curr_result.getTitle());
								System.out.println("Copies Available:" + curr_result.getCopies_avalible());
								break;
							case 2:
								if (curr_user.getFees() != 0) {
									System.out.println("You have " + curr_user.getFees() + " in outstanding fees so you are unable to checkout");
									break;
								}
								items = curr_user.getItems();
								boolean added = false;
								for(int b=0; b<items.length; b++) {
									if(items[b] == null) {
										curr_user.checkout(curr_result.checkout(), b);
										added = true;
										System.out.println("successfully checked out "+ curr_result.getTitle());
									}
								}
								if(!added)
									System.out.println("you have reached your checkout limit");
								break;
							case 3:
								System.out.println("Return to Menu");
								i = false;
								break;
							}
						}
						break;
					case 2:
						System.out.println("Check Due Dates");
						items = curr_user.getItems();
						for(Checked_out_itm item: items) {
							System.out.println(item.getTitle()+": "+item.getTime_remaining()+" days remaining");
						}
						break;
					case 3:
						System.out.println("Checked Out Items:");
						items = curr_user.getItems();
						for(Checked_out_itm itm: items) {
							System.out.println("ID: "+itm.getId() + ":\t "+ itm.getTitle() + "\t " + itm.getTime_remaining() + " days remaining \t this item has been renewed " + itm.getRenewals() + " times");
						}
						int d = 0;
						boolean e = false;
						while(!e || d == 0) {
							System.out.println("Please enter the ID of the item you would like to return or 0 to exit");
							d = scan.nextInt();
							for(int f = 0; f < items.length; f++) {
								if(d == items[f].getId()) {
									e = true;
									curr_user.return_itm(f);
								}
							}
						}
						break;
					case 4:
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
					case 5:
						System.out.println("Enter payment amount");
						System.out.print("$");
						int amt = scan.nextInt();
						curr_user.makePayment(amt);
						System.out.println("Thank you for your payment");
						System.out.println("You now owe "+ curr_user.getFees() + " in fines");
						break;
					case 6:
						System.out.println("Enter your new email address: ");
						String new_email = scan.next();
						curr_user.setEmail(new_email);
						break;
					case 7:
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
					case 8:
						go_again = false;
						System.out.println("Good bye" + curr_user.Name);
						curr_user = null;
						break;
					case 9:
						if(curr_user.is_librarian) {

							//finding the user
							System.out.println("Enter the card Number of the user you would like to edit:");
							User eUser = null;
							boolean f = false;
							do {
								int cNum = scan.nextInt();
								if (cNum > 0) {
									for(User user : Users) {
										if (user.getCardNumber() == cNum) {
											eUser = user;
											f = true;
										}
									}
									if (eUser == null) {
										System.out.println("user not found, try again or enter -1 to exit");
									}
								}
							}
							while(!f);
							System.out.println("------------------");
							System.out.println("1: Look up fines");
							System.out.println("2: Change Email");
							System.out.println("3: Change Address");
							System.out.println("4: Change Phone Number");
							System.out.println("0: exit");

							int a = scan.nextInt();
							switch(a) {
							case 1:
								System.out.println("fines: "+ eUser.getFees());
								break;
							case 2:
								System.out.println("enter the new email");
								String nEmail = scan.next();
								eUser.setEmail(nEmail);
								break;
							case 3:
								System.out.println("enter the new address");
								String nAddress = scan.nextLine();
								eUser.setAddress(nAddress);
								break;
							case 4:
								System.out.println("enter the new email");
								int nPhone = scan.nextInt();
								eUser.setPhone(nPhone);
								break;
							default:
								break;
							}
						}
						else
						System.out.println("Enter A Valid Number");
						break;
					case 10:
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
						System.out.println("Enter number of copies");
						numCopies = scan.nextInt();
						scan.nextLine();
						System.out.println("Enter true if new arrival and false if not");
						newArrival = scan.nextBoolean();
						scan.nextLine();
						switch(add) {

						case 1:
							System.out.println("Enter Publisher");
							publisher = scan.nextLine();
							System.out.println("Enter Author");
							author = scan.nextLine();
							Book newbook = new Book(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							ArrayList<Book> books = StockLoader.getBooks();
							books.add(newbook);
							curr_user.addNewBook(books);
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
							DVD newDVD = new DVD(idNum,title,year,genre,director ,actors,numCopies,newArrival);
							ArrayList<DVD> dvds = StockLoader.getDvds();
							dvds.add(newDVD);
							curr_user.addNewDVD(dvds);
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
							Magazine newMagazine = new Magazine(idNum,title,year,genre,publisher,volume,issue,numCopies,newArrival);
							ArrayList<Magazine> magazines = StockLoader.getMagazines();
							magazines.add(newMagazine);
							curr_user.addNewMagazine(magazines);
							break;
						case 4:
							System.out.println("Enter Publisher");
							publisher = scan.nextLine();
							System.out.println("Enter Author");
							author = scan.nextLine();
							eBook newebook = new eBook(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							ArrayList<eBook> ebooks = StockLoader.getEbooks();
							ebooks.add(newebook);
							curr_user.addNeweBook(ebooks);
							break;
						case 5:
							System.out.println("Enter Publisher");
							publisher = scan.nextLine();
							System.out.println("Enter Author");
							author = scan.nextLine();
							Audio_Book newaudioBook = new Audio_Book(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							ArrayList<Audio_Book> audiobooks = StockLoader.getAudiobooks();
							audiobooks.add(newaudioBook);
							curr_user.addNewAudio_Book(audiobooks);
							break;
						}
						break;
					case 11:
						System.out.println("EXITING THE SYSTEM");
						total_logout = true;
						go_again = false;
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
			System.out.println("were at the end of the loop");
		}
		while(!total_logout);
		scan.close();
	}
}
