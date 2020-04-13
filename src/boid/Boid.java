/**
 * Edit History
 * 4/12 Solbi You Update Boid.java
 */
package boid;

import mvc.*;
import simstation.*;

public class Boid extends Agent {
	private int speed;
	
	public Boid() {
		super("boid");
		speed = Utilities.rng.nextInt(6) + 1;
	}
	//public void update
	public void update() {
		Boid neighbor = (Boid)this.getWorld().getNeighbor(this, 15);
		if (neighbor != null) {
			setHeading(neighbor.getHeading());
			speed = neighbor.getSpeed();
		}
		move(speed);
	}
	public int getSpeed() {
		return this.speed;
	}
 }
