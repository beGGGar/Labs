package Controller;

import Model.*;
import View.View;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.util.*;
/**
 * 
 * @author vdmoi
 */

public class Main {
    private static final String DataBasePath = "notes.txt";
    
    
    public static void main(String args[]) throws IOException {
        AppStates.appStart();
        //AppStates.authorization();
        
        int maxDegree = 4;
        for (int i = 0; i<maxDegree; i++){
            HumanCollection.RunTimeArrayList((int)Math.pow(10, i+1), i+1);
            HumanCollection.RunTimeLinkedList((int)Math.pow(10, i+1), i+1+maxDegree);
        }
        AppStates.appStop();
    }
}