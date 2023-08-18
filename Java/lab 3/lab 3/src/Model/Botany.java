/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.ArrayList;

/**
 * String name, int age, Sex sex, double midleMark, String parentName, double salary
 * @author vdmoi
 */
public class Botany extends Student {
    private double salary = 0;
    
    public double getSalary(){
        return this.salary;
    }
    
    public void setSalary(double salary){
        if (!this.getHaveParent() && salary>=0){
            if(salary == 0)
                this.salary = Math.pow(10, this.getMidleMark());
            else 
                this.salary = salary;
        }
    }
    
    public Botany(){
        super();
    }
    
    public Botany(String name, int age, Sex sex, double midleMark, String parentName){
        super(name, age, sex, midleMark, parentName);
    }
    
    public Botany(String name, int age, Sex sex, double midleMark, String parentName, double salary){
        super(name, age, sex, midleMark, parentName);
        this.salary = salary;
    }
    
    public String toSring(){
        return super.toString() + ", salary:" + this.salary;
    }
    
    public HumansPair createPair(ArrayList<Human> humans){
        java.lang.Class FoundClass = OverParent.class;
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getClass() == FoundClass && this.getParentName() != null) {
                if (this.getParentName().equals(humans.get(i).getName())){
                    humans.get(i).setHaveKid(true);
                    this.setHaveParent(true);
                    return new HumansPair<Botany, OverParent>(this, (OverParent)humans.get(i));
                }
            }
        }
        return new HumansPair<Botany, OverParent>(this, null);
    }
}
