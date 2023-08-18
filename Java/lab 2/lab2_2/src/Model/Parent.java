package Model;
import java.util.ArrayList;
/**
 *класс родитель стандартный
 * @author vdmoi
 */
public class Parent extends Human {
    
    public Parent(){
        super();
    }
    
    public Parent(String name, int age, Sex sex){
        super(name, age, sex);
    }
    
    public Parent(Parent p){
        super(p.getName(), p.getAge(), p.getSex());
    }
    
    //сказано для каждого - сделано
    @Override
    public String toString() {
		return super.toString();
	}

    public HumansPair createPair(ArrayList<Human> humans){
        java.lang.Class FoundClass = Student.class;
        for (int i = 0; i < humans.size(); i++) {
            if (humans.get(i).getClass() == FoundClass && humans.get(i).getParentName() != null) {
                if (humans.get(i).getParentName().equals(this.getName())){
                    humans.get(i).setHaveParent(true);
                    this.setHaveKid(true);
                    return new HumansPair<Parent, Student>(this, (Student)humans.get(i));
                }
            }
        }
        return new HumansPair<Parent, Student>(this, null);
    }
    
}
            
    


