/**
 * Edit History 
 * 4/15 Katrina Slivkoff created the RandomlyCooperate class that implements Strategy
 */

package prisoner;

import java.util.Random;

public class RandomlyCooperate implements Strategy {

	private Random generator = new Random();

	@Override
	public boolean cooperate() {
		return generator.nextBoolean();
	}
	
	public String getStrategyType() {
		return "Randomly Cooperate";
	}
	
}
