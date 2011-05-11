// Segment.java
// Class for a line segment.

// Helper methods written by THC for CS 5 Lab Assignment 3.
// Written by Matthew McNierney for CS5 Lab Assignment #3

import java.awt.*;

public class Segment extends Shape {
  private int x1;		// Start point x-coord of segment
  private int y1;		// Start point y-coord of segment
  private int x2;		// End point x-coord of segment
  private int y2;		// End point y-coord of segment
  
  private static final int TOLERANCE = 3;

  /**
   * Constructor. Calls the superclass's constructor to set the color. Sets x1,
   * y1, x2, and y2 according to the parameters.
   * @param leftX
   * @param leftY
   * @param rightX
   * @param rightY
   * @param clr
   */
  public Segment(int leftX,int leftY,int rightX,int rightY,Color clr) {
  	super(clr);
  	
  	x1 = leftX;
  	y1 = leftY;
  	x2 = rightX;
  	y2 = rightY;
  }
  
  /**
   * Draw the line segment
   */
  public void drawShape(Graphics page) {
  	page.drawLine(x1, y1, x2, y2);
  }
  
  /**
   * Returns whether a given point is close within the segment's tolerance.
   */
  public boolean containsPoint(Point p) {
  	return
  		almostContainsPoint(p,
  				Math.min(x1,x2),
  				Math.min(y1,y2),
  				Math.max(x2,x1),
  				Math.max(y2,y1),
  				TOLERANCE) &&
  		distanceToPoint(p,x1,y1,x2,y2) <= TOLERANCE;
  }
  
  /**
   * Moves a line relative to deltaX and deltaY
   */
  public void move(int deltaX, int deltaY) {
  	x1 += deltaX;
  	x2 += deltaX;
  	y1 += deltaY;
  	y2 += deltaY;
  }
  
  /**
   * Returns the center point of the line segment
   */
  public Point getCenter() {
  	return new Point((x1+x2)/2,(y1+y2)/2);
  }
  
  
  
  // Helper method that returns true if Point p is within a tolerance
  // of a given bounding box.  Here, the bounding box is given by the
  // coordinates of its left, top, right, and bottom.
  private static boolean almostContainsPoint(Point p, int left, int top,
      int right, int bottom, double tolerance) {
    return p.x >= left - tolerance && p.y >= top - tolerance
        && p.x <= right + tolerance && p.y <= bottom + tolerance;
  }

  // Helper method that returns the distance from Point p to the line
  // containing a line segment whose endpoints are given.
  private static double distanceToPoint(Point p, int x1, int y1, int x2,
      int y2) {
    if (x1 == x2) // vertical segment?
      return (double) (Math.abs(p.x - x1)); // yes, use horizontal distance
    else if (y1 == y2) // horizontal segment?
      return (double) (Math.abs(p.y - y1)); // yes, use vertical distance
    else {
      // Here, we know that the segment is neither vertical nor
      // horizontal.  Compute m, the slope of the line containing the
      // segment.
      double m = ((double) (y1 - y2)) / ((double) (x1 - x2));

      // Compute mperp, the slope of the line perpendicular to the
      // segment.
      double mperp = -1.0 / m;

      // Compute the (x, y) intersection of the line containing the
      // segment and the line that is perpendicular to the segment and
      // that contains Point p.
      double x = (((double) y1) - ((double) p.y) - (m * x1) + (mperp * p.x))
          / (mperp - m);
      double y = m * (x - x1) + y1;

      // Return the distance between Point p and (x, y).
      return Math.sqrt(Math.pow(p.x - x, 2) + Math.pow(p.y - y, 2));
    }
  }
}
