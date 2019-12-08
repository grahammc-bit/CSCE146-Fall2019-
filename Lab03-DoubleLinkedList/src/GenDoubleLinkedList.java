public class GenDoubleLinkedList <T>{//Generic linked list of type T
	private class ListNode
	{
		private T data;
		private ListNode nextLink;
		private ListNode prevLink;
		public ListNode() 
		{
			data = null;
			nextLink = null;
			prevLink = null;
		}
		public ListNode(T aData, ListNode aNextLink, ListNode aPrevLink)
		{
			data = aData;
			nextLink = aNextLink;
			prevLink = aPrevLink;
		}
	}
	private ListNode head;
	private ListNode curr;
	public GenDoubleLinkedList()
	{
		head = curr = null;
	}
	public void goToNext()//Moves Current Forward
	{
		if(curr == null || curr.nextLink == null)
			return;
		curr = curr.nextLink;
	}
	public void goToPrev()
	{
		if(curr == null)
			return;
		curr = curr.prevLink;
	}
	public boolean moreToIterate()
	{
		return curr != null &&
				curr.nextLink != null;
	}
	public void resetCurrent()
	{
		curr = head;
	}
	public T getCurrent()
	{
		if(curr == null)
			return null;
		return curr.data;
	}
	public void setCurrent(T aData)
	{
		if(curr != null)
		{
			curr.data = aData;
		}
	}
	public void insert(T aData)//Insert at end
	{
		//Construct link
		ListNode newNode = new ListNode(aData, null, null);
		if(head == null)
		{
			head = curr = newNode;
			return;
		}
		ListNode temp = head;
		while(temp.nextLink != null)
			temp = temp.nextLink;//Follows link
		temp.nextLink = newNode;
		newNode.prevLink = temp;//adds new node
	}
	public void insertAfterCurrent(T aData)//Insert into middle of linked list
	{
		if(curr == null)
			return;
		ListNode newNode = new ListNode(aData, curr.nextLink, null);
		newNode.nextLink = curr.nextLink;
		newNode.prevLink = curr;
		curr.nextLink = newNode;
	}
	public void deleteCurrent()//This deletes the current link
	{
		if(curr == null)
			return;
		if(curr == head)
		{
			head = head.nextLink;
			head.prevLink = null;
			curr = head;
			return;
		}
		curr.prevLink.nextLink = curr.nextLink;
		if(curr.nextLink != null)
		{
			curr.nextLink.prevLink = curr.prevLink;
		}
		curr = curr.nextLink;
	}
	public void print()//Prints the 
	{
		for(ListNode temp = head; temp != null; temp = temp.nextLink)
			System.out.println(temp.data);
	}
	public boolean contains(T aData)//Checks to see if the data is contained
	{
		ListNode temp = head;
		while(temp != null)
		{
			if(temp.data.equals(aData))
				return true;
			temp = temp.nextLink;
		}
		return false;
	}
	
	
	
	
	
	
	

}
