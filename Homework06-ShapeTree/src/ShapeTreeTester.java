//Import the required packages.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Define the Main() class.
class Main
{
      //Define the main() method.
    public static void main(String[] args) throws IOException
    {
    //Create an object of the ShapeTree.
    ShapeTree T = new ShapeTree();
   
    //Create an object of the BufferedReader to read the file.
    BufferedReader objReader = null;
    objReader = new BufferedReader(new FileReader("shapeFile.txt"));
   
    String line;
   
    //Start the loop to read the file.
    while ((line = objReader.readLine()) != null)
    {
            int valid = 0;
           
            //Split the line by tab.
            String words[] = line.split("\t");
           
            //Check the first word and create an object of the same class.
            // Print the error message if the value are invalid.
            if(words[0].equals("Rectangle"))
            {
                  valid = 1;
                  try
                  {
                        T.insert(new Rectangle(Double.parseDouble(words[1]),Double.parseDouble(words[2])));
                  }
                  catch(Exception e)
                  {
                        System.out.println("Not properly formatted line. "
                                    + "Yes you should check for these. Not intentionally "
                                    + "causing a kerfuffle");
                  }
            }
           
            else if(words[0].equals("Right Triangle"))
            {
                  valid = 1;
                  try
                  {
                        T.insert(new Triangle(Double.parseDouble(words[1]),Double.parseDouble(words[2])));
                  }
                  catch(Exception e)
                  {
                        System.out.println("Not properly formatted line. "
                                    + "Yes you should check for these. Not intentionally"
                                    + " causing a kerfuffle");
                  }
            }
           
            else if(words[0].equals("Circle"))
            {
                  valid = 1;
                  try
                  {
                        T.insert(new Circle(Double.parseDouble(words[1])));
                  }
                  catch(Exception e)
                  {
                        System.out.println("Not properly formatted line. "
                                    + "Yes you should check for these. Not intentionally "
                                    + "causing a kerfuffle");
                  }
            }
           
            //Print the error message if the line is invalid.
            else
            {
                  System.out.println("Not properly formatted line. "
                              + "Yes you should check for these. Not intentionally "
                              + "causing a kerfuffle");
            }
           
            //Print the line read if the line is valid.
            if(valid == 1)
            {
                  for(String word:words)
                  {
                        System.out.print(word+"\t");
                  }
                  System.out.println();
            }
    }
   
    //Close the object.
    objReader.close();
    System.out.println();
   
    //Call the methods to print the pre-order, in-order,
    // and the post-order of the tree.
        T.preorder();
        System.out.println();
        T.inorder();
        System.out.println();
        T.postorder();
        System.out.println();
       
        //Call the method to find the maximum area.
        System.out.println("The max area is: "+T.maxArea());
        System.out.println();
       
        //Call the method to delete a rectangle of area 14.
        T.delete("Rectangle", 14);
        System.out.println();
       
        //Print the in-order of the tree.
        T.inorder();
        System.out.println();
       
        //Call the method to delete all the nodes greater
        // than 30 and print the in-order of the tree.
        T.deleteGreaterThan(30);
        T.inorder();
    }
}