//Define the class to create the BST.
public class ShapeTree
{
    private ShapeTreeNode root;
   
    //Define the constructor to initialize the root.
    public ShapeTree()
    {
        root = null;
    }
   
    //Define the method to insert the node.
    public void insert(Shape newnode)
    {
    //Create a new node and set the root
    // if the tree is empty.
        if(root == null)
        {
            root = new ShapeTreeNode(newnode);
        }
       
        //Otherwise, check the data value.
        else
        {
            ShapeTreeNode temp = root;
            ShapeTreeNode curr = null;
           
            //Start the loop to traverse the tree.
            while(temp != null)
            {
                  //Move to the leftChild if the value to be inserted
                  // is less than the current node.
                if(newnode.getArea() < temp.data.getArea())
                {
                    curr = temp;
                    temp = temp.leftChild;
                }
               
                //Otherwise, move to the rightChild.
                else
                {
                    curr = temp;
                    temp = temp.rightChild;
                }
            }
           
            //Insert the node in the leftChild if the value
            // of the value to be inserted is less than
            // the current node.
            if(newnode.getArea() < curr.data.getArea())
            {
                curr.leftChild = new ShapeTreeNode(newnode);
            }
           
            //Otherwise, insert the value in the rightChild.
            else
            {
                curr.rightChild = new ShapeTreeNode(newnode);
            }
        }
    }
   
    //Define the method to toString the tree in in-order.
    public void inorder()
    {
    System.out.println("Printing in-order");
        myinorder(root);
    }
   
    //Define the auxiliary method to toString the
    // tree in in-order.
    public void myinorder(ShapeTreeNode r)
    {
        if(r!=null)
        {
            myinorder(r.leftChild);
            r.data.toString();
            myinorder(r.rightChild);
        }
    }
   
    //Define the method to toString the tree in pre-order.
    public void preorder()
    {
    System.out.println("Printing pre-order");
    mypreorder(root);
    }
   
    //Define the auxiliary method to toString the
    // tree in pre-order.
    public void mypreorder(ShapeTreeNode r)
    {
        if(r!=null)
        {
            r.data.toString();
            mypreorder(r.leftChild);
            mypreorder(r.rightChild);
        }
    }
   
    //Define the method to toString the tree in post-order.   
    public void postorder()
    {
    System.out.println("Printing post-order");
    mypostorder(root);
    }

    //Define the auxiliary method to toString the
    // tree in pre-order.   
    public void mypostorder(ShapeTreeNode r)
    {
        if(r!=null)
        {
            mypostorder(r.leftChild);
            mypostorder(r.rightChild);
            r.data.toString();
        }
    }
   
    //Define the method to return the maximum area.
    public double maxArea()
    {
    ShapeTreeNode temp = root;
   
    //Start the loop to traverse the tree.
    while(temp.rightChild != null)
    {
            //Move to the rightChild side.
            temp = temp.rightChild;
    }
   
    //Return the area of the rightChild-most node.
    return temp.data.getArea();
    }
   
    //Define the method to search a node.
    public void search(String type, double area)
    {
    ShapeTreeNode temp = root;
   
    //Start the loop to traverse the tree.
    while(temp != null)
    {
            //If the node is found, toString the values, and break the loop.
            if (area == temp.data.getArea() && type.equals(temp.data.getName()))
            {
                  temp.data.toString();
                  break;
            }
           
            //Move to the leftChild if the value to be searched
          // is less than the current node.
            else if(area < temp.data.getArea())
            {
                  temp = temp.leftChild;
            }
           
            //Otherwise, move to the rightChild.
            else
            {
                  temp = temp.rightChild;
            }
    }
    }
   
    //Define the method to delete a node.
    public void delete(String type, double area)
    {
    //toString the details of the node.
    System.out.print("Deleting ");
    search(type, area);
   
    //Call the method to delete the node.
    mydelete(type, area);
    }
   
    //Define the auxiliary method to delete a node.
    public void mydelete(String type, double area)
    {
    ShapeTreeNode temp = root;
    ShapeTreeNode parent = null;
   
    //Start the loop to traverse the tree.
    while(temp != null)
    {
            //Check the area and type of the node.
            if (area == temp.data.getArea() && type.equals(temp.data.getName()))
            {
                  //Delete the node if it has no child.
                  if(temp.leftChild == null && temp.rightChild == null)
                  {
                        //Set the root if the root is deleted.
                        if(temp == root)
                        {
                              root = null;
                              break;
                        }
                       
                        if(temp == parent.leftChild)
                        {
                              parent.leftChild = null;
                        }
                        else
                        {
                              parent.rightChild = null;
                        }
                  }
                 
                  //If the node to be deleted has no rightChild child.
                  else if(temp.rightChild == null)
                  {
                        //Set the root if the parent is null.
                        if(parent == null)
                        {
                              root = root.leftChild;
                              break;
                        }
                       
                        //Set the leftChild sub tree of the parent node
                        // if the node to be deleted in on the leftChild.
                        if(temp == parent.leftChild)
                        {
                              parent.leftChild = temp.leftChild;
                        }
                       
                        //Otherwise, set the rightChild sub tree of the parent node
                        else
                        {
                              parent.rightChild = temp.leftChild;
                        }
                  }
                 
                  //If the node has 2 child
                  else
                  {
                        //Move to the rightChild sub-tree.
                        ShapeTreeNode temp2 = temp.rightChild;
                        ShapeTreeNode parent_temp2 = temp;
                       
                        //Move to the leftChild most node in the rightChild
                        // sub-tree.
                        while(temp2.leftChild!=null)
                        {
                              parent_temp2 = temp2;
                              temp2 = temp2.leftChild;
                        }
                       
                        //Copy the value of the leftChild most tree
                        // in the data of the node to be deleted
                        temp.data = temp2.data;
                       
                        //Delete the leftChild-most node.
                        if(temp2 == parent_temp2.leftChild)
                        {
                              parent_temp2.leftChild = temp2.rightChild;
                        }
                       
                        else
                        {
                              parent_temp2.rightChild = temp2.rightChild;
                        }
                  }
                  break;
            }
           
            //Move to the leftChild side if the value to
            // be deleted is less than the current node.
            else if(area < temp.data.getArea())
            {
                  parent = temp;
                  temp = temp.leftChild;
            }
           
            //Otherwise, move to the rightChild side.
            else
            {
                  parent = temp;
                  temp = temp.rightChild;
            }
    }
    }
   
    //Define the method to delete all the nodes
    // greater than the given value.
    public void deleteGreaterThan(double area)
    {
    System.out.println("Deleting values greater than "+area);
    ShapeTreeNode temp = root;
   
    //Start the loop to traverse the tree.
    while(temp!= null)
    {
            //If the value of the current node is greater
            // than the given value, set the delete the
            // rightChild subtree.
            if(temp.data.getArea() > area)
            {
                  temp.rightChild = null;
                 
                  //Call the delete method to delete the current node.
                  mydelete(temp.data.getName(),temp.data.getArea());
                 
                  //Set the pointer to the root node to check
                  // the modified tree.
                  temp = root;
            }
         
            //Otherwise, move to the rightChild side.
            else
            {
                  temp = temp.rightChild;
            }
    }
    }
}