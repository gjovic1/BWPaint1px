package com.company;

import java.awt.*;
import java.awt.event.*;

public class MousePaint extends Frame implements MouseMotionListener
{
    private int x1, y1, x2, y2;
    public MousePaint()
    {
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent windowEvent)
            {
                dispose();
                System.exit(0);
            }
        });
        addMouseMotionListener(this);
        setBounds(50,50,400,250);
        setVisible(true);
    }
    public static void main(String[] argv)
    {
        new MousePaint();
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g){
        g.setColor(Color.red);
        g.drawLine(x1,y1,x2,y2);
    }
    public void mouseDragged(MouseEvent mouseEvent){
        mouseEvent.consume();
        int x = mouseEvent.getX();
        int y = mouseEvent.getY();
        if (x1 == 0){
            x1 = x;
        }
        if(y1 == 0){
            y1 = y;
        }
        x2 = x;
        y2 = y;
        repaint();
        x1 = x2;
        y1 = y2;
    }
    public void mouseMoved(MouseEvent mouseEvent){}
}
