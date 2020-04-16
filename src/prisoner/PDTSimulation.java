package prisoner;

import mvc.AppPanel;
import simstation.*;

public class PDTSimulation extends Simulation {

	public PDTSimulation() {
		super();
	}

	public void populate(){
		int numOfAgents = 20;

		for(int i = 0; i < numOfAgents; i++) {
			Prisoner p = new Prisoner();
			p.setStrategy(new AlwaysCheat());
			addAgent(p);
		}

		for(int j = 10; j < numOfAgents; j++){
			Prisoner p = new Prisoner();
			p.setStrategy(new AlwaysCooperate());
			addAgent(p);
		}


		for(int k = 20; k < numOfAgents; k++){
			Prisoner p = new Prisoner();
			p.setStrategy(new CooperateForCooperate(p));
			addAgent(p);
		}


		for(int l = 30; l < numOfAgents; l++){
			Prisoner p = new Prisoner();
			p.setStrategy(new RandomlyCooperate());
			addAgent(p);
		}

		changed();
	}

	@Override
	public String getStats() {
		return null;
	}

	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PDTFactory());
		panel.display();
	}
}
