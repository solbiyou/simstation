/**
 * Edit History
 * 4/10 Katrina Slivkoff updated methods makeModel, makePanel, commands, title, help, and about
 * 4/12 Solbi You deleted type attribute
 * 4/13 Solbi You update getView method
 */
package simstation;

import mvc.*;
import plague.PlagueSimulation;
import plague.PlagueView;

public class SimulationFactory implements SimFactory {
	
	//private String type;

	@Override 
	public Model makeModel() { 
		Simulation sim = new Simulation(); 
		return sim;
	}
	/*
	@Override 
	public AppPanel makePanel(AppFactory factory) {
		return new SimulationPanel(factory);
	}
	*/
	@Override 
	public String[] getEditCommands() { 
		String[] editCommands = {"Start", "Suspend", "Resume", "Stop", "Stats"};
		return editCommands; 
	}

	@Override 
	public Command makeEditCommand(Model model, String type) { 
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
		String aboutString = "SimStation Version 1.0 Copyright 2020 by Katrina Slivkoff and Solbi You";
		return aboutString; 
	}
	@Override
	public View getView(Model model) {
		SimulationView view = new SimulationView((Simulation) model);
		return view;
	}
}
