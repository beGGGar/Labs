/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 * крутой родитель 
 * доп поля: деньги на ребенка
 * @author vdmoi
 */
public class CoolParent extends Parent{
    private double moneyForKid = 0;
    
    
    /** 
     * @return double
     */
    public double getMoneyForKid(){
        return this.moneyForKid;
    }
    
    
    /** 
     * @param money
     */
    public void setMoneyForKid(double money){
        if (money>=0)
            this.moneyForKid = money;
    }
    
    public CoolParent(){
        super();
    }
    
    public CoolParent(String name, String parentName, int age, Sex sex){
        super(name, parentName, age, sex);
    }
    
    public CoolParent(String name, String parentName, int age, Sex sex, double moneyForKid){
        super(name, parentName, age, sex);
        this.moneyForKid = moneyForKid;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\t" + this.moneyForKid;
    }
    
    @Override
    public String CreatePair(ArrayList<Human> humans){
        Human H;
        double PM;
        for (int i = 0; i<humans.size(); i++){
            H = humans.get(i);
            if(H.getClass() == Botany.class){
                if(H.getParentName().equals(this.name) ){
                    PM = Double.parseDouble(H.toString().split("\t")[5]);
                    if(PM == this.moneyForKid){
                        return "Pair\t" + this.toString() + "\t" + H.toString();
                    }
                    
                }
            }
        }
        return "NOPair\t" + this.toString();
    }
}

