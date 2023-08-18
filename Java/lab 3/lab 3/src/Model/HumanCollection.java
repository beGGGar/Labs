/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.Controller;
import View.View;
import Controller.ErrMsgLog;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.logging.Level;

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
            //ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Write to "+ path);
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
                //ErrMsgLog.log_test.info(time.getHour()+":"+time.getMinute()+":"+time.getSecond()+":"+time.getNano() +" Read from "+ file);

            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                ErrMsgLog.addErrWithLog(ex);
            }finally{
                
            }
            
        } else {

            View.tytleMassegeOfNumber();
            int n = Controller.getInt();
            humans = HumanCollection.createRandomHumans(n);
        }
        return humans;
    }
}
