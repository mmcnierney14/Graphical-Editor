// Ellipse.java
// Class for an ellipse.

// Helper methods written by THC for CS 5 Lab Assignment 3.
// Modified by Matthew McNierney for CS5 Lab Assignment #3

import java.awt.*;

public class Ellipse extends Shape {
	private int x;			// Leftmost x-coord of ellipse's bounding box
	private int y;			// Leftmost y-coord of ellipse's bounding box
	private int width;	// Width of bounding box
	private int height;	// Height of bounding box

	/**
	 * Constructor. Calls the superclass shape's constructor to set the color.
	 * Initializes x, y, width, and height based on the parameters.
	 * @param xPos
	 * @param yPos
	 * @param boxWidth
	 * @param boxHeight
	 * @param clr
	 */
	public Ellipse(int xPos,int yPos,int boxWidth,int boxHeight,Color clr) {
		super(clr);
		x = xPos;
		y = yPos;
		width = boxWidth;
		height = boxHeight;
	}

	/**
	 * Draws the ellipse.
	 */
	public void drawShape(Graphics page) {
		page.fillOval(x, y, width, height);
	}
	 
	/**
	 * Tests whether a given point is within the ellipse.
	 */
	public boolean containsPoint(Point p) {
		return pointInEllipse(p,x,y,width,height);
	}
	 
	/**
	 * Move the ellipse relative to deltaX and deltaY.
	 */
	public void move(int deltaX, int deltaY) {
		x += deltaX;
		y += deltaY;
	}
	 
	/**
	 * Returns the center Point in the circle.
	 */
	public Point getCenter() {
		return new Point(x+width/2,y+height/2);
	}

  // Helper method that returns whether Point p is in an Ellipse with
  // the given top left corner and size.
  private static boolean pointInEllipse(Point p, int left, int top, int width,
      int height) {
    double a = width / 2.0; // half of the width
    double b = height / 2.0; // half of the height
    double centerx = left + a; // x-coord of the center
    double centery = top + b; // y-coord of the center
    double x = p.x - centerx; // horizontal distance between p and center
    double y = p.y - centery; // vertical distance between p and center

    // Now we just apply the standard geometry formula.  (See CRC,
    // 29th edition, p. 178.)
    return Math.pow(x / a, 2) + Math.pow(y / b, 2) <= 1;
  }
}

