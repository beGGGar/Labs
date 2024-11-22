package d2graf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JDesktopPane;
import javax.swing.KeyStroke;

public class MainDesktopPane extends JDesktopPane implements KeyListener, MouseListener{

	MainDesktopPane() {
		super();
		addKeyListener(this);
		addMouseListener(this);
		this.getActionMap();
		this.getInputMap().put(KeyStroke.getKeyStroke((char) KeyEvent.KEY_PRESSED), "");
		//this.getActionMap().put("help", someAction);
		//this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), "help");
		//this.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "help");
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println("MainDesktopPane > "+e.getX()+" "+e.getY()+" "+e.getXOnScreen()+" "+e.getYOnScreen());		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MainDesktopPane keyPressed > "+arg0.getKeyCode()+" "+arg0.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("MainDesktopPane keyReleased > "+arg0.getKeyCode()+" "+arg0.getKeyText(arg0.getKeyCode()));
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		//System.out.println("MainDesktopPane keyTyped > "+arg0.getKeyCode()+" "+arg0.getKeyText(arg0.getKeyCode()));
	}

	Action someAction = new AbstractAction() {
		public void actionPerformed(KeyEvent e) {
			// TODO Auto-generated method stub
			//KeyEvent temp = (KeyEvent) e;
			System.out.println("MainDesktopPane А > "+e.getKeyCode()+" "+e.getKeyText(e.getKeyCode()));
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
	};	
	
}
