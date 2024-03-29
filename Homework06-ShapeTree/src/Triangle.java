//Written by Matthew Graham
public class Triangle extends Shape {
	private double side1;
	private double side2;
	
	public Triangle()
	{
		side1 = 0.0;
		side2 = 0.0;
	}
	public Triangle(double s1, double s2)
	{
		super();
		setSide1(s1);
		setSide2(s2);
		super.setName("Right Triangle");
		super.setArea(0.5*side1*side2);
	}
	public double getSide1() {
		return side1;
	}
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	public double getSide2() {
		return side2;
	}
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	public String toString()
	{
		return "Right Triangle: "+side1+" Side 2: "+side2+super.toString();
	}
	

}
