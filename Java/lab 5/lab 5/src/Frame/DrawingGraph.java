/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Frame;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author vdmoi
 */
public class DrawingGraph extends JPanel{
    public  static int x[] =  {50, 100, 150, 200, 250};
    public  static int y[] =  {80, 200, 150, 320, 100};
    @Override
    protected void paintComponent(Graphics gh) {       
     Graphics2D drp = (Graphics2D)gh;
     //drp.drawLine(20, 340, 20, 20);
     drp.drawLine(20, 340, 460, 340);
     drp.drawPolyline(x, y, 5);
    }
}
