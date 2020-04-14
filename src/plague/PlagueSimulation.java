/**
 * Edit History
 * 4/13 Solbi You implemented PlagueSimulation with overriding methods
 */
package plague;

import mvc.AppPanel;
import simstation.*;

public class PlagueSimulation extends Simulation {
	public static final int VIRULENCE = 50;
	public static final int RESISTANCE = 2;
	public static int AGENT_NUM = 50;
	
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
