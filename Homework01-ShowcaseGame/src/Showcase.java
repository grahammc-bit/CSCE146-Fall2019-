//Written by Matthew Graham
import java.util.Random;
import java.io.*;
public class Showcase{
	private Prize prizes[];
	public static final int SIZE = 50;//Sets final int to size 50
	public static final int POOL = 5;
	public Showcase()
	{
		prizes = new Prize[SIZE];//initializes Prize
		readFile();	//Calls read file
	}	
	public void readFile()//Used to parse file and decipher between columns for names/prices
	{
		BufferedReader fileScanner = null;//BufferedReader instead of Scanner because of .readLine()
		int items = 0;
		try
		{
			fileScanner = new BufferedReader(new FileReader("prizeList.txt"));//Calls txt
			String currLine;
			while((currLine = fileScanner.readLine()) != null)
			{				
				if(!currLine.trim().equals(""))//Makes sure trim does not equal " "
				{
					String input[] = currLine.split("\\s+");//Splits line 
					String prizeName = input[0]+" ";
					
					for(int i=1; i<input.length - 1; i++)
					{
						prizeName = prizeName + input[i]+" ";
					}
					double prizePrice = Double.parseDouble(input[input.length -1]);
					prizes[items++] = new Prize(prizeName, prizePrice);//Adds a count of item
					
					if(items == SIZE)//When items reach 50 it breaks (filled array)
						break;
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public Prize[] randomPrizes()//Creates a random instance
	{
		Random r = new Random();
		Prize randomPrizes[] = new Prize[POOL];
		for(int i=0;i<POOL;i++)
		{
			int rand = r.nextInt(SIZE) % SIZE;
			randomPrizes[i] = prizes[rand];
		}
		return randomPrizes;
	}

}
