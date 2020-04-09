/**
 * Edit History
 * 4/6 Solbi You: file created
 * 4/8 Solbi You: Add random method
 */

package simstation;

import mvc.Utilities;

public enum Heading {
	NORTH, EAST, SOUTH, WEST;
	
	//generating random Heading
	public static Heading random() {
		int random = Utilities.rng.nextInt(4);
		if(random == 0) {
			return NORTH;
		}
		else if(random == 1) {
			return EAST;
		}
		else if(random == 2) {
			return SOUTH;
		}
		else if(random == 3) {
			return WEST;
		}
		else {
			return null;
		}
	}
}
