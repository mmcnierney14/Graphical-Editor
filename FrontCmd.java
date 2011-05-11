// FrontCmd.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information to move a shape to the front of the drawing.

import java.awt.*;

public class FrontCmd extends Command {
	
	/**
	 * On click, move the frontmost shape clicked to the front of the drawing.
	 */
	public void executeClick(Point p, Drawing dwg) {
		dwg.moveToFront(dwg.getFrontmostContainer(p));
	}
}