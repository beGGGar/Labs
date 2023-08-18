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
import java.awt.event.*;

public class Paddle extends Rectangle implements Runnable{ //класс ракеток для игры

    public int id; //какому игроку принадлежит ракетка
    public int yVelocity; //движение по вертикали
    public int speed = 15; //скорость движения

//конструктор - обычный прямоугольник, которому присвоен id игрока
    public Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT, int id){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        this.id=id;
}

//действие объекта при нажатии клавиш
public void keyPressed(KeyEvent e) {
    switch(id) {
    case 1: //для левого игрока
        if(e.getKeyCode()==KeyEvent.VK_W) { //при нажатии W двигается вверх
            setYDirection(-speed);
        }
        if(e.getKeyCode()==KeyEvent.VK_S) { //при нажатии S двигается вниз
            setYDirection(speed);
        }
        break;
    case 2: //для правого игрока
        if(e.getKeyCode()==KeyEvent.VK_UP) { //при нажатии стрелки вверх двигается вверх
            setYDirection(-speed);
        }
        if(e.getKeyCode()==KeyEvent.VK_DOWN) { //при нажатии стрелки вних двигается вниз
            setYDirection(speed);
        }
        break;
    }
}

//действие объекта при отпускании клавиш - остановка
    public void keyReleased(KeyEvent e) {
        switch(id) {
        case 1: //для левого игрока
            if(e.getKeyCode()==KeyEvent.VK_W) {
                setYDirection(0);
            }
            if(e.getKeyCode()==KeyEvent.VK_S) {
                setYDirection(0);
            }   
            break;
        case 2: //для правого игрока
            if(e.getKeyCode()==KeyEvent.VK_UP) {
                setYDirection(0);
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN) {
                setYDirection(0);
            }
            break;
    }
}

//изменение движения по вертикали
    public void setYDirection(int yDirection) {
        yVelocity = yDirection;
    }

//движение
    public void move() {
        y= y + yVelocity;
    }

//прорисовка ракетки на экране
    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void run() {
    }
}