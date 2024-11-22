package MyToolkit;

//import java.awt.BorderLayout;
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

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

public class FrameAppStatus extends JInternalFrame implements ActionListener, KeyListener, MouseListener {

	private JTextArea JTA;
	private JButton BTNClear;
	private JButton BTNReset;
	private JPanel panel;
	public static Map App;
	
	public FrameAppStatus() {
		super();
		
		//Задаем параметры фрейма
		this.setTitle("Контроль состояния приложения");
		this.setName("FrameAppStatus");
		this.setSize(200, 200);
		this.setMinimumSize(new Dimension(200,200));
		this.setResizable(true);
		this.setClosable(true);
		this.setLocation(680, 240);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE );
		this.setVisible(true);
		this.addKeyListener(this);
		this.getActionMap();
		this.getInputMap().put(KeyStroke.getKeyStroke((char) KeyEvent.KEY_PRESSED), "");
		this.addMouseListener(this);
		
		//Создаем панель и назначаем менеджера компоновки для размещения компонентов в панели содержимого 
		panel = new JPanel();
		panel.setName("panel");
		//BorderLayout layout = new BorderLayout();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		
		
		//------------------- Создаем компоненты и разещаем их в ячейках GridBagLayout -----------------------//
	
		JTA = new JTextArea();
		JTA.setName("JTA");
		JTA.isEditable();
		JTA.isVisible();
		JTA.setText("Старт программы");
		JTA.setLineWrap(true);
		JTA.setWrapStyleWord(true);
	
		JScrollPane scrollJTA = new JScrollPane(JTA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);		
		scrollJTA.setName("scrollJTA");
		GridBagConstraints contrJTA = new GBC(1,1,1,1,1,1,GridBagConstraints.NORTHWEST,1);		
		panel.add(scrollJTA, contrJTA);
		//panel.add(scrollJTA, BorderLayout.NORTH);
		
		
		BTNClear = new JButton("Очист.");
		BTNClear.setName("BTNClear");
		BTNClear.addActionListener(this);
		BTNClear.setActionCommand("BTNClear");
		
		BTNReset = new JButton("Coxр.");
		BTNReset.setName("BTNReset");
		BTNReset.addActionListener(this);
		BTNReset.setActionCommand("BTNReset");
		
		Container container = new Container();
		container.setName("JRB");
	    container.setLayout(new GridLayout(1,2));
	    container.add(BTNClear, new GBC(1,1,1,1,1,1,GridBagConstraints.NORTHWEST));
	    container.add(BTNReset, new GBC(2,1,1,1,1,1,GridBagConstraints.NORTHWEST));
	    GridBagConstraints contrBG = new GBC(1,2,1,1,0.1,0.1,GridBagConstraints.NORTHWEST);
	    //panel.add(container, BorderLayout.SOUTH);
	    panel.add(container, contrBG);
		
		getContentPane().add(panel);
		//pack();
	}

	
	
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println(arg0.getClass().getName()+" "+arg0.getActionCommand());
		if( arg0.getActionCommand() == "BTNClear" ) {
			this.JTA.setText("");
		}
		
	}

}
