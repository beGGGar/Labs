package View;

import java.util.ArrayList;

import Controller.LogParser;
import Model.*;
/**
 * интерфейс
 * @author vdmoi
 */
public class View {
    public static void tytleMassegeOfNumber(){
        System.out.println("Enter the number of elements of the Human class. It will be multiplied by 4");
    }
    
    
    /** 
     * @param human
     */
    public static void printHuman(Human human){
        System.out.format("%10s %s\n", (human.getClass().getSimpleName()), human.toString());
    }

    
    /** 
     * @param human
     * @return String
     */
    public static String humanWithClassName(Human human){
        return String.format("%s\t%s", (human.getClass().getSimpleName()), human.toString());
    }

    public static void printHumans(ArrayList<Human> humans){
        if (humans.size()>0){
            for (int i = 0; i < humans.size(); i++){
                printHuman(humans.get(i));
            }
        }
        else System.out.println("Список пуст");
        
    }
    
    public static void printPairs(ArrayList<Human> humans){
        if (humans.size()>0){
            for(int i=0; i<humans.size(); i++){
            System.out.println(humans.get(i).CreatePair(humans));
            }
        }
        else System.out.println("Список пуст");
       
        
    }
    
    public static void menu(){
        String menu = "Lab 2-6\n"
        + "1) Показать список людей\n"
        + "2) Подгрузить список из БД\n"
        + "3) Сохранить в БД\n"
        + "4) Дополнить БД\n"
        + "5) Пополнить список примерами\n"
        + "6) Сгенерировать людей\n"
        + "7) Вывести пары людей\n"
        + "8) Тест времени для ArrayList и LinkedList\n"
        + "9) Граф по логам\n"
        + "0) Выход";
        System.out.println(menu);   
    }

    public static void helloGuest(){
        System.out.println("Welcome, Guest");
    }
    
    public static void helloUser(String name){
        System.out.println("Welcome, " + name);
    }

    public static void printAllLogs(){
        try{

        }
        catch(Exception E){

        }
        for(int i = 0; i < LogParser.AddCount.size(); i++){
            System.out.println(LogParser.AddCount.get(i));
            System.out.println(LogParser.AddTotalTime.get(i));
            System.out.println(LogParser.AddMedianTime.get(i));
            System.out.println(LogParser.RemoveCount.get(i));
            System.out.println(LogParser.RemoveTotalTime.get(i));
            System.out.println(LogParser.RemoveMedianTime.get(i) + "\n");
        }
    }
    
}
