//Written by Matthew Graham
import java.util.Scanner;
public class BortSorter {
	private LinkedListQueue<String> queue;
	private String[] bortArray;
	private int[] bortCount;
	private int count;
	private String word;
	public BortSorter()
	{
		this.queue = new LinkedListQueue<String>();
		this.count = 0;
		this.word = "bort";
	}	
	public void populate()
	{
		Scanner keyboard = new Scanner(System.in);
		boolean quit = false;
		while(quit == false)
		{
			String input = keyboard.nextLine();
			if(input.equals("quit"))
			{
				System.out.println("\nBORT SORTED!!!");
				break;
			}
			else
			{
				queue.enqueue(input);
			}
		}
	}
	public void bortSort()
	{
		bortArray = new String[queue.size()];
		bortCount = new int[queue.size()];
		for(int i = 0; i<bortArray.length; i++)
		{
			count = 0;
			bortArray[i] = queue.dequeue();
			if(bortArray[i].toLowerCase().contains(word))
			{
			    count += countOccurence(bortArray[i].toLowerCase(), word);
			    bortCount[i] = count;
			}
			else
				System.out.println(bortArray[i]);
		}
	}
	public static int countOccurence(String haystack, String needle)
	{
		int lastIndex = 0;
		int count = 0;
		while (lastIndex != -1) 
		{
		    lastIndex = haystack.indexOf(needle, lastIndex);
		    if (lastIndex != -1) 
		    {
		        count++;
		        lastIndex += needle.length();
		    }
		}
		return count;
	}
	public void bortPrint()
	{
		quickSort(bortCount, 0, bortCount.length - 1);
		
		for(int i=0; i<bortArray.length;i++)
		{
			if(bortArray[i].toLowerCase().contains(word))
			{
			    count += countOccurence(bortArray[i].toLowerCase(), word);
			    for(int j=0; j<bortCount.length;j++)
			    {
			    	if(bortCount[j] == count)
			    	{
			    		System.out.println(bortArray[i]);
			    		count = 0;
			    	}
			    }
			}
		}
	}
    public static void quickSort(int[] arr, int start, int end){	 
        int partition = partition(arr, start, end);
        if(partition-1>start) {
            quickSort(arr, start, partition - 1);
        }
        if(partition+1<end) {
            quickSort(arr, partition + 1, end);
        }
    }
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[end];
        for(int i=start; i<end; i++){
            if(arr[i]<pivot){
                int temp= arr[start];
                arr[start]=arr[i];
                arr[i]=temp;
                start++;
            }
        }
        int temp = arr[start];
        arr[start] = pivot;
        arr[end] = temp;
        return start;
    }
}
