package Frames;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * The component that draws the balls.
 * @version 1.34 2012-01-26
 * @author Cay Horstmann
 * Объект содержит список мячиков добаяляемых методом add и метод paintComponent для перерисовки себя
 * т.е. перерисовки положения всех мячиков
 */
public class BallComponent extends JComponent
{
	
   private static final int DEFAULT_WIDTH = 250;
   private static final int DEFAULT_HEIGHT = 250;

   private java.util.List<Ball> balls = new ArrayList<>();

   /**
    * Add a ball to the panel.
    * @param b the ball to add
    */
   public void add(Ball b)
   {
	   //Добавляем мячик к списку мячиков
	   balls.add(b);
   }

   public void paintComponent(Graphics g)
   {
	  //Рисует все добавленные мячики
      Graphics2D g2 = (Graphics2D) g;
      for (Ball b : balls)
      {
         g2.fill(b.getShape());
         g2.drawString(b.getName(), (int) b.getX(), (int) b.getY());
      }
   }
   
   public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}

