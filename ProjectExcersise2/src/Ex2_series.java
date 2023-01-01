

import java.util.*;

public class Ex2_series {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		
		System.out.println("The point of mathemetical series is to approximate a non polynomial function");
		System.out.println("by using an infinite series polynomial expression");
		System.out.println("In theory the accuracy increases with increase in number of terms calculated");
		System.out.println("However, do to limitations with Java's double and float types");
		System.out.println("going too high might cause inaccuracies");
		System.out.println();
		System.out.println("menu: ");
		System.out.println("1.Arithmetic series");
		System.out.println("2.Fibonacci sequence");
		System.out.println("3.Taylor series");
		System.out.println("4.Collatz conjecture");
		System.out.println("5.Power series");
		System.out.println("6.PI using Leibniz formula");
		
		
		System.out.println("8.exit");
		
		int option;
		char sums_or_all; // used to decide if functions print out all terms and the sum or just the sum
		int n; // number of terms to be used
		int x; // value to start some series from
		
		do {
			System.out.println("Show all terms(Y or N)");
			sums_or_all = scan.next().charAt(0);
			System.out.println("Choose from the menu");
			option = scan.nextInt();
			
			
			switch(option) {
			case 1:
				System.out.println("each run S = a + (i * d)");
				System.out.println("Enter number of terms");
				n = scan.nextInt();
				System.out.println("Enter a");
				int a = scan.nextInt();
				System.out.println("Enter d");
				int d = scan.nextInt();
				Arithmetic(n, a, d, sums_or_all);
				break;
			case 2:
				System.out.println("every number is the sum of the 2 precious numbers");
				System.out.println("Starts at 0 1");
				System.out.println();
				System.out.println("Enter number of tersm");
				n = scan.nextInt();
				Fibonacci(n, sums_or_all);
				break;
			case 3:
				System.out.println("Choose between Approximations for: ");
				System.out.println("1.e^x (this is a form of power series)");
				System.out.println("2.sin(x)");
				System.out.println("3.cos(x)");
				System.out.println("4.return");
				int taylor_type = scan.nextInt();
				System.out.println("Enter n: number of terms");
				n = scan.nextInt();
				System.out.println("Enter x value");
				x = scan.nextInt();
				Taylor(n, x, taylor_type, sums_or_all);
				
				break;
			case 4:
				System.out.println("if number is odd apply x = 3x+1 ");
				System.out.println("if number is even x = x/2");
				System.out.println("the collatz conjecture states that by using these 2 rules");
				System.out.println("any possible starting number will reach the 4 2 1 loop");
				System.out.println();
				System.out.println("Enter x: the number to begin with");
				x = scan.nextInt();
				Collatz(x, sums_or_all);
				break;
			case 5:
				System.out.println("formula followed is (x^i)/(i!)");
				System.out.println();
				System.out.println("Enter n: number of terms");
				n = scan.nextInt();
				System.out.println("Enter x value");
				x = scan.nextInt();
				Power(n, x,sums_or_all);
				break;
			case 6:
				n = scan.nextInt();
				PI(n, sums_or_all);
				break;
			case 8:
				return;
			default:
				System.out.println("Invalid option");
				break;
			}
		}while(option != 5);
			
			
}
		
	public static int Factorial(int num) {	//method to return the factorial of a given number (num!)
		
		  int fact=1;  
		     
		  for(int i=1; i <= num ;i++) { 
			  
		      fact=fact*i;  
		      
		  }    
		  return fact;
	}  

	
	public static void Arithmetic(int n, int x, int d, char op) {   
		
		
		double sum = 0;
		for(int i = 0; i <= n; i++) { // each run S = a + (i * d)
			
			int number = x + i*d;
			sum += number;
			//print out each step according to user decision
			if (op == 'y' || op == 'Y') {
				System.out.printf("\nS =  %d + (%d * %d) = %d",x ,i, d, number);
			}
		}
		System.out.printf("\nSum of this series = %f", sum);
	}
	
	
	public static void Fibonacci(int n, char op) { //each number is the sum of the 2 previous numbers
		
		 int num1 = 0;
		 int num2 = 1;
		 int num3;
		 int sum = 1;
		 for(int i = 2; i <= n; i++) {
			 
			 	num3 = num1 + num2;
			 	//print out each step according to user decision
			 	if (op == 'y' || op == 'Y') {
			 		System.out.print(num3 + " ");
			 	}
			 	num1 = num2;
			 	num2 = num3;
			 	sum += num3;
			 
			}
		System.out.printf("\nsum = %d", sum);
		
		
	}
	
	public static void Taylor(int n, double x, int type, char op) { //estimate the value of a function using a near identical polynomial function
		
		
		
		
		switch(type){
		case 1: // e^x
			
			double sum_e = 1;
			for(int i = 1; i <= n; i++) {
				//print out each step according to user decision
				if (op == 'y' || op == 'Y') {
					System.out.println("Step " + i + ": " + (Math.pow(x, i))/Factorial(i) + " ");
				}
				
				sum_e += (Math.pow(x, i))/Factorial(i);
			
			}
			System.out.println("Sum = " + sum_e);
			break;
			
		case 2: //sin(x)
			
			double sum_sin = 0;
			for(int i = 0; i <= n; i++) {
				//print out each step according to user decision
				if (op == 'y' || op == 'Y') {
					System.out.println("Step " + (i + 1) + ": " + ((Math.pow(-1, i) * Math.pow(x, (2 * i)+1))/Factorial((2 * i)+1)));
				}
				sum_sin += ((Math.pow(-1, i) * Math.pow(x, (2 * i)+1))/Factorial((2 * i)+1));
				
			}
			System.out.println(sum_sin);
			break;
		case 3: //cos(x)
			
			
			double sum_cos = 0;
			for(int i = 0; i <= n; i++) {
				//print out each step according to user decision
				if (op == 'y' || op == 'Y') {
					System.out.println("Steps " + (i + 1) + ": " + ((Math.pow(-1, i) * Math.pow(x, (2 * i)))/Factorial((2 * i))) );
				}
				sum_cos += ((Math.pow(-1, i) * Math.pow(x, (2 * i)))/Factorial((2 * i)));
				
			}
			System.out.println(sum_cos);	
			
			break;
		
		
		}
		
	}
	
	public static void Collatz(int x, char op) {
		
		int steps = 0;
		int num = x;
		do {
			if(num % 2 == 0) {
				num /= 2;
			}else {
				num = (num * 3) + 1;
			}
			steps++;
			//print out each step according to user decision
			if (op == 'y' || op == 'Y') {
				System.out.print(num + " ");
			}
			
			
		}while(num != 1);
		System.out.println("\nreached the 4 2 1 loop in "+ steps + " Steps");
		
	}
	
	public static void Power(int n, int x, char op) {
		  
	    double sum = 1.0;

	    // Calculate the power series
	    for (int i = 1; i <= n; i++) {
	    	//print out each step according to user decision
	    	if (op == 'y' || op == 'Y') {
	    		System.out.println("step " + i + ": "+ Math.pow(x, i) / Factorial(i));
	    	
	    	}
	      sum += Math.pow(x, i) / Factorial(i);
	    }

	    // Print the result
	    System.out.println("Sum of power series = " + sum);
	    
	}
	
	public static void PI(int n, char op) {
		
	    
	    

	    // Initialize the sum to 0
	    double sum = 0.0;

	    // Loop through the terms and add them to the sum
	    for (int i = 0; i < n; i++) {
	      // Calculate the term
	      double term = 4.0 * Math.pow(-1, i) / (2 * i + 1);

	      // Add the term to the sum
	      sum += term;
	    }

	    // Print the approximation
	    System.out.println("Approximation of PI: " + sum);
	  }
}
	
	
	
	
	




