package Controller;

import Model.*;
import View.View;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;
/**
 * 
 * @author vdmoi
 */

public class Main {
    public static String DataBasePath = "notes.txt";
    
    public static void main(String args[]) throws IOException {
        ArrayList<Human> humans;
        //генерация нового списка для файла
        //humans = HumanCollection.createRandomHumans(2);
        //HumanCollection.saveToFile(humans, path, false);
        //humans.clear();
        
        //загрузка списка людей из файла
        humans = HumanCollection.loadFromFile(DataBasePath);
        View.printHumans(humans);
        
        //настройка логов для текста 
        ErrMsgLog.errhnd = new FileHandler("src/Controller/Log.txt", true);
        ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
        ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);


        //Получение предварительных настроек
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("Controller/application.properties"));
        String nameProperty = System.getProperty("name");
        String passwordProperty = System.getProperty("password");
        //boolean debugProperty = Boolean.valueOf(System.getProperty("debug"));

        //выполнение программы в соответсвии с полученными property значениями
        //авторизация
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String UserName;
        String Password;
        LocalTime time;
        while (true) {
            System.out.println("Enter your username");
            UserName = reader.readLine();
            if (UserName.equals("")){
                View.helloGuest();
                break;
            }else 
                System.out.println("Enter your password");
                Password = reader.readLine();
                if (UserName.equals(nameProperty) && Password.equals(passwordProperty)) {
                    View.helloUser(UserName);
                    time = LocalTime.now();
                    //ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano()+":"+time.getNano() + " Login: "+ nameProperty);
                    break;
                
                } else {
                    System.out.println("Authorization attempt failed. Try again");
                    time = LocalTime.now();
                    ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano()+":"+time.getNano() + " Failed loggin attempt");
                }
        }
        
        //Сохранения значений в базу данных
        HumanCollection.saveToFile(humans, DataBasePath, false);
        time = LocalTime.now();
        //ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" End ");
    }

}