/**
 * Edit History
 * 4/10 Katrina Slivkoff updated methods makeModel, makePanel, commands, title, help, and about
 */
package simstation;

import mvc.*;

public class SimulationFactory implements AppFactory {
	
	private String type;

	@Override 
	public Model makeModel() { 
		Simulation sim = new Simulation(); 
		return sim;
	}

	@Override 
	public AppPanel makePanel(AppFactory factory) {
		return new SimulationPanel(factory);
	}

	@Override 
	public String[] getEditCommands() { 
		String[] editCommands = {"Start", "Suspend", "Resume", "Stop", "Stats"};
		return editCommands; 
	}

	@Override 
	public Command makeEditCommand(Model model, String command) { 
		if(type == "Start") {
			return new StartCommand(model);
		}else if(type == "Suspend") {
			return new SuspendCommand(model);
		}else if(type == "Resume") {
			return new ResumeCommand(model);
		}else if(type == "Stop") {
			return new StopCommand(model);
		}else if(type == "Stats") {
			return new StatsCommand(model);
		}
		return null;
	}

	@Override 
	public String getTitle() { 
		String titleString = "SimStation"; 
		return titleString; 
	}

	@Override 
	public String[] getHelp() { 
		String[] cmmds = {"Start = start the simulation", "Suspend = suspend the simulation", "Stop = stop the simulation",
			"Stats = displays a dialog box containing the time (in seconds) and the number of birds"};
		return cmmds;
	}

	@Override 
	public String about() { 
		String aboutString = "SimStation Version 1.0 Copyright 2020 by Katrina Slivkoff and Solbi You"; //Set the about return string
		return aboutString; 
	}
}
