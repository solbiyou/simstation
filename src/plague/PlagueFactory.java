/**
 * Edit History
 * 4/13 Solbi You implemented PlagueFactory by overriding methods
 */
package plague;

import mvc.*;
import simstation.*;

public class PlagueFactory extends SimulationFactory{
	public Model makeModel() {
		PlagueSimulation plague = new PlagueSimulation();
		return plague;
	}
	public View getView(Model model) {
		PlagueView view = new PlagueView((PlagueSimulation) model);
		return view;
	}
	
	
}
