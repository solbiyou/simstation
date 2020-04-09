/**
 * Edit History
 * 4/7 Solbi You: file created
 * 4/8 Solbi You: add the methods for timer
 * 4/8 Solbi You: add command methods
 * 4/9 Solbi You: add getStats method
 */
package simstation;

import mvc.*;
import java.util.*;

public class Simulation extends Model {
	public static int SIZE = 250;
	private List<Agent> agents;
	private int clock;
	private Timer timer;
	
	public Simulation() {
		agents = new LinkedList<Agent>();
		clock = 0;
	}
	
	public void addAgent(Agent a) {
		agents.add(a);
	}
	
	public synchronized Agent getNeighbor(Agent thisAgent, double radius) {
		Agent neighbor = null;
		boolean found = false;
		int i = Utilities.rng.nextInt(agents.size());
		int start = i;
		
		while (!found) {
			Agent candidate = agents.get(i);
			if (candidate != thisAgent && thisAgent.distance(candidate) < radius) {
				neighbor = agents.get(i);
				found = true;
			} 
			else {
				i = (i + 1) % agents.size();
				//if it went through all the agents
				if (i == start) 
					break;
			}
		} 
		return neighbor;
	}
	
	//command methods
	public void start() {
		startTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).start();
		}
	}
	
	public void suspend() {
		stopTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).suspend();
		}
	}
	
	public void resume() {
		startTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).resume();
		}
	}
	
	public void stop() {
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).stop();
		}
	}
	
	public String getStats() {
		String stats;
		stats = "#agents = " + agents.size() + "\nclock = " + clock;
		return stats;
	}
	
	//empty method that will be specified in subclasses
	public void populate() {
		
	}
	
	//methods for timer
	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}

    private void stopTimer() {
    	timer.cancel();
    	timer.purge();
    }

    private class ClockUpdater extends TimerTask {
    	public void run() {
    		clock++;
    		//changed();
    	}
    }

	
	
}