package Controller;

import Controller.Controller;
import Model.*;
import View.View;
import java.util.ArrayList;

public class Main{
    public static void main(String[] args){
        View.tytleMassegeOfNumber();
        int n = Controller.getInt();
        ArrayList humans = HumanCollection.createRandomHumans(n);
        OverParent pr = new OverParent("Jorge", 50, Human.Sex.man, 1000);
        Botany bt = new Botany("Bony", 20, Human.Sex.woman, 10, "Jorge", 1000);
        humans.add(pr);
        humans.add(bt);

        View.printHumans(humans);
        System.out.println();
        for (int i = 0; i < humans.size(); i++){
            View.printPair(((Human)humans.get(i)).createPair(humans));
        }
    }
}