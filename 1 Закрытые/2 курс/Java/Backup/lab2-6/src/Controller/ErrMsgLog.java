package Controller;

import java.io.IOException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.*;

/**
 * Класс для обработки исключений и логгирования
 * @author vdmoi
 */
public class ErrMsgLog {
    /**
     * Статическое поле, содержащее в себе список ошибок
     */
    public static ArrayList<Exception> errList;
    /**
     * Поле, содержащее "хэндлер" лога(обработчик)
     */
    public static FileHandler errhnd;
    /**
     * Логгер для записи контрольной информации
     */
    public static Logger log = Logger.getLogger(ErrMsgLog.class.getName());
    /**
     * Логгер для записи ошибок в ходе выполнения программы
     */
    public static Logger log_err = Logger.getLogger(ErrMsgLog.class.getName()+"ERR");
    /**
     * Логгер для записи прохождения автотестов
     */
    public static Logger log_test = Logger.getLogger(ErrMsgLog.class.getName()+"TEST");
    private static boolean debug;
    
    
    /** 
     * @param debug_
     */
    //
    public static void autoConf(boolean debug_){
        ErrMsgLog.debug = debug_;
        errList = new ArrayList<>();
        setLog("Log.txt");
        setLogErr("LogErr.txt");
        }

    /**
     * Кастомный форматтер для тестов, чтоб не выводил число дважды
     */
    static class CustomFormatter extends Formatter {
        @Override
        public String format(LogRecord record) {
            return record.getMessage() + "\n"; // Форматируем только сообщение
        }
    } 

    /**
     * Инициализация логгера
     * @param fileName
     */
    public static void setLog(String fileName){
        try{
            ErrMsgLog.errhnd = new FileHandler("src/Controller/" + fileName, true);
            ErrMsgLog.errhnd.setFormatter(new CustomFormatter());//(new SimpleFormatter());
            ErrMsgLog.log.addHandler(ErrMsgLog.errhnd);
            ErrMsgLog.log.setUseParentHandlers(ErrMsgLog.debug); //вывод в консоль
        }catch(IOException e){
        System.out.println(e);
        }
    }
    
    public static void setLogErr(String fileName){
        try{
            ErrMsgLog.errhnd = new FileHandler("src/Controller/" + fileName, true);
            ErrMsgLog.errhnd.setFormatter(new CustomFormatter());//(new SimpleFormatter());
            ErrMsgLog.log_err.addHandler(ErrMsgLog.errhnd);
            ErrMsgLog.log_err.setUseParentHandlers(debug);
        }catch(IOException e){
        System.out.println(e);
        }
    }

    public static void setLogTest(String fileName){
        try{
            ErrMsgLog.errhnd = new FileHandler("src/Controller/" + fileName, false); //false, чтоб перезаписывал файл
            ErrMsgLog.errhnd.setFormatter(new CustomFormatter());
            ErrMsgLog.log_test.addHandler(ErrMsgLog.errhnd);
            ErrMsgLog.log_test.setUseParentHandlers(false);
        }catch(IOException e){
        System.out.println(e);
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
        log_err.warning(e.getMessage() + " " + time.format(DateTimeFormatter.ofPattern("H:mm:ss")));
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
     * Очистка хендлера и удаление временных файлов
     */
    public static void Exit(){
        for (Handler handler : log_test.getHandlers()){
            handler.close();
        }
        for (Handler handler : log.getHandlers()){
            handler.close();
        }
        for (Handler handler : log_err.getHandlers()){
            handler.close();
        }
        // log = null;
        // log_err = null;
        // log_test = null;
    }
}