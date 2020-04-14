/**
 * Edit History
 * 4/13 Katrina Slivkoff implemented the update method with a random heading and move a random num of steps
 * 
 */
package randomwalk;

import mvc.*;
import simstation.*;

public class RandomWalk extends Agent {

	public RandomWalk() {
		super("random walk");
	}

	public void update() {
		setHeading(Heading.random());
		move(Utilities.rng.nextInt(6) + 1);
	}
}

