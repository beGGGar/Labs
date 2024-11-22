package Model;
import java.util.ArrayList;
import java.awt.EventQueue;

import Controller.ErrMsgLog;

/**
 *класс родитель стандартный
 * @author vdmoi
 */
public class Parent extends Human implements INewClassInput{
    
    public Parent(){
        super();
    }
    
    public Parent(String name, String parentName, int age, Sex sex){
        super(name, parentName, age, sex);
    }
    
    public Parent(Parent p){
        super(p.getName(), p.getParentName(), p.getAge(), p.getSex());
    }
    
    
    /** 
     * @return String
     */
    @Override
    public String toString() {
	return super.toString();
    }
    /**
     * метод ищет студента по имени родителя
     * возвращается сумма строк toString от студента и родителя
     * @param humans
     * @return 
     */
    @Override
    public String CreatePair(ArrayList<Human> humans){
        for (int i = 0; i<humans.size(); i++){
            if(humans.get(i).getClass() == Student.class){
                if(humans.get(i).getParentName().equals(this.name) ){
                    return "Pair\t" + this.toString() + "\t" + humans.get(i).toString();
                }
            }
        }
        return "NOPair\t" + this.toString();
    }

    @Override
    public Object addNew() {
        // EventQueue.invokeLater(new Runnable(){public void run(){
        //     try {
        //         FrameClass frame = new FrameClass(this);
        //         frame.setVisible(true);
        //     } catch (Exception e) {
        //         ErrMsgLog.addErrWithLog(e);
        //     }
        // }});
        // return age;
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeExisting'");
    }

    
}