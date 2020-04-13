/**
 * Edit History
 * 4/10 Katrina Slivkoff created paint component
 *  
 */
package simstation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import mvc.*;

public class SimulationView extends View {

	private static final long serialVersionUID = 1L;

	public SimulationView(Simulation simulation) {
		super(simulation);
	}

	public void paintComponent(Graphics gc) {
		Simulation simulation = (Simulation)model;
		Color oldColor = gc.getColor();
		gc.setColor(Color.RED);
		List<Agent> list = simulation.getAgents();
		for (Agent agent: list) {
			gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
		}

		gc.setColor(oldColor);
	}
}