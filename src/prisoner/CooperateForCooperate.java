/**
 * Edit History
 * 4/15 Katrina Slivkoff created the CooperateForCooperate that implements Strategy
 */
package prisoner;

public class CooperateForCooperate implements Strategy {

	private Prisoner owner;
	
	public CooperateForCooperate(Prisoner owner) { 
		this.owner = owner; 
	}

	@Override
	public boolean cooperate() {
		boolean cooperateHistory = owner.getCooperate();

		if(cooperateHistory) {
			return true;
		}

		return false;
	}

	public String getStrategyType() {
		return "Cooperate if other Cooperates";
	}

}
