package ru.smak.gui.graphics;

import java.awt.*;

public class SelectionPainter {

    private boolean isVisible = false;
    private Point startPoint = null;
    private Point currentPoint = null;
    private Graphics g;
    private static int cnt = 0;

    public SelectionPainter(Graphics g){
        this.g = g;
        g.setXORMode(Color.WHITE);
        g.drawRect(-2, -2, 1, 1);
        g.setPaintMode();
    }

    public void setGraphics(Graphics g){
        this.g = g;
    }

    public void setVisible(boolean value){
        if (!value){
            paint();
            currentPoint = null;
            startPoint = null;
        } else {

        }
        isVisible = value;
    }

    public void setStartPoint(Point p){
        startPoint = p;
    }

    public void setCurrentPoint(Point p){
        if (currentPoint!=null) {
            paint();
        }
        cnt++;
        currentPoint = p;
        paint();
    }

    private void paint(){
        if (isVisible && startPoint!=null && currentPoint!=null) {
            g.setXORMode(Color.WHITE);
            // 11111111 11111111 11111111 - background
            // 11111111 11111111 11111111 - XOR Mode Color
            // 11111111 00000000 00000000 - foreground
            // --------------------------
            // 11111111 00000000 00000000 - новый цвет пискселя (new background)
            g.setColor(Color.BLACK);
            g.drawRect(startPoint.x, startPoint.y,
                    currentPoint.x - startPoint.x,
                    currentPoint.y - startPoint.y);
            g.setPaintMode();
        }
    }
}
