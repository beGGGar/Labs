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
    private static final String DataBasePath = "notes.txt";
    private static final String ApplicationPropertiesPath = "Controller/application.properties";
    
    public static void main(String args[]) throws IOException {
        LocalTime time;
        //настройка логов для текста 
        ErrMsgLog.autoConf();
        //Получение предварительных настроек
        System.getProperties().load(ClassLoader.getSystemResourceAsStream(ApplicationPropertiesPath));
        String nameProperty = System.getProperty("name");
        String passwordProperty = System.getProperty("password");
        boolean debug = Boolean.valueOf(System.getProperty("debug"));

        //выполнение программы в соответсвии с полученными property значениями
        //авторизация
        //Controller.authorization(nameProperty, passwordProperty, debug);
        int maxDegree = 4;
        for (int i = 0; i<maxDegree; i++){
            HumanCollection.RunTimeArrayList((int)Math.pow(10, i+1), i+1);
            HumanCollection.RunTimeLinkedList((int)Math.pow(10, i+1), i+1+maxDegree);
        }
        time = LocalTime.now();
        if (debug)ErrMsgLog.log.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" End ");
    }
}