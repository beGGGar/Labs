/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.InputChecker;
import View.View;
import Log.ErrMsgLog;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author vdmoi
 */
public class HumanCollection {
    
    public static void testStart(int maxDegree){
        ErrMsgLog.clearAllLogs();
        for (int i = 0; i<maxDegree; i++){
            HumanCollection.RunTimeArrayList((int)Math.pow(10, i+1), i+1);
            HumanCollection.RunTimeLinkedList((int)Math.pow(10, i+1), i+1+maxDegree);
        }
    }
    /**
     * создает одномерный массив из людей каждой категории размером n*4
     * 
     * @param n
     * @return 
     */
    public static ArrayList<Human> createRandomHumans(int n) {
        ArrayList humans = new ArrayList<Human>();
        Student st;
        Botany bt;
        Parent pr;
        OverParent op;
        for (int i = 0; i<n; i++){
            st = new Student(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex(), HumanRandomizer.getRandomInt(5), HumanRandomizer.getRandomName());
            bt = new Botany(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex(), HumanRandomizer.getRandomInt(5), HumanRandomizer.getRandomName());
            pr = new Parent(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
            op = new OverParent(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
            humans.add(st);
            humans.add(bt);
            humans.add(pr);
            humans.add(op);
        }
        
        return humans;
    }
    
    /**
     * метод создания LinkedList из Human количеством членов n*4
     * @param n
     * @return 
     */
    public static LinkedList<Human> createRandomLinkedList(int n){
        LinkedList humans = new LinkedList<Human>();
        Student st;
        Botany bt;
        Parent pr;
        OverParent op;
        for (int i = 0; i<n; i++){
            st = new Student(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex(), HumanRandomizer.getRandomInt(5), HumanRandomizer.getRandomName());
            bt = new Botany(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex(), HumanRandomizer.getRandomInt(5), HumanRandomizer.getRandomName());
            pr = new Parent(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
            op = new OverParent(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
            humans.add(st);
            humans.add(bt);
            humans.add(pr);
            humans.add(op);
        }
        return humans;
    }
    
    /**
     * метод заполнения ArrayList
     * @param list
     * @param capacity
     * @return 
     */
    public static ArrayList<Human> addInArrayList(ArrayList<Human> list, int capacity)
    {
        for(int i = 0; i < capacity; i++)
        {
            list.add(i, createHuman());
        }
        return list;
    }
    /**
     * метод заполнения LinkedList
     * @param list
     * @param capacity
     * @return 
     */
    public static LinkedList<Human> addInLinkedList(LinkedList<Human> list, int capacity)
    {
        for(int i = 0; i < capacity; i++)
        {
            list.add(i, createHuman());
        }
        return list;
    }

    /**
     * возвращает тестовый объект 
     * @return Human
     */
    public static Human createHuman(){
        return new Student("Tester", (int)(Math.random()*100), Human.Sex.man, (Math.random()*100), "Tester's father");
    }
    
    public static void RunTimeArrayList(int cap, int counter)
    {
        try {
            ArrayList humans = new ArrayList<Human>();
            LocalTime startTime = LocalTime.now();
            ErrMsgLog.setLogTest("log" + counter);
            
            int addCount = 0;
            int deleteCount = 0;
            long addCountTime = 0;
            long deleteCountTime = 0;
            int totalCount = 0;
            long totalTime = 0;
            long start;
            long finish;
            long res;
            try {
                for (int i = 0; i < cap; i++) {
                    start = System.nanoTime();
                    humans.add(createHuman());
                    finish = System.nanoTime();
                    res = finish - start;
                    addCountTime += res;
                    addCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nadd, ID = " + totalCount + ", " + res);
                }
                System.out.println("\n");
                for (int i = 0; i < cap / 10; i++) {
                    start = System.nanoTime();
                    int randomIndex = (int) (Math.random() * (cap - 1 - i));
                    humans.remove(randomIndex);
                    finish = System.nanoTime();
                    res = finish - start;
                    deleteCountTime += res;
                    deleteCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nremove, ID = " + randomIndex + ", " + res);
                    //System.out.println(1/0);
                }
            } catch (Exception e) {
                ErrMsgLog.addErrWithLog(e);
            }
            LocalTime endTime = LocalTime.now();
            ErrMsgLog.log_test.info("\n\nStart program: " + startTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\nTotal Time = " + totalTime +
                    "\nTotal Count = " + totalCount +
                    "\nTotal MedianTime = " + totalTime / totalCount +
                    "\nAddTotal Time = " + addCountTime +
                    "\nAddTotal Count = " + addCount +
                    "\nAddTotal MedianTime = " + addCountTime / addCount +
                    "\nRemoveTotal Time = " + deleteCountTime +
                    "\nRemoveTotal Count = " + deleteCount +
                    "\nRemoveTotal MedianTime = " + deleteCountTime / deleteCount + "\nFinish program: " + endTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\n");
//        } catch (IOException e){
//            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            ErrMsgLog.log_test.removeHandler(ErrMsgLog.errhnd);
        }
    }
    
    public static void RunTimeLinkedList(int cap, int counter)
    {
        try {
            LinkedList humans = new LinkedList<Human>();
            LocalTime startTime = LocalTime.now();
            ErrMsgLog.setLogTest("log" + counter + ".txt");
            
            int addCount = 0;
            int deleteCount = 0;
            long addCountTime = 0;
            long deleteCountTime = 0;
            int totalCount = 0;
            long totalTime = 0;
            long start;
            long finish;
            long res;
            try {
                for (int i = 0; i < cap; i++) {
                    start = System.nanoTime();
                    humans.add(createHuman());
                    finish = System.nanoTime();
                    res = finish - start;
                    addCountTime += res;
                    addCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nadd, ID = " + totalCount + ", " + res);
                }
                System.out.println("\n");
                for (int i = 0; i < cap / 10; i++) {
                    start = System.nanoTime();
                    int randomIndex = (int) (Math.random() * (cap - 1 - i));
                    humans.remove(randomIndex);
                    finish = System.nanoTime();
                    res = finish - start;
                    deleteCountTime += res;
                    deleteCount++;
                    totalCount++;
                    totalTime += res;
                    ErrMsgLog.log_test.info("\nremove, ID = " + randomIndex + ", " + res);
                    //System.out.println(1/0);
                }
            } catch (Exception e) {
                ErrMsgLog.addErrWithLog(e);
            }
            LocalTime endTime = LocalTime.now();
            ErrMsgLog.log_test.info("\n\nStart program: " + startTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\nTotal Time = " + totalTime +
                    "\nTotal Count = " + totalCount +
                    "\nTotal MedianTime = " + totalTime / totalCount +
                    "\nAddTotal Time = " + addCountTime +
                    "\nAddTotal Count = " + addCount +
                    "\nAddTotal MedianTime = " + addCountTime / addCount +
                    "\nRemoveTotal Time = " + deleteCountTime +
                    "\nRemoveTotal Count = " + deleteCount +
                    "\nRemoveTotal MedianTime = " + deleteCountTime / deleteCount + "\nFinish program: " + endTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + "\n");
//        } catch (IOException e){
//            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            ErrMsgLog.log_test.removeHandler(ErrMsgLog.errhnd);
        }
    }
    
    
    /**
     * сохранение ArrayList<Human> в файл по пути path
     * @param humans
     * @param path
     * @param Update
     * @return
     * @throws java.io.IOException 
     */
    public static boolean saveToFile(ArrayList<Human> humans, String path, boolean Update)throws java.io.IOException {
        boolean Result = false;
        FileWriter dataOut = null;

        try{
             
            if (!Update){
                dataOut = new FileWriter(path, false);
                dataOut.append("");
                dataOut.close();
            }
            dataOut = new FileWriter(path, true);
            for (int i = 0; i < humans.size(); i++){
                dataOut.append(humans.get(i).getClass().getName() + ", " + humans.get(i).toString() + "\n");
            }		
            Result = true;
            LocalTime time = LocalTime.now();
            ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Write to "+ path);
        }
        catch( IOException e ) {
            System.err.println(e.getMessage());
        }
        finally {
            if (dataOut != null)
                dataOut.close();
        }

        return Result;
    }
    
    /**
     * загрузка ArrayList<Human> из файла по пути path
     * @param path
     * @return 
     */
    public static ArrayList<Human> loadFromFile(String path){
        ArrayList<Human> humans = new ArrayList();
        File file = new File(path);
        String buff;
        String[] param;
        String name;
        int age;
        Human.Sex sex;
        boolean start = false;
        if (file.exists() & file.length() != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                while(true){
                    buff = br.readLine();
                    if (buff == null)break;
                    if (buff.contains("Model.")){
                        start = true;
                    }
                    else if(buff.length() == 0){
                        start = false;
                    }
                    if (start){
                        param = buff.split(", ");
                        name = param[1].split(":")[1];
                        age = Integer.parseInt(param[2].split(":")[1]);
                        sex = Human.Sex.valueOf(param[3].split(":")[1]);
                        switch (param[0]) {
                            case ("Model.Parent") -> {
                                Parent parent = new Parent(name, age, sex);
                                humans.add(parent);
                            }
                            case ("Model.OverParent") -> {
                                OverParent OP = new OverParent(name, age, sex, Double.parseDouble(param[4].split(":")[1]));
                                humans.add(OP);
                            }
                            case ("Model.Student") -> {
                                Student student = new Student(name, age, sex, Double.parseDouble(param[4].split(":")[1]), param[5].split(":")[1]);
                                humans.add(student);
                            }
                            case ("Model.Botany") -> {
                                Botany botan = new Botany(name, age, sex, Double.parseDouble(param[4].split(":")[1]), param[5].split(":")[1]);
                                humans.add(botan);                    
                            }
                        }
                    }
                }
           
                LocalTime time = LocalTime.now();
                ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Read from "+ file);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ErrMsgLog.addErrWithLog(ex);
            }finally{
                
            }
            
        } else {

            View.tytleMassegeOfNumber();
            int n = InputChecker.getInt();
            humans = HumanCollection.createRandomHumans(n);
        }
        return humans;
    }
}
