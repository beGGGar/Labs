/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.*;
import Model.Paddle;
import Model.Score;
import Model.Ball;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.*;

public class GameFrame extends JFrame implements Runnable{ //окно игры

    static final int GAME_WIDTH = 1000; //ширина игры
    static final int GAME_HEIGHT = (int)(GAME_WIDTH * (0.5555)); //высота игры
    static  final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);
    static final int BALL_DIAMETER = 20; //диаметр мяча
    static final int PADDLE_WIDTH = 25; //ширина ракетки
    static final int PADDLE_HEIGHT = 100; //высота ракетки
    Thread gameThread; //поток игры
    Thread p1Thread; //поток левой ракетки
    Thread p2Thread; //поток правой ракетки
    Thread ballThread; //поток мяча
    Image image; //картинка
    Graphics graphics; //графический компонент
    Random random; //рандомайзер
    Paddle paddle1; //ракетка левого игрока
    Paddle paddle2; //ракетка правого игрока
    Ball ball; //мяч
    static Score score; //счет
    
    

    public GameFrame(){
        
        this.setTitle("Ping Pong Game"); //добавляем заголовок
        this.setResizable(false); //запрещаем изменять размеры окна
        this.setBackground(Color.black); //фон черный
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершение при нажатии на крестик
        this.setSize(GAME_WIDTH, GAME_HEIGHT); //устанавливаем размер окна игры
        this.setLocationRelativeTo(null); //отображение окна по центру экрана
        score = new Score(GAME_WIDTH,GAME_HEIGHT); //добавляем счет с размерами игры
        this.setVisible(true); //делаем видимым
        this.setFocusable(true); //включаем фокус
        this.addKeyListener(new AL()); //добавляем слушателя клавиатуры
        this.setPreferredSize(SCREEN_SIZE); //устанавливаем размер
        newPaddles(); //добавляем ракетки
        newBall(); //добавляем мяч
        gameThread = new Thread(this); //создаем новый поток для игры
        gameThread.start(); //включаем поток
            }

//создание нового мяча
    public void newBall() {
        random = new Random();
//создаем объект мяч в центре поля по ширине и на рандомной высоте
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);
//создаем поток мяча
        ballThread = new Thread(ball);
        ballThread.start();
}

//создание ракеток
    public void newPaddles() {

//создаем ракетку левого игрока слева и в центре по высоте
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);
//создаем поток левой ракеики
        p1Thread = new Thread(paddle1);
        p1Thread.start();
//создаем ракетку правого игрока справа и в центре по высоте
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);
//создаем поток правой ракетки
        p2Thread = new Thread(paddle2);
        p2Thread.start();

    }

//рисуем объекты игры
    @Override
    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image,0,0,this);
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
        Toolkit.getDefaultToolkit().sync(); //синхронизация прорисовки
    }

//движение мяча и ракеток
    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

//проверка столкновения
    public void checkCollision() {
        if(ball.y <=BALL_DIAMETER) { //если мяч сверху за пределами поля
            ball.setYDirection(-ball.yVelocity); //изменить знак движения по вертикали
        }
        if(ball.y >= GAME_HEIGHT-BALL_DIAMETER) { //если мяч снизу за пределами поля
            ball.setYDirection(-ball.yVelocity); //изменить знак движения по вертикали
        }
        if(ball.intersects(paddle1)) { //если мяч пересекается с левой ракеткой
            ball.xVelocity = Math.abs(ball.xVelocity); //устанавливаем движение по горизонтали вправо
        }
        if(ball.intersects(paddle2)) { //если мяч пересекается с правой ракеткой
            ball.xVelocity = -Math.abs(ball.xVelocity);//устанавливаем движение по горизонтали влево
        }
//в случае гола
        if(ball.x <=0) { //если мяч улетел влево
            score.player2++; //добавляем очко правому игроку

            newPaddles(); //создаем новые ракетки
            newBall(); //создаем новый мяч
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER) { //если мяч улетел вправо
            score.player1++; //добавляем очко левому игроку

            newPaddles(); //создаем новые ракетки
            newBall(); //создаем новый мяч
        }
//ракетки не должны улетать вниз или вверх за пределы поля
        if(paddle1.y<=0)
            paddle1.y=0;
        if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        if(paddle2.y<=0)
            paddle2.y=0;
        if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT))
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
}

//игровой цикл
    @SuppressWarnings("deprecation")
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
        //если кто-то набрал очки для победы, вывести окно конца игры
            if(score.player1 == 3) {
                //через true|false указываю кто победил
                FinishFrame F = new FinishFrame(true);
                p1Thread.interrupt(); //поток левой ракетки
                p2Thread.interrupt(); //поток правой ракетки
                ballThread.interrupt();

                //Thread currentThread = Thread.currentThread();
                //System.out.println(currentThread.getName());

                gameThread.interrupt();
                dispose();
                break;
            }
            if(score.player2 == 3) {
                FinishFrame F = new FinishFrame(false);

                p1Thread.interrupt(); //поток левой ракетки
                p2Thread.interrupt(); //поток правой ракетки
                ballThread.interrupt();

                //Thread currentThread = Thread.currentThread();
                //System.out.println(currentThread.getName());
                gameThread.interrupt();dispose();
                break;
            }
            long now = System.nanoTime();
            delta += (now -lastTime)/ns;
            lastTime = now;
            if(delta >=1) { //если прошел цикл
                move(); //двигаем мяч и объекты
                checkCollision(); //проверяем столкновение
                repaint(); //прорисовка
                delta--;
            }
        }
        //getM();

}

//реакция на использование клавиатуры
    public class AL extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
           paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
            }
        }
   public static void getM(){Thread currentThread = Thread.currentThread();
       System.out.println(currentThread.getName());}
}