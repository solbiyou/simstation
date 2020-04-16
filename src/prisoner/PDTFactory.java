/**
 * Edit History
 * 4/15 Katrina Slivkoff created the PDTFactory class that extends the SimulationFactory
 */

package prisoner;

import mvc.*;
import simstation.*;

public class PDTFactory extends SimulationFactory {
	public Model makeModel() {
		PDTSimulation prisoner = new PDTSimulation();
		return prisoner;
	}
}
