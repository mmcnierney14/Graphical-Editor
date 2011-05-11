// BackCmd.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to send a shape to back of the drawing

import java.awt.*;

public class BackCmd extends Command {
	
	/**
	 * On click, move the frontmost shape to the back of the drawing
	 */
	public void executeClick(Point p, Drawing dwg) {
		dwg.moveToBack(dwg.getFrontmostContainer(p));
	}
}