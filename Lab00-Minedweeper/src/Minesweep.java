/**
 * Written by Matthew Graham, 8/23/19, Lab 00 
 */
import java.util.Random;//Imports use of Javas random utility
public class Minesweep {
  public static final int SIZE = 10; //Sets default value to 10
  public static final String EMPTY = "-";
  public static final String MINE = "*";
  public static void main(String[] args) { 
    String[][] a = new String[SIZE][SIZE];//Create a multidimensional array of size 10x10
    Random r = new Random();//Initializes random
    
    System.out.println("Creating empty board");
    for(int i=0;i<a.length;i++)//For loop fills board
    {
      for(int j=0;j<a[i].length;j++)
      {
        a[i][j] = "-";
      }
    }
    for(int i=0;i<a.length;i++)//Prints board
    {
      for(int j=0;j<a[i].length;j++)
      {
        System.out.print(a[i][j]);
      }
      System.out.println();
    }
    System.out.println("Filling with mines");
        int count = 0;
        while(count < SIZE)//Fills board with mines
        {
          int i = r.nextInt(SIZE);
          int j = r.nextInt(SIZE);
          if(a[i][j].equals("-"))
          {
          a[i][j] = "*";
          count++;
          }
        }
    for(int i=0;i<a.length;i++)//Prints board with Mines
    {
      for(int j=0;j<a[i].length;j++)
      {
        System.out.print(a[i][j]);
      }
      System.out.println();
    }
    
    for(int i=0; i<a.length;i++)//Appoints number values to spaces within mine distance
    {
      for(int j=0; j<a[i].length;j++)
      {
        if(a[i][j].equals("*"))
          continue;
        int count1 = 0;
        if(i-1>=0 && j-1>=0 && a[i-1][j-1].equals("*"))
          count1++;
        if(i-1>=0 && a[i-1][j].equals("*"))
          count1++;
        if(i-1>=0 && j+1<=a.length-1 && a[i-1][j+1].equals("*"))
          count1++;
        if(j-1>=0 && a[i][j-1].equals("*"))
          count1++;
        if(j+1<=a.length-1 && a[i][j+1].equals("*"))
          count1++;
        if(i+1<=a.length-1 && j-1>=0 && a[i+1][j-1].equals("*"))
          count1++;
        if(i+1<=a.length-1 && a[i+1][j].equals("*"))
          count1++;
        if(i+1<=a.length-1 && j+1<=a.length-1 && a[i+1][j+1].equals("*"))
          count1++;
        a[i][j] = ""+count1;
      }
    }
    
    System.out.println("Performing mine count");
    for(int i=0;i<a.length;i++)//Prints final board
    {
      for(int j=0;j<a[i].length;j++)
      {
        System.out.print(a[i][j]);
      }
      System.out.println();
    }
  }

}
