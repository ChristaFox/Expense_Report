package Expense_Report_Fix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author christa_fox
 *
 */
public class Expense_Report {

	/**
	 * Exercise can be found here: https://adventofcode.com/2020/day/1
	 * There is an issue with the expense report.
	 * Specifically, they need you to find the two entries that sum to 2020 and then multiply those
	 * two numbers together.
	 */
	public static void main(String[] args) throws IOException {
		
		//working list for side effects
		ArrayList<Integer> intArr = new ArrayList<>();
		
		//to scan in the items from the in.txt file
		//The in.txt file was copied from the excercise and saved as a txt file.
		Scanner fileInput = new Scanner(new File("src/in.txt"));
		
		//creates the output file
		FileWriter outFile = new FileWriter("src/out.txt");
		
		//removes items previously in the file
		outFile.flush();
		
		//initializes cursor
		int i = 0;
		
		//loop that will execute when the while condition is met. In this case, reaches end of life of file.
		do {
			//Takes the String items in the in.txt file, and converts them to Integers using parseInt
			//before adding them to the ArrayList named intArr.
			intArr.add(i, Integer.parseInt(fileInput.next()));

			//increases cursor
			i++;
		} while (fileInput.hasNext());
		
		//File has been converted to an ArrayList we can work with, so we can close this.
		fileInput.close();
		
		//Table headers for clarity of output file.
		outFile.write("first variable  second variable add_sum         multiply_sum    \n");
		
		//local variable for index of the ArrayList
		int index;
		
		//enhanced forloop to iterate through the ArrayList
		for (int el : intArr) {
			
			//local variable to hold the value of the sum of the two variables.
			Integer sum;
			
			//iterative for loop to add each variable to the el element of the ArrayList intArr
			for (index = 1; index < intArr.size() - 1; index++) {
				sum = el + intArr.get(index);
				
				//print the values that match the table headers roughly where they are located.
				outFile.write("           " + el + "           " + intArr.get(index) +  "           " + sum );
				
				//check if the condition is met to multiply the two variables.
				if (sum.equals(2020)) {
					Integer mult = el * intArr.get(index);
					outFile.write("           " + mult + "\n");
				}
				
				//if it isn't return carriage to the next line in out.txt
				else {
					outFile.write("\n");
				}
			}
		}
		//close the out file
		outFile.close();
	//exit main
	}
	
//exit Expense_Report 
}
