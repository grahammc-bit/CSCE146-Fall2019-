//Written by Matthew Graham
import java.util.*;
import java.io.*;
public class RobotSim implements LLInterface<String> {
	public static final int SIZE = 10;
	private char board[][];
	private LinkedListQueue<String> aMove;
	public RobotSim()
	{
		board = new char[SIZE][SIZE];
		aMove = new LinkedListQueue<String>();
	}
	public void printInitial(String fileName)
	{
		try
		{
			Scanner file = new Scanner(new File(fileName));
			for(int i=0;i<SIZE;i++)
			{
				board[i] = file.nextLine().toCharArray();
				board[0][0] = 'O';
				System.out.println(board[i]);
			}
		}
		catch(Exception e)
		{
			System.out.println("Incorrect board file name");
		}
	}
	public void printBoard()
	{
		for(int i=0;i<SIZE;i++)
		{
			System.out.println(board[i]);
		}
	}
	public boolean safeCheck(int i, int j, char board[][])
	{
		if(i >= 0 && j >= 0 && i < SIZE && j < SIZE && board[i][j] == '_')
			return true;
		else
		{
		System.out.println("CRASH!");
		System.exit(0);
		return false;
		}
	}
	public void makeMove(String fileName2)
	{
		int count = 0;
		int locY = 0;
		int locX = 0;
		try
		{
			Scanner commands = new Scanner(new File(fileName2));
			while(commands.hasNext())
			{
				String move = commands.nextLine();
				aMove.enqueue(move);
				if(aMove.peek().equals("Move Up"))
				{
					System.out.println("\nCommand "+count);
					if(safeCheck(locY-1, locX, board))
					{
						board[locY][locX] = '_';
						board[locY-1][locX] = 'O';
						locY -= 1;
						printBoard();
						aMove.dequeue();
						count++;
					}
				}
				else if(aMove.peek().equals("Move Down"))
				{
					System.out.println("\nCommand "+count);
					if(safeCheck(locY+1, locX, board))
					{
						board[locY][locX] = '_';
						board[locY+1][locX] = 'O';
						locY += 1;
						printBoard();
						aMove.dequeue();
						count++;
					}
				}
				else if(aMove.peek().equals("Move Right"))
				{
					System.out.println("\nCommand "+count);
					if(safeCheck(locY, locX+1, board))
					{
						board[locY][locX] = '_';
						board[locY][locX+1] = 'O';
						locX += 1;
						printBoard();
						aMove.dequeue();
						count++;
					}
				}
				else if(aMove.peek().equals("Move Left"))
				{
					System.out.println("\nCommand "+count);
					if(safeCheck(locY, locX-1, board))
					{
						board[locY][locX] = '_';
						board[locY][locX-1] = 'O';
						locX -= 1;
						printBoard();
						aMove.dequeue();
						count++;
					}
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Incorrect command file name");
		}
	}
	@Override
	public String dequeue() {
		return null;
	}
	@Override
	public String enqueue() {
		return null;
	}
	@Override
	public String peek() {
		return null;
	}
}
