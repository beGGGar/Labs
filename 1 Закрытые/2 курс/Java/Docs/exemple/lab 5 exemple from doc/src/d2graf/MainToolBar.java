package d2graf;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JToolBar;

import Menu.ToolBarTest;

public class MainToolBar {
	
	public Map<String, JToolBar> ToolBars = new HashMap();
	
	public MainToolBar() {
		super();
		this.createToolBars();
	}
	
	public Map createToolBars() {
				
		JToolBar temp = new ToolBarTest("Главная");
		ToolBars.put("Главная", temp);		
		return this.ToolBars;
	}
	
	public JToolBar getToolBar(String Name) {
		return ToolBars.get(Name);
	}
	
}
