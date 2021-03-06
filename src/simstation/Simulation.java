/**
 * Edit History
 * 4/7 Solbi You: file created
 * 4/8 Solbi You: add the methods for timer
 * 4/8 Solbi You: add command methods
 * 4/9 Solbi You: add getStats method
 * 4/12 Solbi You: set World as add agents
 * 4/13 Solbi You: add changed() method in each commands
 * 4/15 Katrina Slivkoff: changed agents and clock to protected
 */
package simstation;

import mvc.*;
import java.util.*;

public class Simulation extends Model {
	public static int SIZE = 250;
	protected List<Agent> agents;
	protected int clock;
	private Timer timer;
	
	public Simulation() {
		agents = new LinkedList<Agent>();
		clock = 0;
	}
	
	public void addAgent(Agent a) {
		agents.add(a);
		a.setWorld(this);
	}
	
	public synchronized Agent getNeighbor(Agent thisAgent, double dist) {
		Agent neighbor = null;
		boolean found = false;
		int i = Utilities.rng.nextInt(agents.size());
		int start = i;
		
		while (!found) {
			Agent randAgent = agents.get(i);
			if (randAgent != thisAgent && thisAgent.distance(randAgent) < dist) {
				neighbor = randAgent;
				found = true;
			}
			else 
			{
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
		changed();
	}
	
	public void suspend() {
		stopTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).suspend();
		}
		changed();
	}
	
	public void resume() {
		startTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).resume();
		}
		changed();
	}
	
	public void stop() {
		stopTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).stop();
		}
		changed();
	}
	
	public String getStats() {
		String stats;
		stats = "#agents = " + agents.size() + "\nclock = " + clock;
		return stats;
	}
	
	//empty method that will be specified in subclasses
	public void populate() {}
	
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
    		changed();
    	}
    }

	public List<Agent> getAgents() {
		return agents;
	}

	
	
}
