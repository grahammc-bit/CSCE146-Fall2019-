//Written by Matthew Graham
public class BortFrontEnd {

	public static void main(String[] args) {
		BortSorter b = new BortSorter();
		System.out.println("Welcome to the BORT sorter. Enter any number of strings and I will sort by BORT’s.");
		System.out.println("Once you’re done entering sentences enter “quit”.");
		b.populate();
		b.bortSort();
		b.bortPrint();
	}

}
