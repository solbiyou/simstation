package prisoner;

import mvc.*;
import simstation.*;

public class PDTFactory extends SimulationFactory {
	public Model makeModel() {
		PDTSimulation prisoner = new PDTSimulation();
		return prisoner;
	}
}
