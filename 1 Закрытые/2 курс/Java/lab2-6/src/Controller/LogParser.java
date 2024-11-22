package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class LogParser {
    public static LinkedList<Long> AddCount;
    public static LinkedList<Long> AddTotalTime;
    public static LinkedList<Long> AddMedianTime;
    public static LinkedList<Long> RemoveCount;
    public static LinkedList<Long> RemoveTotalTime;
    public static LinkedList<Long> RemoveMedianTime;
    
    /**
     * парсер данных из файлов логов
     * @throws IOException 
     */
    public static void ParseLogFinalInfo(String logName) throws IOException{  
        //StartProgram: 16:18:41
        //AddTotalCount = 10
        //AddTotalTime = 8705400
        //AddMedianTime = 870540
        //RemoveTotalCount = 1
        //RemoveTotalTime = 8800
        //RemoveMedianTime = 8800
        //FinishProgram: 16:18:41
        File file = new File(logName);

        //парсинг лога
        try (BufferedReader br = new BufferedReader(new FileReader(file))){

            while(!br.readLine().contains("StartProgram")){}    //ищем начало данных
            
            AddCount.add(Long.parseLong((br.readLine().split(" "))[2]));    //преобразуем string в long
            AddTotalTime.add(Long.parseLong((br.readLine().split(" "))[2]));
            AddMedianTime.add(Long.parseLong((br.readLine().split(" "))[2]));
            RemoveCount.add(Long.parseLong((br.readLine().split(" "))[2]));
            RemoveTotalTime.add(Long.parseLong((br.readLine().split(" "))[2]));
            RemoveMedianTime.add(Long.parseLong((br.readLine().split(" "))[2]));

        } catch (FileNotFoundException e) {
            ErrMsgLog.addErrWithLog(e);
            System.out.println(e);
        }
    }

    /**
     * Перебор всех логов
     * @throws IOException
     */
    public static void ParseAllLogs(int degree) throws IOException{  
        ClassReset();
        int i = 1;
        for (; i < degree+1; i++){
            ParseLogFinalInfo("src/Controller/logArrayList" + i + ".txt");
        }
        for (; i < 2*degree+1; i++){
            ParseLogFinalInfo("src/Controller/logLinkedList" + i + ".txt");
        }
        ErrMsgLog.log.info("");
    }

    /**
     * Обнуление парсера
     */
    public static void ClassReset(){
        AddCount = new LinkedList<>();
        AddTotalTime = new LinkedList<>();
        AddMedianTime = new LinkedList<>();
        RemoveCount = new LinkedList<>();
        RemoveTotalTime = new LinkedList<>();
        RemoveMedianTime = new LinkedList<>();
    }
        
}
