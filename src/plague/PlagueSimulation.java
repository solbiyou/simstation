/**
 * Edit History
 * 4/13 Solbi You implemented PlagueSimulation with overriding methods
 * 4/14 Solbi You adjusted number of chances to demonstrate proper infection rate
 * 4/15 Solbi You added initial number of infected agents
 */
package plague;

import mvc.AppPanel;
import simstation.*;

public class PlagueSimulation extends Simulation {
	public static int INITIAL_NUM = 2;		//initial number of infected agents
	public static int VIRULENCE = 50;		//chance of getting infected if the neighbor is infected
	public static int RESISTANCE = 10;		//chance of resisting infection even if the neighbor tries to infect the agent
	public static int AGENT_NUM = 50;		//number of agent the simulation produce
	
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
