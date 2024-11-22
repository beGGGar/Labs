package Properties;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import MyToolkit.GBC;

public class DrawProperties extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	

	private JComboBox JCB;
	private JPanel panel;
	private JCheckBox JCB_MIET;
	private JCheckBox JCB_BEST;
	private JTextField JTF;
	private JRadioButton JRBLarge;
	private JRadioButton JRBSmall;
	private ButtonGroup ButtonGroup;
	public static Map App;
	
	
	public DrawProperties() {
		super();
		
		//Задаем параметры фрейма
		this.setTitle("DrawProperties");
		this.setName("DrawProperties");
		this.setSize(200, 200);
		this.setMinimumSize(new Dimension(200,200));
		this.setResizable(true);
		this.setClosable(true);
		this.setLocation(680, 0);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE );
		this.setVisible(true);
		this.addKeyListener(this);
		this.getActionMap();
		this.getInputMap().put(KeyStroke.getKeyStroke((char) KeyEvent.KEY_PRESSED), "");
		this.addMouseListener(this);
		
		//Создаем панель и назначаем менеджера компоновки для размещения компонентов в панели содержимого 
		panel = new JPanel();
		panel.setName("panel");
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		
		//------------------- Создаем компоненты и разещаем их в ячейках GridBagLayout -----------------------//
				
		
		//Создаем список
		this.JCB = new JComboBox();
		JCB.setName("JCB");
		JCB.addItem("First");
		JCB.addItem("Second");
		//Добавляем слушателя события		
		JCB.addActionListener(this);
		//Создаем ячейку для списка
		GridBagConstraints contrJCB = new GBC(2,1,2,2,100,100,GridBagConstraints.NORTHWEST);
		//Добавляем список в панель в нужное место в сетке
		panel.add(JCB, contrJCB);
		

		//Создаем первый флажок
		this.JCB_MIET = new JCheckBox("МИЭТ");
		JCB_MIET.setName("JCB_MIET");
		//Добавляем слушателя событий для флажка
		JCB_MIET.addActionListener(this);
		//Создаем ячейку для флажка
		GridBagConstraints contrJCB_MIET = new GBC(1,1,1,1,100,30,GridBagConstraints.NORTHWEST);
		//Добавляем флажок в панель в нужное место в сетке
		panel.add(JCB_MIET, contrJCB_MIET);
		
		//Создаем второй флажок
		this.JCB_BEST = new JCheckBox("Лучший");
		JCB_BEST.setName("JCB_BEST");
		JCB_BEST.addActionListener(this);
		GridBagConstraints contrJCB_BEST = new GBC(1,2,1,1,100,30,GridBagConstraints.NORTHWEST);
		panel.add(JCB_BEST, contrJCB_BEST);
		
		
		//Создаем список радиокнопок
		ButtonGroup = new ButtonGroup();		
		JRBLarge = new JRadioButton("Large", true);
		ButtonGroup.add(JRBLarge);
		JRBLarge.addActionListener(this);
		JRBSmall = new JRadioButton("Small", false);
		JRBSmall.addActionListener(this);
		ButtonGroup.add(JRBSmall);
		
		//Создаем контейнер, который сам будет содержать свой менеджер компоновки и компоненты
		Container container = new Container();
		container.setName("JRB");
	    container.setLayout(new GridLayout(1,2));
	    container.add(JRBLarge, new GBC(1,1,1,1,10,10,GridBagConstraints.NORTHWEST));
	    container.add(JRBSmall, new GBC(2,1,1,1,10,10,GridBagConstraints.NORTHWEST));
	    GridBagConstraints contrBG = new GBC(1,3,3,1,100,30,GridBagConstraints.NORTHWEST);
	    panel.add(container, contrBG);
		
		//Создаем текстовое поле
		this.JTF = new JTextField();
		JTF.setName("JTF");
		JTF.setText("Текст по умолчанию");
		JTF.setColumns(15);
		JTF.addActionListener(this);
		GridBagConstraints contrJTF = new GBC(1,4,3,1,100,30,GridBagConstraints.NORTHWEST);
		panel.add(JTF, contrJTF);
		
		
		//Добавляем панель с компонентами в панель контента фрейма
		getContentPane().add(panel);
		
		//pack();
	}
	
	public JPanel getPanel() {
		return this.panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if( arg0.getSource().equals(JCB_BEST) ) {
			this.JTF.setText(JCB_BEST.getText());
		}
		else if ( arg0.getSource().equals(JCB_MIET) ) {
			this.JTF.setText(JCB_MIET.getText());
		}
		else if ( arg0.getSource().equals(JCB) ) {
			this.JTF.setText(JCB.getSelectedItem().toString());
		}
		else if ( arg0.getSource().equals(JRBLarge) || arg0.getSource().equals(JRBSmall) ) {
			JRadioButton temp = (JRadioButton) arg0.getSource();
			this.JTF.setText(temp.getText());
		}
		
		System.out.println(
				arg0.getSource().getClass().getName()
				+ "\n"
				+ arg0.getActionCommand()
				);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("DrawProperties > "+arg0.getX()+" "+arg0.getY()+" "+arg0.getXOnScreen()+" "+arg0.getYOnScreen());
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("DrawProperties keyPressed > "+arg0.getKeyCode()+" "+arg0.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("DrawProperties keyReleased > "+arg0.getKeyCode()+" "+arg0.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}

	
}
