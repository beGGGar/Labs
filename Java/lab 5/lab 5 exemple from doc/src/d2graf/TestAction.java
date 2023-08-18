package d2graf;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;

public class TestAction extends AbstractAction {

	public TestAction(String name) {
		super(name);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println(getValue(Action.NAME) + "selected");
		
	}
	
}
