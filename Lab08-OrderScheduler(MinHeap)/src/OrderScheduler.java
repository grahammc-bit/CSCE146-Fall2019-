//Written by Matthew Graham
public class OrderScheduler {
	private MinHeap<Order> orders;
	private Order currOrder;
	private int currMinute;
	private int totalOrders;
	private int summedWaitingTimes;
	public OrderScheduler()
	{
		orders = new MinHeap<Order>();
	}
	public void addOrder(Order anOrder)//Adds another order
	{
		if(currOrder == null)
			currOrder = anOrder;
		else orders.insert(anOrder);
		totalOrders++;
	}
	public void advanceOneMinute()//advances the orders by one minutes
	{
		if(currOrder == null)
			return;
		currMinute++;
		currOrder.cookForOneMinute();
		if(currOrder.isDone())
		{
			summedWaitingTimes += currMinute - currOrder.getArrivalTime();
			currOrder = orders.remove();
		}
	}
	public boolean isDone()//sets curr order to done
	{
		return currOrder == null;
	}
	public double getAverageWaitingTime()//divides the waiting time by the orders for the average wait
	{
		return (double)summedWaitingTimes/(double)totalOrders;
	}
	public Order getCurrentOrder()//calls the current order
	{
		return currOrder;
	}

}
