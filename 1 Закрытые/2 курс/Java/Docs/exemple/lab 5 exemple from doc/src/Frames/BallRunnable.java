package Frames;

import java.awt.Component;

/**
 * A runnable that animates a bouncing ball.
 */
//class BallRunnable implements Runnable
class BallRunnable extends Thread
{
   private Ball ball;
   private Component component;
   public static final int STEPS = 5000;
   public static final int DELAY = 5;
   public volatile boolean suspended;
   //Thread thrd;

   /**
    * Constructs the runnable.
    * @param aBall the ball to bounce
    * @param aComponent the component in which the ball bounces
    */
   public BallRunnable(Ball aBall, Component aComponent)
   {
      ball = aBall; //работаем с конкретным мячиком
      component = aComponent;
      suspended = false;
   }
   
   public BallRunnable(Ball aBall, Component aComponent, boolean ThreadOK)
   {
	  super(aBall.getName());
      ball = aBall; //работаем с конкретным мячиком
      component = aComponent;
      suspended = false;
      start();
      /*
      if(ThreadOK) {
    	  thrd = new Thread(this, ball.getName());
    	  thrd.start();
      }
      */
   }   

   public void run()
   {
      try {
          for (int i = 1; i <= STEPS; i++) {
        	  makeMoving();                    
	    	  synchronized(this) {
	    		  while(suspended) {
	    			  wait();
	    		  }
	    	  }    	  
          }	
      }
      catch (InterruptedException e) {
      }
   }
   
   private synchronized void makeMoving() throws InterruptedException {
          ball.move(component.getBounds());
          component.repaint();
          //thrd.sleep(DELAY);
          sleep(DELAY);
   }
   
   
   public synchronized void setPause() {
	   suspended = true;
	   System.out.println("Заморозить");
   }

   public synchronized void clearPause() {
	   suspended = false;
	   notify();
	   System.out.println("Разморозить");
   }
   
}