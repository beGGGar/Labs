package controller;
import model.*;
import model.Client;

public class ClientMain {
    public static void main(String[] args) throws InterruptedException {
        Client client = new Client("Client1");
        client.start();
    }
}