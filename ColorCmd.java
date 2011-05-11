// ColorCmd.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds information on how to change the color of an already existing shape

import java.awt.*;

public class ColorCmd extends Command {
	
	/**
	 * On click, if a shape has been clicked, change its color to the Drawing
	 * object's current set color.
	 */
	public void executeClick(Point p, Drawing dwg) {
		Shape clickedShape = dwg.getFrontmostContainer(p);
		if (clickedShape != null)
			clickedShape.setColor(dwg.getColor());
	}
}