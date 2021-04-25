import java.util.ArrayList;

public class Portfolio {
	
	// dynamic list of investment objects
	private ArrayList <Investment> investmentPortfolio = new ArrayList<Investment>();
	
	public Portfolio(String userName) {
		
		System.out.println("Welcome to " + userName + "'s investment portfolio. \nPlease make a selection");
		
		// loop control sentinel
		boolean invalid  = true;
		int selection;
		
		do {
			
			System.out.println("1. Investment Breakdown \n2. Add Investment \n3. Quit");
			if (PackageDriver.input.hasNextInt()) {
				selection = PackageDriver.input.nextInt();
				
				if (selection == 1) {
					
					System.out.println("This is the breakdown");
					PackageDriver.input.nextLine();
				}
				
				else if (selection == 2) {
					
					System.out.println("Adding to the investments");
					PackageDriver.input.nextLine();
					
				}
				
				else if (selection == 3) {
					
					invalid = false;
					
				}
				
				else {
					
					System.out.println("Please make a valid selection");
					
				}
				
			}
			
			else {
				
				System.out.println("Please make a valid selection");
				PackageDriver.input.nextLine();
				
			}
			
		} while (invalid);
		
	}

}
