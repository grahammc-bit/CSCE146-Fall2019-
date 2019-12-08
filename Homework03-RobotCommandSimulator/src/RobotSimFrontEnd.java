//Written by Matthew Graham
import java.util.Scanner;
public class RobotSimFrontEnd {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		RobotSim r = new RobotSim();
		System.out.println("Welcome to the Robot Simulator!");
		boolean quit = false;
		while(quit == false)
		{
			System.out.println("Input board file name:");
			String fileName = keyboard.nextLine();
			System.out.println("Now enter the robot commands file name:");
			String fileName2 = keyboard.nextLine();
			
			//Board Construction
			System.out.println("Running the Simulation...");
			r.printInitial(fileName);
			r.makeMove(fileName2);
			System.out.println("Simulation End\n\nQuit? Enter \"exit\" to quit or hit enter to run another simulation");
			String input = keyboard.nextLine();
			if(input.equalsIgnoreCase("exit"))
			{
				System.out.println("Goodbye *BEEP-boop*");
				break;
			}
		}

	}

}
