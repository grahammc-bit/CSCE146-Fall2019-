//Written by Matthew Graham
public class LinkedListQueue<T> {//General linked list
	public class ListNode
	{
		T data;
		ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			this.data = aData;
			this.link = aLink;
		}
	}
	private ListNode head;
	private ListNode tail;
	private int size;
	public LinkedListQueue()//Sets head and tail to null
	{
		head = null;
		tail = null;
	}
	public String peek()//Looks at process head and returns it
	{
		if(head == null)
			return null;
		return head.data.toString();
	}
	public T dequeue()//Dequeues and returns the head
	{
		if(head == null)
			return null;
		ListNode temp = head;
		head = head.link;
		size--;
		return temp.data;
	}
	public void enqueue(T aData)//Adds to the head
	{
		ListNode newNode = new ListNode (aData,null);
		if(head == null)
		{
			head = newNode;
			tail = head;
			size = 1;
			return;
		}
		this.tail.link = newNode;
		this.tail = newNode;
		size++;
	}
}
