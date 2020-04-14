/**
 * Edit History
 * 4/13 Solbi You implemented PlagueSimulation with overriding methods
 * 4/14 Solbi You adjusted number of chances to demonstrate proper infection rate
 */
package plague;

import mvc.AppPanel;
import simstation.*;

public class PlagueSimulation extends Simulation {
	public static int VIRULENCE = 10;		//chance of initial infections of the agents 
	public static int RESISTANCE = 50;		//chance of resisting infection even if the neighbor tries to infect the agent
	public static int AGENT_NUM = 50;		//number of agent the simulation producing
	
	public void populate() {
		for(int i = 0; i < AGENT_NUM; i++) {
			addAgent(new Plague());
		}
	}
	
	public String getStats() {
		String infectiontStat = super.getStats() + "\n%infected: " + Plague.infectedPct ; 
		return infectiontStat;
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PlagueFactory());
		panel.display();
	}
}
