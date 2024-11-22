package com.mc.Controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Filter {
    /**
     * Путь до обрабатываемых файлов
     */
    public static String directoryPath = "src/main/resources/CSV";

    /**
     * Обработка данных и поиск зон, соответствующих фильтру
     * @param GroupName
     * @param width
     * @param height
     */
    public static void AverageAnomalyFilter(String FilterName, String GroupName, int width, int height){
        int requiredFrequency = 50; // Частота в процентах
        float lowerLim = 0.0f;
        float upperLim = 12.0f; 
        int FileCount = Tools.CountFiles("src/main/resources/CSV", GroupName); //сколько нужных файлов в директории CSV  
        float[][][] data = new float[FileCount][height][width];
        int[][] counter = new int[height][width];
        
        File directory = new File(directoryPath);
        String path;
        int i = 0;
        // парсим файлы в единый массив
        if (directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                for (String fileName : files) {
                    if (fileName.contains(GroupName)) {
                        path = "src/main/resources/CSV/" + fileName;
                        data[i++] = Converter.CSVtoARRAY(path, width, height);
                    }
                }
                
            } else {
                System.out.println("Каталог пуст");
            }
        } else {
            System.out.println("Указанный путь не является каталогом.");
        }

        // если температура выше 0
        for (int count = 0; count < FileCount; count++){
            for (int y = 0; y<height; y++){
                for (int x = 0; x < width; x++){
                    if (AverageAnomalyFilterValueCheck(data[count][y][x], lowerLim, upperLim))counter[y][x]++;
                }
            }
        }
        

        ////////////////////////////
        
        float[][] buff = data[0];
        int cb;
        for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++){
                cb = counter[y][x];
                if (cb<=FileCount*requiredFrequency/100){
                    buff[y][x] = 1000.0f;
                }
            }
        }
        Converter.ARRAYtoCSV("src/main/resources/CSV/" + FilterName + ".CSV", buff);
        Converter.CSVtoPNG("src/main/resources/CSV/" + FilterName + ".CSV", width, height);
        
        // Color color;
        // int max=0;


        // // наглядная проверка

        // BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        // int cb;
        // for (int y = 0; y < height; y++){
        //     for (int x = 0; x < width; x++){
        //         cb = counter[y][x];
        //         if(cb>max)max=cb;
        //         if (cb>FileCount*requiredFrequency/100-1 && cb<FileCount*requiredFrequency/100+1){
        //             color = new Color(0, 255, 0);
        //         }
        //         else {
        //             color = Converter.getColorForTemperature(data[0][y][x], 12);
        //         }
        //         image.setRGB(x, y, color.getRGB());

        //     }
        // }
        // System.out.println(max + " " + FileCount*requiredFrequency/100);
        // try {
        //     ImageIO.write(image, "png", new java.io.File("src/main/resources/Img/" + FilterName + ".png")); // Укажите путь для сохранения
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        


    }

    public static boolean AverageAnomalyFilterValueCheck(float value, float min, float max){
        return (value>min?true:false) && (value<max?true:false);
    }
}
