package com.beg_gar.Veiw;

import javax.swing.*;
import java.awt.*;


public class ServerFrame {
    /**
     * Меню со списком клиентов
     */
    public static JList<String> ClientList = new JList<>(new String[0]);
    /**
     * Кнопка для отключения сервера
     */
    public static JButton RemoveButton = new JButton("Disconnect");
    /**
     * Поле ввода id клиента для его отключения
     */
    public static JTextField IDTextField = new JTextField(10);
    /**
     * Основное окно
     */
    public static JFrame frame = new JFrame();
    /**
     * Панель с интерфейсом
     */
    public JPanel InterfacePanel = new JPanel();    
    /**
     * Панель со списком клиентов
     */
    public JPanel ClientPanel = new JPanel();

    /**
     * Главное окно
     * @param nameServer
     */
    public ServerFrame(String nameServer) {
        JLabel label = new JLabel("Введите ID клиента");

        frame.setSize(600, 300);
        frame.setTitle(nameServer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InterfacePanel.add(label);
        InterfacePanel.add(IDTextField);
        InterfacePanel.add(RemoveButton);
        ClientPanel.add(new JScrollPane(ClientList));

        frame.getContentPane().add(BorderLayout.NORTH, InterfacePanel);
        frame.getContentPane().add(BorderLayout.CENTER, ClientPanel);
        frame.setVisible(true);
    }
}