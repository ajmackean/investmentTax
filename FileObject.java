import java.io.*;
import java.util.Scanner;

// eliminate this class, integrate functions into respective classes they are used in. 

public class FileObject {
	
	// instantiates a file object for login purposes
	public FileObject(String userName) {
	
		try {
			
			// creation of file with path for user login
			File myObj = new File("user/" + userName + ".txt");
			
			if (myObj.createNewFile()) {
				
				// notifies that the new user was created successfully
				System.out.println("User " + userName + " created successfully");
			
			} else {
				
				System.out.println("Error in user creation.");
				// this would execute if path already has file. 
			}
			
		// general i/o catch block.	
		} catch (IOException e) {
			
			System.out.println("An error occured");
			e.printStackTrace();
			
		} 
	}
	
	public FileObject() {
		
	}
	
	public String returnLogin(String userName) {
		
		String login = "NULL";
		
		try {
			
			File myObj = new File("user/" + userName + ".txt");
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				
				login = myReader.nextLine();
			}
			
			return login;
			
			
		} catch (IOException e) {
			return "error";
		}

	}
	
	// prints the login object file based on userName in conjunction with path
	public void printFile(String userName) {
		
		try {
			
			// gets path value
			File myObj = new File("user/" + userName + ".txt");
			// opens scanner object with path as input
			Scanner myReader = new Scanner(myObj);
			
			while (myReader.hasNextLine()) {
				
				String data = myReader.nextLine();
				System.out.println(data);
				
			}
			
			myReader.close();
			
		} catch (IOException e) {
			System.out.println("error");
		}
		
		
	}
	
	// reads user input
	public void readInputData(String userName) {
		
		try {
		
			// opens the file for input writting
			FileWriter myWriter = new FileWriter("data/" + userName + ".txt");
			
			// writes to the file
			String text = PackageDriver.input.nextLine();
			myWriter.write(text);
			myWriter.close();
		
		} catch (IOException e) {
		
			System.out.println("An error occured");
			e.printStackTrace();
		
		}
		
	// method to read stored password for login purposes	
	}	public void readInputPassword(String userName) {
		
		try {
		
			// opens the file for input writting
			FileWriter myWriter = new FileWriter("user/" + userName + ".txt");
			
			// writes to the file
			String text = PackageDriver.input.nextLine();
			myWriter.write(text);
			myWriter.close();
		
		} catch (IOException e) {
		
			System.out.println("An error occured");
			e.printStackTrace();
		
		}
		
	}

}
	
