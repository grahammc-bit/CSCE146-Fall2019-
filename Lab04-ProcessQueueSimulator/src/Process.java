//Written by Matthew Graham
public class Process {//Creates an object Process which will be used throughout the program
	private String name;
	private double completionTime;
	public Process()
	{
		name = "";
		completionTime = 0.0;
	}
	public Process(String name, double completionTime)
	{
		this.name = name;
		this.completionTime = completionTime;
	}
	public String getName() {//Gets the name of the process
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCompletionTime() {//Returns completion time
		return completionTime;
	}
	public void setCompletionTime(double completionTime) {//Sets completion time
		if(completionTime > 0)
			this.completionTime = completionTime;
		else
			this.completionTime = 0.0;
	}
	public String toString()//Prints the process name and completion time
	{
		return "Process Name: "+name+" Completion Time: "+completionTime;
	}
	

}
