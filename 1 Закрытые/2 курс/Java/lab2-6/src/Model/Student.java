package Model;
import java.util.ArrayList;

public class Student extends Human {
    protected double midleMark;
    
    
    /** 
     * @return double
     */
    public double getMidleMark(){
        return this.midleMark;
    }
    
    
    /** 
     * @param midleMark
     */
    public void setMidleMArk(double midleMark){
        if (midleMark>=0){
            this.midleMark = midleMark;
        }
    }
    
    public Student(String name, String parentName, int age, Sex sex, double midleMark){
        super(name, parentName, age, sex);
        this.midleMark = midleMark;
        this.parentName = parentName;
    }
    
    public Student(){
        super();
        this.midleMark = 0;
        this.parentName = "None";
    }
    
    public Student(Student s){
        super(s.getName(), s.getParentName(), s.getAge(), s.getSex());
        this.midleMark = s.midleMark;
        this.parentName = s.parentName;
    }
    @Override
    public String toString(){
        return super.toString() + "\t" + midleMark;
    }
    /**
     * метод ищет родителя по отчеству студента
     * возвращается сумма строк toString от студента и родителя
     * @return rez
     */
    @Override
    public String CreatePair(ArrayList<Human> humans){
        for (int i = 0; i<humans.size(); i++){
            if(humans.get(i).getClass() == Parent.class){
                if(humans.get(i).getName().equals(this.parentName) ){
                    return "Pair\t" + this.toString() + "\t" + humans.get(i).toString();
                }
            }
        }
        return "NOPair\t" + this.toString();
    }
}
