/**
 * Edit History
 * 4/9 Solbi You: implement execute method
 */
package simstation;

import mvc.*;
import javax.swing.*;

public class StatsCommand extends Command {
	public StatsCommand(Model model) { super(model); }
	public void execute() {
		Simulation simulation = (Simulation) model;
		String print = simulation.getStats();
		JOptionPane.showMessageDialog(null, print);
	}
}