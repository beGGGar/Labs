/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Human;
import java.util.Random;

/**
 *
 * @author vdmoi
 */
public class HumanRandomizer {
    private static final Random sRandom = new Random();
    private static final char[] sAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final int sLength = sAlphabet.length;
    
    
    /** 
     * @return String
     */
    public static String getRandomName() {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s = s + sAlphabet[sRandom.nextInt(sLength)];
        }
        return s;
    }
    
     /**
     * генератор возраста
     * @return 
     */
    public static int getRandomAge() {
        return (int) (Math.random() * 81) + 18;
    }
    
    
    /** 
     * @param max
     * @return int
     */
    public static int getRandomInt(int max){
        return (int) (Math.random() * max);
    }
    
    /**
     * возвращает случайное значение из enum Sex
     * @return 
     */
    public static Human.Sex getRandomSex() {
        return Human.Sex.values()[new Random().nextInt(Human.Sex.values().length)];
    }
}
