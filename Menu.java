import java.io.File;

public class Menu {
	
	// menu selection constants
	private final int READ_USER = 1;
	private final int PRINT_USER = 2;
	private final int QUIT= 3;
	
	public Menu(String userName) {
		
		System.out.println("Welcome " + userName);
		// loop sentinel for data verification / menu selection
		boolean invalid = true;
		// menu selection var
		int menuSelection = 0;
		
		do {
			
			System.out.println("What would you like to do?");
			System.out.println("1. Manage portfolio \n2. Print portfolio summary \n3. Quit");
			
			// data type verification
			if (PackageDriver.input.hasNextInt()) {
				menuSelection = PackageDriver.input.nextInt();
				
				// selection verification
				if (menuSelection == READ_USER) {
					
					Portfolio user = new Portfolio(userName);
					invalid = false;

				}
				
				else if (menuSelection == PRINT_USER) {
					
					Portfolio summary = new Portfolio(1, userName);
					// NEEDS TO PRINT A PORTFOLIO SUMMARY
					
					
				}
				
				else if (menuSelection == QUIT) {
					invalid = false;
				}
				
				else {
					System.out.println("invalid");
				}

			} // end of selection verification
			
			else {
				System.out.println("Invalid input");
				PackageDriver.input.nextLine();
			} // end of data type verification
			
			
		} while (invalid); // end of menu loop 
			
	}

}
