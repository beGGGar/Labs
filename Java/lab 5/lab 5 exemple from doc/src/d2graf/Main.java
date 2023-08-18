package d2graf;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Frames.DrawFrame;
import Frames.ThreedTest;
import Menu.FileMenu;
import MyToolkit.FrameAppStatus;
import Properties.DrawProperties;

/**
 * @version 1.0.1
 * @author MIET. Andrianow A
 */
public class Main implements MouseListener
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(new Runnable()
         {
            @Override
            public void run()
            {
            	
            	//Создаем массив объектов APPLICATIONS, который будет хранить ссылки на объекты программы
            	Map <String, Object> Application = new HashMap();
            	

                //Создаем главное окно программы
            	JFrame PFrame = new MainFrame();
            	Application.put("PFrame", PFrame);
            	PFrame.setTitle("GUI Java MIET");
            	PFrame.setName("PFrame");
            	//Создаем область рабочего стола в которую можно помещать фреймы
            	JDesktopPane desktopPanePFrame = new MainDesktopPane();
            	desktopPanePFrame.setName("desktopPanePFrame");
            	PFrame.add(desktopPanePFrame);
            	PFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            	PFrame.setSize(900, 620);
            	PFrame.setVisible(true);
            	

            	
            	
            	//Создаем окно с графиком
            	DrawFrame.App = Application;
                JInternalFrame GFrame = new DrawFrame();                
                GFrame.setTitle("GraphicTest");
                GFrame.setName("GFrame");
                GFrame.setSize(650, 550);
                GFrame.setMinimumSize(new Dimension(550, 550));
                GFrame.setResizable(true);
                GFrame.setClosable(true);
                GFrame.setDefaultCloseOperation(JInternalFrame.HIDE_ON_CLOSE );
                GFrame.setVisible(true);               
                Application.put("GFrame", GFrame);
               
                
                //Создаем окно с настройками
                DrawProperties.App = Application;
                JInternalFrame PropFrame = new DrawProperties();
                Application.put("PropFrame", PropFrame);
                //PropFrame.getPanel() - недоступно
                
      			//Создаем меню
      			JMenuBar MainMenuBar = new MainMenuBar(desktopPanePFrame);
            	
      			//Создаем панель инструментов
      			MainToolBar MainToolBar = new MainToolBar();
      			JToolBar JTB = MainToolBar.getToolBar("Главная");
      			
      			//Создаем окно с контрольным текстовым полем
      			FrameAppStatus.App = Application;
      			JInternalFrame StatusFrame = new FrameAppStatus();
      			Application.put("StatusFrame", StatusFrame);
      			
      			
      			//Создаем окно для экспериментов с многопоточностью
      			ThreedTest.App = Application;
      			JInternalFrame ThreedTest = new ThreedTest();
      			Application.put("ThreedTest", ThreedTest);
      			
            	//Добавляем в главное окно все ранее созданные компоненты
            	desktopPanePFrame.add(GFrame);
            	desktopPanePFrame.add(PropFrame);
            	desktopPanePFrame.add(StatusFrame);
            	desktopPanePFrame.add(ThreedTest);
            	desktopPanePFrame.add(JTB);
            	PFrame.setJMenuBar(MainMenuBar);
      			
            	/*
            	 * переопределение - возможно
      			for(Component test: frame.getComponents()) {
      				System.out.println(test.getName());
      			}
      			*/

            }
         });
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


}




