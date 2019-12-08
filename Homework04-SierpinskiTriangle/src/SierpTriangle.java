//Written by Matthew Graham
import java.awt.*;
import javax.swing.*;
public class SierpTriangle extends Canvas {
	public static final int SIZE = 800;

	public static void main(String[] args) {
		JFrame frame = new JFrame("Sierpinski's Triangle");
		frame.setSize(SIZE,SIZE);
		
		SierpTriangle sp = new SierpTriangle();
		frame.add(sp);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}
	public void paint(Graphics g)//Calls drawIt to paint triangle
	{
		drawIt(g);
	}
	public void drawIt(Graphics g)
	{
        int triH = (int) Math.round(SIZE * Math.sqrt(3.0) / 2.0);
        Point p1 = new Point(0, triH);
        Point p2 = new Point(SIZE / 2, 0);
        Point p3 = new Point(SIZE, triH);
        drawShape(6, g, p1, p2, p3);//Change first value to a number between 1-9 for different sized Sierpinski Triangles
	}
    public static void drawShape(int level, Graphics g, Point p1, Point p2, Point p3) 
    {
    	if (level == 1) //Creates a base triangle in instance of level == 1 
    	{
    		Polygon p = new Polygon();
    		p.addPoint(p1.x, p1.y);
    		p.addPoint(p2.x, p2.y);
    		p.addPoint(p3.x, p3.y);
    		g.fillPolygon(p);
    	} 
    	else 
    	{
    		//Recursive, splits into 3 triangles
    		Point p4 = midpoint(p1, p2);
    		Point p5 = midpoint(p2, p3);
    		Point p6 = midpoint(p1, p3);
    		
    		//recursive on 3 triangular areas
    		drawShape(level - 1, g, p1, p4, p6);
    		drawShape(level - 1, g, p4, p2, p5);
    		drawShape(level - 1, g, p6, p5, p3);
    	}
    }
    public static Point midpoint(Point p1, Point p2) //Return midpoint of p1 and p2
    {
        return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
    }
}
