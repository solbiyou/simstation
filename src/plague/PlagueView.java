/**
 * Edit History
 * 4/13 Solbi You implemented PlagueView to represent two colors for plague
 */
package plague;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import simstation.*;
import mvc.*;

public class PlagueView extends SimulationView {
	public PlagueView(PlagueSimulation plague) {
		super(plague);
	}
	public void paintComponent(Graphics gc) {
		PlagueSimulation simulation = (PlagueSimulation)model;
		Color oldColor = gc.getColor();
		//gc.setColor(Color.RED);
		List<Agent> list = simulation.getAgents();
		for (Agent agent: list) {
			Plague plague = (Plague)agent;
			if(plague.isInfected()) {
				gc.setColor(Color.RED);
			}
			else {
				gc.setColor(Color.GREEN);
			}
			gc.fillOval(agent.getXc(), agent.getYc(), 5, 5);
		}

		gc.setColor(oldColor);
	}
}
