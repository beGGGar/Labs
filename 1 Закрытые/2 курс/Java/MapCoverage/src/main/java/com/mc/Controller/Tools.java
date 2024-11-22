package com.mc.Controller;

import java.io.File;

public class Tools {
    /**
     * Подсчитывает файлы в директории, включающие в названии FileNamePart
     * @param directoryPath
     * @param FileNamePart
     * @return
     */
    public static int CountFiles(String directoryPath, String FileNamePart) {

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] files = directory.list();
            if (files != null) {
                int count = 0;
                for (String fileName : files) {
                    if (fileName.contains(FileNamePart)) {
                        count++;
                    }
                }
                return count;
            } else {
                System.out.println("Каталог пуст");
            }
        } else {
            System.out.println("Указанный путь не является каталогом.");
        }
        return -1;
    }
}
