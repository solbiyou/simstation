/**
 * Edit History
 * 4/7 Solbi You: file created
 * 4/8 Solbi You: add the methods for timer
 * 4/8 Solbi You: add command methods
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
		resumeTimer();
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).resume();
		}
	}
	
	public void stop() {
		for(int i=0; i < agents.size(); i++) {
			agents.get(i).stop();
		}
	}
	
	//empty method that will be specified in subclasses
	public void populate() {
		
	}
	
	//methods for timer
	private void startTimer() {
		timer = new Timer();
		timer.scheduleAtFixedRate(new ClockUpdater(), 1000, 1000);
	}
	
	private void resumeTimer() {
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