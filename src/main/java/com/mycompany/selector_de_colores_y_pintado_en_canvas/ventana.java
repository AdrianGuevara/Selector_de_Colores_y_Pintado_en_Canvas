package com.mycompany.selector_de_colores_y_pintado_en_canvas;


import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ventana extends JFrame{
    JButton boton1,boton2,boton3,boton4,boton5;
    pintado pintado = new pintado();
    ventana(){
        setTitle("Selector de Colores");
        boton1 = new JButton(new ImageIcon("verde.png"));
        boton2 = new JButton(new ImageIcon("amarillo.jpg"));
        boton3 = new JButton(new ImageIcon("azul2.jpg"));
        boton4 = new JButton(new ImageIcon("negro.jpg"));
        boton5 = new JButton(new ImageIcon("naranja.jpg"));
        boton5.addActionListener(e -> pintado.setColor(Color.orange));
        boton1.addActionListener(e -> pintado.setColor(Color.green));
        boton2.addActionListener(e -> pintado.setColor(Color.yellow));
        boton3.addActionListener(e -> pintado.setColor(Color.blue));
        boton4.addActionListener(e -> pintado.setColor(Color.black));
        getContentPane().add(boton1);
        getContentPane().add(boton2);
        getContentPane().add(boton3); 
        getContentPane().add(boton4);
        getContentPane().add(boton5);
        getContentPane().add(pintado);
    }

    public static void main(String[] args) {
        ventana ventana=new ventana();
        ventana.setSize(500, 500);
        ventana.setLayout(new GridLayout(3,6));
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        ventana.setVisible(true);
    }
}

   
