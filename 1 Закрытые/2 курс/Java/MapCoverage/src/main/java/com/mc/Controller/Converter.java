package com.mc.Controller;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




public class Converter {

    
    /** 
     * @param FilePath
     * @param width
     * @param height
     */
    public static void CSVtoPNG(String FilePath, int width, int height){

        // Создаем изображение
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            String line;
            int y = 0;
            float temperature;
            Color color;
            //int pixelCount = 0;
            // float max = 0, min = 0;
            
            while ((line = br.readLine()) != null && y < height) {
                String[] values = line.split(",");

                for (int x = 0; x < width; x++) {
                    try{
                        // парсинг float
                        temperature = Float.parseFloat(values[x]); 
                        
                    }catch(Exception E){
                        // количество значений может быть ниже х
                        temperature = 99999.0f;
                        System.out.println("Ошибка при parseFloat при х=" + x + " y=" + y);

                    }

                    //temperature = Float.parseFloat(values[x]); 
                    // if (temperature > max && temperature < 9999)max = temperature;
                    // if (temperature < min)min = temperature;
                    
                    color = getColorForTemperature(temperature, 12);
                    image.setRGB(x, y, color.getRGB());
                    //pixelCount++;
                }
                y++;
            }
            // System.out.println(min + " " + max);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Сохраняем изображение
        try {
            String[] path = FilePath.split("/");
            String fileName = path[path.length - 1];
            ImageIO.write(image, "png", new java.io.File("src/main/resources/Img/" + fileName + ".png")); // Укажите путь для сохранения
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @param temperature
     * @return Color
     */
    public static Color getColorForTemperature(float temperature, int minmax) {
        int color = (int) (255 - Math.abs(temperature) *255 / minmax);

        // Генерируем цвет
        if (temperature == 99999.0){
            return new Color(100, 100, 100); // фон
        }else if(temperature == 1000.0){
            //зеленый для фильтров
            return new Color(0, 255, 0);
        }else if (temperature < 0) {
            // Синий к белому;
            return new Color(color, color, 255);
        } else if (temperature >= 0) {
            // Красный к белому
            return new Color(255, color, color);
        } 
        System.out.println("ERR in getColorForTemperature, TEMP = " + temperature);
        return new Color(0,0,0);
    }    

    
    public static float[][] CSVtoARRAY(String FilePath, int width, int height){
        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            float[][] TempMap= new float[height][width];
            String line;
            int y = 0;
            float temperature;
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                for (int x = 0; x < width; x++) {
                    try{
                        // парсинг float
                        temperature = Float.parseFloat(values[x]); 
                    }catch(Exception E){
                        // количество значений может быть ниже х
                        temperature = 99999.0f;

                        System.out.println("Ошибка при parseFloat при х=" + x + " y=" + y);
                    }
                    TempMap[y][x] = temperature;                   
                }
                y++;
                if (y>=height)break;
            }
            // for(y = 0; y<height; y++){
            //     for(int x = 0; x < width; x++){
            //         System.out.println(TempMap[y][x] + ",");
            //     }
            // }
            return TempMap;
        
        } catch (IOException e) {
            System.out.println(e.toString());
        }

        return new float[width][height];
    }


    public static void ARRAYtoCSV(String CSVName, float[][] data){
        int width = data[0].length;
        int height = data.length;

        String buff;
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(CSVName))) {
            for (int y = 0; y < height; y++ ){
                buff = "";
                for (int x = 0; x < width; x++){
                    buff = buff + data[y][x] + ",";
                }
                bw.write(buff);
                bw.newLine();
                
            }
        }catch(IOException e){System.out.println("что-то в arraytocsv");}
    }
}
