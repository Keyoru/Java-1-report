
import java.util.*;

public class Excersise1 {

	
	//months array as a static for ease of access across the entire program
	static String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sept", "Oct", "Nov", "Dec"};
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		
	
		
		int[] Games = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
		int[] Score = new int[12];
		
		
		char contin = 'y';
		do {
			System.out.println("Enter the month number: ");
			int month_number = scan.nextInt();
			
			System.out.println("Enter the score for " + months[month_number]);
			Score[month_number] = scan.nextInt();
			Games[month_number]++;
			
		
			System.out.println("Enter 'y' to continue or 'n' to stop");
			contin = scan.next().charAt(0);
		
		}while(contin == 'Y' || contin == 'y');
		
		System.out.println("Your team played " + NbGames(Games) + " game(s)");
		System.out.println("Your team scored maximum goals on " + max(Score));
		
	}
	
	public static String max(int[] arr) {
		String month = "None";
		
		int max = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				month = months[i];
			}
		}
		return month;
	}
	
	public static int NbGames(int[] arr) {
		
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if (arr[i] >= 0) count++;
		}
		return count;
		
	}

}
