package Menu;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

public class ToolBarTest extends JToolBar implements ActionListener {

	public JButton BTF;
	public JButton BTS;
	public JButton BTT;
	
	public ToolBarTest(String Name) {
		super();		
		this.setName(Name);
		this.setSize(150, 40);
		this.setComponentOrientation(getComponentOrientation());
		this.setOrientation(HORIZONTAL);
		this.setMinimumSize(getSize());
		this.makeContent();
		this.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	private void makeContent() {
		
		//JButton BTF = null;
        BTF = new JButton("");
        BTF.setName("BTF");
        BTF.addActionListener(this);
        BTF.setToolTipText("First");
        ImageIcon img = new ImageIcon("src/first.jpg");
        System.out.println(img.getIconWidth());
        BTF.setIcon(img);
        
        BTS = new JButton("");
        BTS.setName("BTS");
        BTS.addActionListener(this);
        BTS.setToolTipText("Second");
        img = new ImageIcon("src/second.jpg");
        BTS.setIcon(img);
        
        //this.addSeparator(); // добавить разделитель
        BTT = new JButton("");
        BTT.setToolTipText("Three");
        img = new ImageIcon("src/three.jpg");
        BTT.setIcon(img);
        BTT.addActionListener(this);
        
        this.add(BTF);
        this.add(BTS);
        this.add(BTT);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("First")) {
            System.out.println("first buton pressed");
		
		}

        if (e.getActionCommand().equals("Second"))
            System.out.println("second buton pressed");

        if (e.getActionCommand().equals("Three"))
            System.out.println("third buton pressed");		
	}
	
	
}
