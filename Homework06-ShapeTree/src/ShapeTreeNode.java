//Written by Matthew Graham
public class ShapeTreeNode {
	public Shape data;
	public ShapeTreeNode leftChild;
	public ShapeTreeNode rightChild;
	
	public ShapeTreeNode(Shape object)
	{
		data = object;
		leftChild = null;
		rightChild = null;
	}

}
