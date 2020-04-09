/**
 * Edit History
 * 4/7 edited by Solbi You
 */
package simstation;

import mvc.*;
import java.util.*;

public class Simulation extends Model {
	public static int SIZE = 250;
	protected List<Agent> agents;
	private int clock;
	private Timer timer;
	
	public Simulation() {
		agents = new LinkedList<Agent>();
		clock = 0;
	}
	
	public void addAgent(Agent a) {
		agents.add(a);
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