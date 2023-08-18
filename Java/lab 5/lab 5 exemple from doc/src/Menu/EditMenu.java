package Menu;

import javax.swing.JDesktopPane;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class EditMenu extends javax.swing.JMenu {
	private JDesktopPane JDP;
	
	public EditMenu(String StartName) {
		super(StartName); //Это имя первого пункта меню в колонке
		makeMenu();
		this.JDP = null;
	}
	
	public EditMenu(String StartName, JDesktopPane jdp) {
		super(StartName); //Это имя первого пункта меню в колонке
		this.JDP = jdp;
		makeMenu();
	}	
	
	private void makeMenu() {
		JMenuItem Punkt1 = new JMenuItem("Open Threed Frame");
		JMenuItem Punkt2 = new JMenuItem("Empty 1");
		JMenuItem Punkt3 = new JMenuItem("Empty 2");
		Punkt1.setAccelerator(KeyStroke.getKeyStroke("ctrl T"));
		
		this.add(Punkt1);
		this.add(Punkt2);
		this.add(Punkt3);
		
		Punkt1.addActionListener(new EditAction("Open Threed", this.JDP));
		Punkt2.addActionListener(new EditAction("undefined", this.JDP));
		Punkt3.addActionListener(new EditAction("undefined", this.JDP));
		Punkt3.setActionCommand("Open Threed");
	}	
}
