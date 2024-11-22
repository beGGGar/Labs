/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Botany;
import Model.CoolParent;
import Model.Human;
import Model.Human.Sex;
import Model.Parent;
import Model.Student;
import View.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

/**
 *
 * @author vdmoi
 */
public class HumanCollection {
    /**
     * создает одномерный массив из людей каждой категории размером n*4
     * 
     * @param n
     * @return 
     */
    public static void createRandomHumans(ArrayList<Human> humans, int n) {
        Student st;
        Botany bt;
        Parent pr;
        CoolParent op;
        for (int i = 0; i<n; i++){
            st = new Student(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex(), HumanRandomizer.getRandomInt(5));
            bt = new Botany(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex(), HumanRandomizer.getRandomInt(5));
            pr = new Parent(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
            op = new CoolParent(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
            humans.add(st);
            humans.add(bt);
            humans.add(pr);
            humans.add(op);
        }
    }

    
    /** 
     * @param humans
     */
    public static void AddDefaultPeoples(ArrayList<Human> humans){
        CoolParent cp= new CoolParent("Jorge", "Nikita", 50, Human.Sex.man, 1000);
        Botany bt = new Botany("Bony", "Jorge", 20, Human.Sex.woman, 10, 1000);
        Parent pr = new Parent("Nadya", "Vova", 37, Human.Sex.woman);
        Student st = new Student("Den", "Nadya", 17, Human.Sex.man, 4.5);
        humans.add(cp);
        humans.add(st);
        humans.add(bt);
        humans.add(pr);
    }
    /**
     * Создает рандомного Human
     * @return 
     */
    public static Human createHuman(){
        return new Human(HumanRandomizer.getRandomName(), HumanRandomizer.getRandomName(), HumanRandomizer.getRandomAge(), HumanRandomizer.getRandomSex());
    }
    
    /**
     * Тест ArrayList
     * @param cap число тестируемых элементов
     * @param counter номер теста
     */
    public static void RunTimeArrayList(int cap, int counter)
    {
        try {
            ArrayList<Human> humans = new ArrayList<Human>();
            Long[] addTimings = new Long[cap];
            Long[] removeTimings = new Long[cap/10];
            LocalTime startTime = LocalTime.now();
            ErrMsgLog.setLogTest("logArrayList" + counter + ".txt");
            Human human;
            
            long addCount = 0;
            long deleteCount = 0;
            long addCountTime = 0;
            long deleteCountTime = 0;
            long totalCount = 0;
            long start;
            long finish;
            long res;
            try {
                for (int i = 0; i < cap; i++) {
                    human = createHuman();
                    start = System.nanoTime();
                    humans.add(human);
                    finish = System.nanoTime();
                    res = finish - start;
                    addCountTime += res;
                    addCount++;
                    totalCount++;
                    addTimings[i] = res;
                    ErrMsgLog.log_test.info("\nadd, ID = " + totalCount + ", " + res);
                }
                int randomIndex = 0;
                for (int i = 0; i < cap / 10; i++) {
                    randomIndex = (int) (Math.random() * (cap - 1 - i));
                    start = System.nanoTime();
                    humans.remove(randomIndex);
                    finish = System.nanoTime();
                    res = finish - start;
                    deleteCountTime += res;
                    deleteCount++;
                    totalCount++;
                    removeTimings[i] = res;
                    ErrMsgLog.log_test.info("\nremove, ID = " + randomIndex + ", " + res);
                }
            } catch (Exception e) {
                ErrMsgLog.addErrWithLog(e);
            }
            
            Arrays.sort(addTimings);
            Arrays.sort(removeTimings);
            //запись в лог
            LocalTime endTime = LocalTime.now();
            ErrMsgLog.log_test.info(
                    "\n\nStartProgram: " + startTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + 
                    "\nAddTotalCount = " + addCount +
                    "\nAddTotalTime = " + addCountTime +
                    "\nAddMedianTime = " + addTimings[addTimings.length/2] +
                    "\nRemoveTotalCount = " + deleteCount +
                    "\nRemoveTotalTime = " + deleteCountTime +
                    "\nRemoveMedianTime = " + removeTimings[removeTimings.length/2] + 
                    "\nFinishProgram: " + endTime.format(DateTimeFormatter.ofPattern("H:mm:ss")));
//        } catch (IOException e){
//            System.out.println(e.getMessage());
        } catch (Exception e){
            //System.out.println(e.getMessage());
            ErrMsgLog.addErrWithLog(e);
        } finally {
             //ErrMsgLog.log_test.removeHandler(ErrMsgLog.errhnd);
        }
    }
    
     /**
     * Тест LinkedList
     * @param cap число тестируемых элементов
     * @param counter номер теста
     */
    public static void RunTimeLinkedList(int cap, int counter)
    {
        try {
            LinkedList<Human> humans = new LinkedList<Human>();
            Long[] addTimings = new Long[cap];
            Long[] removeTimings = new Long[cap/10];
            LocalTime startTime = LocalTime.now();
            ErrMsgLog.setLogTest("logLinkedList" + counter + ".txt");
            Human human;
            
            long addCount = 0;
            long deleteCount = 0;
            long addCountTime = 0;
            long deleteCountTime = 0;
            long totalCount = 0;
            long start;
            long finish;
            long res;
            try {
                for (int i = 0; i < cap; i++) {
                    human = createHuman();
                    start = System.nanoTime();
                    humans.add(human);
                    finish = System.nanoTime();
                    res = finish - start;
                    addCountTime += res;
                    addCount++;
                    totalCount++;
                    addTimings[i] = res;
                    ErrMsgLog.log_test.info("\nadd, ID = " + totalCount + ", " + res);
                }
                int randomIndex = 0;
                for (int i = 0; i < cap / 10; i++) {
                    randomIndex = (int) (Math.random() * (cap - 1 - i));
                    start = System.nanoTime();
                    humans.remove(randomIndex);
                    finish = System.nanoTime();
                    res = finish - start;
                    deleteCountTime += res;
                    deleteCount++;
                    totalCount++;
                    removeTimings[i] = res;
                    ErrMsgLog.log_test.info("\nremove, ID = " + randomIndex + ", " + res);
                    //System.out.println(1/0);
                }
            } catch (Exception e) {
                ErrMsgLog.addErrWithLog(e);
            }
            Arrays.sort(addTimings);
            Arrays.sort(removeTimings);
            
            //запись в лог
            LocalTime endTime = LocalTime.now();
            ErrMsgLog.log_test.info(
                    "\n\nStartProgram: " + startTime.format(DateTimeFormatter.ofPattern("H:mm:ss")) + 
                    "\nAddTotalCount = " + addCount +
                    "\nAddTotalTime = " + addCountTime +
                    "\nAddMedianTime = " + addTimings[addTimings.length/2] +
                    "\nRemoveTotalCount = " + deleteCount +
                    "\nRemoveTotalTime = " + deleteCountTime +
                    "\nRemoveMedianTime = " + removeTimings[removeTimings.length/2] + 
                    "\nFinishProgram: " + endTime.format(DateTimeFormatter.ofPattern("H:mm:ss")));
//        } catch (IOException e){
//            System.out.println(e.getMessage());
        } catch (Exception e){
            //System.out.println(e.getMessage());
            ErrMsgLog.addErrWithLog(e);
        } finally {
            //ErrMsgLog.log_test.removeHandler(ErrMsgLog.errhnd);
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
        FileWriter dataOut = null;

        try{

            dataOut = new FileWriter("./" + path + "\\Save.txt", Update);
            
            for (int i = 0; i < humans.size(); i++){
                dataOut.append(View.humanWithClassName(humans.get(i)) + "\n");
            }		
            //LocalTime time = LocalTime.now();
            //ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Write to "+ path);
        }
        catch( IOException e ) {
            System.err.println(e.getMessage());
            return false;
        }
        finally {
            if (dataOut != null)
                dataOut.close();
        }
        return true;
    }

    /**
     * загрузка ArrayList<Human> из файла по пути path
     * @param path
     * @return 
     */
    public static ArrayList<Human> loadFromFile(String path){
        ArrayList<Human> humans = new ArrayList<Human>();
        File file = new File(path);
        String[] param;
        String buff;
        if (file.exists() & file.length() != 0) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                while(true){
                    buff = br.readLine();
                    
                    if (buff!=null){
                        param = buff.split("\t");
                        switch (param[0]) {
                            case ("Parent") -> {
                                Parent parent = new Parent(param[1], param[2], Integer.parseInt(param[3]), Sex.valueOf(param[4]));
                                humans.add(parent);
                            }
                            case ("CoolParent") -> {
                                CoolParent OP = new CoolParent(param[1], param[2], Integer.parseInt(param[3]), Sex.valueOf(param[4]), Double.parseDouble(param[5]));
                                humans.add(OP);
                            }
                            case ("Student") -> {
                                Student student = new Student(param[1], param[2], Integer.parseInt(param[3]), Sex.valueOf(param[4]), Double.parseDouble(param[5]));
                                humans.add(student);
                            }
                            case ("Botany") -> {
                                Botany botan = new Botany(param[1], param[2], Integer.parseInt(param[3]), Sex.valueOf(param[4]), Double.parseDouble(param[5]), Double.parseDouble(param[6]));
                                humans.add(botan);    
                            }
                        }
                    }
                    else break;
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
            int n = Controller.getInt();
            HumanCollection.createRandomHumans(humans, n);
        }
        return humans;
    }
}

