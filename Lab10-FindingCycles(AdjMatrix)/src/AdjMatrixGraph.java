//Written by Matthew Graham
import java.util.*;

public class AdjMatrixGraph {

	public static final int DEF_SIZE = 10;
	private double[][] adjMatrix;
	private ArrayList<Integer> markedVert;

	public AdjMatrixGraph() {
		adjMatrix = new double[DEF_SIZE][DEF_SIZE];
		init();
	}

	public AdjMatrixGraph(int size) {
		if(size > 1)
			adjMatrix = new double[size+1][size+1];//Sets adjMatrix to size + 1
		init();
	}

	private void init() {//initializes the graph by calling markedVert and setting [i][j] to 0
		for(int i=1; i<adjMatrix.length;i++)
		{
			for(int j=1;j<adjMatrix[i].length; j++)
			{
				adjMatrix[i][j] = 0;
			}
		}
		markedVert = new ArrayList<Integer>();
	}

	public void addEdge(int toVert, int fromVert, double weight) {
		if (!isValid(toVert) || !isValid(fromVert)) return;
		adjMatrix[toVert][fromVert] = weight;
	}

	private boolean isValid(int i) {//Checks for valid values with toVert, fromVert, and weight
		return i >= 0 && i < adjMatrix.length;
	}	
	public void printDFS(int index)//printDFS sorted list
	{
		markedVert.add(index);
		for(int i = 0; i<adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0 && markedVert.contains(i) == false)
			{
				printDFS(i);
				markedVert.remove(markedVert.size()-1);
			}
			else if(adjMatrix[index][i] != 0 && i == markedVert.get(0))
			{
				for(int j=0; j<markedVert.size(); j++)
				{
					System.out.print(markedVert.get(j)+" ");
				}
				System.out.println(markedVert.get(0)+" ");
			}
		}
	}

	Queue<Integer> vQ = new LinkedList<Integer>();

	public void printBFS() {
		markedVert.clear();
		vQ.clear();

		markedVert.add(0);
		vQ.add(0);
		System.out.println(0);

		while (!vQ.isEmpty()) {
			int currentIndex = vQ.remove();
			markedVert.add(currentIndex);

			for (int i = 0; i < adjMatrix.length; i++) {
				if (!markedVert.contains(i) && !vQ.contains(i) && adjMatrix[currentIndex][i] != 0) {
					System.out.println(i);
					vQ.add(i);
				}
			}
		}
	}
	
	public void printDFSForAll()//Prints DFS and then clears markedVert for each cycle
	{
		for(int i=0; i<adjMatrix[0].length; i++)
		{
			markedVert.clear();
			printDFS(i);
		}
	}
	public int getSize() {
		return adjMatrix[0].length;
	}
}
