//Written by Matthew Graham
public class SorterFrontend {
	public static final int RUNS = 20;
	public static void main(String[] args) {
		Sorts s = new Sorts();
		System.out.println("----------------------\nSorting Method Complexity Tester\n----------------------");
		for(int i=0; i<RUNS; i++)
		{
			System.out.println("-------------\nTest "+i+"\n-------------");
			s.initialize();
		}
		s.avgCheck();
	}

}
