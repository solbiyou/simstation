/**
 * Edit History
 * 4/7 Solbi You: created
 * 4/8 Solbi You: update move method
 * 4/9 Solbi You: add distance method
 * 4/12 Solbi You: add conditions in move method
 */
package simstation;

import java.io.*;
import java.util.*;

import mvc.*;

public abstract class Agent implements Runnable, Serializable {
	private String name;
	private AgentState state;
	private Thread thread;
	private Heading heading;
	private Simulation world;
	private int xc;
	private int yc;

	public Agent(String name) {
		this.name = name;
		state = AgentState.READY;
		thread = null;
		heading = Heading.random();
		xc = Utilities.rng.nextInt(Simulation.SIZE);
		yc = Utilities.rng.nextInt(Simulation.SIZE);	
	}
	
	//command methods
	public synchronized void start() {
		state = AgentState.READY;
		if (thread == null) {
			thread = new Thread(this, name);
		}
		thread.start();
	}
	
	public synchronized void suspend() { 
		state = AgentState.SUSPENDED; 
	}
	
	public synchronized void resume() {
		if (!isStopped()) {
			state = AgentState.READY;
			notify();
		}
	}
	
	public synchronized void stop() {
		state = AgentState.STOPPED; 
	}
	
	public synchronized boolean isStopped() { 
		return state == AgentState.STOPPED; 
	}
	
	public synchronized boolean isSuspended() {
		return state == AgentState.SUSPENDED;  
	}
	
	//getters
	public int getXc() {
		return xc;
	}

	public int getYc() {
		return yc;
	}
	public Simulation getWorld() {
		return world;
	}
	
	public synchronized Heading getHeading() { 
		return heading; 
	}
	
	//setters
	public void setWorld(Simulation simulation) {
		world = simulation;
	}
	public void setHeading(Heading heading) {
		this.heading = heading;
	}
	
	public synchronized void join() throws InterruptedException {
		if (thread != null) 
			thread.join();
	}
	
	//public synchronized String toString() { return name + ".state = " + state; }
	
	//abstract method for customization
	public abstract void update();
	
	public void run() {
		//thread = Thread.currentThread(); // catch my thread
		while(!isStopped()) {
			state = AgentState.RUNNING;
			update();
			try {
				Thread.sleep(100); // be cooperative
				synchronized(this) {
					while(isSuspended()) { 
						wait(); 
					}
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	//moving 
	protected void move(int steps) {
		if(heading == Heading.EAST) {
			xc += steps;
			if(xc >= Simulation.SIZE) {
				xc = 0;
			}
		}
		else if(heading == Heading.WEST) {
			xc -= steps;
			if(xc <= 0) {
				xc = Simulation.SIZE;
			}
		}
		else if(heading == Heading.NORTH) {
			yc += steps;
			if(yc >= Simulation.SIZE) {
				yc = 0;
			}
		}
		else {
			yc -= steps; 
			if(yc <= 0) {
				yc = Simulation.SIZE;
			}
		}
		world.changed();
	}

	public double distance(Agent agent) {
		double xdistance = this.xc - agent.xc;
		double ydistance = this.yc - agent.yc;
		double dist = Math.sqrt(xdistance*xdistance + ydistance*ydistance);
		return dist;
	}
	

}

