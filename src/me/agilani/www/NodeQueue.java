package me.agilani.www;

import java.util.LinkedList;
import java.util.Queue;

public class NodeQueue {
	public Queue<Node> allRunAbles;
	public boolean keepRunning;
	
	public NodeQueue()
	{
		 allRunAbles = new LinkedList<Node>();
		 keepRunning = true;
	}
}
