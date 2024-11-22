package model;

import java.awt.*;
/**
 * Класс счеты игры
 * @author Разноглазов Никита ПИН-24
 *
 */
public class Score extends Rectangle{
    static int GameWidth;
    static int GameHeight;
    public int player1;
    public int player2;

    public Score(int GameWidth, int GameHeight){
        Score.GameWidth = GameWidth;
        Score.GameHeight = GameHeight;
        player1 = 0;
        player2 = 0;
    }
    /**
     * Функция отрисовывания счета
     * @param g
     */
    public void draw(Graphics g){
        g.setColor(Color.BLACK);
        g.setFont(new Font("Console", Font.PLAIN, 60));

        g.drawLine(GameWidth/2,0,GameWidth/2,GameHeight);
        g.drawString(String.valueOf(player1),GameWidth/2-85,50);
        g.drawString(String.valueOf(player2),GameWidth/2+20,50);
    }
}
