package Controller;

import Model.*;
import javax.swing.*;

import java.awt.*;
import  java.awt.event.*;

public class GamePanel extends JPanel implements Runnable{
    static final int Width = 1280;
    static final int Height = 720;
    static final Dimension ScreenSize = new Dimension(Width, Height);
    static final int BallSize = 10;
    static final int RacketWidth = 10;
    static final int RacketHeight = 75;
    static final int TotalScore = 5;

    Image image;
    Graphics graphics;

    Racket racket1;
    Racket racket2;
    Ball ball;
    Score score;

    Thread gameThread;
    Thread BallThread;
/**
 * Создание потока для логики игры, запуск ракеток, мяча, счета
 */
    public GamePanel(){
        newRackets();
        newBall();
        score = new Score(Width,Height);
        this.setFocusable(true);
        this.addKeyListener(new AListener());
        this.setPreferredSize(ScreenSize);

        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Создание нового мяча и потока для него
     */
    public void newBall(){
        ball = new Ball((Width/2 - BallSize/2), (Height/2-BallSize/2), BallSize,BallSize);
        BallThread = new Thread(ball);
        BallThread.start();
    }
    
    /**
     * Создание новых равкето и потоков для них
     */
    public void newRackets(){
        racket1 = new Racket(0,(Height/2)-(RacketHeight/2), RacketWidth, RacketHeight,1);
        racket2 = new Racket(Width-RacketWidth ,(Height/2)-(RacketHeight/2), RacketWidth, RacketHeight,2);
    }
    /**
     * Зарисовывание игрового поля
     */
    public void paint(Graphics g){
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }
    /**
     * Зарисовывание объектов на игровом поле
     * @param g
     */
    public void draw(Graphics g){
        racket1.draw(g);
        racket2.draw(g);
        ball.draw(g);
        score.draw(g);
    }
    
    /**
     * Движение ракеток и мяча в данный момент
     */
    public void move(){
        racket1.move();
        racket2.move();
        ball.move();
    }
    
    /**
     * Проверка коллизий для игрового поля
     * Позволяет мячу отскакивать от верхней и нижней стенок и не дает ракеткам выходить за границы экрана
     * Увеличивает счет при касании мяча правой или левой стенки
     */
    public void checkCollision(){
        if(ball.y<=0){
            ball.setYDirection(-ball.getySpeed());
        }
        if(ball.y > Height - BallSize){
            ball.setYDirection(-ball.getySpeed());
        }

        if(ball.intersects(racket1)) {
            ball.setxSpeed(Math.abs(ball.getxSpeed()));
            ball.setXDirection(ball.getxSpeed());
        }
        if(ball.intersects(racket2)) {
            ball.setxSpeed(Math.abs(ball.getxSpeed()));
            ball.setXDirection(-ball.getxSpeed());
        }

        if(ball.x<=0){
            score.player2++;
            newRackets();
            newBall();
        }

        if(ball.x>=Width-BallSize){
            score.player1++;
            newRackets();
            newBall();
        }

        if(racket1.y<=0){
            racket1.y=0;
        }
        if(racket1.y>=(Height-RacketHeight)){
            racket1.y = Height-RacketHeight;
        }
        if(racket2.y<=0){
            racket2.y=0;
        }
        if(racket2.y>=(Height-RacketHeight)){
            racket2.y = Height-RacketHeight;
        }
    }
    
    /**
     * Запуск логики игры
     * Задается дельта - число через которое будет обноавляться поле и считываться колизии объектов
     * Проверка на условие победы одной из сторон
     */
    
    @Override
    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 30.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;
        while(score.player1 < TotalScore && score.player2 < TotalScore){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta>=1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
        if (score.player1 == TotalScore) {
            int answer = JOptionPane.showConfirmDialog(null, "Winner - Player 1!!!\n" +
                    "Restart?", "Finish", JOptionPane.YES_NO_OPTION);
            if (answer == 0)
            {
                restart();
                run();
            }
            else
                System.exit(0);
        

        }
        if (score.player2 == TotalScore) {
            int answer = JOptionPane.showConfirmDialog(null, "Winner - Player 2!!!\n" +
                    "Restart?", "Finish", JOptionPane.YES_NO_OPTION);
            if (answer == 0) {
                restart();
                run();
            }
            else
                System.exit(0);
            
        }
    }


    /**
     * Перезапуск игры
     * Обнуление счета и обновление ракетов и мяча на нулевое положение
     */
    
    public void restart() {
        score.player1 = 0;
        score.player2 = 0;
        newRackets();
        newBall();
    }

    public class AListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){
            racket1.keyPressed(e);
            racket2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e){
            racket1.keyReleased(e);
            racket2.keyReleased(e);
        }
    }
}

