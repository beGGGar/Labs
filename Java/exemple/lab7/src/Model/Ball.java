/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author 8200608
 */
import java.awt.*;
import java.util.*;

public class Ball extends Rectangle implements Runnable{ //класс мяча для игры

    Random random; //рандомайзер
    public int xVelocity; //движение по горизонтали
    public int yVelocity; //движение по вертикали
    public int initialSpeed = 3; //скорость

//конструктор
   public Ball(int x, int y, int width, int height){
        super(x,y,width,height); //делаем прямоугольник
        random = new Random();
        int randomXDirection = random.nextInt(2); //выбираем случайно 0 или 1
        if(randomXDirection == 0) //если выпал 0, меняем на -1
            randomXDirection--;
        setXDirection(randomXDirection*initialSpeed); //задаем движение влево или вправо

        int randomYDirection = random.nextInt(2); //выбираем случайно 0 или 1
        if(randomYDirection == 0) //если выпал 0, меняем на -1
            randomYDirection--;
        setYDirection(randomYDirection*initialSpeed); //задаем движение вверх или вниз
    }

//изменение движения по горизонтали
    public void setXDirection(int randomXDirection) {
        xVelocity = randomXDirection;
    }

//изменение движения по вертикали
    public void setYDirection(int randomYDirection) {
        yVelocity = randomYDirection;
    }

//движение
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }

//прорисовка мяча на экране
    public void draw(Graphics g) {
        g.setColor(Color.red);
        g.fillOval(x, y, height, width); //закрашиваем круг в рамках прямоугольника
    }

    @Override
    public void run() {
    }
}