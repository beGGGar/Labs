package view;

import javax.swing.*;

import model.GamePanel;

import java.awt.*;
/**
 * Создание и определение окна с игрой
 * @author Разноглазов Никита ПИН-24
 *
 */
public class FramePingPong extends JFrame{
    GamePanel panel;
    public FramePingPong(){
        panel = new model.GamePanel();
        this.add(panel);
        this.setTitle("Ping-Pong Game");
        this.setResizable(false);
        this.setBackground(Color.GREEN);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }
}

