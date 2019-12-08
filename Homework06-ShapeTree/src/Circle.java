//Written by Matthew Graham
public class Circle extends Shape {
	private double r;	
	public Circle()
	{
		this.r = 0.0;
	}
	public Circle(double aR)
	{
		super();
		this.setR(aR);
		super.setName("Circle");
		super.setArea(r*r*Math.PI);
	}
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public String toString()
	{
		return "Circle Radius: "+r+super.toString();
	}
	


}
