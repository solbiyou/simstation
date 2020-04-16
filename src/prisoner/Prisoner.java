/**
 * Edit History 
 * 4/15 Katrina Slivkoff implemented the getters/setters and update method
 */

package prisoner;

import mvc.Utilities;
import simstation.*;

public class Prisoner extends Agent {

	private int fitness = 100;
	private Strategy strategy;
	private boolean cooperate;

	public Prisoner() {
		super("PDT");
		strategy = new AlwaysCooperate();
		cooperate = false;
	}

	public int getFitness() {
		return fitness;
	}

	public void increaseFitness(int num) {
		fitness = fitness + num;
	}

	public void addCooperate(boolean b){
		cooperate = b;
	}

	public boolean getCooperate(){
		return cooperate;
	}

	public boolean cooperate() {
		return strategy.cooperate();
	}

	public void setStrategy(Strategy s) {
		strategy = s;
	}
	
	public String getStrategyType() {
		return strategy.getStrategyType();
	}

	@Override
	public void update() {
		Prisoner neighbor = (Prisoner)this.getWorld().getNeighbor(this, 15);

		if(neighbor != null) {		
			boolean prisoner1 = cooperate();
			boolean prisoner2 = neighbor.cooperate();

			if(prisoner1 && prisoner2){
				increaseFitness(3);
				neighbor.increaseFitness(3);
			}
			else if(!prisoner1 && prisoner2){
				increaseFitness(5);
				neighbor.increaseFitness(0);
			}
			else if(prisoner1 && !prisoner2){
				increaseFitness(0);
				neighbor.increaseFitness(5);
			}
			else{
				increaseFitness(1);
				neighbor.increaseFitness(1);
			}

			addCooperate(prisoner2);
			neighbor.addCooperate(prisoner1);
		}
		
		setHeading(Heading.random());
		move(Utilities.rng.nextInt(6) + 1);
	}
	
}
