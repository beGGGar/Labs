package Model;

import java.util.ArrayList;

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
    not_stated
    }
    private int age;
    private String name;
    private Sex sex;
    private boolean haveKid = false;
    private boolean haveParent = false;

    public String getName() {
    return name;
    }

    public int getAge() {
    return age;
    }

    public Sex getSex() {
    return sex;
    }

    public boolean getHaveKid(){
        return this.haveKid;
    }

    public boolean getHaveParent(){
        return this.haveParent;
    }

    public String getParentName(){
        return "";
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

    public void setHaveKid(boolean HK){
        this.haveKid = HK;
    }

    public void setHaveParent(boolean HP){
        this.haveParent = HP;
    }

    protected Human(String name, int age, Sex sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    protected Human(){
        this.name = "not_stated";
        this.age = 0;
        this.sex = Sex.not_stated;
    }

    protected Human(Human h){
        this.age = h.age;
        this.name = h.name;
        this.sex = h.sex;
    }

    public String toString(){
        return "Name: " + name + ", Age:" + age + ", sex: " + sex.toString();
    }

    /**
     * создает пару объектов-отпрысков суперкласса Human по внутренним параметрам
     * Parent-Student, OverParent-Botany
     * @param humans
     * @return
     */
    public HumansPair createPair(ArrayList<Human> humans){
        return new HumansPair<Human, Human>(this, this);
    }
}
