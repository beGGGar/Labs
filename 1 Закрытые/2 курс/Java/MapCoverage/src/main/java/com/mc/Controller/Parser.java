package com.mc.Controller;

import java.io.InputStream;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.HashMap;
import java.util.Map.Entry;

import java.net.URI;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Обеспечивает скачивание актуальных файлов из NASA dataset
 */
public class Parser {

    /**
     * Парсит все ID файлов для формирования ссылок на скачивание
     * @param width
     * @param height
     * @return
     */
    public static HashMap<String, String> ParseAllDownloadLinksID(int width, int height){
        String url = "https://neo.gsfc.nasa.gov/view.php?datasetId=MOD_LSTAD_M&year=";
        String ActualUrl;
        HashMap<String, String> IdWithDate = new HashMap<>(); // ключ - id, значение - дата создания данных
        String downloadID;
        String date;

        for (int year = 2000; year<2002; year++){

            ActualUrl = url+year;
            try {
                Document document = Jsoup.connect(ActualUrl).get();
                String html = document.outerHtml();
                String[] htmlArray = html.split("\\n");

                // вытаскиваем из html номера ссылок на скачивание из строк <a onclick="viewDataset('1785067','2020-02-01');" href="javascript:void(0);">
                for (int i = 0; i < htmlArray.length; i++){
                    if (htmlArray[i].contains("a onclick=\"viewDataset")){
                        downloadID = htmlArray[i].split("\'")[1];
                        date = htmlArray[i].split("\'")[3];
                        IdWithDate.put(downloadID, date);
                    }    
                }                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Составлен массив номеров ссылок.");
        return IdWithDate;
    }

    /**
     * Скачивает файлы из NASA dataset по заданным параметрам
     * @param width
     * @param height
     * @param FileExtention
     * @param Type
     */
    public static void FileDownloader(int width, int height, String FileExtention, String GroupName){
        // "https://neo.gsfc.nasa.gov/servlet/RenderData?si=" + downloadID + "&cs=rgb&format=CSV&width=" + width + "&height=" + height;
        HashMap<String, String> IdWithDate = ParseAllDownloadLinksID(width, height);
        String pathToFiles = "src/main/resources/" + FileExtention + "/"; // путь до папки с файлами
        String DLLink;
        String FileName = "";

        URL url;

        if (!IdWithDate.isEmpty()){
            for (Entry<String, String> pair : IdWithDate.entrySet()) {
                try {
                    DLLink = "https://neo.gsfc.nasa.gov/servlet/RenderData?si=" + pair.getKey() + "&cs=rgb&format=" + FileExtention + "&width=" + width + "&height=" + height;
                    FileName = GroupName + "_" + pair.getKey() + "_" + pair.getValue() + "_" + width + "x" + height + "." + FileExtention;
                    System.out.print("Скачивание файла " + FileName + "\t");
                    Path path = Paths.get(pathToFiles + FileName);
                    

                    if (Files.exists(path) && Files.isRegularFile(path)) {
                        System.out.println("Файл уже скачан: " + FileName);
                    } else {
                        Files.createDirectories(path.getParent()); // Создаем директории, если их нет. Проверка на существование файла
                        //Скачивание файла
                    url = URI.create(DLLink).toURL();
                    InputStream in = url.openStream();
                    Files.copy(in, path); // Копируем файл
                    in.close();
                    System.out.println("Файл успешно скачан.");
                    }
                    
                }
                
                catch (AccessDeniedException e) {
                    System.err.println("Доступ к файлу запрещен: " + e.getMessage());
                }catch (FileAlreadyExistsException e){
                    System.out.println("Файл уже скачан: " + FileName);
                }catch (Exception e) {
                    System.err.println("Ошибка: " + e.toString());
                }
            }
        } else System.out.println("Ошибка: Файлы не были найдены в базе NASA!");
    }
}