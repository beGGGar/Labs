/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 * создает пару из объектов-отпрысков суперкласса Human
 * @author vdmoi
 */
public class HumansPair<A, B> {
    private A obj1;
    private B obj2;
    
    public A getFirst(){
        return obj1;
    }
    
    public B getSecond(){
        return obj2;
    }
    
    public void setFirst(A a){
        obj1 = a;
    }
    
    public void setSecond(B b){
        obj2 = b;
    }
    
    public HumansPair(){}
    
    public HumansPair(A a, B b){
        obj1 = a;
        obj2 = b;
    }
    
    
    public String toString(){
        String res = "";
        if (isValid()){
            res = obj1.toString() + "\n" + obj2.toString();
            return res;
        }
        else{
            res = "Pair broken!";
            if (obj1 == null)
                res = res + "L";
            if (obj2 == null)
                res = res + "R";
            return res;
        }
            
        
    }
    
    public boolean isValid(){
        return obj1 != null && obj2 != null;
    }
}
