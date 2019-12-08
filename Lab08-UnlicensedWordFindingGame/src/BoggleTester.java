//written by Matthew Graham
public class BoggleTester {

	public static void main(String[] args) {
		System.out.println("Lets play some darn Boggle.");
		Boggle b = new Boggle();
		char [][] board = { {'R','A','H','J','M'},
				{'Y','U','W','W','K'},
				{'R','X','N','F','M'},
				{'Q','G','E','E','B'},
				{'E','O','A','P','E'} };
		
		b.printBoard(board);
		b.searchBoard(board);	
	}//main method end

}//boggle tester end
