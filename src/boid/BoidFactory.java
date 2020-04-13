/**
 * Edit History
 * 4/12 Solbi You Update BoidFactory.java
 */
package boid;

import simstation.*;
import mvc.*;

public class BoidFactory extends SimulationFactory{
	public Model makeModel() {
		BoidSimulation boid = new BoidSimulation();
		return boid;
	}
}
