import java.util.Scanner;


public class PackageDriver {
	
	// static scanner for class wide use
	final static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		LoginMenu c1 = new LoginMenu();
		
//		c1.loginLoop();
		
		Portfolio test = new Portfolio("Penis");
		
		input.close();
		
	}

}
