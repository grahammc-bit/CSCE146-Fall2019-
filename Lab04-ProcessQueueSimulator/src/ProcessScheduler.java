//Written by Matthew Graham
public class ProcessScheduler {
	private LinkedListQueue <Process> processes;//Creates a LinkedListQueue
	private Process currProcess;//Creates a process
	public ProcessScheduler()
	{
		this.processes = new LinkedListQueue<Process>();
		this.currProcess = null;
	}
	public Process getCurrentProcess()//returns the current process
	{
		return currProcess;
	}
	public void addProcess(Process aProcess)//adds a process to the head
	{
		if(currProcess == null)
			currProcess = aProcess;
		else
			processes.enqueue(aProcess);
	}
	public void runNextProcess()//dequeues a process
	{
		currProcess = processes.dequeue();
	}
	public void cancelCurrentProcess()//cancels the current process
	{
		currProcess = processes.dequeue();
	}
	public void printProcessQueue()//prints all process data
	{
		processes.print();
	}

}
