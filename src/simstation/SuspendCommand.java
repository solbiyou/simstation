/**
 * Edit History
 * 4/9 Solbi You: implement execute method
 */
package simstation;

import mvc.*;

public class SuspendCommand extends Command {
	public SuspendCommand(Model model) { super(model); }
	public void execute() {
		Simulation simulation = (Simulation) model;
		simulation.suspend();
	}
}
