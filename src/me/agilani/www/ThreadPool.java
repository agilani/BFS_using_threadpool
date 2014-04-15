package me.agilani.www;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool extends Thread{

	public ThreadPool tpr;
	public NodeQueue nqueue;
	public Node parentNode, adeel, nabeel, kiran, kamil, zoya, taha, zoha, newborn;
	
	public ThreadPool()
	{
		nqueue = new NodeQueue();
		
		parentNode = new Node(0, "Shafiq", null, nqueue);
		
		adeel = new Node(1, "Adeel", parentNode, nqueue);
		nabeel = new Node(1, "Nabeel", parentNode, nqueue);
		kiran = new Node(1, "Kiran", parentNode, nqueue);
		
		kamil = new Node(2, "Kamil", adeel, nqueue);
		
		zoya = new Node(2, "Zoya", nabeel, nqueue);
		
		taha = new Node(2, "Taha", kiran, nqueue);
		zoha = new Node(2, "Zoha", kiran, nqueue);
		newborn = new Node(2, "new born", kiran, nqueue);
		
		parentNode.setChildren(adeel);
		parentNode.setChildren(nabeel);
		parentNode.setChildren(kiran);
		
		adeel.setChildren(kamil);
		nabeel.setChildren(zoya);
		
		kiran.setChildren(taha);
		kiran.setChildren(zoha);
		kiran.setChildren(newborn);
		
		/*
		for(Node child : parentNode.getChildren())
		{
			System.out.println(child.getNumber());
		}
		*/
	}
	
	@Override
	public void run() {

		super.run();
		
		nqueue.allRunAbles.add(parentNode);
		
		ExecutorService executor = Executors.newFixedThreadPool(1);
		
		while(nqueue.keepRunning == true)
		{
			//System.out.println("Queue size is " + nqueue.allRunAbles.size());
			
			Node node = nqueue.allRunAbles.poll();
			if(node!=null)
			{
				executor.execute(node);
			}
			else
			{
				try
				{
					Thread.sleep(5000);
				}
				catch(Exception e)
				{
					
				}
			}
		}
		
        executor.shutdown();
        
        while (!executor.isTerminated())
        {
        	
        }
        System.out.println("Finished all threads");
	}

}
