//Written by Matthew Graham
import java.util.Scanner;
import java.util.Random;
public class TicTacToeFront extends TicTacToe {
	
	public static final int SIZE = 3;
	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		TicTacToe t = new TicTacToe();//Creates an instance of TicTacToe
		int wins = 0;
		char[][] coord = new char[SIZE][SIZE];
		System.out.println("Welcome to Tic Tac Toe Tourney! How many games can you win in a row?");
		try
		{
			t.setBoard(coord);//calls setBoard
			t.printBoard(coord);//calls printBoard
			while(true)
			{
			System.out.println("Enter the coordinates to place an \"X\". Row then Column.\nOr enter a negative number to quit.");
			int inputX = keyboard.nextInt();//Determines x and y inputs
			int inputY = keyboard.nextInt();
				if(inputX < 0 || inputY < 0)//If negative number, quits game.
				{
					System.out.println("Thanks for playing.");
					break;
				}
				else
				{
					if(coord[inputX][inputY] != ' ')//Determines if space is empty
					{
						System.out.println("There is already a piece there.");
						t.printBoard(coord);
					}
					else
					{
						coord[inputX][inputY] = 'X';//Occupies space with X
						wins = t.winCheck(wins, coord);//checks if X has won
						
						boolean check = false;
						while(!check)
						{
							Random r = new Random();//Creates random int 0-2 to fill for O
							int randX = r.nextInt(SIZE);
							int randY = r.nextInt(SIZE);
							if(coord[randX][randY] != 'X' && coord[randX][randY] != 'O')
							{
								coord[randX][randY] = 'O';
								System.out.println("Computer's Turn");
								check = true;//Breaks while loop to show that a suitable spot was found
							}
						}
						wins = t.winCheck(wins, coord);//checks if O has won
						t.printBoard(coord);
					}
		    	}
	        }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}