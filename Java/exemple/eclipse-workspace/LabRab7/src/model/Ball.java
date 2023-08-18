package model;

import java.awt.*;
import java.util.*;

/**
 * Класс мяча, которым будет производиться игра, 
 * наследуется от прямоугольника для удобства отслеживания координат
 * @author Разноглазов Никита ПИН-24
 *
 */

public class Ball extends Rectangle implements Runnable{
    Random random;
    protected int xSpeed;
    protected int ySpeed;
    int moreSpeed = 10;
    public Ball(int x, int y, int width, int height){
        super(x,y,width,height);
    }
    /**
     * Задание направления скорости по оси х
     * @param randomXDirection
     */
    public void setXDirection(int randomXDirection){
        setxSpeed(randomXDirection);
    }
    /**
     * Задание направления скорости по оси y
     * @param randomYDirection
     */
    public void setYDirection(int randomYDirection){
        setySpeed(randomYDirection);
    }

    /**
     * Функция движения мяча, которая изменяет его координаты на размер скорости
     */
    public void move(){
        x += getxSpeed();
        y += getySpeed();
    }
    /**
     * Функция изображения мяча
     * @param g
     */
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x,y,height,width);
    }

    
    /**
     * Функция начала игры с мячом, задающая направление мяча в рандомное место
     */
    @Override
    public void run() {
        random = new Random();
        int randomXDirection = random.nextInt(2);
        if(randomXDirection == 0) {
            randomXDirection--;
        }
        setXDirection(randomXDirection*moreSpeed);
        
        int randomYDirection = random.nextInt(2);
        if(randomYDirection == 0) {
            randomYDirection--;
        }
        setYDirection(randomYDirection*moreSpeed);
      
    }
	public int getySpeed() {
		return ySpeed;
	}
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	public int getxSpeed() {
		return xSpeed;
	}
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
}
