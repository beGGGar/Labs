/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Model;

import java.util.ArrayList;
import java.awt.EventQueue;

import Controller.ErrMsgLog;
import View.GraphFrame;
import View.View;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;



/**
 * String name, int age, Sex sex, double midleMark, String parentName, double pocketMoney
 * @author vdmoi
 */
public class Botany extends Student implements INewClassInput{
    private double pocketMoney;
    
    
    /** 
     * @return double
     */
    public double getSalary(){
        return this.pocketMoney;
    }
    
    
    /** 
     * @param pocketMoney
     */
    public void setSalary(double pocketMoney){
        if(pocketMoney>=0){
            this.pocketMoney = pocketMoney;
        }
    }
    
    public Botany(){
        super();
        this.pocketMoney = 0;
    }
    
    public Botany(String name, String parentName, int age, Sex sex, double midleMark){
        super(name, parentName, age, sex, midleMark);
        this.pocketMoney = Math.pow(10, midleMark);
    }
    
    public Botany(String name, String parentName, int age, Sex sex, double midleMark, double pocketMoney){
        super(name, parentName, age, sex, midleMark);
        this.pocketMoney = pocketMoney;
    }
    
    @Override
    public String toString(){
        return super.toString() + "\t" + this.pocketMoney;
    }
    /**
     * метод ищет крутого родителя по отчеству ботаника
 возвращается сумма строк toString от ботаника и крутого родителя
 а также определяет карманные деньги pocketMoney
     * @param humans
     * @return 
     */
    @Override
    public String CreatePair(ArrayList<Human> humans){
        Human H;
        double PM;
        for (int i = 0; i<humans.size(); i++){
            H = humans.get(i);
            if(H.getClass() == CoolParent.class){
                if(H.getName().equals(this.parentName) ){
                    PM = Double.parseDouble(H.toString().split("\t")[4]);
                    if (PM == this.pocketMoney){
                        return "Pair\t" + this.toString() + "\t" + H.toString();
                    }
                }
            }
        }
        return "NOPair\t" + this.toString();
    }

    @Override
    public Object addNew() {
        String param1 = this.toString();
        String param2 = this.getClass().getSimpleName();
        Botany human = new Botany();
        EventQueue.invokeLater(new Runnable(){public void run(){
                    FrameClass frame = new FrameClass(param2, param1);
                    frame.buttonSave.addActionListener(new ButtonEventListener(frame, human));
                    frame.setVisible(true);
                }});
        
        if (human.equals(new Botany()))return null;

        return human; // Возврат null, пока не будет создан объект
    }

    class ButtonEventListener implements ActionListener {
        private FrameClass frame;
        private Botany human;

        public ButtonEventListener(FrameClass frame, Botany human) {
            this.frame = frame;
            this.human = human;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String name = frame.TField1.getText();
                String parentName = frame.TField2.getText();
                int age = Integer.parseInt(frame.TField3.getText());
                Sex sex = frame.radioOption1.isSelected() ? Sex.man : Sex.woman;
                double sessionMark = Double.parseDouble(frame.TField5.getText());
                double pocketMoney = Double.parseDouble(frame.TField6.getText());

                // Проверки вводимых данных
                if (!Character.isUpperCase(name.charAt(0))) {
                    System.out.println("Имя должно начинаться с заглавной буквы: " + name);
                    return;
                }

                if (!Character.isUpperCase(parentName.charAt(0))) {
                    System.out.println("Отчество должно начинаться с заглавной буквы: " + parentName);
                    return;
                }

                if (age < 1 || age > 110) {
                    System.out.println("Возраст - целое от 1 до 110: " + age);
                    return;
                }

                if (sessionMark < 2 || sessionMark > 5) {
                    System.out.println("Оценка от 2 до 5: " + sessionMark);
                    return;
                }

                if (pocketMoney < 10 || pocketMoney > 100000) {
                    System.out.println("Карманные деньги от 10 до 100000: " + pocketMoney);
                    return;
                }
                human.setName(name);
                human.setParentName(parentName);
                human.setAge(age);
                human.setSex(sex);
                human.setMidleMArk(sessionMark);
                human.setSalary(pocketMoney);
                JOptionPane.showMessageDialog(null, "Сохранено","Output", JOptionPane.PLAIN_MESSAGE);
                frame.dispose();
            }catch(Exception E){
                System.out.println("Неправильный ввод");
            }
            
            

            // Если все проверки пройдены, создаем новый объект Botany
            
            // Возвращаем или обрабатываем созданный объект как нужно
        }
    }
    // @Override
    // public Object addNew() {
    // String param1 = this.toString();
    // String param2 = this.getClass().getSimpleName();
    // // EventQueue.invokeLater(new Runnable() {
    // //     public void run() {
    // String name = "";
    // String fatherName = "";
    // int age = 0;
    // Sex sex = Sex.None;
    // double sessionMark = 0;
    // double pocketMoney = 0;
    // while (true) {
    //     try {
    //         FrameClass frame = new FrameClass(param2, param1);
    //         frame.setVisible(true);
        

    //         name = frame.TField1.getText();
    //         // Проверка имени
    //         if (!Character.isUpperCase(name.charAt(0))) {
    //             System.out.println("Имя должно начинаться с заглавной буквы: " + name);
    //             continue;
    //         }

    //         parentName  = frame.TField2.getText();
    //         // Проверка отчеств
    //         if (!Character.isUpperCase(parentName.charAt(0))) {
    //             System.out.println("Отчество должно начинаться с заглавной буквы: " + fatherName);
    //             continue;
    //         }

    //         age = Integer.parseInt(frame.TField3.getText());
    //         // Проверка возраста
    //         if (age < 1 || age > 110) {
    //             System.out.println("Возраст - целое от 0 до 110: " + age);
    //             continue;
    //         }

    //         // Проверка пола
    //         if (frame.radioOption1.isSelected()) {
    //             sex = Sex.man;
    //         } else if (frame.radioOption2.isSelected()) {
    //             sex = Sex.woman;
    //         } else {
    //             System.out.println("Пол не выбран. Смиритесь со своим");
    //             continue;
    //         }

    //         sessionMark = Float.parseFloat(frame.TField5.getText());
    //         // Проверка среднего балла
    //         if (sessionMark < 2 || sessionMark > 5) {
    //             System.out.println("Оценка от 2 до 5: " + sessionMark);
    //             continue;
    //         }

    //         pocketMoney = Double.parseDouble(frame.TField6.getText());
    //         // Проверка карманных денег
    //         if (pocketMoney < 10 || pocketMoney > 100000) {
    //             System.out.println("Карманные деньги от 10 до 100000: " + pocketMoney);
    //             continue;
    //         }

    //         return new Botany(name, fatherName, age, sex, sessionMark, pocketMoney);
    //     }
    //     catch (Exception e) {
    //         System.out.println(e);
    //         System.out.println(2);
    //         ErrMsgLog.addErrWithLog(e);
    //     } 
    //     System.out.println(3);
    //     return 0;
    //     }
    // }


    // @Override
    // public String validateInputs(String[] params) {
        
    //     if(params.length==0) return "Не передано данных";
    //     // Проверка имени
    //     if (!Character.isUpperCase(params[0].charAt(0))) {
    //         return "Имя должно начинаться с заглавной буквы";
    //     }
    
    //     // Проверка отчеств
    //     if (!Character.isUpperCase(params[1].charAt(0))) {
    //         return "Отчество должно начинаться с заглавной буквы";
    //     }
    
    //     // Проверка возраста
    //     int age = Integer.parseInt(params[2]);
    //     // Проверка возраста
    //     if (age < 1 || age > 110) {
    //         return "Возраст должен быть от 1 до 110";
    //     }

    //     double midleMark = Float.parseFloat(params[3]);
    //     // Проверка среднего балла
    //     if (midleMark < 2 || midleMark > 5) {
    //         System.out.println("Оценка от 2 до 5: " + midleMark);
    //         continue;
    //     }

    
    //     // Проверка среднего балла
    //     if (midleMark < 2 || midleMark > 5) {
    //         return "Средний балл должен быть от 2 до 5";
    //     }
    
    //     // Проверка карманных денег
    //     if (pocketMoney < 10 || pocketMoney > 100000) {
    //         return "Карманные деньги должны быть от 10 до 100000";
    //     }
    //     ///////////////////
    //     if (!Character.isUpperCase(name.charAt(0))) {
    //         System.out.println("Имя должно начинаться с заглавной буквы: " + name);
    //         continue;
    //     }
        
    //     parentName  = frame.TField2.getText();
    //     // Проверка отчеств
    //     if (!Character.isUpperCase(parentName.charAt(0))) {
    //         System.out.println("Отчество должно начинаться с заглавной буквы: " + fatherName);
    //         continue;
    //     }

    //     age = Integer.parseInt(frame.TField3.getText());
    //     // Проверка возраста
    //     if (age < 1 || age > 110) {
    //         System.out.println("Возраст - целое от 0 до 110: " + age);
    //         continue;
    //     }

    //     // Проверка пола
    //     if (frame.radioOption1.isSelected()) {
    //         sex = Sex.man;
    //     } else if (frame.radioOption2.isSelected()) {
    //         sex = Sex.woman;
    //     } else {
    //         System.out.println("Пол не выбран. Смиритесь со своим");
    //         continue;
    //     }

    //     sessionMark = Float.parseFloat(frame.TField5.getText());
    //     // Проверка среднего балла
    //     if (sessionMark < 2 || sessionMark > 5) {
    //         System.out.println("Оценка от 2 до 5: " + sessionMark);
    //         continue;
    //     }

    //     pocketMoney = Double.parseDouble(frame.TField6.getText());
    //     // Проверка карманных денег
    //     if (pocketMoney < 10 || pocketMoney > 100000) {
    //         System.out.println("Карманные деньги от 10 до 100000: " + pocketMoney);
    //         continue;
    
    //     return "Valid"; // Все проверки пройдены успешно
    // }
}
