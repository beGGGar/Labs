package Frame;

import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author vdmoi
 */
public class FrameExemple extends JFrame{
    private int WIDTH = 1000; //ширина игры
    private int HEIGHT = (int)(WIDTH * (0.5555)); //высота игры
    private final Dimension SCREEN_SIZE = new Dimension(WIDTH,HEIGHT);
    
    private JButton button = new JButton("button");
    private JTextField input= new JTextField("", 5);
    private JLabel label = new JLabel("Input:");
    private JRadioButton rbutton1 = new JRadioButton("Swich1");
    private JRadioButton rbutton2 = new JRadioButton("Swich2");
    private JCheckBox check = new JCheckBox("Check", false);
    
    
    
    public FrameExemple(){
        //this.setTitle("Ping Pong Game"); //добавляем заголовок
        super("Graph");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //завершение при нажатии на крестик
        this.setResizable(false); //запрещаем изменять размеры окна
        //this.setBackground(Color.black); //фон черный
        
        //this.setSize(WIDTH, HEIGHT); //устанавливаем размер окна игры
        //this.setLocationRelativeTo(null); //отображение окна по центру экрана
        this.setBounds(100, 100, 250, 250);
        
        // а это зачем this.setPreferredSize(SCREEN_SIZE); //устанавливаем размер
        
        this.setVisible(true); //делаем видимым
 
//        JButton button = new JButton("Нажми меня!");
//        
//        this.add(button, BorderLayout.SOUTH);
// 
//        JLabel label = new JLabel("Привет, мир!");
//        this.add(label, BorderLayout.NORTH);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));
        container.add(label);
        container.add(input);
        
        ButtonGroup buttGroup = new ButtonGroup();
        buttGroup.add(rbutton1);
        buttGroup.add(rbutton2);
        
        container.add(rbutton1);
        rbutton1.setSelected(true);
        container.add(rbutton2);
        container.add(check);
        button.addActionListener(new ButtonActionListener());
        container.add(button);
        
        
         
    } 
    class ButtonActionListener implements ActionListener{
        public ButtonActionListener(){}

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = "";
            message += "Button was pressed\n";
            message += "Text is" + input.getText() + "\n";
            message += (rbutton1.isSelected() ? "Radio #1" : "Radio #2") + "is selected\n";
            message += "CheckBox is" + (check.isSelected() ? "checked" : "not checked") + "\n";
            JOptionPane.showMessageDialog(null, message, "Output", JOptionPane.PLAIN_MESSAGE);
        }
    
    }
 
}


