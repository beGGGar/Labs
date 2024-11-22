package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * Интерфейс для вода информации для типа botanic
 * @author Raznoglazov Nikita PIN-24
 *
 */

public class FrameBotanic extends JFrame {
	private int width = 600;
	private int height = 800;

	private JLabel text1 = new JLabel("Name: ");
	private JLabel text2 = new JLabel("Age: ");
	private JLabel text3 = new JLabel("Sex: ");
	private JLabel text4 = new JLabel("Patronymic: ");
	private JLabel text5 = new JLabel("Mark: ");
	private JLabel text6 = new JLabel("Pocket money: ");

	public JTextField TField1 = new JTextField(10);
	// TField1.setBackground(Color.CYAN);
	public JTextField TField2 = new JTextField(10);
	// TField2.setBackground(Color.CYAN);
	public JTextField TField3 = new JTextField(10);
	// TField3.setBackground(Color.CYAN);
	public JTextField TField4 = new JTextField(10);
	// TField4.setBackground(Color.CYAN);
	public JTextField TField5 = new JTextField(10);
	// TField5.setBackground(Color.CYAN);
	public JTextField TField6 = new JTextField(10);
	// TField6.setBackground(Color.CYAN);

	public JButton button = new JButton("Submit");
	public boolean wait = true;

	public FrameBotanic()
    {
    	super("Botanic");
    	this.setBounds(300,300,300,300);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	Container container = this.getContentPane();
    	container.setLayout(new GridLayout(7,2,2,2));
    	container.add(text1);
    	container.add(TField1);
    	container.add(text2);
    	container.add(TField2);
    	container.add(text3);
    	container.add(TField3);
    	container.add(text4);
    	container.add(TField4);
    	container.add(text5);
    	container.add(TField5);
    	container.add(text6);
    	container.add(TField6);
    	
    	button.addActionListener(new ButtonEventListener());
    	container.add(button);

    }
	
	class ButtonEventListener implements ActionListener{
		public void actionPerformed (ActionEvent e)
		{
			String message = "";
			message+="Button pressed\n";
			wait = false;
			
			JOptionPane.showMessageDialog(null, message,"Output", JOptionPane.PLAIN_MESSAGE);
		}
		
	}
	
}