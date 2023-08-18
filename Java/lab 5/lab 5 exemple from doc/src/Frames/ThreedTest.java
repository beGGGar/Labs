package Frames;

import java.awt.BorderLayout;
import java.awt.Component;
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
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import MyToolkit.GBC;

public class ThreedTest  extends JInternalFrame  implements ActionListener, KeyListener, MouseListener {
	
	private JPanel panel;
	public static Map App;
	private BallComponent BallContainer;
	private int BallCounter = 0;
	private java.util.List <BallRunnable> ArBrun = new ArrayList<>();
	//private Thread t;
	
	public ThreedTest() {
		super();
		
		//Задаем параметры фрейма
		this.setTitle("Тестируем многопоточность");
		this.setName("ThreedTest");
		this.setSize(600, 500);
		this.setMinimumSize(new Dimension(200,200));
		this.setResizable(true);
		this.setClosable(true);
		this.setLocation(0, 0);
		this.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE );
		//this.setVisible(true);
		this.addKeyListener(this);
		this.getActionMap();
		this.getInputMap().put(KeyStroke.getKeyStroke((char) KeyEvent.KEY_PRESSED), "");
		this.addMouseListener(this);
		
		//Создаем панель и назначаем менеджера компоновки для размещения компонентов в панели содержимого 
		panel = new JPanel();
		panel.setName("panel");
		BorderLayout layout = new BorderLayout();
		//GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		
		
	    
	    //Добавляем кнопки управления
	    JPanel buttonPanel = new JPanel();
	    addButton(buttonPanel, "Запуск", new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		addBall();
	    		
	    		
	    	}
	    });
	    
	    addButton(buttonPanel, "Заморозить", new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		try {
					pauseBall();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            }
	         });
	    
	    addButton(buttonPanel, "Разморозить", new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		runBall();
	            }
	         });	    

	    addButton(buttonPanel, "Скрыть", new ActionListener() {
	    	public void actionPerformed(ActionEvent event) {
	    		//System.exit(0);
	    		hideBall();
	            }
	         });
	    
	    //Добавляем панель с кнопками управления во фрейм
	    add(buttonPanel, BorderLayout.SOUTH);
	    
	    //Создаем и добавляем объект-компонент, который будет содержать мячики
	    BallContainer = new BallComponent();
	    add(BallContainer, BorderLayout.CENTER);
		
		//Создаем контейнер для рисования
	    /*
		Container Tcont= new Container();
		Tcont.setName("Tcont");
		Tcont.setMinimumSize(new Dimension(500,400));
	    //Tcont.setLayout(new GridLayout(1,2));
	    //panel.add(Tcont, new GBC(1,1,1,1,0.1,0.1,GridBagConstraints.NORTHWEST));
	    

		Container Bcont= new Container();
		Bcont.setName("Bcont");
		Bcont.setLayout(new GridBagLayout());
		Bcont.setMinimumSize(new Dimension(500,50));		
		
		BTNStart = new JButton("Старт");
		BTNStart.setName("BTNStart");
		BTNStart.addActionListener(this);
		BTNStart.setActionCommand("BTNStart");
		
		Bcont.add(BTNStart, new GBC(1,1,1,1,1,1,GridBagConstraints.NORTHWEST));
		
		//panel.add(Bcont, new GBC(1,2,1,1,0.1,0.1,GridBagConstraints.NORTHWEST));
	    
		//getContentPane().add(panel);
		*/
	}
	
	
	   /**
	    * Adds a button to a container.
	    * @param c the container
	    * @param title the button title
	    * @param listener the action listener for the button
	    */
	   public void addButton(Container c, String title, ActionListener listener)
	   {
	      JButton button = new JButton(title);
	      c.add(button);
	      button.addActionListener(listener);
	   }	
	
	   /**
	    * Adds a bouncing ball to the canvas and starts a thread to make it bounce
	    */
	   public void addBall()
	   {
		  //При добавлении каждого мячика, добавляем его в контейнер с мячами и запускаем
		  //его скачки в отдельном потоке с помощью объекта BallRunnable
		  
	      Ball b = new Ball(600, BallCounter+""); //Создаем мячик, а точнее координаты мячика
	      
	      
	      BallContainer.add(b); //Помещаем в контейнер с мячиками
	      //Конструируем объект, исполнение которого должно быть запущено в отдельном потоке
	      //Предаем в него мячик и конейнер с мячиками
	      //Runnable r = new BallRunnable(b, BallContainer);
	      BallRunnable r = new BallRunnable(b, BallContainer, true);
	      //Создаем объект потока для объекта r
	      //t = new Thread(r);
	      //t.setName(BallCounter+"");
	      //Запускаем поток
	      BallCounter++;
	      //t.start();
	      //ArThreads.add(t);
	      ArBrun.add(r);
	   }
	   
	   
	   public void hideBall() {
		   this.setVisible(false);
/*   
		   Object[] possibilities = {"ham", "spam", "yam"};
		   String s = (String)JOptionPane.showInputDialog(
		   this,
		   		"Complete the sentence:\n"
		   		+ "\"Green eggs and...\"",
		   		"Customized Dialog",
		   		JOptionPane.PLAIN_MESSAGE,
		   		null,
		   		possibilities,
				   "ham");		   
*/	   
	   }
	   
	   
	   public void pauseBall() throws InterruptedException {
		   //Прерываем все потоки
		   for (BallRunnable t : ArBrun) {
			  //System.out.println(t.get);
			   t.setPause();
		   }
	   }
	   
	   public void runBall() {
		   //Запуск прерванных потоков
		   for (BallRunnable t : ArBrun) {
			  //System.out.println(t.get);
			   t.clearPause();
		   }
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
		if( arg0.getActionCommand() == "BTNStart" ) {
			this.setStatus(arg0.getActionCommand());
		}		
	}
	
	
	/*
	 * Метод добавляет текст в поле JFT фрейма DrawProperties
	 */
	private void setStatus(String text) {
		
		JInternalFrame SF = (JInternalFrame) App.get("StatusFrame");
		
		for(Component temp: SF.getContentPane().getComponents()) {
			
			if( temp.getName() == "panel" ) {
								
				JPanel tempPanel = (JPanel) temp;
				
				for(Component panelComponent: tempPanel.getComponents()) {
					System.out.println(panelComponent.getClass().getName()+" "+panelComponent.getName());
					if( panelComponent.getName() == "scrollJTA" ) {
						
						JScrollPane scrollJTA = (JScrollPane) panelComponent; 
						
						for(Component subpanelComponent: scrollJTA.getComponents()) {
							System.out.println("sub > " + subpanelComponent.getClass().getName()+" "+subpanelComponent.getName());
							if( subpanelComponent.getName() == "JTA" ) {
								JTextArea tempComponent = (JTextArea) panelComponent;
								tempComponent.setText(tempComponent.getText()+"\n"+text);
							}
						}
						
						//JTextArea tempComponent = (JTextArea) panelComponent;
						//tempComponent.setText(tempComponent.getText()+"\n"+text);
					}
				}					
			}
  		}
	}

}
