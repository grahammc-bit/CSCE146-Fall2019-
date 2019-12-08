//Written by Matthew Graham
import java.util.Scanner;
public class TicTacToe {
	public static final int SIZE = 3;
	
	
	public void printBoard(char[][] coord)//Prints board
	{
	       System.out.println(" |     0    |     1    |    2     |");
	       System.out.println("_____________________________________________________");
	       System.out.println("0|     "+coord[0][0]+"    |     "+coord[1][0]+"    |    "+coord[2][0]+"     |");
	       System.out.println("_____________________________________________________");
	       System.out.println("1|     "+coord[0][1]+"    |     "+coord[1][1]+"    |    "+coord[2][1]+"     |");
	       System.out.println("_____________________________________________________");
	       System.out.println("2|     "+coord[0][2]+"    |     "+coord[1][2]+"    |    "+coord[2][2]+"     |");
	       System.out.println("_____________________________________________________");
    }
	public void setBoard(char[][] coord)//Sets board with empty spaces
	{
		for(int i=0; i<SIZE; i++)
		{
			for(int j=0;j<SIZE;j++)
			{
				coord[i][j]=' ';
			}
		}
	}	
	public boolean winCondition(char x, char[][] coord)//Runs a series of check to see if any 3 are in a row
	{
	    if(coord[0][0] == x && coord[1][0] == x && coord[2][0] == x)
		{
			return true;
		}
	    else if(coord[0][1] == x && coord[1][1] == x && coord[2][1] == x)
		{
			return true;
		}
	    else if(coord[0][2] == x && coord[1][2] == x && coord[2][2] == x)
		{
			return true;
		}
	    if(coord[0][0] == x && coord[0][1] == x && coord[0][2] == x)
		{
			return true;
		}
	    else if(coord[1][0] == x && coord[1][1] == x && coord[1][2] == x)
		{
			return true;
		}
	    else if(coord[2][0] == x && coord[2][1] == x && coord[2][2] == x)
		{
			return true;
		}
	    if(coord[0][0] == x && coord[1][1] == x && coord[2][2] == x)
		{
			return true;
		}
	    else if(coord[0][2] == x && coord[1][1] == x && coord[2][0] == x)
		{
			return true;
		}
	    else
	    return false;
	}
	public int winCheck(int wins, char[][] coord)//Multiple checks for win, loss, and cat.
	{
		Scanner keyboard = new Scanner(System.in);
		boolean win = winCondition('X', coord);
		if(win)
		{
			System.out.println("You win!\nThe computer demands a rematch!");
			wins++;
			setBoard(coord);
			return wins;
		}		
		boolean lose = winCondition('O', coord);
		if(lose)
		{
			printBoard(coord);
			System.out.println("You lost but you won "+wins+" in a row.\n\nWould you like to play again? Yes or No?");
			String answer = keyboard.nextLine();
			if(answer.equalsIgnoreCase("Yes"))
			{
			wins = 0;
			setBoard(coord);
			return wins;
			}
			else
			{
				System.out.println("Goodbye!");
				System.exit(0);
			}
		}
		boolean cat = catCondition(coord);
		if(cat)
		{
			System.out.println("Cat! Try again.");
			setBoard(coord);
			printBoard(coord);
			return wins;
		}
		return wins;
				
	}
	public boolean catCondition(char[][] coord)//This allows us to check if any avail spaces are left on board. If there arent, its cat.
	{
		for(int i=0; i<SIZE; i++)
		{
			for(int j=0; j<SIZE; j++)
			{
				if(coord[i][j] == ' ')
				{
					return false;
				}
			}
		}
		return true;
	}
	
}
