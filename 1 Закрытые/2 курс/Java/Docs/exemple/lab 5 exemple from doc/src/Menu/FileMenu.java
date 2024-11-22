package Menu;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class FileMenu extends javax.swing.JMenu {
	private JDesktopPane JDP;
	
	public FileMenu(String StartName) {
		super(StartName); //Это имя первого пункта меню в колонке
		makeMenu();
		this.JDP = null;
	}
	
	public FileMenu(String StartName, JDesktopPane jdp) {
		super(StartName); //Это имя первого пункта меню в колонке
		this.JDP = jdp;
		makeMenu();
	}	
	
	private void makeMenu() {
		JMenuItem Punkt1 = new JMenuItem("Open GraphicTest");
		JMenuItem Punkt2 = new JMenuItem("Open PropertiesTest");
		JMenuItem Punkt3 = new JMenuItem("Open Status");
		Punkt1.setAccelerator(KeyStroke.getKeyStroke("ctrl G"));
		Punkt2.setAccelerator(KeyStroke.getKeyStroke("ctrl P"));
		Punkt3.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
		
		this.add(Punkt1);
		this.add(Punkt2);
		this.add(Punkt3);
		
		Punkt1.addActionListener(new FileAction("Open GraphicTest", this.JDP));
		Punkt2.addActionListener(new FileAction("Open PropertiesTest", this.JDP));
		Punkt3.addActionListener(new FileAction("Open Status", this.JDP));
		Punkt3.setActionCommand("Open Status");
		
		this.addSeparator();
		
		JMenu PunktTestSub = new JMenu("Тест подменю");
		this.add(PunktTestSub);
		JMenuItem PunktTestSub_Punkt1 = new JMenuItem("Первый пункт");
		JMenuItem PunktTestSub_Punkt2 = new JMenuItem("Второй пункт");
		PunktTestSub.add(PunktTestSub_Punkt1);
		PunktTestSub.add(PunktTestSub_Punkt2);
				
		JMenuItem Punkt4 = new JMenuItem("Test");
		Punkt4.setEnabled(false);
		this.add(Punkt4);
	}	
}
