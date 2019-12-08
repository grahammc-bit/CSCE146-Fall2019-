//Writte by Matthew Graham
import java.util.Scanner;
import java.io.*;
public class FruitTreeTester {

	public static void main(String[] args) {

		LinkedBSTree<Fruit> tree = new LinkedBSTree<Fruit>();//Creates tree
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the fruit tree!\nPlease enter a fruit file Name:");
		String fileName = keyboard.nextLine();
		System.out.println("Populating tree file");
		try
		{
			Scanner file = new Scanner(new FileReader(fileName));//Sets fileScanner
			while(file.hasNextLine())
			{
				String currLine = file.nextLine();//Creates currLine variable
				String[] splitLine = currLine.split("\t");//Tab delimeter
				if(splitLine.length == 2)
					tree.insert(new Fruit(splitLine[0],Double.parseDouble(splitLine[1])));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//Runs the tree
		System.out.println("Printing the in-order traversal: ");
		tree.printInOrder();
		System.out.println("\nPrinting the pre-order traversal: ");
		tree.printPreOrder();
		System.out.println("\nPrinting the post-order traversal: ");
		tree.printPostOrder();
		System.out.println("\nDeleting Apple 0.4859853412170728");
		tree.delete(new Fruit("Apple",0.4859853412170728));
		System.out.println("\nPrinting in-order traversal: ");
		tree.printInOrder();

	}

}
