package Menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class FileAction extends AbstractAction {
	private JDesktopPane JDP; //Для работы с объектами рабочего стола
	private String PunktMenuName;
		
	public FileAction(String name) {
		super(name);
		this.JDP = null;
		this.PunktMenuName = name;
	}
	
	public FileAction(String name, JDesktopPane jdp) {
		super(name);
		this.JDP = jdp;
		this.PunktMenuName = name;
	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if( this.JDP != null ) {
			System.out.println(getValue(Action.NAME) 
					+ " selected " 
					+ this.JDP.getName()
					);
			
			
			
			for(Component test: this.JDP.getComponents()) {
  				System.out.println("Component> "+test.getName());
  				if( test.getName() == "GFrame" && this.PunktMenuName == "Open GraphicTest" ) {
  					test.setVisible(true);
  				}
  				if( test.getName() == "DrawProperties" && this.PunktMenuName == "Open PropertiesTest" ) {
  					test.setVisible(true);
  				}
  				if( this.PunktMenuName == "Open Status" && test.getName() == "FrameAppStatus" ) {
  					test.setVisible(true);
  				}
  				
  			}			
		}
		else {			
			JMenuItem JMI = (JMenuItem) arg0.getSource(); 
			JPopupMenu JPP = (JPopupMenu) JMI.getParent();
			System.out.println(getValue(Action.NAME) 
					+ " selected \n" 
					+ arg0.getSource().getClass().getName()
					+ "\n"
					+ JMI.getParent().getClass().getName()
					+ "\n"
					//+ JPP.getRootPane().getName()
					);				
		}		
	}
	
}
