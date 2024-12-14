// Imports
import java.util.NoSuchElementException;
import java.util.Scanner;

// A class to get five numbers from a person and output the sum
public class SumRecursion {
	
	// A method that gets a number per number of iterations and returns its sum.
	public static int findSum(int numberOfIterations, int currentSum, Scanner scnr) {
		
		// Base case and return the sum if the number of iterations is zero
		if (numberOfIterations <= 0) {
			return currentSum;
		} else {
			// Decrease the number of iterations, get the number from the user and call to get the sum
			numberOfIterations--;
			int nextNumber = getNumber(scnr);
			return findSum(numberOfIterations, currentSum + nextNumber, scnr);
		}
	}
	
	// A method to get a number from the user or allows them to quit. 
	public static int getNumber(Scanner scnr) {
		boolean hasValidInput = false;
		int number = 0;
		
		while (!hasValidInput) {
			try {
				System.out.println("Please enter a whole number or enter \"q\" to quit:");
				String input = scnr.next();
				
				// If the input is q, exit the program
				if (input.strip().equals("q")) {
					System.out.println("\nExiting..");
					System.exit(0);
				}
				
				// Get input as a number
				number = Integer.parseInt(input);
				hasValidInput = true;
				System.out.println();
			} catch (NoSuchElementException | IllegalStateException | NumberFormatException e) {
				// An incorrect value has been entered and inform the user
				System.out.println("\nIncorrect value entered. Please try again.\n");
				scnr.nextLine();
			}
		}
		
		// Return the number
		return number;
	}

	public static void main(String[] args) {
		// Create the scanner
		Scanner scnr = new Scanner(System.in);
		
		// Output the sum of 5 numbers the user enters
		System.out.printf("Sum: %d\n", findSum(5, 0, scnr));
		
		// Close the scanner
		scnr.close();
	}

}
