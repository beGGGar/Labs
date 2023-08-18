package Main;

import View.*;
import Log.ErrMsgLog;
import Model.*;
import Frame.*;
import java.awt.EventQueue;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author vdmoi
 */

public class Main {
    public static void main(String args[]){
        AppStates.appStart();
        Graph gr = new Graph("src/Log/log1.txt");
                //System.out.println(gr.toString());
                
                gr.t();
        //HumanCollection.testStart(4);
        
        EventQueue.invokeLater(new Runnable(){
            @Override
            public void run(){
                Map <String, Object> application = new HashMap();
                
                
            }
        });
        

    }
}