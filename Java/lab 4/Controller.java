package Controller;

import View.View;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalTime;
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
    
    public static void authorization(String nameProperty, String passwordProperty, boolean debug){
        try{
            //выполнение программы в соответсвии с полученными property значениями
            //авторизация
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String UserName;
            String Password;
            LocalTime time;
            while(true) {
                System.out.println("Enter your username");
                UserName = reader.readLine();
                if (UserName.equals("")){
                    View.helloGuest();
                    time = LocalTime.now();
                    ErrMsgLog.log.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano()+":"+time.getNano() + " Guest_coming");
                    break;
                }else 
                    System.out.println("Enter your password");
                    Password = reader.readLine();
                    if (UserName.equals(nameProperty) && Password.equals(passwordProperty)) {
                        View.helloUser(UserName);
                        time = LocalTime.now();
                        ErrMsgLog.log.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano()+":"+time.getNano() + " Login: "+ nameProperty);
                        break;

                    } else {
                        System.out.println("Authorization attempt failed. Try again");
                        time = LocalTime.now();
                        ErrMsgLog.log.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano()+":"+time.getNano() + " Failed loggin attempt");
                    }
                }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
