package com.beg_gar.lab8;

import java.util.ArrayList;

import com.beg_gar.Controller.RandomName;
import com.beg_gar.Model.Client;
import com.beg_gar.Model.Server;

public class ClientMain {
    private static int PORT = 12345;
    private static String ipLocal = "127.0.0.1";
    private static int MaxClient = 20;
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        // Client cl = new Client(RandomName.getRandomName());
        // cl.Start(ipLocal, PORT);


        ArrayList<Client> list = new ArrayList<>();
        
        
        for (int i = 0; i < MaxClient; i++) {
            Client cl = new Client(RandomName.getRandomName());
            // Добавляем клиента в список
            list.add(cl);
            // Запускаем клиента в отдельном потоке

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // Каждый клиент будет подключаться и работать в своем потоке
                    cl.Start(ipLocal, PORT);
                    System.out.println("Client " + cl.getName() + " connected.");
                }
            }).start();
        }
        Server.updateClientList();
    }
}
