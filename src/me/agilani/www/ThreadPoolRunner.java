package me.agilani.www;

public class ThreadPoolRunner{

	public ThreadPoolRunner()
	{
		System.out.println("Thread pooling is starting");
	}
	

	public static void main(String[] args)
	{
		ThreadPool tpool = new ThreadPool();
		tpool.start();
	}
}
