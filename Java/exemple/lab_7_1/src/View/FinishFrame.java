/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.GameFrame;
import static javax.swing.GroupLayout.Alignment.LEADING;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import Controller.GameFrame;

public class FinishFrame extends JFrame{
    
   public FinishFrame(boolean F){
        this.setTitle("Game over"); //добавляем заголовок
        this.setResizable(false); //запрещаем изменять размеры окна
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершение при нажатии на крестик
        this.setSize(250, 150); //размер окна
        this.setVisible(true); //делаем видимым
        this.setLocationRelativeTo(null); //отображение окна по центру экрана

//формируем строку для вывода информации о победителе
        String winner;
        if(F) {
            winner = "Player 2 won!";
        }
        else {
            winner = "Player 1 won!";
        }
//создаем и добавляем объект надписи
        JLabel w = new JLabel(winner);
        this.add(w);

//кнопка для начала новой игры
        JButton newgame = new JButton("New game");
        this.add(newgame);

        newgame.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            dispose();
            //System.exit(0);
            GameFrame frame = new GameFrame();
        }
       });

//кнопка для выхода из игры
        JButton finish = new JButton("Exit");
        this.add(finish);

        finish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //System,exit(0) завершает java-процесс в рамках которого живут потоки.
                System.exit(0);
            }
        }   );

//расположение объектов на окне
    GroupLayout layout = new GroupLayout(this.getContentPane());
    this.getContentPane().setLayout(layout);
    layout.setAutoCreateGaps(true);
    layout.setAutoCreateContainerGaps(true);
    layout.setHorizontalGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(LEADING)
        .addComponent(w)
        .addComponent(newgame)
        .addComponent(finish))
        );
    layout.setVerticalGroup(layout.createSequentialGroup()
        .addComponent(w)
        .addComponent(newgame)
        .addComponent(finish)
        );
    }
    }