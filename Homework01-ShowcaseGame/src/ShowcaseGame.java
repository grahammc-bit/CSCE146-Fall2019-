//Written by Matthew Graham
import java.util.Scanner;
public class ShowcaseGame{

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		Showcase s = new Showcase();//Calls Show case
		while(true)
		{
			System.out.println("Welcome to the showcase show down!\nYour prizes are:");
			Prize[] randomPrizes = s.randomPrizes();//Initializes prizes
			double prizeValue = 0.0;
		
			for(int i=0; i<randomPrizes.length; i++)//Initializes random items
			{
				 System.out.println(randomPrizes[i].getName());
				 prizeValue = prizeValue + randomPrizes[i].getPrice();
			}
			
			System.out.println("\nYou must guess the total cost of all without going over.\nEnter your guess.");
			double guess = keyboard.nextDouble();
			if(Math.abs(prizeValue - guess)<= 2000)//Decides if the price entered is within the $2000 range
			{
				System.out.println("You guessed "+guess+" the actual price is "+prizeValue+"\nYour guess was under you win!");
			}
			else
			{
				System.out.println("You guessed "+guess+" the actual price is "+prizeValue+"\nThat was incorrect. You lose.");
			}
			System.out.println("Would you like to play again?");
			
			String pAgain = keyboard.next();
			System.out.println();
			if(pAgain.equalsIgnoreCase("No"))//Calls for while break
			{
				System.out.println("Thanks for playing!");
				break;
			}
		  }
		}
	}
