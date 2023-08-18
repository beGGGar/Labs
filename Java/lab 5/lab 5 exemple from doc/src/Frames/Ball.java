package Frames;

import java.awt.geom.*;

/**
   A ball that moves and bounces off the edges of a 
   rectangle
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
*/
public class Ball
{
   private static final int XSIZE = 15;
   private static final int YSIZE = 15;
   private double x = 0;
   private double y = 0;
   private double dx = 1;
   private double dy = 1;
   private String Name = "";
   private double[] XY = {0,0};
   
   Ball(int maxX, String Name) {
	   super();
	   x = (double) Math.random()*maxX;
	   XY[0] = x;
	   this.Name = Name;
   }

   /**
      Moves the ball to the next position, reversing direction
      if it hits one of the edges
   */
   public void move(Rectangle2D bounds)
   {
	  //Получаем прямоугольник, для расчета координат перемещения и контроля границ отскока
      x += dx;
      y += dy;
      if (x < bounds.getMinX())
      { 
         x = bounds.getMinX();
         dx = -dx;
      }
      if (x + XSIZE >= bounds.getMaxX())
      {
         x = bounds.getMaxX() - XSIZE; 
         dx = -dx; 
      }
      if (y < bounds.getMinY())
      {
         y = bounds.getMinY(); 
         dy = -dy;
      }
      if (y + YSIZE >= bounds.getMaxY())
      {
         y = bounds.getMaxY() - YSIZE;
         dy = -dy; 
      }
      
      XY[0] = x;
      XY[1] = y;
   }

   /**
      Gets the shape of the ball at its current position.
   */
   public Ellipse2D getShape()
   {
      return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
   }
   
   public double[] getXY() {
	   return XY;
   }
   
   public double getX() {
	   return x;
   }
   
   public double getY() {
	   return y;
   }   
   
   public String getName() {
	   return this.Name;
   }
}
