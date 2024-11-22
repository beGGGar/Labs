import Model.*;
import View.*;
import Controller.*;

import java.io.IOException;
import java.util.ArrayList;


import java.awt.*;




public class Main{
    protected static String SavePath = "/src";
    /** 
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException{ 
        
        AppStates.appStart();
        ArrayList<Human> humans = new ArrayList<Human>();

        boolean autorisated = AppStates.authorization();
        if (!autorisated){
            System.out.println("Права ограничены. Возможен лишь просмотр дефолтных значений");
            HumanCollection.AddDefaultPeoples(humans);
            View.printHumans(humans);
        }


        int a = -1;
        while (autorisated && a!=0){
            View.menu();
            a = Controller.getInt();
            switch(a){
                case 1:
                View.printHumans(humans);
                System.out.println(((Object)(humans.get(0))).getClass());
                //  System.out.println(humans.get(0).toString().split("\t").length);
                
                break;

                case 2:
                humans = HumanCollection.loadFromFile(SavePath);
                break;

                case 3:
                HumanCollection.saveToFile(humans, SavePath, false);
                break;

                case 4:
                HumanCollection.saveToFile(humans, SavePath, true);
                break;

                case 5:
                HumanCollection.AddDefaultPeoples(humans);
                break;

                case 6:
                View.tytleMassegeOfNumber();
                int n = Controller.getInt();
                HumanCollection.createRandomHumans(humans, n);
                break;

                case 7: 
                View.printPairs(humans);
                break;

                case 8:
                //тесты
                int maxDegree = 5;
                for (int i = 0; i<maxDegree; i++){
                    HumanCollection.RunTimeArrayList((int)Math.pow(10, i+1), i+1);
                    HumanCollection.RunTimeLinkedList((int)Math.pow(10, i+1), i+1+maxDegree);
                }
                break;

                case 9:
                // вывод логов в график
                LogParser.ParseAllLogs(5);
                EventQueue.invokeLater(new Runnable(){public void run(){
                    try {
                        GraphFrame frame = new GraphFrame();
                        frame.setVisible(true);
                    } catch (InterruptedException e) {
                        ErrMsgLog.addErrWithLog(e);
                    }
                }});
                break;

                case 10: 
                Botany p = new Botany();
                p = (Botany) p.addNew();
                humans.add(p);
                break;

                case 0:
                break;

                default:
                System.out.println("В разработке");
                break;
            }
        }
        AppStates.appStop();
    }
}