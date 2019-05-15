/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.selector_de_colores_y_pintado_en_canvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;

    
    public class pintado extends JComponent{
    private Point inicioArrastre;
    private Point finArrastre;
    private Color colorActual = Color.BLACK;
    private List<Linea> lineas = new ArrayList<>();
    public pintado() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                repaint();
            }
            @Override
            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
                finArrastre = new Point(e.getX(), e.getY());
                Linea linea = crearLinea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
                lineas.add(linea);
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse
                finArrastre = new Point(e.getX(), e.getY());
                Linea linea = crearLinea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
                lineas.add(linea);
                inicioArrastre = new Point(finArrastre.x, finArrastre.y);
                repaint();
            }
        });
    }
    private class Linea{
        public Shape forma;
        public Color color;
    }
    private Linea crearLinea(int x1, int y1, int x2, int y2) {
        Linea linea = new Linea();
        linea.forma = new Line2D.Float(x1, y1, x2, y2);
        linea.color = colorActual;
        return linea;
    }
    public void setColor(Color color){
        colorActual = color;
    }
    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        lineas.forEach(linea -> {
            g2.setColor(linea.color);
            g2.draw(linea.forma);
        });
    }
}
