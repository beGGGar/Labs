/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Model.HumanRandomizer.*;
import java.util.ArrayList;

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
        ArrayList<Human> humans = new ArrayList<Human>();
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
}
