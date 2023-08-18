package model;
import java.util.logging.Logger;

/**
 * Абстрактный суперкласс человек от которого будут наследоваться остальные. 
 * Имеет имя, возраст и пол.
 * @author Raznoglazov Nikita PIN-24
 *
 */
public abstract class Human {

protected String name;
protected int age;
protected String sex;

private static Logger log = Logger.getLogger(Human.class.getName());

public String GetName() {
return name;
}

public int GetAge() {
return age;
}

public String GetSex() {
return sex;
}

public void SetName(String name) {
this.name = name;
}

public void SetAge(int age) {
this.age = age;
}

public void SetSex(String sex) {
this.sex = sex;
}

protected Human(String name, int age, String sex) {
this.name = name;
this.age = age;
this.sex = sex;
}

protected Human() {
this.name = "";
this.age = 0;
this.sex = "";
}
/**
 * Переопределение метода toString, выводящего все поля класса в виде строки
 */
public String toString() {
return name + "\t" + age + "\t" + sex;
}

}
