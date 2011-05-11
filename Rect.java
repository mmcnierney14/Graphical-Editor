// Rect.java
// Class for a rectangle.

// Written by Matthew McNierney for CS 5 Lab Assignment 3.
// Based on Rect.java by THC

import java.awt.*;

public class Rect extends Shape {
  public int x;				// Leftmost x-coord of rectangle
  public int y;				// Leftmost y-coord of rectangle
  public int width;		// Width of rectangle
  public int height;	// Height of rectangle
  
  /**
   * Constructor. Calls the superclass's constructor to set the color. Sets x,
   * y, width, and height based on the parameters.
   * @param xPos
   * @param yPos
   * @param rectWidth
   * @param rectHeight
   * @param rectColor
   */
  public Rect(int xPos,int yPos,int rectWidth,int rectHeight,Color rectColor) {
  	super(rectColor);
  	x = xPos;
  	y = yPos;
  	width = rectWidth;
  	height = rectHeight;
  }
  
  /**
   * Draws the rectangle.
   */
  public void drawShape(Graphics page) {
  	page.fillRect(x, y, width, height);
  }
  
  /**
   * Returns the center point of the rectangle.
   */
  public Point getCenter() {
  	return new Point(x+width/2,y+height/2);
  }
  
  /**
   * Moves the rectangle relative to deltaX and deltaY
   */
  public void move(int deltaX,int deltaY) {
  	x += deltaX;
  	y += deltaY;
  }
  
  /**
   * Returns whether a given point is within the rectangle
   */
  public boolean containsPoint(Point p) {
  	return
  		p.x >= x &&
  		p.x <= x + width &&
  		p.y >= y &&
  		p.y <= y + height;
  }
}
