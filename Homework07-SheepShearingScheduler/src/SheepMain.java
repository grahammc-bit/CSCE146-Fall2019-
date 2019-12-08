//Written by Matthew Graham
import java.util.Scanner;
import java.io.*;
public class SheepMain {

	public static void main(String[] args) {
		try
		{
		System.out.println("Welcome to the Sheep Shearing Scheduler!");
		String file;
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a file name: ");
		file=sc.nextLine();
		SheepHeap Sheep = new SheepHeap();
		Scanner s = new Scanner(new File(file));
		while(s.hasNext())
		{
		String name = s.next();
		int sT = s.nextInt();
		int aT = s.nextInt();
		Sheep.insert(new sheep(aT,sT,name));
		}
		System.out.println("\n\nThe Schedule is: ");
		Sheep.heapSort();
		Sheep.printHeap();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
