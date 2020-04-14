/**
 * Edit History
 * 4/13 Solbi You implemented Plague class. update method not finished yet
 */
package plague;

import boid.Boid;
import mvc.Utilities;
import simstation.*;

public class Plague extends Agent {
	private boolean isInfected;
	private double infectedPct;
	private int steps;
	
	public Plague() {
		super("plague");
		isInfected = false;
		steps = Utilities.rng.nextInt(6) + 1;
	}

	@Override
	public void update() {
		Plague neighbor = (Plague)this.getWorld().getNeighbor(this, 15);
		if (neighbor != null) {
			
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
