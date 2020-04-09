/**
 * Edit History
 * 4/9 Solbi You: implement execute method
 */
package simstation;
import mvc.*;

public class StartCommand extends Command {
	public StartCommand(Model model) { super(model); }
	public void execute() {
		Simulation simulation = (Simulation) model;
		simulation.start();
	}
}