/**
 * Edit History 
 * 4/15 Katrina Slivkoff implemented the populate method and stats method
 */

package prisoner;

import mvc.AppPanel;
import simstation.*;

public class PDTSimulation extends Simulation {

	public static int STRATEGIES = 4;	
	public static int COOPERATIVE = 3;	
	public static int CHEAT = 1;	
	public static int WIN = 5;			
	public static int LOSE = 0;			

	private ArrayList<String> strategyTypes;	


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

		for(int j = 0; j < numOfAgents; j++){
			Prisoner p = new Prisoner();
			p.setStrategy(new AlwaysCooperate());
			addAgent(p);
		}


		for(int k = 0; k < numOfAgents; k++){
			Prisoner p = new Prisoner();
			p.setStrategy(new CooperateForCooperate(p));
			addAgent(p);
		}


		for(int l = 0; l < numOfAgents; l++){
			Prisoner p = new Prisoner();
			p.setStrategy(new RandomlyCooperate());
			addAgent(p);
		}

		changed();
	}

	@Override
	public String getStats() {
		double[] count = new double[STRATEGIES];
		double[] totalScore = new double[STRATEGIES];
		ArrayList<String> average = new ArrayList<String>();

		strategyTypes = new ArrayList<String>();
		strategyTypes.add("Cooperator's average = ");
		strategyTypes.add("Cheater's average = ");
		strategyTypes.add("Random's average = ");
		strategyTypes.add("Reciprocator's average = ");		

		for (Agent a: agents) {
			Prisoner prisoner = (Prisoner)a;
			String type = prisoner.getStrategyType();

			if (type == "Always Cooperate") {
				count[0]++;
				totalScore[0] += prisoner.getFitness();
			} 
			else if (type == "Always Cheat") {
				count[1]++;
				totalScore[1] += prisoner.getFitness();		
			} 
			else if (type == "Randomly Cooperate") {
				count[2]++;
				totalScore[2] += prisoner.getFitness();
			} 
			else if(type == "Cooperate if other Cooperates"){
				count[3]++;
				totalScore[3] += prisoner.getFitness();
			} 
		}

		for (int i = 0; i < strategyTypes.size(); i++) {
			double temp = totalScore[i] / count[i];

			String printAverage = strategyTypes.get(i) + temp + "\n";
			average.add(printAverage);
		}

		return "#agents = " + getAgents().size() + "\nclock = " + clock + "\n" + average.get(0) + average.get(1) + average.get(2) + average.get(3);
	}

	public static void main(String[] args) {
		AppPanel panel = new SimulationPanel(new PDTFactory());
		panel.display();
	}
}
