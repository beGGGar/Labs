package d2graf;

import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import Menu.FileMenu;
import Menu.EditMenu;

public class MainMenuBar extends JMenuBar {
	private JDesktopPane JDP;
	
	MainMenuBar() {
		super();		
		FileMenu FileMenu = new FileMenu("File");
		EditMenu EditMenu = new EditMenu("Edit");
		this.add(FileMenu);
		this.add(EditMenu);
	}
	
	MainMenuBar(JDesktopPane jdp) {
		super();
		this.JDP = jdp;
		FileMenu FileMenu = new FileMenu("File", jdp);
		EditMenu EditMenu = new EditMenu("Edit", jdp);
		this.add(FileMenu);
		this.add(EditMenu);
	}	
}
