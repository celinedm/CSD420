/*
 * Celine Del Mundo
 * CSD 420 Module 
 * June 1, 2024
 * 
 * Creating a program that will read and write file and data
 */
package module01;

import java.util.Scanner;

//Extending from the program that stores the randomly generated numbers and date.
public class DisplayData extends ReadWrite {
	public static void main(String[] args) {
		//inserting scanner for user input
				Scanner userInput = new Scanner(System.in);
				
				//Allowing the program to keep giving the selection
				while (true) {
					selection();
					int choice = userInput.nextInt();
					
					//creating a switch case to go through the user choice
					switch (choice) {
					case 1:
						writeData();
						break;
						
					case 2:
						readData();
						break;
						
					default:
						System.out.println("Pick a valid number");
					}
					userInput.close();
				}
				
	}
}
