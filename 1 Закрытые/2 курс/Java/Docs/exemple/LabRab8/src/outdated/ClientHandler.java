package outdated;



import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Client;

public class ClientHandler implements Runnable{
    @Override
    /**
     * Переопределённый метод, запускающийся при запуске потока, отправляет данные на сервер
     */
    public void run() {
        BufferedReader dis = null;
        try {
            dis = new BufferedReader(new InputStreamReader(Client.connection.getInputStream()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        while(true){
            try {
                try {
                    if(dis.readLine() == null){
                        break;
                    }
                    String msg = dis.readLine();
                } catch (IOException e) {
                    break;
                }
                Thread.sleep(10);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}