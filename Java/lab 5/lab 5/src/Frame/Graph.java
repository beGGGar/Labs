/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frame;

////import Log.ErrMsgLog;
import Log.ErrMsgLog;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author vdmoi
 */
public class Graph{
    public String logName;
    public int totalTime;
    public int totalCount;
    public int totalMedianTime;
    public int addTotalTime;
    public int addTotalCount;
    public int addTotalMedianTime;
    public int removeTotalTime;
    public int removeTotalCount;
    public int removeTotalMedianTime;
    
    public Graph(String logName){
        this.logName = logName;
    }
    /**
     * парсер данных из файлов логов
     * @throws IOException 
     */
    public void loadDataFromLogs() throws IOException{  
//        Start program: 1:53:38
//        Total Time = 788600
//        Total Count = 11
//        Total MedianTime = 71690
//        AddTotal Time = 784100
//        AddTotal Count = 10
//        AddTotal MedianTime = 78410
//        RemoveTotal Time = 4500
//        RemoveTotal Count = 1
//        RemoveTotal MedianTime = 4500
//        Finish program: 1:53:38
        File file = new File(logName);
        
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            while(!br.readLine().contains("Start program")){}

            totalTime = Integer.parseInt(br.readLine());
            totalCount = Integer.parseInt(br.readLine());
            totalMedianTime = Integer.parseInt(br.readLine());
            addTotalTime = Integer.parseInt(br.readLine());
            addTotalCount = Integer.parseInt(br.readLine());
            addTotalMedianTime = Integer.parseInt(br.readLine());
            removeTotalTime = Integer.parseInt(br.readLine());
            removeTotalCount = Integer.parseInt(br.readLine());
            removeTotalMedianTime = Integer.parseInt(br.readLine());

        } catch (FileNotFoundException e) {
            ErrMsgLog.addErrWithLog(e);
            System.out.println(e);
        }
    }
        
    /**
     *
     * @return
     */
    @Override
    public String toString(){
        return "\n\nTotal Time = " + totalTime +
                    "\nTotal Count = " + totalCount +
                    "\nTotal MedianTime = " + totalMedianTime +
                    "\nAddTotal Time = " + addTotalTime +
                    "\nAddTotal Count = " + addTotalCount +
                    "\nAddTotal MedianTime = " + addTotalMedianTime +
                    "\nRemoveTotal Time = " + removeTotalTime +
                    "\nRemoveTotal Count = " + removeTotalCount +
                    "\nRemoveTotal MedianTime = " + removeTotalMedianTime;
    }
    public void t(){
        int rez;
        rez = totalTime + totalCount +totalMedianTime + addTotalTime + addTotalCount + addTotalMedianTime + removeTotalTime + removeTotalCount + removeTotalMedianTime;
        System.out.println(rez);
    
    }
    
}