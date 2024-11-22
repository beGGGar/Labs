import Controller.*;
/**
 *
 * @author vdmoi
 */
public class MapCoverage {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        int width = 1440;
        int height = 720;
        Converter.CSVtoPNG("src/CSV/MOD_LSTAD_M_2000-03-01_rgb_3600x1800.CSV", width, height);
    }
}
