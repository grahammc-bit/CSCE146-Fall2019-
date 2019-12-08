//Written by Matthew Graham
import java.util.*;
public class ReversePolishCalculator{
	private StackInterface<Integer> valueStack;
	public ReversePolishCalculator()
	{
		valueStack = new LLStack<Integer>();
	}
	public int calculate(String input)
	{
		Scanner sc = new Scanner(input);
		while(sc.hasNext())
		{
			String str = sc.next();
			if(str.equals("+"))//Adds stack value
			{
				if(check())
					return 0;
				int n2 = valueStack.pop();
				int n1 = valueStack.pop();
				valueStack.push(n1+n2);
			}
			else if(str.equals("-"))//Subtracts stack values
			{
				if(check())
					return 0;
				int n2 = valueStack.pop();
				int n1 = valueStack.pop();
				valueStack.push(n1-n2);
			}
			else if(str.equals("*"))//Multiplies stack values
			{
				if(check())
					return 0;
				int n2 = valueStack.pop();
				int n1 = valueStack.pop();
				valueStack.push(n1*n2);
			}
			else if(str.equals("/"))//Divides stack values
			{
				if(check())
					return 0;
				int n2 = valueStack.pop();
				if(n2 == 0)//Makes sure not multiplying by 0
				{
					System.out.println("Cannot divide by 0");
					return 0;
				}
				int n1 = valueStack.pop();
				valueStack.push(n1/n2);
			}
			else
			{
				try
				{
					int i = Integer.parseInt(str);//Parses str to int
					valueStack.push(i);
				}
				catch(Exception e)
				{
					System.out.println("Not a valid operator");
					return 0;
				}
			}
		}
		if(valueStack.size() == 1)
			return valueStack.pop();
		System.out.println("This was not properly formatted. There were too many numbers and not enough operators.");
		clearStack();
		return 0;
	}
	public boolean check()//Checks to see if operands are valid
	{
		if(valueStack.size()>=2)
			return false;
		System.out.println("This was not properly formatted. Too many operators and not enough numbers.");
		return true;
	}
	public void clearStack()//Clears the stack
	{
		while(valueStack.size()>0)
		{
			valueStack.pop();
		}
	}

}
