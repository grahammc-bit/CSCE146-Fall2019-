//Written by Matthew Graham
public class SheepHeap { 
	public static final int DEFAULT_SIZE = 100;
	private sheep[] heap;
	private int lastIndex;
	
	public SheepHeap()
	{
		heap = (new sheep[DEFAULT_SIZE]);
		lastIndex = 0;
	}
	public SheepHeap(int aHeap)
	{
		heap = new sheep[DEFAULT_SIZE];
	}
	public void insert(sheep value)
	{
		if(lastIndex >= heap.length)
		{
			System.out.println("Max size of heap has been reached");
			return;
		}
		heap[lastIndex] = value;
		bubbleUp();
		lastIndex++;
	}
	public void bubbleUp()
	{
		int index = this.lastIndex;
		while(index>0 && heap[(index-1)/2].compareTo(heap[index])<0)
		{
			//SWAP
			sheep temp = heap[(index-1)/2];
			heap[(index-1)/2] = heap[index];
			heap[index] = temp;
			index = (index-1)/2;
		}
	}
	public sheep peek()
	{
		if(heap == null)
			return null;
		return heap[0];
	}
	public sheep remove()
	{
		if(lastIndex <= 0)
			return null;
		sheep retVal = peek();
		
		heap[0] = heap[lastIndex - 1];
		heap[lastIndex-1] = null;
		lastIndex--;
		
		bubbleDown();
		
		return retVal;
	}
	public void bubbleDown()
	{
		int index = 0;
		while(index*2+1 < lastIndex)//While there is a left child
		{
			//Find smallest child
			int smallIndex = index*2+1;
			if(index*2+2 < lastIndex && heap[index*2+1].compareTo(heap[index*2+2])<0)//Right was smaller than left
				smallIndex = index*2+2;
			
			if(heap[index].compareTo(heap[smallIndex])<0)
			{
				//Swap
				sheep temp = heap[index];
				heap[index] = heap[smallIndex];
				heap[smallIndex] = temp;
			}
			else
				break;
			index = smallIndex;
		}
	}
	public void printHeap()
	{
		for(sheep moo : heap)
		{
			if(moo == null)
				break;
			System.out.println(moo.toString());
		}
	}
	public void heapSort()
	{
		SheepHeap tempHeap = this;
		for(int i = lastIndex;i>0;i--)
			System.out.println(tempHeap.remove()+" ");
	}
	public boolean isEmpty()
	{
		if(heap[0] == null)
			return true;
		return false;
	}
	
} 
