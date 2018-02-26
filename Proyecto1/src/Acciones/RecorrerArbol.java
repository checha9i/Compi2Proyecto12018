/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Analizadores.Lexico;
import Analizadores.Nodo;
import Analizadores.Sintactico;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chech
 */
public class RecorrerArbol {
public Font subrayado = new Font("Arial", TextAttribute.UNDERLINE_ON, Font.BOLD);
    public int[] Analizar(String entrada,JPanel cosas,JTabbedPane pestaña,int[] posicion) {

        try {
            //crear el lexico
            Lexico lexico = new Lexico(new StringReader(entrada));
            //crear el sintactico
            Sintactico parser = new Sintactico(lexico);

            //ejecutar el analisis
            parser.parse();

            JOptionPane.showMessageDialog(null, "Analisis Completo", "Ejemplo 1 AST", 1);

            //Graficar
            //this.graficarAST(parser.raiz);            
            Graficador g = new Graficador();
            g.graficarAST(parser.raiz);

            //Recorrido
        this.recorrido(parser.raiz, cosas,pestaña,posicion);
        } catch (Exception ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un grave problema", "Ejemplo 1 AST", 2);
        }
return posicion;
    }

    public int tamañoarbol(int tamaño, Nodo nodoactual) {

        for (Nodo hijo : nodoactual.hijos) {
            tamaño = tamañoarbol(tamaño, hijo) + 1;

        }

        return tamaño;
    }
    
    public  int[] recorrido(Nodo nodoactual, JPanel html,JTabbedPane pestaña,int[] posicion) {
        
        switch (nodoactual.valor) {
            case "chtml":
                
                for (Nodo hijo : nodoactual.hijos) {
                    this.recorrido(hijo, html, pestaña,posicion);
                }
                break;
                //EMPIEZA ENCABEZADO
            case "encabezado":
                
                
                this.recorrido((nodoactual.hijos.get(0)), html, pestaña,posicion);
                
                break;
                
            case "ContenidoEncabezado":
                for (Nodo hijo : nodoactual.hijos) {
                    this.recorrido(hijo, html, pestaña,posicion);
                }
                break;
            case "CCSS":
                
                break;
            case "CJS":
                
                break;
                
            case "titulo":
                pestaña.setTitleAt(pestaña.getSelectedIndex(),nodoactual.hijos.get(0).valor);
                break;
                //FIN ENCABEZADO
                
                //EMPIEZA CUERPO
            case "cuerpo":
                
                
                for (Nodo hijo : nodoactual.hijos) {
                    this.recorrido(hijo, html, pestaña,posicion);
                }
                break;
                
            case "ContenidoCuerpo":
                for (Nodo hijo : nodoactual.hijos) {
                    this.recorrido(hijo, html, pestaña,posicion);
                }
                break;
                
            case "saltofin":
                
              
                break;
            case "panel":
                
                 JPanel panel=new JPanel();
               
      panel.setLayout(new FlowLayout(FlowLayout.LEFT));                 
//parametros
               
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    panel.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    
                    posicion[0]+=0;
                    panel.setPreferredSize(new Dimension(10,10));
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    panel.setAlignmentX(alineado);
                   panel.setPreferredSize(new Dimension(alto,ancho));
                    posicion[0]+=0;
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                 System.out.println("Panel vacio "+nodoactual.hijos.get(1).valor);
                if(nodoactual.hijos.get(1).valor=="Vacio"){
                      System.out.println("Panel vacio "+nodoactual.hijos.get(1).valor);
                    html.add(panel);
                }else{
                   
                        for (Nodo hijo : nodoactual.hijos.get(1).hijos.get(0).hijos) {
                             System.out.println("Contenido Panel"+hijo.valor);
                    this.recorrido(hijo, panel, pestaña,posicion);
                }
                    
                html.add(panel);
                }
                
                
                
                break;
                      
            case "cajatexto":
                JTextArea textarea=new JTextArea();
//                textarea.setText("            ");
               
                JScrollPane scroll = new JScrollPane (textarea);
                
                textarea.setBorder(BorderFactory.createLineBorder(Color.black, 1));
                System.out.println("textarea"+textarea.getText());
                //parametros
                
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    textarea.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    textarea.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), textarea.getPreferredSize()));
                    posicion[0]+=0;
                     textarea.setLineWrap(true);
                textarea.setRows(5);
                textarea.setColumns(25);
                textarea.setWrapStyleWord(true);
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    textarea.setAlignmentX(alineado);
                    textarea.setSize(alto, ancho);
                    
                    textarea.setRows(alto);
                    textarea.setColumns(ancho);
                    textarea.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),textarea.getSize()));
                    posicion[0]+=0;
                    textarea.setRows(textarea.getSize().height);
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                
                html.add(scroll);
                
                
                break;
                
            case "caja":
                
               ArrayList<String> opcion = new ArrayList<String>();
                JComboBox cajaopcion =new JComboBox();
                ListDataListener lista;
                
                //          System.out.println(textarea.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    cajaopcion.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    cajaopcion.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), cajaopcion.getPreferredSize()));
                    posicion[0]+=0;
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    cajaopcion.setAlignmentX(alineado);
                    cajaopcion.setSize(alto, ancho);
                    cajaopcion.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),cajaopcion.getSize()));
                    posicion[0]+=0;
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                
                
                //configuracion de las opciones
             
                if(nodoactual.hijos.get(1).valor!="Vacio"){
                    for (Nodo hijo : nodoactual.hijos.get(1).hijos.get(0).hijos) {
                        
                        if(hijo.hijos.get(0).valor!="Sin Parametros"){
                            int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                            String id="",grupo="";
                            for (Nodo hijo2 : hijo.hijos.get(0).hijos) {
                                
                                switch (hijo2.valor){
                                    case "alto":
                                        alto= Integer.parseInt(hijo2.hijos.get(0).valor);
                                        System.out.println(alto);
                                        break;
                                    case "ancho":
                                        ancho= Integer.parseInt(hijo2.hijos.get(0).valor);
                                        System.out.println(ancho);
                                        break;
                                    case "id":
                                        id=hijo2.hijos.get(0).valor;
                                        System.out.println(id);
                                        break;
                                    case "grupo":
                                        grupo=hijo2.hijos.get(0).valor;
                                        System.out.println(grupo);
                                        break;
                                    case "alineado":
                                        String alig;
                                        alig=hijo2.hijos.get(0).valor;
                                        if(alig=="izquierda"){
                                            alineado=SwingConstants.LEFT;
                                        }else if(alig=="derecha"){
                                            alineado=SwingConstants.RIGHT;
                                        }else if(alig=="centrado"){
                                            alineado=SwingConstants.CENTER;
                                        }
                                        
                                        System.out.println(alineado);
                                        break;
                                    case "valor":
                                        String valor=hijo2.hijos.get(0).valor;
                                        System.out.println(valor);
                                        break;
                                        
                                }//fin switch
                            }//fin for
                            
                       
                            
                            
                        }
                        
                        //Fin parametros OPcion CSS
                        
                        
                        //  opcion.add(hijo.hijos.get(0).hijos.get(1).valor);
                        if(hijo.hijos.get(1).valor!="Vacio"){
                          
                           opcion.add(hijo.hijos.get(1).valor);
                   //        opcion.add("hola");
                           cajaopcion.setModel(new DefaultComboBoxModel(opcion.toArray()));
                            
                        }
                        
                    }
                }
                
                  html.add(cajaopcion);
                
                
                break;
                
            case "textoa":
                JTextField textfield=new JTextField();
                
                //          System.out.println(textarea.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    textfield.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    textfield.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), textfield.getPreferredSize()));
                    posicion[0]+=0;
                   JTextField aux=new JTextField(10);
                   textfield=aux;
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    JTextField aux= new JTextField(ancho);
                    
                    // Objeto.setSize(alto, ancho);
                    aux.setAlignmentX(alineado);
                    aux.setSize(alto, ancho);
                    aux.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),textfield.getSize()));
                    textfield=aux;
                }
                
                html.add(textfield);
                
                
                break;
                
            case "texto":
                
                JLabel Objeto=new JLabel();
                Objeto.setText(nodoactual.hijos.get(1).valor);
                System.out.println(Objeto.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Objeto.setHorizontalAlignment(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    Objeto.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), Objeto.getPreferredSize()));
                    posicion[0]+=0;
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    Objeto.setHorizontalAlignment(alineado);
                    Objeto.setSize(alto, ancho);
                    Objeto.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),Objeto.getSize()));
                    posicion[0]+=0;
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                
                html.add(Objeto);
                
                break;
                
            case "imagen":
                
                JLabel Objeto3=new JLabel();
                //Objeto3.setText(nodoactual.hijos.get(1).valor);
                //  System.out.println(Objeto3.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Objeto3.setHorizontalAlignment(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    Objeto3.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), Objeto3.getPreferredSize()));
                    posicion[0]+=0;
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="",ruta,click;
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                            case "ruta":
                                ruta=hijo.hijos.get(0).valor;
                                Objeto3.addMouseListener(new MouseListener() {
                                    public void mouseClicked(MouseEvent arg0) {
                                        System.out.println("click");
                                    }
                                    public void mouseEntered(MouseEvent arg0) {
                                        
                                    }
                                    
                                    public void mouseExited(MouseEvent arg0) {
                                        
                                    }
                                    public void mousePressed(MouseEvent arg0) {}
                                    public void mouseReleased(MouseEvent arg0) {}
                                });
                                break;
                            case "click":
                                click=hijo.hijos.get(0).valor;
                                System.out.println(click);
                                break;
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    Objeto3.setSize( ancho,alto);
                    if (nodoactual.hijos.get(1).valor!="Vacio"){
                        String path = nodoactual.hijos.get(1).valor;
                        Objeto3.setMaximumSize(new Dimension(alto,ancho));
                        ImageIcon imagen = new ImageIcon(path);
                        Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(
                                Objeto3.getWidth(),
                                Objeto3.getHeight(),
                                Image.SCALE_DEFAULT));
                        System.out.println("Path imagen:"+path);
                        Objeto3.setIcon(icono);
                    }
                    
                    
                    
                    
                    Objeto3.setHorizontalAlignment(alineado);
                    
                    Objeto3.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),Objeto3.getSize()));
                    
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                
                html.add(Objeto3);
                break;
                
                
            case "boton":
                JButton Boton=new JButton();
                Boton.setText(nodoactual.hijos.get(1).valor);
                System.out.println(Boton.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Boton.setHorizontalAlignment(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    
                    Boton.setBounds(20, 20, 20, 20);
                    //  Boton.setSize(10,20);
                    
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    Boton.setHorizontalAlignment(alineado);
//               Boton.setSize(alto, ancho);
Boton.setBounds(20, 20, 20, 20);
                }
                
                
                
                
                html.add(Boton);
                
                
                break;
                
                
            case "enlace":
                JLabel Objeto2=new JLabel();
                Objeto2.setText(nodoactual.hijos.get(1).valor);
                System.out.println(Objeto2.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Objeto2.setHorizontalAlignment(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    Objeto2.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), Objeto2.getPreferredSize()));
                    posicion[0]+=0;
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    Objeto2.setHorizontalAlignment(alineado);
                    Objeto2.setSize(alto, ancho);
                    Objeto2.setForeground(Color.blue);
                    
                    Font font = Objeto2.getFont();
                    Map attributes = font.getAttributes();
                    attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
                    Objeto2.setFont(font.deriveFont(attributes));
                    Objeto2.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),Objeto2.getSize()));
                    posicion[0]+=0;
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                Objeto2.addMouseListener(new MouseListener() {
                    public void mouseClicked(MouseEvent arg0) {
                        System.out.println("click");
                    }
                    public void mouseEntered(MouseEvent arg0) {
                        
                    }
                    
                    public void mouseExited(MouseEvent arg0) {
                        
                    }
                    public void mousePressed(MouseEvent arg0) {}
                    public void mouseReleased(MouseEvent arg0) {}
                });
                
                html.add(Objeto2);
                
                
                break;
                
            case "tabla":
                
                DefaultTableModel model=new DefaultTableModel();
             JTable tabla=new JTable(model);

             
          
             
                //parametros tabla
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    tabla.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                   
            tabla.setPreferredScrollableViewportSize(new Dimension(100,100));
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    tabla.setAlignmentX(alineado);
            tabla.setPreferredScrollableViewportSize(new Dimension(ancho,alto));                 
                 tabla.setPreferredSize(new Dimension(ancho, alto));
                 }
                
                
                //Contenido de la tabla
                
                if(nodoactual.hijos.get(1).valor!="Vacio"){
                    
                    if(nodoactual.hijos.get(1).hijos.get(0).valor!="fil_t"){
                        System.out.println("Error en Tabla");
                    }
                    for (Nodo hijo : nodoactual.hijos.get(1).hijos.get(0).hijos) {
                        if(hijo.hijos.get(0).valor=="Sin Parametros"){}
                         
                            for (Nodo hijo2 : hijo.hijos.get(1).hijos ) {
                                switch(hijo2.valor){
                                    case "ct":
                                        
                                        
                                        
                                    break;
                                    case "cb":
                                        
                                        
                                        
                                    break;
                                    default:
                                        
                                        System.out.println("ERROR EN CONTENIDO DE LA TABLA");
                                }
                                
                                
                                
                            }
                        
                        
                    }
                    
                }
         model.addColumn("Col1");
                                model.addColumn("Col1");
                              model.addRow(new Object[]{"",""});
                /*  tabla.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                {null, null, null}
                },
                new String [] {
                "Título 1", "Título 2", "Título 3"
                }
                ));*/
                JScrollPane jScrollPane1=new JScrollPane();
                jScrollPane1.setPreferredSize(tabla.getPreferredSize());
                jScrollPane1.setViewportView(tabla);

                
                html.add(jScrollPane1);
                break;
                
            case "spinner":
                JTextField spinner=new JTextField(5);
               spinner.setText(nodoactual.hijos.get(1).valor);
                System.out.println(spinner.getText());
                //parametros
                
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    spinner.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    spinner.setBounds(new Rectangle(new Point(posicion[0], posicion[1]), spinner.getPreferredSize()));
                    posicion[0]+=0;
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                System.out.println(grupo);
                                break;
                            case "alineado":
                                String alig;
                                alig=hijo.hijos.get(0).valor;
                                if(alig=="izquierda"){
                                    alineado=SwingConstants.LEFT;
                                }else if(alig=="derecha"){
                                    alineado=SwingConstants.RIGHT;
                                }else if(alig=="centrado"){
                                    alineado=SwingConstants.CENTER;
                                }
                                
                                System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    spinner.setAlignmentX(alineado);
                    spinner.setSize(alto, ancho);
                 
                    spinner.setBounds(new Rectangle(new Point(posicion[0], posicion[1]),spinner.getSize()));
                    posicion[0]+=0;
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
              
                 if(nodoactual.hijos.get(1).valor=="Vacio"){
                 spinner.setText("   ");
                 }
                 else{
                 spinner.setText(nodoactual.hijos.get(1).valor);
                 }
               
               
                
                 html.add(spinner);
                break;
           
          
                
         
                
                //FIN CUERPO
            default:
                //throw new AssertionError();
        }
        return posicion;
    }

    
    
public void GuardarCSS(Nodo nodoactual,ListaCSS lista){
switch(nodoactual.valor){
    case "Estilo":
        for (Nodo hijo : nodoactual.hijos) {
            for (Nodo hijo2 : hijo.hijos.get(0).hijos) {
               
               
                
                
            }        
            
            
        }
        
        break;
    
    default:
}

}
    
}



