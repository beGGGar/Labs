package controller;

import view.FramePingPong;
import view.View;

/**
 * Main часть прогаммы
 * 
 * @author Nikita Raznoglazov PIN-24
 *
 */
public class Main {

    private static FramePingPong game;

    /**
     * Запуск игры в ПингПонг
     */
    static void modelDefineGame(){
        game = new FramePingPong();
    }
    
    /**
     * Исполнение программы
     * @param args
     */
    public static void main(String[] args){
         modelDefineGame();
     
    }
}
