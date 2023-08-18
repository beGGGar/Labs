package Log;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.*;
import java.io.File;

/**
 * Класс для обработки исключений и логгирования
 * @author vdmoi
 */
public class ErrMsgLog {
    public static String pathToLogs = "src/Log/";
    /**
     * Статическое поле, содержащее в себе список ошибок
     */
    public static ArrayList<Exception> errList;
    /**
     * Поле, содержащее "хэндлер" лога
     */
    public static FileHandler errhnd;
    //контрольный
    public static Logger log = Logger.getLogger(ErrMsgLog.class.getName());
    //для ошибок
    public static Logger log_err = Logger.getLogger(ErrMsgLog.class.getName()+"ERR");
    //для тестов
    public static Logger log_test = Logger.getLogger(ErrMsgLog.class.getName()+"TEST");
    
    public static void autoConf(){
        try{
            errList = new ArrayList<>();
            LogManager.getLogManager().readConfiguration(ErrMsgLog.class.getResourceAsStream("logging.properties"));
            setLog("Log.txt");
            //log = Logger.getLogger("Log");
            setLogErr("LogErr.txt");
        }catch(IOException | SecurityException e){
            System.out.println(e);
            addErrWithLog(e);
        }
    }
    
    public static void setLogTest(String fileName){
        try{
            ErrMsgLog.errhnd = new FileHandler(pathToLogs + fileName, true);
            ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
            ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
        }catch(IOException e){
        System.out.println(e);
        addErrWithLog(e);
        }
    }
    
    public static void setLog(String fileName){
        try{
            ErrMsgLog.errhnd = new FileHandler(pathToLogs + fileName, true);
            ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
            ErrMsgLog.log.addHandler(ErrMsgLog.errhnd);
        }catch(IOException e){
        System.out.println(e);
        addErrWithLog(e);
        }
    }
    
    public static void setLogErr(String fileName){
        try{
            ErrMsgLog.errhnd = new FileHandler(pathToLogs + fileName, true);
            ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
            ErrMsgLog.log_err.addHandler(ErrMsgLog.errhnd);
        }catch(IOException e){
        System.out.println(e);
        addErrWithLog(e);
        }
    }
    
    /**
     * Метод для добавления объекта исключения в список исключений
     * @param e пойманное исключение
     */
    public void addErr(Exception e){
        errList.add(e);
    }

    /**
     * Метод для логгирование ошибки и возвращения кол-ва пойманных ошибок
     * @param e пойманное исключение
     */
    public static void addErrWithLog(Exception e) {
        errList.add(e);
        LocalTime time = LocalTime.now();
        log_err.log(Level.WARNING, "{0} {1}", new Object[]{e.getMessage(), time.format(DateTimeFormatter.ofPattern("H:mm:ss"))});
    }

    /**
     * @return размер списка исключений
     */
    public static int getErrCount(){
        return errList.size();
    }

    /**
     * Выводит текст ошибки
     * @param e сообщение объекта исключения
     */
    public static void showErrText(Exception e){
        System.err.println(e.getMessage());
    }
    
    /**
     * Удаляет все файлы логов
     */
    public static void clearAllLogs(){
        File file = new File(pathToLogs);
        File files[] = file.listFiles();    
        String name;
        for (File f : files){
            name = f.getName();
            if(name.contains("log") && name.contains(".txt")){
                f.delete();
            }
        }
    }
    
}