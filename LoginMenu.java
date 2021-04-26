import java.nio.file.*;

public class LoginMenu {
	
	// need a delete user function
	
	// needs to have some sort of encryption
	
	private String userName;
	private String password; 
	
	public LoginMenu() {
		
		this.loginLoop();
		
	}
	
	public void loginLoop() {
		
		// loop control sentinel 
		boolean invalid = true;
		int selection;
		
		do {
			
			
			System.out.println("What would you like to do? \n1. Login \n2. Create New User \n3. Delete User\n4. Quit");
			
			// data verification loop 
			if (PackageDriver.input.hasNextInt()) {
				
				// variable assignment
				selection = PackageDriver.input.nextInt();
				
				// selection structure
				if (selection == 1) {
					
					System.out.println("Login");
					userLogin();
					invalid = false;
					// calls login method
					
				}
				
				else if (selection == 2) {
					
					// creates new user
					newUser();
					
					// logs out after quitting
					invalid = false;
					
				}
				
				else if (selection == 3) {
					
					System.out.println("Delete user");
					
				}
				
				else if (selection == 4) {
					
					System.out.println("Quit");
					invalid = false;
					// quits
					
				}
				
				else {
					
					System.out.println("Invalid selection");
					PackageDriver.input.nextLine(); // clears input stream for next loop
				} // end of selection stream
				
				
			}
			
			else {
				
				System.out.println("Error please enter an integer");
				PackageDriver.input.nextLine(); // clears input stream for next loop
				
			} // end of data type verification
			
			
		} while(invalid); // end of repetition for menu
		
		System.out.println("Exiting Program");
		
	}

	public void userLogin() {
		
		// asks for username and password. If that matches up it open the /data/username file
		
		
	}
	
	public void newUser() {
		
		// could check path from here I guess...
		
		// sentinel control value
		boolean invalid = true;
		
		PackageDriver.input.nextLine();
		
		do {
			
			// prompt user for an input
			System.out.println("Please enter a username");
			
			// clears input stream and stores input as a variable to check the path of
			userName = PackageDriver.input.nextLine();
			
			Path myPath = Paths.get("user/" + userName + ".txt");
			
			if (Files.exists(myPath)){
				
				// user exists
				System.out.println("Error. User Already exists.");
			}
			
			else {
				
				// instantiation of new user
				FileObject newFile = new FileObject(userName);
				
				// needs to create a password
				System.out.println("Please enter a password");
				
				// needs to write password to first line of the text. 
				
				newFile.readInputPassword(userName);
				
				// creates a new menu, enters menu loop
				Menu newMenu = new Menu(userName, newFile);
						
				invalid = false;
			}
			
		} while(invalid);
		
	}
}
