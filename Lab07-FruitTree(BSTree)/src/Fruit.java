//Written by Matthew Graham
public class Fruit implements Comparable {
	private double weight;
	private String name;
	public Fruit()
	{
		weight = 0.0;
		name = " ";
	}
	public Fruit(String aName, double aWeight)
	{
		setWeight(aWeight);
		setName(aName);
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double aWeight) {
		if(this.weight >= 0.0)
			this.weight = aWeight;
	}
	public String getName() {
		return name;
	}
	public void setName(String aName) {
		if(aName != null)
			this.name = aName;
	}
	public String toString()//Basic tostring
	{
		return this.name+" "+this.weight;
	}
	public int compareTo(Object aFruit)//Compare to method to be used in LinkedBSTree
	{
		Fruit tmp = (Fruit)aFruit;
		if(this.weight > tmp.getWeight())
			return 1;
		else if(this.weight < tmp.getWeight())
			return -1;
		else
			return 0;
	}
	

}
