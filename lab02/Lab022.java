package lab022;
import java.util.Scanner;
public class Lab022 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String grade = scan.nextLine();
		String gradeU = grade.toUpperCase();
		String[] gArray= gradeU.split(" ");
		int score;
		int total = 0;
		
		for(int i = 0; i < gArray.length; i++) {
			if (gArray[i].equals("A"))
				score = 100;
			else if (gArray[i].equals("B"))
				score = 90;
			else if (gArray[i].equals("C"))
				score = 80;
			else if (gArray[i].equals("D"))
				score = 70;
			else
				score = 0;
			
			total += score;
			
			if (i == 0)
				System.out.print("1st");
			else if (i == 1)
				System.out.print("2nd");
			else if (i == 2)
				System.out.print("3rd");
			else
				System.out.print(i + 1 + "th");		
			System.out.println(" student's score is " + score);
		}
		
		double average = (double)total / gArray.length;
		System.out.println("This class's average = " + String.format("%.2f", average));	
		scan.close();
	}

}
