/**
 * Edit History
 * 
 */
package boid;

import simstation.*;
import mvc.*;

public class BoidFactory extends SimulationFactory{
	public Model makeModel() {
		return new BoidSimulation();
	}
	
}
