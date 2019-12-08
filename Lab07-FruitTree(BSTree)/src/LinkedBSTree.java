//Written by Matthew Graham
public class LinkedBSTree <T extends Comparable> {
	private class Node
	{
		private T data;
		private Node leftChild;//Less than
		private Node rightChild;//Greater or equal
		public Node(T aData)
		{
			data = aData;
			leftChild = rightChild = null;
		}
	}
	private Node root;//Is where everything happens
	public LinkedBSTree()
	{
		root = null;
	}
	public void insert(T aData)
	{
		if(root == null)
			root = new Node(aData);
		else
			insert(root,aData);
	}
	private Node insert(Node aNode, T aData)//Recursive insert
	{
		if(aNode == null)//Found a leaf
		{
			aNode = new Node(aData);//Return a new node
		}
		else if(aData.compareTo(aNode.data) < 0)//LESS go left
		{
			aNode.leftChild = insert(aNode.leftChild,aData);
		}
		else if(aData.compareTo(aNode.data) >= 0)//GREATER go right
		{
			aNode.rightChild = insert(aNode.rightChild,aData);
		}
		return aNode;
	}
	public void printPreOrder()
	{
		printPreOrder(root);
	}
	public void printPreOrder(Node aNode)//Process First
	{
		if(aNode == null)//Encountered a leaf
			return;
		System.out.println(aNode.data);//Process
		printPreOrder(aNode.leftChild);//Recursive Left
		printPreOrder(aNode.rightChild);//Recursive right
	}
	public void printInOrder()
	{
		printInOrder(root);
	}
	private void printInOrder(Node aNode)//Process middle
	{
		if(aNode == null)
			return;
		printInOrder(aNode.leftChild);//Recursive Left
		System.out.println(aNode.data);//Process
		printInOrder(aNode.rightChild);//Recursive Right
	}
	public void printPostOrder()
	{
		printPostOrder(root);
	}
	private void printPostOrder(Node aNode)//Process last
	{
		if(aNode == null)
			return;
		printPostOrder(aNode.leftChild);//Recursive Left
		printPostOrder(aNode.rightChild);//Recursive Right
		System.out.println(aNode.data);//Process
	}
	public void delete(T aData)
	{
		root = delete(root,aData);
	}
	private Node delete(Node aNode, T aData)
	{
		//Find the value
		if(aNode == null)
			return null;//Data was not found
		if(aData.compareTo(aNode.data) < 0)//Go left
			aNode.leftChild = delete(aNode.leftChild,aData);
		else if(aData.compareTo(aNode.data) > 0)//Go right
			aNode.rightChild = delete(aNode.rightChild,aData);
		else//We found it! Destroy it!
		{
			if(aNode.rightChild == null)
				return aNode.leftChild;
			if(aNode.leftChild == null)
				return aNode.rightChild;
			//If we reach here we have two children
			//Find smallest value in right subtree
			Node temp = findMin(aNode.rightChild);
			//Replace the value
			aNode.data = temp.data;
			//Delete the smallest node in the right subtree
			aNode.rightChild = delete(aNode.rightChild,temp.data);
		}
		return aNode;
		
	}
	private Node findMin(Node aNode)
	{
		if(aNode == null)
			return null;
		if(aNode.leftChild == null)
			return aNode;
		else
			return findMin(aNode.leftChild);
	}
	

}
























