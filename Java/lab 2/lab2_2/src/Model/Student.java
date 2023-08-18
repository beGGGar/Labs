package Model;
import java.util.ArrayList;
/**
 * наследует от human
 * имя возраст пол оценка имя_родителя
 * @author vdmoi
 */
public class Student extends Human {
    private double midleMark;
    private String parentName;
    
    public double getMidleMark(){
        return this.midleMark;
    }
    
    public String getParentName(){
        return this.parentName;
    }
    
    public void setMidleMArk(float midleMark){
        if (midleMark>=0){
            this.midleMark = midleMark;
        }
    }
    
    public void setParentName(String parentName){
        this.parentName = parentName;
    }
    
    public Student(String name, int age, Sex sex, double midleMark, String parentName){
        super(name, age, sex);
        this.midleMark = midleMark;
        this.parentName = parentName;
    }
    
    public Student(){
        super();
        this.midleMark = 0;
        this.parentName = "not_stated";
    }
    
    public Student(Student s){
        super(s.getName(), s.getAge(), s.getSex());
        this.midleMark = s.midleMark;
        this.parentName = s.parentName;
    }
    
    public String toString(){
        return super.toString() + ", MidleMark: " + midleMark + ", parent name: " + parentName;
    }
    /**
     * createPair create пары людей
     * здесь student-parent
     * поиск совпадений по отчеству student и имени parent
     * @return rez
     */
    
    // TODO: доделать
    public HumansPair createPair(ArrayList<Human> humans){
        java.lang.Class FoundClass = Parent.class;
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getClass() == FoundClass && this.getParentName() != null) {
                if (this.getParentName().equals(humans.get(i).getName())){
                    humans.get(i).setHaveKid(true);
                    this.setHaveParent(true);
                    return new HumansPair<Student, Parent>(this, (Parent)humans.get(i));
                }
            }
        }
        return new HumansPair<Student, Parent>(this, null);
    }
}
