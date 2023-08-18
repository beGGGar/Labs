package lab;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * . 
 * @author vdmoi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnsupportedEncodingException {
        String myString = "орвыап";
        byte bytes[] = null; 
        try {
            bytes = myString.getBytes("UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        String value = new String(bytes, "UTF-8"); 
        System.out.println(value);
        Controller ctrl = new Controller();
    }
    
}
