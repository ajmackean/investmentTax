import java.math.BigDecimal;

public class Investment {
	
	// these should list individual investments
	
	private String name;
	private BigDecimal amount; 
	private BigDecimal currentValue;
	private BigDecimal totalValue;
	
	public Investment() {
		
		// sentinel boolean
		boolean invalid = true;
		
		System.out.println("Please enter the name of the investment");
		this.name = PackageDriver.input.nextLine();
		
		do {
			
			System.out.println("Please enter quantity");
			
			if (PackageDriver.input.hasNextBigDecimal()) {
				this.amount = PackageDriver.input.nextBigDecimal();
				invalid = false;
			}
			
			else {
				System.out.println("Error: Please enter a valid number");
				PackageDriver.input.nextLine();
			}
			
		} while (invalid);
		
		// resets sentinel control boolean
		invalid = true; 
		
		do {
			
			System.out.println("Please enter the current price");
			
			if (PackageDriver.input.hasNextBigDecimal()) {
				this.currentValue = PackageDriver.input.nextBigDecimal();
				invalid = false;
			}
			
			else {
				System.out.println("Error: Please enter a valid number");
				PackageDriver.input.nextLine();
			}
			
		} while (invalid);
		
		// resets sentinel control boolean
		invalid = true; 
		
		// calculate current investment value
		this.totalValue = amount.multiply(currentValue);
		
		System.out.println("Name: " +name);
		System.out.println("Price per unit: " + currentValue);
		System.out.println("Total investment value: " + totalValue);
		
	}
	

}
