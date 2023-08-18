package Main;

import Log.ErrMsgLog;
import View.View;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.logging.Level;

/**
 * контроллер. Обработка входящих данных, передача их в модели
 * @author vdmoi
 */
public class AppStates {
    private static final String ApplicationPropertiesPath = "Main/application.properties";
    private static String nameProperty = "";
    private static String passwordProperty = "";
    private static boolean debug = false;
    private static LocalTime time;
    
    public static void appStart(){
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
        @Override
        public void run() {
            appStop();
        }
    }, "Shutdown-thread"));
        //первичная настройка приложения
        try{
            System.getProperties().load(ClassLoader.getSystemResourceAsStream(ApplicationPropertiesPath));
            nameProperty = System.getProperty("name");
            passwordProperty = System.getProperty("password");
            debug = Boolean.parseBoolean(System.getProperty("debug"));
            
            if (debug){
                ErrMsgLog.autoConf();
                time = LocalTime.now();
                ErrMsgLog.log.log(Level.FINE, "{0}:{1}:{2}:{3} App start", new Object[]{time.getHour(), time.getMinute(), time.getSecond(), time.getNano()});
            }
        }catch(java.io.IOException e){
            System.out.println(e);
        }
    }
    
    public static void appStop(){
        time = LocalTime.now();
        if (debug)ErrMsgLog.log.log(Level.FINE, "{0}:{1}:{2}:{3} App stop", new Object[]{time.getHour(), time.getMinute(), time.getSecond(), time.getNano()});
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
                    ErrMsgLog.log.log(Level.INFO, "{0}:{1}:{2}:{3}:{4} Guest_coming", new Object[]{time.getHour(), time.getMinute(), time.getSecond(), time.getNano(), time.getNano()});
                    break;
                }else {
                    System.out.println("Enter your password");
                    Password = reader.readLine();
                    if (UserName.equals(nameProperty) && Password.equals(passwordProperty)) {
                        View.helloUser(UserName);
                        time = LocalTime.now();
                        ErrMsgLog.log.log(Level.INFO, "{0}:{1}:{2}:{3}:{4} Login: {5}", new Object[]{time.getHour(), time.getMinute(), time.getSecond(), time.getNano(), time.getNano(), nameProperty});
                        break;
                    
                    } else {
                        System.out.println("Authorization attempt failed. Try again");
                        time = LocalTime.now();
                        ErrMsgLog.log.log(Level.INFO, "{0}:{1}:{2}:{3}:{4} Failed loggin attempt", new Object[]{time.getHour(), time.getMinute(), time.getSecond(), time.getNano(), time.getNano()});
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
                
        }
    }
}
