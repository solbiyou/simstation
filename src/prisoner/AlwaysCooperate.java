/**
 * Edit History 
 * 4/15 Katrina Slivkoff created the AlwaysCooperate class that implements Strategy
 * 
 */

package prisoner;

public class AlwaysCooperate implements Strategy {

	@Override
	public boolean cooperate() {
		return true;
	} 
	
	public String getStrategyType() {
		return "Always Cooperate";
	}

}
