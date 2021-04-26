import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Investment implements Serializable{
	
	// these should list individual investments
	
	private String name;
	private BigDecimal amount; 
	private BigDecimal initialUnitValue;
	private BigDecimal initialInvestmentTotal;
	private BigDecimal changeInValue;
	private BigDecimal currentValue;
	
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
			
			System.out.println("Please enter the current price of one unit");
			
			if (PackageDriver.input.hasNextBigDecimal()) {
				this.initialUnitValue = PackageDriver.input.nextBigDecimal();
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
		this.initialInvestmentTotal = amount.multiply(initialUnitValue);
		this.currentValue = initialInvestmentTotal;
		
		
	}
	
	// loop to update the value of the individual investments
	public void setCurrentValue() {
		
		// loop control sentinel 
		boolean invalid = true;
		
		System.out.println("What is the current value of " + name + " per unit?");
		
		while (invalid) {
						
			if (PackageDriver.input.hasNextBigDecimal()) {
				
				// sets the current portfolio value 
				this.currentValue = amount.multiply(PackageDriver.input.nextBigDecimal());
				invalid = false;
			}
						
			else {
							
				System.out.println("Error. Please enter a valid number");
							
			} // end of validation loop
		}
		
		// updates the changeInValue field. Duplicated code, potentially redundant. In future find way to simplify.
		changeInValue = currentValue.subtract(initialInvestmentTotal);
	}
	
	// prints out the investment breakdown of each object in the portfolio array
	public void printBreakdown() {
			
		System.out.println("=====================================================");
		System.out.println("Name: " + name);
		System.out.println("Purchased " + amount.setScale(2, RoundingMode.HALF_DOWN) + " units of " + name 
				+ " for $" + initialUnitValue.setScale(2, RoundingMode.HALF_DOWN));
		System.out.println("Investment is currently valued at $" + currentValue.setScale(2, RoundingMode.HALF_DOWN));
		
		// print profit or loss
		changeInValue = currentValue.subtract(initialInvestmentTotal);
		
		if (changeInValue.compareTo(BigDecimal.ZERO) == 0) {
			System.out.println("No change in investment value");
		}
		
		else if (changeInValue.compareTo(BigDecimal.ZERO) > 0) {
			System.out.println("Profit of $" + changeInValue.setScale(2, RoundingMode.HALF_DOWN));
		}
		
		else if (changeInValue.compareTo(BigDecimal.ZERO) < 0) {
			System.out.println("Loss of -$" + changeInValue.setScale(2, RoundingMode.HALF_DOWN));
		}
		
		else {
			// there should be no way for this to trigger. Kept here as data validation though.
			System.out.println("Error in calculating the change in value.");
		}
		// change in value = current total - initial total
		System.out.println("=====================================================");
	}
	
	public BigDecimal getCurrentValue() {
		return currentValue;
	}
}
