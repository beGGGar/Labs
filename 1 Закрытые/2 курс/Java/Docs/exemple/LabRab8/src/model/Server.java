package model;
import view.ServerFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.HashMap;

public class Server {
    /**
     * Коллекция для хранения сокетов, чтобы сохранять покдлючение к клиентам
     */
    public volatile static HashMap<Integer, Socket> mapOfSockets = new HashMap<>();
    /**
     * Список строк с описанием каждого клиента для вывода на главный экран
     */
    public volatile static HashMap<Integer, String> mapOfString = new HashMap<>();
    /**
     * Сокет для установки соединения
     */
    private final ServerSocket serverSocket;
    /**
     * Определяет ключ в коллекциях
     */
    private int counter = 0;
 

    /**
     * Конструткор сервера
     * @param adminName имя админа
     * @param nameServer имя сервера
     * @throws IOException может вызваться при инициализации серверного сокета
     */
    public Server(String adminName, String nameServer) throws IOException {
        new ServerFrame(adminName, nameServer);
        serverSocket = new ServerSocket(5050, 100);
        ServerFrame.remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int key = -1;
                for (int k : Server.mapOfString.keySet()) {
                    try {
                        if (k == Integer.parseInt(ServerFrame.textId.getText())) {
                            key = k;
                        }
                    }catch(NumberFormatException err){
                        System.out.println("Error : id не существует");
                   
                    }
                }
                if(key >= 0) {
                    ServerFrame.textId.setText("");
                        mapOfString.remove(key);
                        try {
                            mapOfSockets.get(key).close();
                        } catch (IOException err) {
                            System.out.println("Error : " + err.getMessage());
                        }
                        mapOfSockets.remove(key);
                    } else {
                    System.out.println("Error : id не существует");
                    
                }
                    String[] mas = mapOfString.values().toArray(new String[0]);
                    ServerFrame.list.setListData(mas);
                    ServerFrame.frame.revalidate();
                
            }
        });
    }

    /**
     * Запуск работы сервера
     */
    public void start() {
        Socket sock = null;
        do {
            try {
                sock = serverSocket.accept();
                BufferedReader dis = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                String msg = dis.readLine();
                    mapOfSockets.put(counter, sock);
                    mapOfString.put(counter, msg + " - ID : [" + counter + "]");
                
                String[] mas = mapOfString.values().toArray(new String[0]);
                ServerFrame.list.setListData(mas);
                ServerFrame.frame.revalidate();
                counter++;
            } catch (IOException err) {
            	
            	 System.out.println("IO Exception");
            }
        } while (counter <= 100);
    }
}