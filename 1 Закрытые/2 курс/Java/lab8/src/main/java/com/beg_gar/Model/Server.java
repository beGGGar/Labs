package com.beg_gar.Model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.beg_gar.Veiw.ServerFrame;

public class Server {
    private String ServerName;
    private int PORT;
    private int MaxConnections;
    /**
     * Коллекции для хранения сокетов и информации о клиентах
     */
    public volatile static HashMap<Integer, Socket> mapOfSockets = new HashMap<>();
    public volatile static HashMap<Integer, String> mapOfString = new HashMap<>();

    private ServerSocket serverSocket;
        /**
         * Определяет ключ в коллекциях
         */
    private int counter = 0;

    public Server(String ServerName, int PORT, int MaxConnections){
        this.ServerName = ServerName;
        this.PORT = PORT;
        this.MaxConnections = MaxConnections;
    }

    public static void updateClientList() {
        // Обновление списка клиентов в UI
        String[] clientList = mapOfString.values().toArray(new String[0]);
        ServerFrame.ClientList.setListData(clientList);
        ServerFrame.frame.revalidate();
    }

    
    /** 
     * @return ActionListener
     */
    private ActionListener RemoveActionListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = -1;
                try {
                    key = Integer.parseInt(ServerFrame.IDTextField.getText());
                    if (key >= 0 && Server.mapOfString.containsKey(key)) {
                        // Если ключ существует в mapOfString
                        ServerFrame.IDTextField.setText("");
                        Server.mapOfString.remove(key);
                        
                        // отключение и Удаление из списка


                        if (Server.mapOfSockets.containsKey(key)) {
                            try(PrintWriter writer = new PrintWriter(mapOfSockets.get(key).getOutputStream(), true);){
                                //Server.mapOfSockets.get(key).close();????????????
                                writer.write("exit");
                                Server.mapOfSockets.remove(key);
                                Server.mapOfString.remove(key);
                            }catch(IOException err){
                                System.out.println("Error : " + err.getMessage());
                            }
                        }                       
                        
        
                        // Обновление списка в UI
                        updateClientList();
                    } else {
                        System.out.println("Error : id не существует");
                    }
                } catch (NumberFormatException err) {
                    System.out.println("Error : id нействителен");
                }
    
                
            }
        };
    }


    public void Start(){
        /**
         * Запуск сервера
         */
        Socket socket;
        try {
            new ServerFrame(ServerName);
            ServerFrame.RemoveButton.addActionListener(RemoveActionListener());

            serverSocket = new ServerSocket(PORT); // serverSocket = new ServerSocket(PORT, MaxConnections);
            System.out.println("Сервер запущен");

            /**
             * Подключение клиентов
             */
            do{
                socket = serverSocket.accept();
                BufferedReader dis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String msg = dis.readLine();

                mapOfSockets.put(counter, socket);
                mapOfString.put(counter, msg + " - ID : [" + counter + "]");
                updateClientList();

                new ClientHandler(socket, counter).start();

                counter++;
            }while(true);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }       
    }

    /**
     * Внутренний класс обработчика клиентов
     */
    private static class ClientHandler extends Thread {
        private final Socket socket;
        private final int clientId;

        public ClientHandler(Socket socket, int clientId) {
            this.socket = socket;
            this.clientId = clientId;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {
                
                // Чтение сообщений от клиента
                String message;
                while ((message = reader.readLine()) != null) {
                    System.out.println("Received from client " + clientId + ": " + message);

                    // Отправка ответа клиенту
                    writer.println("Server response to client " + clientId + ": " + message);

                    if ("exit".equalsIgnoreCase(message)) {
                        break;
                    }
                }
            } catch (IOException e) {
                System.out.println("Error handling client " + clientId + ": " + e.getMessage());
            } finally {
                // Закрытие соединения с клиентом
                try {
                    socket.close();
                    mapOfSockets.remove(clientId);
                    mapOfString.remove(clientId);
                    // обновление списка в фрейме
                    updateClientList();
                } catch (IOException e) {
                    System.out.println("Error closing socket for client " + clientId + ": " + e.getMessage());
                }
            }
        }
    }
}
