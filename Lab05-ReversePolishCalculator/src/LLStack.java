//Written by Matthew Graham
import java.util.*;
public class LLStack<T> implements StackInterface<T> {
	private class ListNode
	{
		private T data;
		private ListNode link;
		public ListNode(T aData, ListNode aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	private ListNode head;//Only need head for stack
	private int size;
	public LLStack()
	{
		head = null;
		size = 0;
	}
	public void push(T aData)//Adds values
	{
		ListNode newNode = new ListNode(aData, head);
		head = newNode;
		size++;
	}
	public T pop()//Returns values
	{
		if(head == null)
			return null;
		T ret = head.data;
		head = head.link;
		size--;
		return ret;
	}
	public int size()//Checks size of stack
	{
		return this.size;
	}
	public T peek()//Peeks at data
	{
		if(head == null)
			return null;
		return head.data;
	}
	public void print()//Useful for exam
	{
		ListNode temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.link;
		}
	}

}
