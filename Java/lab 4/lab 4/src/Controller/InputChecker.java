/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Scanner;

/**
 *
 * @author vdmoi
 */
public class InputChecker {
    /**
     * получение целого положительного числа
     * @return 
     */
    static public int getInt() {
        int res;
        Scanner in;
        while (true) {
            in = new Scanner(System.in);
            try {
                res = in.nextInt();
                if(res >= 0) {
                return res;
                } 
                else {System.out.println("Error, try again");}
            } catch (Exception e) {
                System.out.println(e + " try again");
            }
        }
    }
}
