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

public class Score extends Rectangle{ //класс счет

    static int GAME_WIDTH; //ширина игры
    static int GAME_HEIGHT; //высота игры
    public int player1; //очки левого игрока
    public int player2; //очки правого игрока

//конструктор
    public Score(int GAME_WIDTH, int GAME_HEIGHT){
        Score.GAME_WIDTH = GAME_WIDTH;
        Score.GAME_HEIGHT = GAME_HEIGHT;
    }

//прорисовка счета на экране
    public void draw(Graphics g) {
        g.setColor(Color.white); //цвет
        g.setFont(new Font("Consolas",Font.PLAIN,60)); //шрифт
        g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT); //разделительная линия поля
        g.drawString(String.valueOf(player1), (GAME_WIDTH/2)-85, 100); //очки правого игрока
        g.drawString(String.valueOf(player2), (GAME_WIDTH/2)+20, 100); //очки левого игрока
    }   
}