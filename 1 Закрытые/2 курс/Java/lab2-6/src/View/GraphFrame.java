package View;
import java.awt.*;
import javax.swing.JFrame;

import Controller.LogParser;

public class GraphFrame extends JFrame {
    private int Width = 1280;
    private int Height = 720;

    public GraphFrame() throws InterruptedException {
        setTitle("Simple Graph");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Width, Height);
        setLocationRelativeTo(null); // Центрировать окно

        setLayout(new GridLayout(4, 2)); // Два графика в строку

        
        GraphComponent GC1 = new GraphComponent(LogParser.AddMedianTime.subList(0, LogParser.AddMedianTime.size()/2), Color.BLUE, Width/2, Height/8, "ArrayList AddMedianTime");
        GraphComponent GC2 = new GraphComponent(LogParser.RemoveMedianTime.subList(0, LogParser.AddMedianTime.size()/2), Color.BLUE, Width/2, Height/8, "AL RemoveMedianTime");
        GraphComponent GC3 = new GraphComponent(LogParser.AddTotalTime.subList(0, LogParser.AddMedianTime.size()/2), Color.BLUE, Width/2, Height/8, "AL AddTotalTime");
        GraphComponent GC4 = new GraphComponent(LogParser.RemoveTotalTime.subList(0, LogParser.AddMedianTime.size()/2), Color.BLUE, Width/2, Height/8, "AL RemoveTotalTime");
        GraphComponent GC5 = new GraphComponent(LogParser.AddMedianTime.subList(LogParser.AddMedianTime.size()/2, LogParser.AddMedianTime.size()), Color.RED, Width/2, Height/8, "LinkedList AddMedianTime");
        GraphComponent GC6 = new GraphComponent(LogParser.RemoveMedianTime.subList(LogParser.AddMedianTime.size()/2, LogParser.AddMedianTime.size()), Color.RED, Width/2, Height/8, "LL RemoveMedianTime");
        GraphComponent GC7 = new GraphComponent(LogParser.AddTotalTime.subList(LogParser.AddMedianTime.size()/2, LogParser.AddMedianTime.size()), Color.RED, Width/2, Height/8, "LL AddTotalTime");
        GraphComponent GC8 = new GraphComponent(LogParser.RemoveTotalTime.subList(LogParser.AddMedianTime.size()/2, LogParser.AddMedianTime.size()), Color.RED, Width/2, Height/8, "LL RemoveTotalTime");

        add(GC1);
        add(GC2);
        add(GC3);
        add(GC4);
        add(GC5);
        add(GC6);
        add(GC7);
        add(GC8);
    }
}