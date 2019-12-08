//Written by Matthew Graham
public class Process implements Comparable<Process> {
	private int priority;
	private double time;
	private String name;
	public Process()
	{
		this.priority = 0;
		this.time = 0.0;
		this.name = " ";
	}
	public Process(String aName, int aPriority, double aTime)
	{
		this.setPriority(aPriority);
		this.setTime(aTime);
		this.setName(aName);
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String toString()
	{
		return "Name: "+this.name+" Time: "+this.time+" Priority: "+this.priority;
	}
	public int compareTo(Process aProcess)
	{
		if(this.priority > aProcess.getPriority())
			return 1;
		else if(this.priority < aProcess.getPriority())
			return -1;
		else return 0;
	}
	

}
