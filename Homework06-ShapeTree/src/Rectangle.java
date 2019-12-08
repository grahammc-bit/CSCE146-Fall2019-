//Written by Matthew Graham
public class Rectangle extends Shape {
	private double b;
	private double h;
	
	public Rectangle()
	{
		this.b = 0.0;
		this.h = 0.0;
	}
	public Rectangle(double aB, double aH)
	{
		super();
		this.setH(aH);
		this.setB(aB);		
		super.setName("Rectangle");
		super.setArea(aB*aH);
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public double getH() {
		return h;
	}
	public void setH(double h) {
		this.h = h;
	}
	public String toString()
	{
		return "Rectangle Side 1: "+b+" Side 2: "+h+super.toString();
	}
	

}
