package Model;

import java.util.ArrayList;
//import javafx.util.Pair;

/**
 * абстрактный класс человек
 * поля: имя str, возраст int, пол
 * пол формата enum Sex
 * @author vdmoi
 */


public class Human {
    public enum Sex{
    man,
    woman,
    None
    }
    protected int age;
    protected String name;
    protected String parentName;
    protected Sex sex;

    
    /** 
     * @return String
     */
    public String getName() {
    return name;
    }

    
    /** 
     * @return int
     */
    public int getAge() {
    return age;
    }

    public Sex getSex() {
    return sex;
    }

    public String getParentName(){
        return parentName;
    }

    public void setName(String name) {
    this.name = name;
    }

    public void setAge(int age) {
        if(age >=0){
            this.age = age;
        }
    }

    public void setSex(Sex sex) {
    this.sex = sex;
    }
    
    public void setParentName(String parentName){
        this.parentName = parentName;
    }

    public Human(String name, String parentName, int age, Sex sex){
        this.name = name;
        this.parentName = parentName;
        this.age = age;
        this.sex = sex;
    }

    public Human(){
        this.name = "None";
        this.parentName = "None";
        this.age = 0;
        this.sex = Sex.None;
    }

    public Human(Human h){
        this.age = h.age;
        this.name = h.name;
        this.parentName = h.parentName;
        this.sex = h.sex;
    }

    public String toString(){
        return name + "\t" + parentName + "\t" + age + "\t" + sex.toString();
    }
    
    public String CreatePair(ArrayList<Human> humans){
        return "NOPair" + this.toString(); 
    }

    public String validateInputs(String[] params) {
        return "Unvalid"; // Все проверки пройдены успешно
    }
}
