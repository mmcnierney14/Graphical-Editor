// DeleteCmd.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to delete a shape from the drawing

import java.awt.*;

public class DeleteCmd extends Command {
	
	/**
	 * On click, remove the frontmost shape from the drawing.
	 */
	public void executeClick(Point p, Drawing dwg) {
		dwg.removeShape(dwg.getFrontmostContainer(p));
	}
}