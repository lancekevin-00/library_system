package library_system;
/**
 * Library class, Runs the menu for the library
 * @author riley and lance
 * Imports for all of the json files
 */
import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import java.util.ArrayList;
import java.util.Scanner;
public class Library {

	public static void main(String [] args) {
		//load users and get an instance of stock
		ArrayList<User> Users = UserLoader.loadUsers();
		ArrayList<Item> stock = StockLoader.loadDB();
		ArrayList<Checked_out_itm> chkItems = UserLoader.loadCheckedOutItems();
		UserLoader.finish_Checked_out_itm_intsantiation(chkItems, stock);
		UserLoader.finish_Checked_out_itm_intsantiation(chkItems, stock);
		User curr_user = null;
		Checked_out_itm[] items;
		boolean total_logout = false;
		Scanner scan = new Scanner(System.in);
		/**
		 * Starts the menu and library System, Makes sure the system continues running until the user wants to exit
		 */
		while(!total_logout){
			System.out.println("~~~~~~~~~~~~~~WELCOME TO THE LIBRARY~~~~~~~~~~~~~~");
			do {
				System.out.println("enter your card # to login: ");
				int card_num = scan.nextInt();

				//login
				boolean found = false;
				for(User user: Users) {
					if(user.getCardNumber() == card_num) {
						found = true;
						int pwd_attmpts = 3;
						String pwd;
						do {
							System.out.println("please enter your password to continue: ");
							pwd = scan.next();
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
			//Prints the menu
			try {
				boolean go_again = true;
				while(go_again) {
					System.out.println("~~~~~~~~~~~~~~MENU~~~~~~~~~~~~~~");
					System.out.println("1: Search");
					System.out.println("2: Check Due Dates");
					System.out.println("3: Return");
					System.out.println("4: Check Fines");
					System.out.println("5: Pay Fines");
					System.out.println("6: Change Password");
					System.out.println("7: Log out");
					if(curr_user.is_librarian) {
						System.out.println("8: Edit User");
						System.out.println("9: Add item");
						System.out.println("10: Update day");
						System.out.println("11: EXIT THE SYSTEM");
					}

					
					int choice = scan.nextInt();
					scan.nextLine();
					//Searches through the database for the inputed term by the user
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

						//Returns the Search results
						System.out.println("Results:");
						for(Item itm: results) {
							System.out.println(itm.getId() + ": "+ itm.getTitle());
						}

						int id;
						boolean zero = false;
						Item curr_result = null;
						while(curr_result == null && !zero) {
							System.out.println("Select a Result by id# or enter zero to exit:");
							id = scan.nextInt();
							if(id <= 0)
								zero = true;
							for(int i = 0; i < results.size(); i++) {
								if(results.get(i).getId() == id)
									curr_result = results.get(i);
								}
						}
						
						if(zero)
							break;
						//User is given options based on item they selected
						boolean i = true;
						while(i) {
							System.out.println("~~~~~~~~~ACTIONS~~~~~~~~~");
							System.out.println("1: Get Info");
							System.out.println("2: Checkout");
							System.out.println("3: Return to Menu");
							int c = scan.nextInt();
							scan.nextLine();
							switch(c) {
								case 1:
									System.out.println(curr_result.getTitle());
									System.out.println("Copies Available:" + curr_result.getCopies_avalible());
									break;
								case 2:
									//checking that there are no fees
									if (curr_user.getFees() != 0) {
										System.out.println("You have " + curr_user.getFees() + " in outstanding fees so you are unable to checkout");
										break;
									}

									items = curr_user.getItems();

									int g = 0;
									while(items[g] != null && g < items.length)
										g++;

									if(g == items.length) {
										System.out.println("you have reached your checkout limit");
										break;
									}

									Checked_out_itm itm = curr_result.checkout(curr_user);
									if(itm == null) {
										System.out.println("there are no more copies in stock");
										break;
									}

									curr_user.checkout(itm, g);

									break;
								case 3:
									System.out.println("Return to Menu");
									i = false;
									break;
								}
						}
						break;
						//Checks due dates of checked out items
					case 2:
						System.out.println("Check Due Dates");
						items = curr_user.getItems();
						for(Checked_out_itm item: items) {
							if(item !=null) {
							System.out.println(item.getTitle()+": "+item.getTime_remaining()+" days remaining");
							}
						}
						break;
						//Lets the user know which items they have checked out 
					case 3:
						System.out.println("Checked Out Items:");
						items = curr_user.getItems();
						for(Checked_out_itm itm: items) {
							if(itm != null)
								System.out.println("ID: "+itm.getId() + ":\t "+ itm.getTitle() + "\t " + itm.getTime_remaining() + " days remaining \t this item has been renewed " + itm.getRenewals() + " times");
						}
						int d = 0;
						boolean e = false;
						while(!e || d == 0) {
							System.out.println("Please enter the ID of the item you would like to return or 0 to exit");
							d = scan.nextInt();
							for(int f = 0; f < items.length; f++) {
								if(items[f]!=null && d == items[f].getId()) {
									e = true;
									curr_user.return_itm(f);
								}
							}
						}
						break;
						//Prints out the users fees and allows the user to pay the fees
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
						//The user can make a payment for their fees
					case 5:
						System.out.println("Enter payment amount");
						System.out.print("$");
						int amt = scan.nextInt();
						curr_user.makePayment(amt);
						System.out.println("Thank you for your payment");
						System.out.println("You now owe "+ curr_user.getFees() + " in fines");
						break;
						//The user can change their password
					case 6:
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
						//Logout
					case 7:
						go_again = false;
						System.out.println("Good bye " + curr_user.Name);
						curr_user = null;
						break;
						//Allows the librarian to edit a user
					case 8:
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
							System.out.println("2: Change Address");
							System.out.println("3: exit");

							int a = scan.nextInt();
							switch(a) {
							case 1:
								System.out.println("fines: "+ eUser.getFees());
								break;
							case 2:
								System.out.println("enter the new address");
								String nAddress = scan.nextLine();
								eUser.setAddress(nAddress);
								break;
							default:
								f = true;
								break;
							}
						}
						else
						System.out.println("Enter A Valid Number");
						break;
						//Allows the librarian to add a new item to stock and specify all information about it
					case 9:
						String title, genre, publisher, author,director,actors;
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
							updateBook(books);
							break;
						case 2:
							System.out.println("Enter Directors");
							director = scan.nextLine();
							System.out.println("Enter the actors you want displayed seperated by commas");
							actors = scan.nextLine();
							DVD newDVD = new DVD(idNum,title,year,genre,director ,actors,numCopies,newArrival);
							ArrayList<DVD> dvds = StockLoader.getDvds();
							dvds.add(newDVD);
							updateDVDs(dvds);
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
							updateMagazines(magazines);
							break;
						case 4:
							System.out.println("Enter Publisher");
							publisher = scan.nextLine();
							System.out.println("Enter Author");
							author = scan.nextLine();
							eBook newebook = new eBook(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							ArrayList<eBook> ebooks = StockLoader.getEbooks();
							ebooks.add(newebook);
							updateeBooks(ebooks);
							break;
						case 5:
							System.out.println("Enter Publisher");
							publisher = scan.nextLine();
							System.out.println("Enter Author");
							author = scan.nextLine();
							Audio_Book newaudioBook = new Audio_Book(idNum,title,year,genre,publisher,author,numCopies,newArrival);
							ArrayList<Audio_Book> audiobooks = StockLoader.getAudiobooks();
							audiobooks.add(newaudioBook);
							updateAudio_Books(audiobooks);
							break;
						}
						break;
						//Updates the day for the checked out books
					case 10:
						System.out.println("Updating the day");
						for(User user: Users) {
							if(user !=  null) {
								System.out.println(user.getName());
								user.updateDay();
								user.updateFees();
							}
						} 
						break;
						//Exits the system
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
		}
		while(!total_logout);
		scan.close();
		//Writes all the updated lists to the respective database
		updateBook(StockLoader.getBooks());
		updateDVDs(StockLoader.getDvds());
		updateMagazines(StockLoader.getMagazines());
		updateeBooks(StockLoader.getEbooks());
		updateAudio_Books(StockLoader.getAudiobooks());
		updateUsers(Users);
		updateChkOutItems(chkItems);
	}
/**Helper Methods
 *
 * These methods print out the updated arraylists to the json files
 * 
 */
	private static void updateBook(ArrayList<Book> books) {

		try (FileWriter file = new FileWriter("books.json")) {
			file.write("{\"books\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <books.size(); i++) {
		    	  list.add(books.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");

	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateDVDs(ArrayList<DVD> dvd) {
		try (FileWriter file = new FileWriter("dvds.json")) {
			file.write("{\"dvds\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <dvd.size(); i++) {
		    	  list.add(dvd.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateMagazines(ArrayList<Magazine> magazines) {
		try (FileWriter file = new FileWriter("magazines.json")) {
			file.write("{\"magazines\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <magazines.size(); i++) {
		    	  list.add(magazines.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateeBooks(ArrayList<eBook> ebook) {
		try (FileWriter file = new FileWriter("ebooks.json")) {
			file.write("{\"ebooks\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <ebook.size(); i++) {
		    	  list.add(ebook.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateAudio_Books(ArrayList<Audio_Book> audiobook) {
		try (FileWriter file = new FileWriter("audiobooks.json")) {
			file.write("{\"audiobooks\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <audiobook.size(); i++) {
		    	  list.add(audiobook.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateUsers(ArrayList<User> users) {
		try (FileWriter file = new FileWriter("users.json")) {
			file.write("{\"users\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <users.size(); i++) {
		    	  list.add(users.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	private static void updateChkOutItems(ArrayList<Checked_out_itm> chkItems) {
		try (FileWriter file = new FileWriter("checkedoutitems.json")) {
			file.write("{\"checkedoutitems\":");
			  JSONArray list = new JSONArray();
		      for(int i = 0; i <chkItems.size(); i++) {
		    	  list.add(chkItems.get(i));
		      }
			file.write(list.toJSONString());
			file.write("\n}");
	file.flush();
	file.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
