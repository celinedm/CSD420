/*
 * Celine Del Mundo
 * CSD 420 Module 
 * June 1, 2024
 * 
 * Creating a program that will read and write file and data
 */

package module01;

import java.util.*;
import java.io.*;

public class ReadWrite {
	
	//creating a method to display the choices for the user
	public static void selection(){
		System.out.println("Press '1' to write data");
		System.out.println("Press '2' to read data");
		System.out.println("Enter your choice: ");
	}
	
	
	//randomly generated integers
	public static int[] randomNumbers(int number) {
		int [] randomInts = new int[number];
		Random random = new Random();
		
		for (int i = 0; i < number; i++) {
			randomInts[i] = random.nextInt();
		}
		return randomInts;
	}
	//randomly generated doubles
	public static double[] randomDouble(int doub) {
		double[] randomDoubs = new double[doub];
		Random randomD = new Random();
		
		for (int j = 0; j < doub; j++) {
			randomDoubs[j] = randomD.nextDouble();
		}
		return randomDoubs;
	}
	
	//method to write data
	public static void writeData() {
		
		//creating an output stream for file
		try(DataOutputStream writeDat = new DataOutputStream(new FileOutputStream("celinedatafile.dat"))){
			
			//writing out the five randomly generated numbers
			int[] randomInts = randomNumbers(5);
			for (int value : randomInts) {
				writeDat.writeInt(value);
			}
			
			//writing out the five randomly generated double numbers
			double[] randomDoubs = randomDouble(5);
			for (double value : randomDoubs) {
				writeDat.writeDouble(value);
			}
			//"Date objective instance using the current date"
			Date date = new Date();
			writeDat.writeLong(date.getTime());
		
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//method to read data
	public static void readData() {
		try(DataInputStream readDat = new DataInputStream(new FileInputStream("celinedatafile.dat"))){
			
			//reading date
			long date = readDat.readLong();
			System.out.println("Date: " + new java.util.Date(date));
			System.out.println(); // creating an extra ln for clarity
			
			//reading the random integers
			System.out.println("Random Integer: ");
			for (int i = 0; i <= 5; i++) {
				System.out.println(readDat.readInt());
			
			}
			System.out.println(); //extra ln for clarity
			
			//reading the random doubles
			System.out.println("Random doubles: ");
				for ( int j = 0 ; j <= 5; j++) {
					System.out.println(readDat.readDouble());
			}
			
			
		}
		catch(EOFException ex) {
			System.out.println();// extra ln for clarity
			System.out.println("Completed: Reading Data");
			System.out.println();
			System.out.println();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
	
	}

}
