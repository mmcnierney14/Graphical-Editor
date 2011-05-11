// MoveCmd.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information to move a shape around the drawing.

import java.awt.*;

public class MoveCmd extends Command {
	private Shape s;						// Holds the shape that is clicked.
	private int centerOffsetX;	// Holds the distance from the click point to the
															// center of the circle.
	private int centerOffsetY;	// Holds the distance from the click point to the
															// center of the circle.
	
	/**
	 * On press, get the frontmost shape, and calculate the offsets
	 */
	public void executePress(Point p, Drawing dwg) {
		s = dwg.getFrontmostContainer(p);
		if (s != null) {
			centerOffsetX = p.x - s.getCenter().x;
			centerOffsetY = p.y - s.getCenter().y;
		}
	}
	
	/**
	 * On drag, move the shape relative to the offsets
	 */
	public void executeDrag(Point p, Drawing dwg) {
		if (s != null) {
			s.setCenter(new Point(p.x-centerOffsetX,p.y-centerOffsetY));
		}
	}
}