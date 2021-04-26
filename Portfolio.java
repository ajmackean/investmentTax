import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class Portfolio implements Serializable{
	
	// dynamic list of investment objects
	private ArrayList <Investment> investmentPortfolio = new ArrayList<Investment>();
	private String userName;
	
	private BigDecimal portfolioCurrentTotal = new BigDecimal(99);
	double test = 0;
	
	// will have to track some things like total value, change in portfolio value, that kind of stuff
	
	public Portfolio(String userName) {
		
		this.userName = userName;
		// this readObjectFile will break code if non existant. Need to compare against path for new users
		this.readObjectFile();
		
		System.out.println("Welcome to " + userName + "'s investment portfolio. \nPlease make a selection");
		
		// loop control sentinel
		boolean invalid  = true;
		int selection;
		
		// selection structure for portfolio menu
		do {
			
			System.out.println("1. Detailed Investment Breakdown \n2. Add Investment \n3. Manage investments \n4. Quit");
			if (PackageDriver.input.hasNextInt()) {
				selection = PackageDriver.input.nextInt();
				
				// provides investment breakdown in details
				if (selection == 1) {
					
					if (investmentPortfolio.size() == 0) {
						System.out.println("You are not currently tracking any investments.");
					}
					
					else {
						for (Investment number: investmentPortfolio) {
							number.printBreakdown();
							
							// sets the portfolio value for each investment
							this.portfolioCurrentTotal = portfolioCurrentTotal.add(number.getCurrentValue());

						}
						
						// print the total portfolio value
						System.out.println("\n\n***** Current value of total investments: $" + portfolioCurrentTotal + " *****\n\n");
						
					}

					PackageDriver.input.nextLine();
				}
				
				// allows for new investments to be added
				else if (selection == 2) {
					
					PackageDriver.input.nextLine(); // clear input stream
					Investment test = new Investment();
					investmentPortfolio.add(test);
					PackageDriver.input.nextLine();
					
				}
				
				// change / delete investments
				else if (selection == 3) {
					
					System.out.println("Changing the investments");
					PackageDriver.input.nextLine();
					
				}
				
				// quit the program
				else if (selection == 4) {
					
					System.out.println("See ya nerd");
					this.printObjectFile();
					invalid = false;
				}
				
				// invalid selection 
				else {
					
					System.out.println("Please make a valid selection");
					
				}
				
			}
			
			// invalid data type selection
			else {
				
				System.out.println("Please make a valid selection");
				PackageDriver.input.nextLine();
				
			}
			
		} while (invalid);
		
	}

	public void printObjectFile() {
		
		// uses argument of portfolio object as well as username to create serializable object
		try {
			// creates the path to file
			FileOutputStream fileOut = new FileOutputStream("data/" + userName + ".ser");
			// creates the object output
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			// writes object to the path
			out.writeObject(investmentPortfolio);
			out.close();
			fileOut.close();
		} catch (IOException i) {
			i.printStackTrace();
		}
	}
	
	// i think this is all ready to go
	public void readObjectFile() {
		
		try {
			FileInputStream fileIn = new FileInputStream("data/" + userName + ".ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			this.investmentPortfolio = (ArrayList<Investment>)in.readObject();
			in.close();
			fileIn.close();
			return;
	
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			return;
		}
		

	}
	
	
}
