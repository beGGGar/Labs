package com.beg_gar.lab8;

import com.beg_gar.Model.*;

/**
 *
 * @author vdmoi
 */
public class ServerMain {
    private static int PORT = 12345;
    private static String ServerName = "MyServer";
    private static int MaxConnections = 100;
    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        Server server = new Server(ServerName, PORT, MaxConnections);
        server.Start(); 
    }
}
