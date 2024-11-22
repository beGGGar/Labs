package View;

import javax.swing.*;

import Controller.GamePanel;

import java.awt.*;
public class FramePingPong extends JFrame{

    public FramePingPong(){
        GamePanel panel = new GamePanel();
        this.add(panel);
        this.setTitle("Ping-Pong Game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
    }
}

