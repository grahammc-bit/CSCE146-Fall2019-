//Written by Matthew Graham
public class Shape {
	private double area;
	private String name;
	public Shape()
	{
		this.area = 0.0;
		this.name = "";
	}
	public Shape(int anArea, String aName)
	{
		this.setArea(anArea);
		this.setName(aName);
	}
	public double getArea() {
		return area;
	}
	public void setArea(double area) {
		this.area = area;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return " Area: "+area;
	}
	
	
	

}
