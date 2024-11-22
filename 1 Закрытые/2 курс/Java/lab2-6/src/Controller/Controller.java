package Controller;

import java.util.Scanner;
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
        in = new Scanner(System.in);
        while (true) {
            if(in.hasNextInt()){
                res = in.nextInt();
                if (res >= 0){
                    return res;
                }
                else System.out.println("Необходимо целое значение от 0");
            }
            else{
                System.out.println("Error, try again"); in.close();
            }
            // try {
            //     System.out.println(2);
            //     res = in.nextInt();
            //     if(res >= 0) {
            //         in.close();
            //         System.out.println(3);
            //         return res;
            //     } 
            //     else {
            //         System.out.println("Error, try again"); in.close();
            //         System.out.println(4);
            //     }
            // } catch (Exception e) {
            //     System.out.println(e + " try again");
            // }
        }
    }
}
