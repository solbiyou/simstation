/**
 * Edit History 
 * 4/15 Katrina Slivkoff created the AlwaysCheat class that implements Strategy
 * 
 */

package prisoner;

public class AlwaysCheat implements Strategy {
	
	@Override
	public boolean cooperate() {
		return false;
	} 
	
	public String getStrategyType() {
		return "Always Cheat";
	}
	
}
