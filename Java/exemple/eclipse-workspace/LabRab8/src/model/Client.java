package model;
import java.io.*;
import java.net.*;


public class Client {
    public static Socket connection;
    public String name = "";
    
    public Client(String name){
        this.name = name;
    }

    /**
     * Функция запуска клиента
     * Подключается сокет
     * Отправляется запрос
     */
    public void start(){
        try{
            connection = new Socket(InetAddress.getByName("127.0.0.1"), 5050);
            PrintStream ps = new PrintStream(connection.getOutputStream());
            ps.println(name + " 127.0.0.1");
            ps.flush();
        } catch(Exception err){
            System.out.println(err.getMessage());
        }
    }
}