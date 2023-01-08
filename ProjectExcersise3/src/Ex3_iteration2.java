
import java.io.*;
import java.util.*;


public class Ex3_iteration2 {

	static File students = new File("Students.txt");
	static Scanner scan = new Scanner(System.in);
	static int count = 9; //count of how many students user inputs into the file

	public static void main(String[] args) throws FileNotFoundException {
		
		
		Scanner input = new Scanner(students);
		Scanner scan = new Scanner(System.in);
			
		//input();
		Student[] students_array = new Student[count];//student array initialized with count from input() method
		into_array(students_array);
		
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
				if(grades(id, students_array) > count) { 	//if the returned value(int tries in method) 
															//is greater than count, that means no such ID exists
					System.out.println("no student with this ID has been found");
					break;
				}else
				
				break;
			case 2:
				System.out.println("Choose type (1 = Science, 2 = Math, and 3 = English))");
				int type = scan.nextInt();
				Final_average(type, students_array);
				break;
			case 3:
				passed_failed(students_array);
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
			     }//else continue to loop on any string 
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Count = " + count);
		
	}
	
	//method to fill the Student object array from the selected file
	public static void into_array(Student[] arr)throws FileNotFoundException{
		Scanner input = new Scanner(students);
		
		for(int i = 0; i < count; i++) {
			//use a scanner for each line for simplicity
			String Line = input.nextLine();
			Scanner Line_input = new Scanner(Line);

			int id = Line_input.nextInt();
			String fname = Line_input.next();
			String lname = Line_input.next();
			int type = Line_input.nextInt();
			
			double midterm = Line_input.nextDouble();
			double finalexam = Line_input.nextDouble();
			double paper = Line_input.nextDouble();
			double presentation = Line_input.nextDouble();
			
			//create the new object in array at each index
			arr[i] = new Student(id, fname, lname, type, midterm, finalexam, paper, presentation);
			}	
		}
		
	
	
	public static int grades(int ID, Student[] arr) throws FileNotFoundException {

		int tries = 0; //tries integer used in identifying whether the selected ID is present in the file or not
		for(int i = 0; i <= count; i++) {
			if(arr[i].getID() == ID) {
				System.out.println("Mid term grade: " + arr[i].getMidterm());
				System.out.println("Final exam grade: " + arr[i].getFinal_exam());
				System.out.println("Research paper grade: " + arr[i].Research_paper);
				System.out.println("Presentation grade: " + arr[i].getPresentation());
				System.out.println("Final grade: " + ((arr[i].getMidterm() + arr[i].getFinal_exam() + arr[i].getResearch_paper() 
						+ arr[i].getPresentation())/4) );
				break;
			}else tries++;
		}
		return tries;
	}
	
	
	public static void Final_average(int type, Student[] arr) throws FileNotFoundException {
		double sum = 0;
		double highest_final = 0;
		double lowest_final = 100;
		for(int i = 0; i < count; i++) {
			
			if(arr[i].getType() == type) {

				double finalexam = arr[i].getFinal_exam();
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
	
	public static void passed_failed(Student[] arr) throws FileNotFoundException {

		
		
		
		int[][] array = new int[2][3];
		int type;
		
		for(int i = 0; i < count; i++) {

			
			double midterm = arr[i].getMidterm();
			double finalexam = arr[i].getFinal_exam();
			double paper = arr[i].getResearch_paper();
			double presentation = arr[i].getPresentation();
			double average = (midterm + finalexam + paper + presentation)/4;
			
			if(average >= 60) {
				array[0][arr[i].getType()-1] ++;
			}else array[1][arr[i].getType()-1] ++;
			
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




