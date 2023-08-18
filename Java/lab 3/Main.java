package Controller;

import Controller.Controller;
import Model.*;
import View.View;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args)throws IOException{
        View.tytleMassegeOfNumber();
        int n = 1;//Controller.getInt();
        HumanCollection humans = new HumanCollection();//HumanCollection.createRandomHumans(n);
        humans.createRandomHumans(n);
        OverParent pr = new OverParent("Jorge", 50, Human.Sex.man, 1000);
        Botany bt = new Botany("Bony", 20, Human.Sex.woman, 10, "Jorge", 1000);
        humans.add(pr);
        humans.add(bt);

        View.printHumans(humans.getHumans());
        System.out.println();
        for (int i = 0; i < humans.size(); i++){
            View.printPair(humans.get(i).createPair(humans.getHumans()));
        }
    }
}