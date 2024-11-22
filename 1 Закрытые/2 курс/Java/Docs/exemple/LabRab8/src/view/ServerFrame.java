package view;
import model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ServerFrame {
    /**
     * Меню со списком клиентов
     */
    public static JList<String> list = new JList<>(new String[0]);
    /**
     * Кнопка для отключения сервера
     */
    public static JButton remove = new JButton("Delete");
    /**
     * Поле ввода id клиента для его отключения
     */
    public static JTextField textId = new JTextField(10);
    /**
     * Основное окно
     */
    public static JFrame frame = new JFrame();
    /**
     * Панель с интерфейсом
     */
    public JPanel panel = new JPanel();
    /**
     * Панель со списком клиентов
     */
    public JPanel panel2 = new JPanel();
    /**
     * Панель, с выводом информации для админа
     */
    public JPanel panel3 = new JPanel();

    /**
     * Конструктор главного окна
     * @param nameAdmin Имя админа
     * @param nameServer Название сервера
     */
    public ServerFrame(String nameAdmin, String nameServer) {
        JLabel label = new JLabel("Введите ID клиента");
        frame.setSize(600, 300);
        frame.setTitle(nameServer);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(label);
        panel.add(textId);
        panel.add(remove);
        panel2.add(new JScrollPane(list));
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.CENTER, panel2);
        frame.getContentPane().add(BorderLayout.SOUTH, panel3);
        frame.setVisible(true);

    }
}