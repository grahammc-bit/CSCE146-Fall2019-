//Written by Matthew Graham
import java.io.*;
import java.util.*;
public class Boggle{
	private static String[] dictionary; 
	private static boolean [][] unusable; 
	private String word;
	public static final int dictionarySize = 25144;
	public static final int SIZE = 5;
	
	public Boggle()
	{
		dictionary = new String[dictionarySize];
		init();
	}
	public void init()
	{
		int index = 0;
		try 
		{
			FileReader file = new FileReader("dict.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNext())
			{
				dictionary[index] = scan.next().toLowerCase();
				index++;
			}//while end
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//init end
	public void printBoard (char [][] board)
	{
		for (int row = 0; row < board.length; row++) 
		{
		    for (int col = 0; col < board.length; col++) 
		    {
		        System.out.print(board[row][col] + "  ");
		    }//nested for end
		    System.out.println();
		}//for end
		System.out.println();
	}//printBoard end
	public void searchBoard (char [][] board)
	{		
		//Create unusable matrix
		unusable = new boolean[SIZE][SIZE];
		word = "";
		
		//For each starting point, print and call
		for(int row = 0; row < SIZE; row++)
		{
			for(int col = 0; col < SIZE; col++)
			{
				System.out.println("Starting "+ row +" "+ col);
				findWords(board, unusable, row, col, word);
			}//nested for end
		}//for end		
	}//searchBoard end
	
	//Search all 8 cells surrounding the starting letter
	public void findWords(char [][] board, boolean [][] unusable, int x, int y, String word)
	{
		//System.out.println("x: "+ x + ", y: " + y + " - " + word);
		
		//Check bounds
		if(x < 0 || x > SIZE-1 || y < 0 || y > SIZE-1)
			return;
		//Check if already unusable
		if(unusable[x][y] == true)
			return;
		//Check assigned max word length
		if(word.length() == 6)
			return;
		
		//Checks passed, mark unusable
		unusable[x][y] = true;
		//Add to current word
		word = word + board[x][y];
		
		//If word is found, print
		if(hasFound(word))
			System.out.println("Found Word: " + word);

		//Traverse 8 surrounding cells
		findWords(board, unusable, x-1, y-1, word); //TOP left
		findWords(board, unusable, x-1, y, word); //TOP middle
		findWords(board, unusable, x-1, y+1, word); //TOP right
		findWords(board, unusable, x, y-1, word); //MIDDLE left
		findWords(board, unusable, x, y+1, word); //MIDDLE right
		findWords(board, unusable, x+1, y-1, word); //BOTTOM left
		findWords(board, unusable, x+1, y, word); //BOTTOM middle
		findWords(board, unusable, x+1, y+1, word); //BOTTOM right

		//Going back, remove last letter in our word
		if (word != null && word.length() > 0)
		{
			word = word.substring(0, word.length()-1);
		}
		//Going back, mark unusable false again
		unusable[x][y] = false;
	}//findWords end
	
	//Checks current word against our dictionary
	public boolean hasFound(String word)
	{
		//Must be a word with 2 or more letters
		if(word.length() < 2)
			return false;
		//Inefficient? for loop to search entire dictionary
		for(int i = 0; i < dictionarySize; i++)
		{
			if(word.toLowerCase().equals(dictionary[i]))
			{
				return true;
			}
		}
		return false;
	}//hasFound end
}//Boggle end