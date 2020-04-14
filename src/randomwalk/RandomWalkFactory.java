/**
 * Edit History
 * 4/13 Katrina Slivkoff implemented the make model method
 */
package randomwalk;

import mvc.*;
import simstation.*;

public class RandomWalkFactory extends SimulationFactory {
	public Model makeModel() {
		return new RandomWalkSimulation();
	}
}
