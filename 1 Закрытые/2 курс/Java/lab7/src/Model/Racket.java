package Model;

import java.awt.*;
import  java.awt.event.*;

public class Racket extends Rectangle {
    int id;
    int ySpeed;
    int speed = 12;
    public Racket(int x, int y, int RacketWidth, int RacketHeight, int id){
        super(x,y,RacketWidth, RacketHeight);
        this.id=id;
    }
    
    /**
     * Считывание нажатия на клавишы W,S Up,Down
     * @param e
     */
    public void keyPressed(KeyEvent e){
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(speed);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(-speed);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(speed);
                    move();
                }
                break;
        }
    }
    /**
     * Считывание отпускания клавишь W,S Up,Down
     * @param e
     */
    public void keyReleased(KeyEvent e){
        switch (id) {
            case 1:
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    setYDirection(0);
                    move();
                }
                break;
            case 2:
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    setYDirection(0);
                    move();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    setYDirection(0);
                    move();
                }
                break;
        }
    }
    /**
     * Функция определения направления по оси y
     * @param yDirection
     */
    public void setYDirection(int yDirection){
        ySpeed = yDirection;
    }
    /**
     * Функция движения ракетки вверх или вниз
     */
    public void move(){
        y += ySpeed;
    }
    /**
     * Функция отрисовывания ракеток
     * @param g
     */
    public void draw(Graphics g){
        if(id==1){
            g.setColor(Color.blue);
        }
        else g.setColor(Color.WHITE);
        g.fillRect(x,y,width,height);
    }

}