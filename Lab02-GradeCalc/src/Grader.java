//Written by Matthew Graham
import java.util.Scanner;
import java.io.*;
public class Grader extends Student {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		try
		{
			System.out.println("Welcome to the Grader Program");
			while(true)
			{
				Student s = new Student();
				System.out.println("Enter a file name or \"quit\" to exit");
				String input = keyboard.nextLine();
				if(input.equals("quit"))
				{
					System.out.println("Thanks for using the program.");
					break;
				}
				else
				{
					s.readGradeFile(input);
					System.out.println(s.toString());
				}
			}	
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
