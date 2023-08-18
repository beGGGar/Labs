package View;

import java.util.ArrayList;
import Model.*;
/**
 * интерфейс
 * @author vdmoi
 */
public class View {
    public static void tytleMassegeOfNumber(){
        System.out.println("Enter the number of elements of the Human class. This number will be multiplied by 4 ");
    }
    
    public static void printHuman(Human human){
        System.out.format("%16s %s\n", human.getClass().getName(), human.toString());
    }
    public static void printHumans(ArrayList<Human> humans){
        for (int i = 0; i < humans.size(); i++){
            //System.out.println(humans.get(i).toString() + ", " + humans.get(i).getClass().getName());
            //System.out.format("%18s %s\n", humans.get(i).getClass().getName(), humans.get(i).toString());
            printHuman(humans.get(i));
        }
    }
    
    public static void printPair(HumansPair pair){
        if (pair.isValid()){
            System.out.println("*---\nPair " + pair.getFirst().getClass().getName() + "-" + pair.getSecond().getClass().getName() + ":");
            printHuman((Human)pair.getFirst());
            printHuman((Human)pair.getSecond());
            System.out.println("*---");
        }
        else{
            try{
                System.out.println(((Human)pair.getFirst()).getName() + " doesn't have a pair");
            }
            catch(Exception e){
                System.out.println("Pair empty!");
            }
        }
       
        
    }
    
    
}
