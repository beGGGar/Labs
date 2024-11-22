package controller;

import model.*;
import java.io.IOException;

/**
 * Класс для запуска программы
 */
public class Main {
    /**
     * Точка входа программы
     * @param args Аргументы командной строки
     * @throws IOException Может вызваться при создании сервера
     */
    public static void main(String[] args) throws IOException {
    	
        Server server = new Server("Nik", "Server");
        server.start();
    }
}