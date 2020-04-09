/**
 * Edit History
 * 4/7 Solbi You: created
 * 4/8 Solbi You: update move method
 * 4/9 Solbi You: add distance method
 */
package simstation;

import java.io.*;
import java.util.*;

import mvc.*;

abstract class Agent implements Runnable, Serializable {
	private String name;
	private AgentState state;
	private Thread thread;
	private Heading heading;
	private Simulation world;
	private Integer xc, yc;

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
	public String getName() { 
		return name; 
	}
	
	public synchronized AgentState getState() { 
		return state; 
	}
	
	public synchronized Heading getHeading() { 
		return heading; 
	}
	
	public synchronized void join() throws InterruptedException {
		if (thread != null) thread.join();
	}
	
	public synchronized String toString() { return name + ".state = " + state; }
	
	//abstract method for customization
	public abstract void update();
	
	public void run() {
		thread = Thread.currentThread(); // catch my thread
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
	void move(int steps) {
		if(heading == Heading.EAST) {
			xc += steps;
		}
		else if(heading == Heading.WEST) {
			xc -= steps;
		}
		else if(heading == Heading.NORTH) {
			yc += steps;
		}
		else {
			yc -= steps; 
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

