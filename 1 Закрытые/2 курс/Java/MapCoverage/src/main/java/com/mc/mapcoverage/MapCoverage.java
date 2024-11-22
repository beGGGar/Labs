package com.mc.mapcoverage;

import java.util.Scanner;

import com.mc.Controller.*;
/**
 *
 * @author vdmoi
 */
public class MapCoverage {
    
    /** 
     * @param args
     */
    public static void main(String[] args){
        String FileExtention = "CSV";
        int width = 1440;
        int height = 720;
        String Group = "MOD_LSTAD_M";//"MonthData";
        // ТЕСТ КОНВЕРТЕРА 
        // Converter.ARRAYtoCSV("src/main/resources/CSV/rtyu.CSV", Converter.CSVtoARRAY("src/main/resources/CSV/test.CSV", width, height));
        // Converter.CSVtoPNG("src/main/resources/CSV/rtyu.CSV", width, height);

        //Parser.FileDownloader(width, height, FileExtention, Group);
        Filter.AverageAnomalyFilter("FilterTest", Group, width, height);
        //Converter.CSVtoPNG("src/main/resources/CSV/test.CSV", width, height);
        // Converter.CSVtoARRAY("src/main/resources/CSV/MOD_LSTAD_M_2001-03-01_rgb_1440x720.CSV", width, height);
        //Parser.ParseDownloadLinkID("CSV", width, height);   MOD_LSTAD_M_2001-01-01_rgb_1440x720.CSV

        // String path;
        // for (int year = 2001; year<2003; year++){
        //     for (int month = 1; month<13; month++){
        //         path = "src/main/resources/CSV/MOD_LSTAD_M_" + year + "-" + (month<10? "0" : "") + month + "-01_rgb_1440x720.CSV";
        //         Converter.CSVtoPNG(path, width, height);
        //     }
        // }
        String a = "";
        Scanner sc = new Scanner(System.in);
        while (true){
            a = sc.nextLine();
            switch(a){
                
                
                case "":
                break;

                case "1":
                Converter.ARRAYtoCSV("src/main/resources/CSV/rtyu.CSV", Converter.CSVtoARRAY("src/main/resources/CSV/test.CSV", width, height));
                Converter.CSVtoPNG("src/main/resources/CSV/rtyu.CSV", width, height);
                System.out.println("Готово.");

                break;
                
                case "2":
                Filter.AverageAnomalyFilter("FilterTest", Group, width, height);
                System.out.println("Готово.");

                break;

                case "3":
                Parser.FileDownloader(width, height, FileExtention, Group);
                System.out.println("Готово.");
                break;

                default:
                System.out.println("В разработке");
                break;
            }
        }
        
    }
}
