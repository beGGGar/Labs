package Controller;

import View.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;

/**
 * контроллер. Обработка входящих данных, передача их в модели
 * @author vdmoi
 */
public class AppStates {
    private static final String ApplicationPropertiesPath = "Controller/application.properties";
    private static String nameProperty = "";
    private static String passwordProperty = "";
    private static boolean debug = false;
    private static LocalTime time;
    
    public static void appStart(){
        try{
            System.getProperties().load(ClassLoader.getSystemResourceAsStream(ApplicationPropertiesPath));
            nameProperty = System.getProperty("name");
            passwordProperty = System.getProperty("password");
            debug = Boolean.valueOf(System.getProperty("debug"));
        }catch(java.io.IOException e){
            System.out.println(e);
        }
        ErrMsgLog.autoConf();
    }
    
    public static void appStop(){
        time = LocalTime.now();
        if (debug)ErrMsgLog.log.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" End ");
    }
      
    public static void authorization(){
        try{
            //выполнение программы в соответсвии с полученными property значениями
            //авторизация
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String UserName;
            String Password;
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
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
