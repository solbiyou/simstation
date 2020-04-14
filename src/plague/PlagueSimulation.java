/**
 * Edit History
 * 4/13 Solbi You implemented PlagueSimulation with overriding methods
 */
package plague;

import mvc.AppPanel;
import simstation.*;

public class PlagueSimulation extends Simulation {
	public static int VIRULENCE = 50;
	public static int RESISTANCE = 2;
	
	public void populate() {
		for(int i = 0; i < 50; i++) {
			addAgent(new Plague());
		}
	}
	
	public String getStats() {
		String infectiontStat = super.getStats() + "\n%infected: " + ((Plague) getAgents()).getInfectedPct() ; 
		return infectiontStat;
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PlagueFactory());
		panel.display();
	}
}
