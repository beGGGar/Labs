package Model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Интерфейс для вода информации для типа botanic
 *
 */
public class FrameClass extends JFrame{
    // private int width = 600;
	// private int height = 800;

	private JLabel textName = new JLabel("Name: ");
	private JLabel textAge = new JLabel("Age: ");
	private JLabel textSex = new JLabel("Sex: ");
	private JLabel textParentName = new JLabel("Parent name: ");
	private JLabel textMoney = new JLabel("Pocket money: ");
	private JLabel textMidleMark = new JLabel("Midle mark");

	public JTextField TField1 = new JTextField(10);
	public JTextField TField2 = new JTextField(10);
	public JTextField TField3 = new JTextField(10);
	public JTextField TField4 = new JTextField(10);
	public JTextField TField5 = new JTextField(10);
	public JTextField TField6 = new JTextField(10);

	JRadioButton radioOption1 = new JRadioButton("Male");
    JRadioButton radioOption2 = new JRadioButton("Female");

	public JButton buttonSave = new JButton("ОК");
	public boolean wait = true;

	String className = "";
	String[] params;
	private int fieldsNum = 0;


	public FrameClass(String className, String toString){
		System.out.println(toString);
		super(className);
		this.className = className;
		this.params = toString.split("\t");
		this.setBounds(300,300,300,300);
		
		fieldsNum = params.length;

		Container container = this.getContentPane();
		container.setLayout(new GridLayout(fieldsNum+1, 2, 2, 2));
		addFields(container);

    	container.add(buttonSave);
	}

	/**
	 * @param C
	 * @param human
	 */
	private void addFields(Container C){
		//из human
		C.add(textName);
		C.add(TField1);
		C.add(textParentName);
		C.add(TField2);
		C.add(textAge);
		C.add(TField3);
		C.add(textSex);

		//кнопки для выбора пола
		ButtonGroup radioGroup = new ButtonGroup();
		radioGroup.add(radioOption1);
		radioGroup.add(radioOption2);

		JPanel radioPanel = new JPanel();
    	radioPanel.setLayout(new FlowLayout());

		radioPanel.add(radioOption1);
		radioPanel.add(radioOption2);
		C.add(radioPanel);

		switch (className) {
			case "Parent":
			break;
			
			case "CoolParent":
			C.add(textMoney);
			C.add(TField5);
			break;

			case "Student":
			C.add(textMidleMark);
			C.add(TField6);
			break;

			case "Botany":
			C.add(textMidleMark);
			C.add(TField5);
			C.add(textMoney);
			C.add(TField6);
			break;

			default:
			break;
		}
	}
	
	// class ButtonEventListener implements ActionListener{
	// 	public void actionPerformed (ActionEvent e)
	// 	{
	// 		String message = "";
	// 		message+="Button pressed\n";
	// 		wait = false;
			
	// 		JOptionPane.showMessageDialog(null, message,"Output", JOptionPane.PLAIN_MESSAGE);
	// 	}
		
	// }
}
