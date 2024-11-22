package ru.miet.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorFrame extends JFrame {
    private JTextField display = new JTextField();
    private String currentInput = "";

    public CalculatorFrame() {
        // Настройка окна
        setTitle("Калькулятор");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Окно по центру экрана

        // Основной панель для калькулятора
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Поле для ввода/вывода
        
        //display.setFont(new Font("Arial", Font.PLAIN, 24));
        display.setHorizontalAlignment(JTextField.RIGHT); // ориентация текста
        display.setEditable(false);
        panel.add(display, BorderLayout.NORTH);

        // Панель с кнопками калькулятора
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));

        // Кнопки калькулятора
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };

        // Добавление кнопок на панель
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 24));
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel, BorderLayout.CENTER);
        add(panel);

        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("=")) {
                try {
                    // Вычисление выражения
                    currentInput = evaluateExpression(currentInput);
                    display.setText(currentInput);
                } catch (Exception ex) {
                    display.setText("Ошибка");
                    currentInput = "";
                }
            } else if (command.equals("C")) {
                currentInput = "";
                display.setText("");
            } else {
                currentInput += command;
                display.setText(currentInput);
            }
        }
    }

    // Метод для вычисления выражений (простое выражение с операциями)
    private String evaluateExpression(String expression) {
        try {
            double result = 0;
            String[] tokens = expression.split(" ");
            double num1 = Double.parseDouble(tokens[0]);
            double num2 = Double.parseDouble(tokens[2]);
            String operator = tokens[1];

            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        throw new ArithmeticException("Деление на 0");
                    }
                    break;
            }

            return String.valueOf(result);
        } catch (Exception e) {
            return "Ошибка";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorFrame());
    }
}
