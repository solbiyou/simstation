/**
 * Edit History
 * 4/13 Katrina Slivkoff implemented the populate and main method
 */
package randomwalk;

import mvc.*;
import simstation.*;

public class RandomWalkSimulation extends Simulation{

	public void populate() {
		for(int i = 0; i < 50; i++) {
			addAgent(new RandomWalk());
		}
	}
	
	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new RandomWalkFactory());
		panel.display();
	}
}
