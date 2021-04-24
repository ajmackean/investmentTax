import java.io.File;

public class Menu {
	
	// this seems to be functioning ok
	
	// menu selection constants
	private final int READ_USER = 1;
	private final int PRINT_USER = 2;
	private final int QUIT= 3;
	
	public Menu(String userName, FileObject newFile) {
		
		System.out.println("Welcome " + userName);
		// loop sentinel for data verification / menu selection
		boolean invalid = true;
		// menu selection var
		int menuSelection = 0;
		
		do {
			
			System.out.println("What would you like to do?");
			System.out.println("1. Read user input \n2. Print file \n3. Quit");
			
			// data type verification
			if (PackageDriver.input.hasNextInt()) {
				menuSelection = PackageDriver.input.nextInt();
				
				// selection verification
				if (menuSelection == READ_USER) {
					System.out.println("Please enter something");
					PackageDriver.input.nextLine();
					newFile.readInputData(userName);
				}
				
				else if (menuSelection == PRINT_USER) {
					newFile.printFile(userName);
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
