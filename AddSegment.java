// AddSegment.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to add a new line segment to the drawing

import java.awt.*;

public class AddSegment extends Command {
	private Point cp;				// Where the user clicks
	private int numDrags;		// Number of times executeDrag is called
	
	public AddSegment() {
		cp = null;
		numDrags = 0;
	}
	
	/**
	 * On press, get the click point and reset numDrags
	 */
	public void executePress(Point p, Drawing dwg) {
		cp = p;
		numDrags = 0;
	}
	
	/**
	 * On drag, add new shape if it's the first drag, and replace that shape with
	 * a new shape if it's at least the second drag.
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (numDrags == 0) {
			dwg.addShape(new Segment(
					cp.x,
					cp.y,
					p.x,
					p.y,
					dwg.getColor()));
		}
		else {
			dwg.replaceFront(new Segment(
					cp.x,
					cp.y,
					p.x,
					p.y,
					dwg.getColor()));
		}
		numDrags++;
	}
}