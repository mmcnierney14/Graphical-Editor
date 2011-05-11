// ExchangeCmd.java
// Command class to perform an exchange command.

// Written by THC for CS 5 Lab Assignment 3.

import java.awt.*;

public class ExchangeCmd extends Command {
  private Shape firstShape; // the first Shape clicked

  // When the mouse is clicked, find the frontmost Shape in the
  // drawing that contains the mouse position.  If there is such a
  // Shape, then if this is the first click in the pair of clicks
  // (indicated by firstShape being null), save it in firstShape.
  // Otherwise, exchange the centers of this newly clicked Shape and
  // firstShape.
  public void executeClick(Point p, Drawing dwg) {
    // Find the frontmost shape containing p.
    Shape s = dwg.getFrontmostContainer(p);
    
    if (s != null) { // was there a Shape containing p?
      if (firstShape == null)
        firstShape = s; // save this Shape for when there's another click
      else {
        // We have two Shapes to exchange.  Get their centers.
        Point firstCenter = firstShape.getCenter();
        Point secondCenter = s.getCenter();

        // Exchange their centers.
        firstShape.setCenter(secondCenter);
        s.setCenter(firstCenter);

        // Now we get to start all over.
        firstShape = null;
      }
    }
  }
}
