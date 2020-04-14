/**
 * Edit History
 * 4/13 Solbi You implemented Plague class. update method not finished yet
 * 4/13 Solbi You finished update method
 */
package plague;

import mvc.Utilities;
import simstation.*;

public class Plague extends Agent {
	private boolean isInfected;
	public static double infectedPct = 0;
	private int steps;
	
	public Plague() {
		super("plague");
		int randPctNum = Utilities.rng.nextInt(100) + 1;
		if(randPctNum < PlagueSimulation.VIRULENCE) {
			isInfected = true;
			synchronized(this) {
				Plague.infectedPct += (double)100/PlagueSimulation.AGENT_NUM;
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
		if (neighbor != null && neighbor.isInfected) {
			if(!isInfected) {
				synchronized(this) {
					Plague.infectedPct += (double)100/PlagueSimulation.AGENT_NUM;
				}
			}
			isInfected = true;
			if(randPctNum < PlagueSimulation.RESISTANCE && !neighbor.isInfected()) {
				isInfected = false;
				synchronized(this) {
					Plague.infectedPct -= (double)100/PlagueSimulation.AGENT_NUM;
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
