// Drawing.java
// By Matthew McNierney for CS5 Lab Assignment #3
// Holds various methods for manipulating and storing the shapes in the drawing.

import java.awt.*;
import java.util.ArrayList;

public class Drawing {
	private Color color;							// The current color to draw with
	private ArrayList<Shape> shapes;	// ArrayList holding all of the shapes
	
	/**
	 * Constructor. Initialize the color to the default color and create the
	 * ArrayList to hold the shapes.
	 * @param defaultColor
	 */
	public Drawing(Color defaultColor) {
		color = defaultColor;
		shapes = new ArrayList<Shape>();
	}
	
	/**
	 * Set the color to draw with.
	 * @param clr
	 */
	public void setColor(Color clr) {
		color = clr;
	}
	
	/**
	 * Get the color to draw with.
	 * @return color
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Add a new shape to the ArrayList
	 * @param shape
	 */
	public void addShape(Shape shape) {
		shapes.add(shape);
	}
	
	/**
	 * Draw all of the shapes.
	 * @param g
	 */
	public void draw(Graphics g) {
		for (Shape shape : shapes)
			shape.draw(g);
	}

	/**
	 * Get the front most shape at a given point. Creates a temp array with all
	 * of the shapes at a given point, and returns the last shape in the array.
	 * @param p
	 * @return frontmost shape
	 */
	public Shape getFrontmostContainer (Point p) {
		ArrayList<Shape> shapesAtPoint = new ArrayList<Shape>();
		
		for (int i = 0; i < shapes.size(); i++)
			if (shapes.get(i).containsPoint(p))
				shapesAtPoint.add(shapes.get(i));
		
		return (shapesAtPoint.size() > 0) ? 
				shapesAtPoint.get(shapesAtPoint.size()-1) :
				null;
	}
	
	/**
	 * Removes a shape from the drawing.
	 * @param shape
	 */
	public void removeShape(Shape shape) {
		if (shape != null)
			shapes.remove(shapes.indexOf(shape));
	}
	
	/**
	 * Moves a shape to the front of the drawing.
	 * @param shape
	 */
	public void moveToFront(Shape shape) {
		if (shape != null) {
			removeShape(shape);
			addShape(shape);
		}
	}
	
	/**
	 * Moves a shape to the back of the drawing.
	 * @param shape
	 */
	public void moveToBack(Shape shape) {
		if (shape != null) {
			removeShape(shape);
			shapes.add(0,shape);
		}
	}
	
	/**
	 * Replace the frontmost shape with a new shape.
	 * @param shape
	 */
	public void replaceFront(Shape shape) {
			shapes.remove(shapes.size()-1);
			shapes.add(shape);
	}
	
}