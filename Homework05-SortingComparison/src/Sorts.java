//Written by Matthew Graham
import java.util.Random;
public class Sorts {
	public static final int MAX = 1000;
	public static final int RUNS = 20;
	private int[] merge;
	private int mergeCount;
	private int[] quick;
	private int quickCount;
	private int[] bubble;
	private int bubbleCount;
	private int[] selection;
	private int selectionCount;
	public Sorts()
	{
		merge = new int[MAX];
		quick = new int[MAX];
		bubble = new int[MAX];
		selection = new int[MAX];
		mergeCount = 0;
		quickCount = 0;
		bubbleCount = 0;
		selectionCount = 0;
	}
	public void initialize()
	{
		Random r = new Random();//Init randomizer
		for(int i=0; i<MAX; i++)
		{
			merge[i] = quick[i] = bubble[i] = selection[i] = r.nextInt(MAX);//Populates different arrays with the same integers
		}
		selectionSort(selection);
		System.out.println("Selection sort successful? "+sortCheck(selection));

		bubbleSort(bubble);
		System.out.println("Bubble sort successful? "+sortCheck(bubble));

		mergeSort(merge, 0, merge.length-1);
		System.out.println("Merge sort successful? "+sortCheck(merge));

		quickSort(quick, 0, quick.length-1);
		System.out.println("Quick sort successful? "+sortCheck(quick));
	}
	public void avgCheck()//Checks and calls calculate for averages
	{
		System.out.println("----------------------\nAverage Checks\n----------------------");
		System.out.println("Selection: "+calculate(selectionCount));
		System.out.println("Bubble: "+calculate(bubbleCount));
		System.out.println("Merge: "+calculate(mergeCount));
		System.out.println("Quick: "+calculate(quickCount));
	}
	public boolean sortCheck(int[] a)//Checks if the arrays are sorted properly
	{
		boolean sorted = true;
		for (int i = 0; i < a.length - 1; i++) 
		{
		    if (a[i] > a[i+1]) 
		    {
		        return sorted = false;
		    }
		}
		return sorted;
	}
	public int calculate(int count)//Calculates averages 
	{
		int temp = count;
		count = 0;
		return temp/RUNS;
	}
    public void mergeSort(int a[], int l, int r) 
    { 
        if (l < r) 
        { 
            // Find the middle point 
            int m = (l+r)/2; 
  
            // Sort first and second halves 
            mergeSort(a, l, m); 
            mergeSort(a , m+1, r); 
  
            // Merge the sorted halves 
            merge(a, l, m, r);
        }
    } 
	public void merge(int a[], int l, int m, int r) 
    { 
        // Find sizes of two sub-arrays to be merged 
        int n1 = m - l + 1; 
        int n2 = r - m; 
        /* Create temporary arrays */
        int L[] = new int [n1]; 
        int R[] = new int [n2]; 
        /*Copy data to temporary arrays*/
        for (int i=0; i<n1; ++i) 
            L[i] = a[l + i]; 
        for (int j=0; j<n2; ++j) 
            R[j] = a[m + 1+ j]; 
        /* Merge the temporary arrays */
        // Initial indexes of first and second sub-arrays 
        int i = 0, j = 0; 
        // Initial index of merged sub-array array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                a[k] = L[i]; 
                i++; 
            } 
            else
            { 
                a[k] = R[j]; 
                j++; 
            } 
            k++; 
            mergeCount++;
        } 
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            a[k] = L[i]; 
            i++; 
            k++; 
        } 
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            a[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
	public void quickSort(int[] a, int l, int h)
	{
        if (l < h) 
        { 
            /* pi is partitioning index, a[pi] is  
              now at right place */
            int pi = partition(a, l, h); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSort(a, l, pi-1); 
            quickSort(a, pi+1, h); 
        } 
	}
	public int partition(int[] a, int l, int h)
	{
        int pivot = a[h];  
        int i = (l-1); // index of smaller element 
        for (int j=l; j<h; j++) 
        { 
            // If current element is smaller than the pivot 
            if (a[j] < pivot) 
            { 
                i++; 
  
                // swap a[i] and a[j] 
                int temp = a[i]; 
                a[i] = a[j]; 
                a[j] = temp; 
            } 
            quickCount++;
        } 
  
        // swap a[i+1] and a[h] (or pivot) 
        int temp = a[i+1]; 
        a[i+1] = a[h]; 
        a[h] = temp; 
  
        return i+1; 
	}
	public void bubbleSort(int[] a)//Basic bubble sort method
	{
		boolean hasSwapped = true;
	    while(hasSwapped)
	    {
	      hasSwapped = false;
	      for(int i=0; i<a.length-1;i++)
	      {
	        if(a[i] > a[i+1])//Swap
	        {
	          int temp = a[i];
	          a[i] = a[i+1];
	          a[i+1] = temp;
	          hasSwapped = true;
	        }
	        bubbleCount++;
	      } 
	    }
	}
	public void selectionSort(int[] a)
	{
	    // One by one move boundary of unsorted sub-array 
        for (int i = 0; i < a.length-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < a.length; j++) 
            {
                if (a[j] < a[min_idx]) 
                    min_idx = j; 
                selectionCount++;
            }
            // Swap the found minimum element with the first element
            int temp = a[min_idx]; 
            a[min_idx] = a[i]; 
            a[i] = temp; 
        } 
	}
}
