package Frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import MyToolkit.GBC;


/**
 * A frame that contains a panel with drawings
 */
public class DrawFrame extends JInternalFrame implements ActionListener
{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel Status;
	private JPanel panel;
	private JButton openGraf;
	private JButton closeGraf;
	private DrawGraf DG;
	static public Map App;
	
	public DrawFrame() {
		
		//Формируем заголовок-описание графика
		GrafDataTitle GTitle = new GrafDataTitle("Проверка", "", 0, 0, 0, 0, "ед", "нс");
		
		//Формируем данные для построения графика
		ArrayList <Float> X = new ArrayList();
		X.add(0F);
		X.add(10F);
		X.add(100F);
		X.add(1000F);
		X.add(10000F);

		ArrayList <Float> Y = new ArrayList();
		Y.add(0F);
		Y.add(2F);
		Y.add(4F);
		Y.add(9F);
		Y.add(16F);	
		
		//Создаем панель содержимого для размещения элементов
		panel = new JPanel();
		//Назначаем менеджера компоновки для размещения компонентов в панели содержимого
		GridBagLayout layout = new GridBagLayout();
		//int[] h = { 10, 1, 1};
		//layout.rowHeights = h;
		panel.setLayout(layout);
		
		DG = new DrawGraf(new GrafData(GTitle, X, Y), true, false, new Color(255, 0, 0));
		DG.setPosition(500, 400, 50, 50, 400, 300);
		DG.setBorder((Border) new CompoundBorder(new EmptyBorder(0,0,0,0), new TitledBorder("График")));
		DG.setName("График");
		//Создаем ячейку для графика		
		GridBagConstraints contrDG = new GBC(1,1,2,1,1,1,GridBagConstraints.NORTHWEST);
		DG.setMinimumSize(new Dimension(500,400));
		panel.add(DG, contrDG);

		
		//Создаем кнопку показать график
		openGraf = new JButton("Показать график");
		openGraf.setName("openGraf");
		openGraf.setActionCommand("openGraf");
		openGraf.addActionListener(this);	
		panel.add(openGraf, new GBC(1,2,1,1,0,0,GridBagConstraints.NORTHWEST));

		
		//Создаем кнопку скрыть график
		closeGraf = new JButton("Скрыть график");
		closeGraf.setName("closeGraf");
		closeGraf.setActionCommand("closeGraf");
		closeGraf.addActionListener(this);		
		panel.add(closeGraf, new GBC(2,2,1,1,0,0,GridBagConstraints.NORTHWEST));
		
		
		//Создаем метку для отображения состояний
		Status = new JLabel("Пока пусто");
		Status.setName("Status");
		Status.setToolTipText("Состояние");
		Status.setBorder((Border) new CompoundBorder(new EmptyBorder(10,0,10,10), new TitledBorder("Статус")));
		panel.add(Status, new GBC(1,3,2,1,1,1,GridBagConstraints.NORTHWEST));
		
		getContentPane().add(panel);
		openGraf.setVisible(false);
		
		//pack();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {		
		if( ae.getActionCommand().toString() == "closeGraf" ) {
			JOptionPane JOP = new JOptionPane();			
			
			int selection = JOP.showConfirmDialog(getParent(), "Вы действительно хотите скрыть график?", "Prop", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if( selection == JOptionPane.OK_OPTION ){
				this.Status.setText("График - скрыт");
				//Скрываем график, открываем кнопку OpenGraf
				this.DG.setVisible(false);
				this.openGraf.setVisible(true);
				this.closeGraf.setVisible(false);
				this.setJFT("График - скрыт");
			}			
		}
		else if( ae.getActionCommand().toString() == "openGraf" ) {
			this.Status.setText("График - отображается");
			//Открываем график, открываем кнопку closeGraf
			this.DG.setVisible(true);
			this.openGraf.setVisible(false);
			this.closeGraf.setVisible(true);
			this.setJFT("График - отображается");	  		
		}
		
		//System.out.println(ae.getActionCommand().toString());
		/*
		for(Component test: panel.getComponents()) {
			System.out.println(test.getName());
  		}
  		*/
	}
	
	/*
	 * Метод добавляет текст в поле JFT фрейма DrawProperties
	 */
	private void setJFT(String text) {
		
		JInternalFrame JIF = (JInternalFrame) App.get("PropFrame");
		
		for(Component temp: JIF.getContentPane().getComponents()) {
			
			if( temp.getName() == "panel" ) {
								
				JPanel tempPanel = (JPanel) temp;
				
				for(Component panelComponent: tempPanel.getComponents()) {
					System.out.println(panelComponent.getClass().getName()+" "+panelComponent.getName());
					if( panelComponent.getName() == "JTF" ) {
						JTextField tempComponent = (JTextField) panelComponent;
						tempComponent.setText(text);
					}
				}					
			}
  		}
	}
	
	public Component[] getComponents () {
		return panel.getComponents();
	}
	
}