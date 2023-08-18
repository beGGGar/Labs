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
    public static ArrayList<Exception> errList = new ArrayList<>();
    /**
     * Поле, содержащее "хэндлер" лога
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
     * Начальная настройка логгеров класса
     */
    public static void setLoggers(){
        try {
            errList = new ArrayList<>();
            LogManager.getLogManager().readConfiguration(ErrMsgLog.class.getResourceAsStream("logging.properties"));
            ErrMsgLog.errhnd = new FileHandler("src/controller/err_log.txt", true);
            ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
            ErrMsgLog.log.addHandler(ErrMsgLog.errhnd);
            ErrMsgLog.errhnd = new FileHandler("src/controller/err_log.txt", true);
            ErrMsgLog.errhnd.setFormatter(new SimpleFormatter());
            ErrMsgLog.log_err.addHandler(ErrMsgLog.errhnd);
        }catch(IOException err){
            
        }
    }
}