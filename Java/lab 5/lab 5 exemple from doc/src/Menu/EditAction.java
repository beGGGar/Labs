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

public class EditAction extends AbstractAction {
	private JDesktopPane JDP; //Для работы с объектами рабочего стола
	private String PunktMenuName;
		
	public EditAction(String name) {
		super(name);
		this.JDP = null;
		this.PunktMenuName = name;
	}
	
	public EditAction(String name, JDesktopPane jdp) {
		super(name);
		this.JDP = jdp;
		this.PunktMenuName = name;
	}	

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if( this.JDP != null ) {
			System.out.println(getValue(Action.NAME) 
					+ " > selected " 
					+ " | " +  this.JDP.getName() 
					+ " | " +  this.PunktMenuName
					+ " | " + arg0.getActionCommand()
					);
			
			
			
			for(Component test: this.JDP.getComponents()) {
  				System.out.println("Component> "+test.getName());
  				if( this.PunktMenuName == "Open Threed" && test.getName() == "ThreedTest" ) {
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
