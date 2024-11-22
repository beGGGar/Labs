package View;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class GraphComponent extends JComponent {
    private static int POINT_SIZE = 10;
    private static int STROKE_WIDTH = 2;
    private static int POINT_STROKE_WIDTH = 4;

    private int Width;
    private int Height;
    private Color GRAPH_COLOR;
    private int[] xPoints;
    private List<Long> yPoints;
    private String title;
    private Long maxYValue;

    public GraphComponent(List<Long> yPoints, Color GColor, int Width_, int Height_, String title_){
        this.Width = Width_;
        this.Height = Height_;
        GenXPoints(yPoints.size());
        GenYPoints(yPoints);
        GRAPH_COLOR = GColor;
        this.title = title_;
    }

    
    /**
     * Задает х координаты
     * @param count
     */
    public void GenXPoints(int count){
        if(count != 0){
            xPoints = new int[count];
            for (int i = 0; i < count; i++){
                xPoints[i] = 50 + (Width-100)/(count-1)*(i);
            }
        }
    }
    /**
     * Задает Y кординаты и скалирует
     * @param points
     */
    public void GenYPoints(List<Long> points){
        this.yPoints = new ArrayList<Long>();
        this.maxYValue = Collections.max(points);
        double scaleFactor = ((double) Height) / (double) maxYValue;
        for (Long point : points) {
            // Масштабируем точку и добавляем в новый список
            long scaledPoint = Math.round(Height - point * scaleFactor);
            this.yPoints.add(scaledPoint);
        }
    }
    /** 
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        //граф
        drawGraph(g2d, xPoints, yPoints,GRAPH_COLOR);
        //заголовок
        g2d.drawString(title, Width/2, Height/2);
        //шкала
        drawYScale(g2d);
    }

    private void drawGraph(Graphics2D g2d, int[] xPoints, List<Long> yPoints, Color color) {
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(STROKE_WIDTH));

        for (int i = 0; i < xPoints.length - 1; i++) {
            g2d.draw(new Line2D.Double(xPoints[i], yPoints.get(i), xPoints[i + 1], yPoints.get(i+1)));
        }

        g2d.setStroke(new BasicStroke(POINT_STROKE_WIDTH));
        for (int i = 0; i < xPoints.length; i++) {
            g2d.fillOval(xPoints[i] - POINT_SIZE / 2, (int) (yPoints.get(i) - POINT_SIZE / 2), POINT_SIZE, POINT_SIZE);
        }

        g2d.setColor(Color.BLACK);
    }

    private void drawYScale(Graphics2D g2d) {
        long step = this.maxYValue / 5;
        for (int i = 0; i <= 5; i++) {
            int y = Height - (int)(((Height - 20) / (double)maxYValue) * (i * step));
            g2d.drawString(String.valueOf(i * step), 15, y);
            g2d.drawLine(5, y, 10, y); // Линия шкалы
        }
    }
}