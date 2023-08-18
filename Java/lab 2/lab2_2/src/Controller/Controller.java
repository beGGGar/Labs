package Controller;

import java.util.Scanner;
import View.View;
import java.util.Random;
import Model.*;
import java.util.ArrayList;
/**
 * контроллер. Обработка входящих данных, передача их в модели
 * @author vdmoi
 */
public class Controller {
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
