package lab02;

import java.util.Scanner;

public class Lab02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		
		String[] name= input.split(",");
		
		String[] len = name[0].split(" ");		
		
		String n;
		n = name[1].replace("homework.ppt", "Homework.pdf");
		
		System.out.println("Name Length(Korean) : " + len.length);
		System.out.println(len[1].toUpperCase().charAt(0) + "." + len[2].toUpperCase().charAt(0) + "." + len[0].substring(0,1).toUpperCase() + len[0].substring(1) + " submitted" + n);
		
		scan.close();
	}
   
}