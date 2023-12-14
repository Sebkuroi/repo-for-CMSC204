import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class CarQueue 
{
	
	Queue<Integer> directionQueue = new LinkedList<Integer>();
	Random random = new Random();
	public CarQueue() 
	{
		{
			directionQueue.add(0);
			directionQueue.add(0);
			directionQueue.add(2);
			directionQueue.add(1);
			directionQueue.add(3);
			directionQueue.add(3);
		}
	}

	public void addToQueue() 
	{
		class Run implements Runnable 
		{
			public void run() 
			{
				try 
				{
					while (true) 
					{
						int Integer = random.nextInt(4);
						directionQueue.add(Integer);
						Thread.sleep(100);
					}
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}	
			}
		
		}
		
		Runnable myrun = new Run();
		Thread thread = new Thread(myrun);
		thread.start();
	}

	public int deleteQueue() 
	{
		return directionQueue.remove();
	}

}