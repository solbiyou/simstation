/**
 * Edit History
 * 4/13 Solbi You implemented Plague class. update method not finished yet
 * 4/13 Solbi You implemented update method
 * 4/14 Solbi You changed the logic in update method
 * 4/15 Solbi You changed the logic according to the professor's
 */
package plague;

import mvc.Utilities;
import simstation.*;

public class Plague extends Agent {
	private boolean isInfected;
	public static double infectedPct = 0;
	public static int initialInfectionNUm = 0;
	private int steps;
	
	public Plague() {
		super("plague");
		//initial infection for the first INITIAL_NUM of agents
		if(Plague.initialInfectionNUm < PlagueSimulation.INITIAL_NUM) {
			isInfected = true;
			synchronized(this) {
				Plague.initialInfectionNUm++;		
				Plague.infectedPct += (double)100/PlagueSimulation.AGENT_NUM;	//increase the percentage when the agent gets infected
			}
		}
		else {
			isInfected = false;
		}
		steps = Utilities.rng.nextInt(6) + 1;
	}

	@Override
	public void update() {
		Plague neighbor = (Plague)this.getWorld().getNeighbor(this, 15);
		int randPctNum = Utilities.rng.nextInt(100) + 1;
		if (neighbor != null) {
			// if the neighbor is infected and this agent is not yet infected then this agent gets infected unless it resists
			if(!isInfected && neighbor.isInfected && randPctNum > PlagueSimulation.RESISTANCE && randPctNum < PlagueSimulation.VIRULENCE) {
				synchronized(this) {
					Plague.infectedPct += (double)100/PlagueSimulation.AGENT_NUM;	//increase the percentage when the agent gets infected
					isInfected = true;
				}	
			}
		}
		setHeading(Heading.random());
		move(steps);
	}
	
	//getters
	public boolean isInfected() {
		return isInfected;
	}

	public double getInfectedPct() {
		return infectedPct;
	}

	public int getSteps() {
		return steps;
	}

}
