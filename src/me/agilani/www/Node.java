package me.agilani.www;

import java.util.ArrayList;
import java.util.List;

public class Node implements Runnable {

	private NodeQueue nqueue;
	private Node parent;
	private List<Node> children = new ArrayList<Node>();
	private String name;
	private int number;
	
	public Node(int number, String name, Node parent, NodeQueue nqueue)
	{
		setParent(parent);
		setNQUEUE(nqueue);
		setNumber(number);
		setName(name);
	}
	
	
	@Override
	public void run()
	{
		try
		{
			if(parent!=null)
				System.out.println("Starting at level " + this.getNumber());
			else
				System.out.println("Starting at level 0");

			System.out.println("      Start of Story");
			System.out.println("            My name is " + this.getName());
			if(parent!=null)
				System.out.println("            My parent's name is " + this.parent.getName());
		
			
			if(this.getChildren().size()>0)
			{
				System.out.println("            My Children are:");
				for(Node n : this.getChildren())
				{
					System.out.println("                  " + n.getName());
					getNQUEUE().allRunAbles.add(n);
				}
			}
			else
			{
				getNQUEUE().keepRunning = false;
			}

			
			System.out.println("      End of Story.\r\n\r\n");
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public List<Node> getChildren() {
		return children;
	}

	public void setChildren(Node child) {
		this.children.add(child);
	}


	public NodeQueue getNQUEUE() {
		return nqueue;
	}


	public void setNQUEUE(NodeQueue nqueue) {
		this.nqueue = nqueue;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
