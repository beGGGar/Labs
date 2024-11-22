package com.beg_gar.Model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private String name;

    public Client(String name){
        this.name = name;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    
    /** 
     * @param ip
     * @param PORT
     */
    public void Start(String ip, int PORT){
        try(Socket socket = new Socket(InetAddress.getByName(ip), PORT);
            // отправка на сервер
            PrintStream ps = new PrintStream(socket.getOutputStream()); 
            // прием с мервера
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                
            ps.println(name + " " + ip);
            ps.flush();
            
            //ожидание команды с сервера
            String response;
            while ((response = br.readLine()) != null) {    
                
                System.out.println("Server: " + response);

                // Завершение при получении команды "exit"
                if ("exit".equalsIgnoreCase(response)) {
                    System.out.println("Client " + name + " " + ip + " was disconnected.");
                    break;
                }
            }
            if (response == null) {
                System.out.println("Server connection lost or closed.");
            }
        } catch(Exception err){
            System.out.println(err.getMessage() + " in client");
        }
    }
}
