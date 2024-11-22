package Controller;

import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class Converter {

    public static void CSVtoPNG(String FilePath, int width, int height){

        // Создаем изображение
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        try (BufferedReader br = new BufferedReader(new FileReader(FilePath))) {
            String line;
            int y = 0;
            float temperature;
            Color color;
            float max = 0, min = 0;
            
            while ((line = br.readLine()) != null && y < height) {
                String[] values = line.split(",");

                for (int x = 0; x < width; x++) {
                    // try{
                    //     //замена , на . и парсинг float
                    //     temperature = Float.parseFloat(values[x].replace(",", ".")); 
                    //     System.out.print(1);
                    // }catch(Exception E){
                    //     // количество значений может быть ниже х
                    //     temperature = (float) 0.99999;
                    //     System.out.print(0);
                    // }
                    temperature = Float.parseFloat(values[x]); 
                    if (temperature > max && temperature < 9999)max = temperature;
                    if (temperature < min)min = temperature;
                    
                    color = getColorForTemperature(temperature, 12);
                    image.setRGB(x, y, color.getRGB());
                }
                y++;
            }
            System.out.println(min + " " + max);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Сохраняем изображение
        try {
            ImageIO.write(image, "png", new java.io.File("src/Img/output1.png")); // Укажите путь для сохранения
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    /** 
     * @param temperature
     * @return Color
     */
    private static Color getColorForTemperature(float temperature, int minmax) {
        int color = (int) (255 - Math.abs(temperature) *255 / minmax);

        // Генерируем цвет
        if (temperature == 99999.0){
            return new Color(100, 100, 100); // фон
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
}
