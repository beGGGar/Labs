package com.beg_gar.Controller;

import java.util.Random;

public class RandomName {
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
}
