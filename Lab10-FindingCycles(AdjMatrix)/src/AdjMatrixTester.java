//Written by Matthew Graham
import java.util.*;

public class AdjMatrixTester {
	
	public static void main(String[] args) {
		AdjMatrixGraph matrix = new AdjMatrixGraph(7);
		// to from weight
		matrix.addEdge(1, 5, 1);
		matrix.addEdge(2, 1, 1);
		matrix.addEdge(3, 1, 1);
		matrix.addEdge(4, 2, 1);
		matrix.addEdge(2, 1, 1);
		matrix.addEdge(5, 2, 1);
		matrix.addEdge(5, 3, 1);
		matrix.addEdge(5, 7, 1);
		matrix.addEdge(6, 3, 1);
		matrix.addEdge(7, 4, 1);
		matrix.addEdge(7, 6, 1);
		
		System.out.println("The Cycles in this graph are:\n");
		matrix.printDFSForAll();

	}
}
