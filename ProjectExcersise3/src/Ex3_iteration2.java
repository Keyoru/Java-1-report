

import java.io.*;
import java.util.*;


public class Ex3_iteration2 {
	static File students = new File("Students.txt");
	static Scanner scan = new Scanner(System.in);
	static int count = 0;
	//an array to store the student objects
 

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner input = new Scanner(students);
		Scanner scan = new Scanner(System.in);
			
		input();
		
		System.out.println("Choose from the following menu:");
		System.out.println("1.Display grades of specific student(input ID)");
		System.out.println("2.Calculate Average of the final exam, and highest and lowest final exam grade for specific type(input type)");
		System.out.println("3.Display number of students passed and failed from each type");
		System.out.println("4.Exit");

		int choice;
		do {
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Input student ID: ");
				int id = scan.nextInt();
				if(grades(id) >= count) {
					System.out.println("no student with this ID has been found");
					break;
				}else
				
				break;
			case 2:
				System.out.println("Choose type (1 = Science, 2 = Math, and 3 = English))");
				int type = scan.nextInt();
				Final_average(type);
				break;
			case 3:
				passed_failed();
				break;
			default:
				System.out.println("Invalid input, please choose from the menu");
				break;
		}
		}while(choice != 4);
		
		
	}
	
	
	
	public static void input(){
		
		System.out.println("Input student information in the form of");
		
		
		PrintStream out;
		try {
			out = new PrintStream(students);
			
			char contin = 'y';
			while(true){
				
				System.out.println("ID/First name/Last name/ Type(1, 2, 3)/ Grades(Mid term/ Final exam/ Research paper/ Presentation)");
				String user_input = scan.nextLine();
				out.println(user_input);
				
				
				count++;

			    System.out.println("Do you want to continue y or n");
			    String c = scan.nextLine();

			   if(c.equalsIgnoreCase("n")){ 
			      break;
			     }//else continue to loop on any string ;-)

			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Student[] students_array = new Student[count];
		
		System.out.println("Count = " + count);
		
	}
	
	
	
	public static int grades(int ID) throws FileNotFoundException {
		

		Scanner input = new Scanner(students);
		
		int tries = 0;
		
		for(int i = 0; i < count; i++) {
			String Line = input.nextLine();
			Scanner Line_input = new Scanner(Line);
			
			
			if(Line_input.nextInt() == ID) {
				
				//empty .next() functions to skip the name and type
				Line_input.next();
				Line_input.next();
				Line_input.next();
				
				double midterm = Line_input.nextDouble();
				double finalexam = Line_input.nextDouble();
				double paper = Line_input.nextDouble();
				double presentation = Line_input.nextDouble();
				
				System.out.println("Mid term grade: " + midterm);
				System.out.println("Final exam grade: " + finalexam);
				System.out.println("Research paper grade: " + paper);
				System.out.println("Presentation grade: " + presentation);
				System.out.println("Final grade: " + ((midterm + finalexam + paper + presentation)/4) );
			}else tries++;
			
			
		}
		
		return tries;
	}
	
	public static void Final_average(int type) throws FileNotFoundException {
		double sum = 0;
		double highest_final = 0;
		double lowest_final = 100;
		Scanner input = new Scanner(students);
		for(int i = 0; i < count; i++) {
			
			//read each line at a time for simplicity
			String Line = input.nextLine();
			Scanner Line_input = new Scanner(Line);
			
			//empty .next() functions to skip the id and name
			Line_input.next();
			Line_input.next();
			Line_input.next();
			
			//check if type token corresponds 
			if(Line_input.nextInt() == type) {
				
				Line_input.nextDouble(); //skip midterm grade
				
				double finalexam = Line_input.nextDouble();
				if(highest_final < finalexam) highest_final = finalexam;
				else if (lowest_final > finalexam) lowest_final = finalexam;
				
				sum += finalexam;
			}	
		}
		
		double average_finalexam = sum / count;
		
		System.out.println("For type " + type+ ": ");
		System.out.println("highest final grade: " + highest_final);
		System.out.println("lowest final grade: " + lowest_final);
		System.out.println("final exam average: " + average_finalexam);
	}
	
	public static void passed_failed() throws FileNotFoundException {
		Scanner input = new Scanner(students);
		
		
		
		int[][] array = new int[2][3];
		int type;
		
		for(int i = 0; i < count; i++) {
			
			//read each line at a time for simplicity
			String Line = input.nextLine();
			Scanner Line_input = new Scanner(Line);
			
			//empty .next() functions to skip the id and name
			Line_input.next();
			Line_input.next();
			Line_input.next();
			type = Line_input.nextInt() - 1;
			
			double midterm = Line_input.nextDouble();
			double finalexam = Line_input.nextDouble();
			double paper = Line_input.nextDouble();
			double presentation = Line_input.nextDouble();
			double average = (midterm + finalexam + paper + presentation)/4;
			
			if(average >= 60) {
				array[0][type] ++;
			}else array[1][type] ++;
			
		}
		
		
		System.out.println("Type:          1   2   3");
		for(int i = 0; i < array.length; i++) {
			switch(i) {
				case 0:
					System.out.print("Total passed:  ");
					break;
				case 1:
					System.out.print("Total failed:  ");
					break;
				default:
					break;
			}
			for(int j = 0; j <array[0].length; j++) {
				System.out.print(array[i][j] + "   ");
			}
			System.out.println();
		}
		
	}
}




