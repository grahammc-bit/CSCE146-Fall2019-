//Written by Matthew Graham
public class sheep implements Comparable<sheep> {
	private int arrivalTime;
	private int shearTime;
	private String name;
	public sheep()
	{
		this.arrivalTime = 0;
		this.shearTime = 0;
		this.name = "";
	}
	public sheep(int aT, int sT, String aName)
	{
		this.setArrivalTime(aT);
		this.setShearTime(sT);
		this.setName(aName);
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public int getShearTime() {
		return shearTime;
	}
	public void setShearTime(int shearTime) {
		this.shearTime = shearTime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return "Name: "+this.name+", Sheer Time: "+this.shearTime+", Arrival Time: "+this.arrivalTime;
	}
	public int compareTo(sheep aSheep)
	{
		if(this.arrivalTime > aSheep.getArrivalTime())
			return 1;
		else if(this.arrivalTime < aSheep.getArrivalTime())
			return -1;
		else return 0;
	}
	
}
