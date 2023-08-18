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
public class OverParent extends Parent{
    private double moneyForKid = 0;
    
    public double getMoneyForKid(){
        return this.moneyForKid;
    }
    
    public void setMoneyForKid(double money){
        if (money>=0)
            this.moneyForKid = money;
    }
    
    public OverParent(){
        super();
    }
    
    public OverParent(String name, int age, Sex sex){
        super(name, age, sex);
    }
    
    public OverParent(String name, int age, Sex sex, double moneyForKid){
        super(name, age, sex);
        this.moneyForKid = moneyForKid;
    }
    
    public String toString(){
        return super.toString() + ", money_for_kid:" + this.moneyForKid;
    }
    
    public HumansPair createPair(ArrayList<Human> humans){
    java.lang.Class FoundClass = Botany.class;
    for (int i = 0; i < humans.size(); i++) {
        if (humans.get(i).getClass() == FoundClass && humans.get(i).getParentName() != null) {
            if (humans.get(i).getParentName().equals(this.getName())){
                humans.get(i).setHaveParent(true);
                this.setHaveKid(true);
                return new HumansPair<Parent, Botany>(this, (Botany)humans.get(i));
            }
        }
    }
    return new HumansPair<OverParent, Botany>(this, null);
    }
        
    
    
}

