/**
 * Edit History
 * 4/12 Solbi You Update BoidSimulation.java
 */
package boid;
import mvc.AppPanel;
import simstation.*;

public class BoidSimulation extends Simulation {
	public void populate() {
		//super.populate();
		for(int i = 0; i < 50; i++) {
			addAgent(new Boid());
		}
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new BoidFactory());
		panel.display();
	}
}
