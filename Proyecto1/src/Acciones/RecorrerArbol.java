/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Analizadores.Lexico;
import Analizadores.LexicoCSS;
import Analizadores.Nodo;
import Analizadores.Sintactico;
import Analizadores.SintacticoCSS;
import Principal.LeerArchivo;
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
    public int[] Analizar(String entrada,JPanel cosas,JTabbedPane pestaña,ArrayList<ListaCSS> listacss,int[] pos) {
      int[] posicion=new int[6];
      posicion[0]=pos[0];
        posicion[1]=pos[1];
        posicion[2]=pos[2];
        posicion[3]=pos[3];
        
        try {
            //crear el lexico
            Lexico lexico = new Lexico(new StringReader(entrada));
            //crear el sintactico
            Sintactico parser = new Sintactico(lexico);

            //ejecutar el analisis
            parser.parse();


            //Graficar
            //this.graficarAST(parser.raiz);            
            Graficador g = new Graficador();
           // g.graficarAST(parser.raiz);
      
            
//Recorrido

            try {
            
                posicion = this.recorrido(parser.raiz, cosas, pestaña, listacss, posicion);
            } catch (Exception e) {
            }
//JOptionPane.showMessageDialog(null, "Analisis Completo", "CHTML", 1);

        } catch (Exception ex) {
            Logger.getLogger(Compilador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un grave problema", "CHTML", 2);
        }
return posicion;
    }

    public int tamañoarbol(int tamaño, Nodo nodoactual) {

        for (Nodo hijo : nodoactual.hijos) {
            tamaño = tamañoarbol(tamaño, hijo) + 1;

        }

        return tamaño;
    }
      public int[] posicion= new int[6];
    
    public  int[] recorrido(Nodo nodoactual, JPanel html,JTabbedPane pestaña,ArrayList<ListaCSS> listacss,int[] pos) {
      
   
             
        posicion[0]=pos[0];
        posicion[1]=pos[1];
        
  
        
        posicion[2]=0;
        posicion[3]=0;
           if(posicion[5]<posicion[1]){
                   posicion[5]=posicion[1];
                   }
           
           
        switch (nodoactual.valor) {
            case "chtml":
                
                for (Nodo hijo : nodoactual.hijos) {
            posicion=      this.recorrido(hijo, html, pestaña, listacss, posicion);
                }
                
                break;
                //EMPIEZA ENCABEZADO
            case "encabezado":
                
                
              posicion=this.recorrido((nodoactual.hijos.get(0)), html, pestaña, listacss, posicion);
                
                break;
                
            case "ContenidoEncabezado":
                for (Nodo hijo : nodoactual.hijos) {
                   posicion= this.recorrido(hijo, html, pestaña, listacss, posicion);
                }
                break;
            case "CCSS":
              String urlcss=nodoactual.hijos.get(0).valor;
                             LeerArchivo leer = new LeerArchivo();
            String comp = leer.LeerArchivo(urlcss);
         
               AnalizarCCSS(comp,listacss);
                       System.out.println("Se cargo a memoria el css");
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
                  posicion=  this.recorrido(hijo, html, pestaña, listacss, posicion);
                }
                break;
                
            case "ContenidoCuerpo":
                for (Nodo hijo : nodoactual.hijos) {
                    this.recorrido(hijo, html, pestaña, listacss, posicion);
                }
                break;
                
            case "saltofin":
                

                         
                       
                           posicion[1]=posicion[5]+1;
                          posicion[0]=0;
                               if(posicion[5]>posicion[1]){
                   posicion[5]=posicion[1];
                   }
                break;
            case "panel":
                
                 JPanel panel=new JPanel();
               
      panel.setLayout(new FlowLayout(FlowLayout.LEFT));                 
//parametros
                       posicion[2]=50; 
                   posicion[3]=50;
                  int[] auxp;
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    panel.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    
               
                   
                    panel.setPreferredSize(new Dimension(10,10));
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                                //System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                               // System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                               // System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                               // System.out.println(grupo);
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
                                
                              //  System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    panel.setAlignmentX(alineado);
                   posicion[2]=ancho; 
                   posicion[3]=alto;
                   
                   panel.setPreferredSize(new Dimension(ancho,alto));
                     
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                 
                //termina parametros
                
                //empieza contenido
                   if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   }
                   
                   
                //System.out.println("Panel vacio "+nodoactual.hijos.get(1).valor);
                if(nodoactual.hijos.get(1).valor=="Vacio"){
                    //  System.out.println("Panel vacio "+nodoactual.hijos.get(1).valor);
                    panel.setBounds(posicion[0], posicion[1], posicion[2], posicion[3]);
                      
                    posicion[4]=posicion[0]+posicion[2];
                    posicion[0]=posicion[4];
                    if (posicion[4]>html.getWidth()){
                        html.setSize(posicion[2], posicion[3]);
                    }
                    html.add(panel);
                    
                    
                }else{
                      int[] posn=new int[6];
                      
              
                            auxp=posicion;
                            
                            int x=posicion[0];
                            int y=posicion[1];
                            int width=posicion[2];
                            int height=posicion[3];
                            int maxx=posicion[4];
                            int maxy=posicion[5];
                            posn[0]=0;
                              posn[1]=0;
                                    
                        for (Nodo hijo : nodoactual.hijos.get(1).hijos.get(0).hijos) {
                          //   System.out.println("Contenido Panel"+hijo.valor);
                          
                  this.recorrido(hijo, panel, pestaña, listacss,posn);
                                    
                        }
                        posicion[0]=x;
                        posicion[1]=y;
                        posicion[2]=width;
                        posicion[3]=height;
                        posicion[4]=maxx;
                        posicion[5]=maxy;
                        
                   panel.setBounds(posicion[0], posicion[1], posicion[2], posicion[3]);
                      
                    posicion[4]=posicion[0]+posicion[2];
                    posicion[0]=posicion[4]; 
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
                   
                    html.add(panel);
           
                }
                
                
                
                break;
                      
            case "cajatexto":
                JTextArea textarea=new JTextArea();
//                textarea.setText("            ");
               
                JScrollPane scroll = new JScrollPane (textarea);
                
                textarea.setBorder(BorderFactory.createLineBorder(Color.black, 1));
               // System.out.println("textarea"+textarea.getText());
                //parametros
                
                   posicion[2]=100; 
                   posicion[3]=70;
                 
            
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    textarea.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
        
                     textarea.setLineWrap(true);
                
                textarea.setWrapStyleWord(true);
                
              
                }
                else{
                    int alto=20,ancho= 50 ,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                               // System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                              //  System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                                
                              //  System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                //System.out.println(grupo);
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
                                
                               //System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    textarea.setAlignmentX(alineado);
                    textarea.setSize(ancho, alto);
                    
                    textarea.setRows(alto);
                    textarea.setColumns(ancho);
               
                         posicion[2]=ancho; 
                   posicion[3]=alto;
                
                    
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                
                if(nodoactual.hijos.get(1).valor!="Vacio"){
                textarea.setText(nodoactual.hijos.get(1).valor);
                    
                }
           scroll = new JScrollPane (textarea);
               
                                 scroll.setBounds(posicion[0], posicion[1], posicion[2], posicion[3]);
                       
                    posicion[4]=posicion[0]+posicion[2];
                    posicion[0]=posicion[4];
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
                
                html.add(scroll);
                   if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   }
                
                break;
                
             case "caja":
                
               ArrayList<String> opcion = new ArrayList<String>();
                JComboBox cajaopcion =new JComboBox();
                ListDataListener lista;
                
                //          System.out.println(textarea.getText());
                //parametros
                     posicion[2]=100; 
                   posicion[3]=30;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    cajaopcion.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                   
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                               // System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                                //System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                               // System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //  System.out.println(grupo);
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
                                
                               // System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    cajaopcion.setAlignmentX(alineado);
                    cajaopcion.setSize(alto, ancho);
                    
                      
                                       posicion[2]=ancho; 
                   posicion[3]=alto;
                  
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
                                    //    System.out.println(alto);
                                        break;
                                    case "ancho":
                                        ancho= Integer.parseInt(hijo2.hijos.get(0).valor);
                                      //  System.out.println(ancho);
                                        break;
                                    case "id":
                                        id=hijo2.hijos.get(0).valor;
                                     //   System.out.println(id);
                                        break;
                                    case "grupo":
                                        grupo=hijo2.hijos.get(0).valor;
                                    //    System.out.println(grupo);
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
                                        
                                     //   System.out.println(alineado);
                                        break;
                                    case "valor":
                                        String valor=hijo2.hijos.get(0).valor;
                                     //   System.out.println(valor);
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
                
                   if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   } 
                
                cajaopcion.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
                  html.add(cajaopcion);
                
                
                break;
                
            case "textoa":
                JTextField textfield=new JTextField();
                
                //          System.out.println(textarea.getText());
                //parametros
                       posicion[2]=100; 
                   posicion[3]=10;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    textfield.setAlignmentX(SwingConstants.CENTER);
                    
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
                              //  System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                               // System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                              //  System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //  System.out.println(grupo);
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
                                
                            //    System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    JTextField aux= new JTextField(ancho);
                    
                    // Objeto.setSize(alto, ancho);
                    aux.setAlignmentX(alineado);
                    aux.setSize(alto, ancho);
                    textfield=aux;
                       posicion[2]=ancho; 
                   posicion[3]=alto;
               
                    
                }
                            if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   } 
                
                textfield.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
                html.add(textfield);
                
                
                break;
                
            case "texto":
                
                JLabel Objeto=new JLabel();
                Objeto.setText(nodoactual.hijos.get(1).valor);
               // System.out.println(Objeto.getText());
                //parametros
                     posicion[2]=100; 
                   posicion[3]=10;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                     
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Objeto.setHorizontalAlignment(SwingConstants.LEFT);
                    // Objeto.setLocation(posicion[0],posicion[1]);
               
                    
                }
                else{
                    int alto=15,ancho=105,alineado=SwingConstants.LEFT;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                            //    System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                           //     System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                             //   System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                            //    System.out.println(grupo);
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
                                
                            //    System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    Objeto.setHorizontalAlignment(alineado);
                    Objeto.setSize(alto, ancho);
                   posicion[2]=ancho; 
                   posicion[3]=alto;
                 
                                
                }
                            if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   } 
                             Objeto.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
                html.add(Objeto);
                break;
                
            case "imagen":
                
                JLabel Objeto3=new JLabel();
                //Objeto3.setText(nodoactual.hijos.get(1).valor);
                //  System.out.println(Objeto3.getText());
                //parametros
                  posicion[2]=100; 
                   posicion[3]=10;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Objeto3.setHorizontalAlignment(SwingConstants.LEFT);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                   
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.LEFT;
                    String id="",grupo="",ruta,click;
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                            //    System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                            //    System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                             //   System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                          //      System.out.println(grupo);
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
                                
                            //    System.out.println(alineado);
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
                       // System.out.println("Path imagen:"+path);
                        Objeto3.setIcon(icono);
                    }
                    
                    
             Objeto3.setHorizontalAlignment(alineado);
                       posicion[2]=ancho; 
                   posicion[3]=alto;
               
                  
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                            if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   } 
                        Objeto3.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
                html.add(Objeto3);
                
                break;
                
                
            case "boton":
                JButton Boton=new JButton();
                Boton.setText(nodoactual.hijos.get(1).valor);
              //  System.out.println(Boton.getText());
                //parametros
                     posicion[2]=Boton.getPreferredSize().width; 
                   posicion[3]=Boton.getPreferredSize().height;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Boton.setHorizontalAlignment(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                    
                    //Boton.setBounds(20, 20, 20, 20);
                    //  Boton.setSize(10,20);
                    
                    
                }
                else{
                    int alto=Boton.getPreferredSize().height,ancho=Boton.getPreferredSize().width,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                         //       System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                            ////    System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                              //  System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //  System.out.println(grupo);
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
                                
                           //      System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    Boton.setHorizontalAlignment(alineado);
//               Boton.setSize(alto, ancho);
      posicion[2]=ancho; 
                   posicion[3]=alto;
               
                }
                            if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   } 
                Boton.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
                
                
                html.add(Boton);
                
                
                break;
                
                
            case "enlace":
                JLabel Objeto2=new JLabel();
                Objeto2.setText(nodoactual.hijos.get(1).valor);
      
                //parametros
                            posicion[2]=Objeto2.getPreferredSize().width; 
                   posicion[3]=Objeto2.getPreferredSize().height;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                     
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    Objeto2.setHorizontalAlignment(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                 
                                               posicion[2]=Objeto2.getPreferredSize().width; 
                   posicion[3]=Objeto2.getPreferredSize().height;
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                               // System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                               // System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                              //  System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //   System.out.println(grupo);
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
                                
                       //          System.out.println(alineado);
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
                    
                         posicion[2]=ancho; 
                   posicion[3]=alto;
               
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                           if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
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
                   
                Objeto2.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
               
                
                html.add(Objeto2);
                
                
                break;
                
            case "tabla":
                
                DefaultTableModel model=new DefaultTableModel();
             JTable tabla=new JTable(model);
             posicion[2]=200; 
                   posicion[3]=30;
              
             
          
             
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
                               //  System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                              //   System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                             //    System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                 //ln(grupo);
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
                                
                             //    System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    tabla.setAlignmentX(alineado);
            tabla.setPreferredScrollableViewportSize(new Dimension(ancho,alto));                 
                 tabla.setPreferredSize(new Dimension(ancho, alto));
                
                          posicion[2]=ancho; 
                   posicion[3]=alto;
             
                }
                
                      
                //Contenido de la tabla
                
                if(nodoactual.hijos.get(1).valor!="Vacio"){
                    
                    if(nodoactual.hijos.get(1).hijos.get(0).valor!="fil_t"){
                        //println("Error en Tabla");
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
                                        
                                    //    System.out.println("ERROR EN CONTENIDO DE LA TABLA");
                                }
                                
                                
                                
                            }
                        
                        
                    }
                    
                }
                   if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
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

                jScrollPane1.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
                html.add(jScrollPane1);
                break;
                
            case "spinner":
                JTextField spinner=new JTextField(5);
               spinner.setText(nodoactual.hijos.get(1).valor);
                // System.out.println(spinner.getText());
                //parametros
                              posicion[2]=200; 
                   posicion[3]=30;
                     if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);}
                if(nodoactual.hijos.get(0).valor=="Sin Parametros"){
                    // Objeto.setSize(100, 15);
                    spinner.setAlignmentX(SwingConstants.CENTER);
                    // Objeto.setLocation(posicion[0],posicion[1]);
                   
                    
                }
                else{
                    int alto=100,ancho=15,alineado=SwingConstants.CENTER;
                    String id="",grupo="";
                    for (Nodo hijo : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                        
                        switch (hijo.valor){
                            case "alto":
                                alto= Integer.parseInt(hijo.hijos.get(0).valor);
                              //   System.out.println(alto);
                                break;
                            case "ancho":
                                ancho= Integer.parseInt(hijo.hijos.get(0).valor);
                              //   System.out.println(ancho);
                                break;
                            case "id":
                                id=hijo.hijos.get(0).valor;
                              //  System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //  System.out.println(grupo);
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
                                
                               // System.out.println(alineado);
                                break;
                                
                        }//fin switch
                    }//fin for
                    // Objeto.setSize(alto, ancho);
                    spinner.setAlignmentX(alineado);
                    spinner.setSize(alto, ancho);
                             posicion[2]=ancho; 
                   posicion[3]=alto;
                
                 
                    
                    //  Objeto.setLocation(posicion[0],posicion[1]);
                }
                          if(posicion[5]<(posicion[1]+posicion[3])){
                   posicion[5]=(posicion[1]+posicion[3]);
                   } 
                 if(nodoactual.hijos.get(1).valor=="Vacio"){
                 spinner.setText("   ");
                 }
                 else{
                 spinner.setText(nodoactual.hijos.get(1).valor);
                 }
               
               spinner.setBounds(posicion[0],posicion[1], posicion[2], posicion[3]);
                    //  Objeto.setLocation(0,800);
                    posicion[4]=posicion[0]+posicion[2];
                   
                    if (posicion[4]>html.getWidth()){
                        
                        html.setSize(posicion[4], posicion[5]);
                    }
               posicion[0]=posicion[4]+1;
               
                
                 html.add(spinner);
                break;
           
          
                
         
                
                //FIN CUERPO
            default:
                //throw new AssertionError();
                posicion[0]=pos[0];
        posicion[1]=pos[1];
        posicion[2]=pos[2];
        posicion[3]=pos[3];
               
                
                
        }
        
        return posicion;
  }

    
  public  int inde;
    
public int GuardarCSS(Nodo nodoactual,ArrayList<ListaCSS> lista){

    
    if(lista.isEmpty()){
    inde=0;
    }
    
            
    switch(nodoactual.valor){
        case "Estilos":
            for (Nodo hijo : nodoactual.hijos) {
                
                  this.GuardarCSS(hijo.hijos.get(0), lista);
            }
            break;
            
        case "ElementoOGrupo":
          
            for (Nodo hijo : nodoactual.hijos) {
                
                inde=this.GuardarCSS(hijo, lista);
                
            }
            break;
            
        case "ID":

            ListaCSS css=new ListaCSS(inde);
            
            
            css.index=inde;
            css.ID=nodoactual.hijos.get(0).valor;
                      
            
            for (Nodo ncss : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                
                switch(ncss.valor){
                   case "formato":
                        for (Nodo formato: ncss.hijos.get(0).hijos) {
                        if(css.formato==null){
                            css.formato=formato.valor;
                        }else{css.formato+=","+formato.valor;}
                        }
                        break;
                    case "letra":
                        css.letra=ncss.hijos.get(0).valor;
                        break;
                    case "tamtex":
                        css.tamtext=(int) Math.round(Double.parseDouble(ncss.hijos.get(0).valor));
                        break;
                    case "Alineado":
                        css.alineado=ncss.hijos.get(0).valor;
                        break;
                    
                    case "fondoelemento":
                       if(TestHex(ncss.hijos.get(0).valor)){
                         Color fondo=GetColorHex(ncss.hijos.get(0).valor);
                           css.fondoelemento = fondo;
                         
                       }else{
                       Color fondo=getColor(ncss.hijos.get(0).valor);
                       css.fondoelemento=fondo;
                       }
                        break;
                    case "ColorText":
                          if(TestHex(ncss.hijos.get(0).valor)){
                         Color fondo=GetColorHex(ncss.hijos.get(0).valor);
                           css.colortext = fondo;
                         
                       }else{
                       Color fondo=getColor(ncss.hijos.get(0).valor);
                       css.colortext=fondo;
                       }
                        break;
                    case "borde":
                        if(TestHex(ncss.hijos.get(1).valor)){
                         Color colorborde=GetColorHex(ncss.hijos.get(1).valor);
                           css.ColorBorde = colorborde;
                         
                       }else{
                       Color colorborde=getColor(ncss.hijos.get(1).valor);
                       css.ColorBorde=colorborde;
                       }
                        css.ThicknessBorde=(int) Math.round(Double.parseDouble(ncss.hijos.get(0).valor));
                        css.curveBorde=Boolean.parseBoolean(ncss.hijos.get(2).valor);
                        break;
                    case "visible":
                        css.visible=Boolean.parseBoolean(ncss.hijos.get(0).valor);
                        break;
                    case "opaque":
                        css.opaque=Boolean.parseBoolean(ncss.hijos.get(0).valor);
                        break;
                    case "autoredimension":
                        css.autoredimension=Boolean.parseBoolean(ncss.hijos.get(0).valor);
                        css.DirRedimension=ncss.hijos.get(1).valor;
                        break;
                    case "Texto":
                        css.texto=ncss.hijos.get(0).valor;
                        break;
                
                }
                
            }
            if(BuscarCSS(lista,css.GRUPO)==false||BuscarCSS(lista,css.ID)==false){
            lista.add(css);
            }
           inde+=1;
            
            break;
            
        case "Grupo":
            

                  ListaCSS css2=new ListaCSS(inde);
            css2.index=inde;
            css2.GRUPO=nodoactual.hijos.get(0).valor;
            
            for (Nodo ncss : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                
                switch(ncss.valor){
                    case "formato":
                        for (Nodo formato: ncss.hijos.get(0).hijos) {
                        if(css2.formato==null){
                            css2.formato=formato.valor;
                        }else{css2.formato+=","+formato.valor;}
                        }
                        break;
                    case "letra":
                        css2.letra=ncss.hijos.get(0).valor;
                        break;
                    case "tamtex":
                        css2.tamtext=(int) Math.round(Double.parseDouble(ncss.hijos.get(0).valor));
                        break;
                    case "Alineado":
                        css2.alineado=ncss.hijos.get(0).valor;
                        break;
                    
                    case "fondoelemento":
                       if(TestHex(ncss.hijos.get(0).valor)){
                         Color fondo=GetColorHex(ncss.hijos.get(0).valor);
                           css2.fondoelemento = fondo;
                         
                       }else{
                       Color fondo=getColor(ncss.hijos.get(0).valor);
                       css2.fondoelemento=fondo;
                       }
                        break;
                    case "ColorText":
                          if(TestHex(ncss.hijos.get(0).valor)){
                         Color fondo=GetColorHex(ncss.hijos.get(0).valor);
                           css2.colortext = fondo;
                         
                       }else{
                       Color fondo=getColor(ncss.hijos.get(0).valor);
                       css2.colortext=fondo;
                       }
                        break;
                    case "borde":
                        if(TestHex(ncss.hijos.get(1).valor)){
                         Color colorborde=GetColorHex(ncss.hijos.get(1).valor);
                           css2.ColorBorde = colorborde;
                         
                       }else{
                       Color colorborde=getColor(ncss.hijos.get(1).valor);
                       css2.ColorBorde=colorborde;
                       }
                        css2.ThicknessBorde=(int) Math.round(Double.parseDouble(ncss.hijos.get(0).valor));
                        css2.curveBorde=Boolean.parseBoolean(ncss.hijos.get(2).valor);
                        break;
                    case "visible":
                        css2.visible=Boolean.parseBoolean(ncss.hijos.get(0).valor);
                        break;
                    case "opaque":
                        css2.opaque=Boolean.parseBoolean(ncss.hijos.get(0).valor);
                        break;
                    case "autoredimension":
                        css2.autoredimension=Boolean.parseBoolean(ncss.hijos.get(0).valor);
                        css2.DirRedimension=ncss.hijos.get(1).valor;
                        break;
                   case "Texto":
                        css2.texto=ncss.hijos.get(0).valor;
                        break;
                }
                
            }
            if(BuscarCSS(lista,css2.GRUPO)==false||BuscarCSS(lista,css2.ID)==false){
           lista.add(css2);
            }
      inde+=1;
            break;
            
            
        default:
    }
    
  return inde;
}

public void AnalizarCCSS(String url,ArrayList<ListaCSS> lista){
    
 int index=0;
  try 
        {
            

            //crear el lexico
            LexicoCSS lexico = new LexicoCSS(new StringReader(url));
            //crear el sintactico
            SintacticoCSS parser = new SintacticoCSS(lexico);
            
            //ejecutar el analisis
            parser.parse();
                                    
          //  JOptionPane.showMessageDialog(null, "Analisis Completo","Ejemplo 1 AST",1);
            
            //Graficar
            //this.graficarAST(parser.raiz);            
            GraficadorCSS g = new GraficadorCSS();
         //  g.graficarAST(parser.raiz);
            
            //Recorrido
            GuardarCSS(parser.raiz,lista);
            MemoriaCSS(lista);
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(CompiladorCSS.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ocurrio un grave problema","Ejemplo 1 AST",2);
        }   

     
}

public void MemoriaCSS(ArrayList<ListaCSS> lista){
    if(!lista.isEmpty()){
        
        for(int i=0;i<lista.size();i++){
            System.out.println("index: "+lista.get(i).index);
            System.out.println("Grupo: "+lista.get(i).GRUPO);
            System.out.println("ID: "+lista.get(i).ID);
            System.out.println("Alineado: "+lista.get(i).alineado);
            System.out.println("AutoRedimension: ["+lista.get(i).autoredimension+","+lista.get(i).DirRedimension+"]");
            System.out.println("Borde: ["+lista.get(i).ColorBorde+","+lista.get(i).ThicknessBorde+","+lista.get(i).curveBorde+"]");
            System.out.println("ColorText: "+lista.get(i).colortext);
            System.out.println("FondoElemento: "+lista.get(i).fondoelemento);
            System.out.println("Formato: "+lista.get(i).formato);
            System.out.println("Letra: "+lista.get(i).letra);
            System.out.println("Opaque: "+lista.get(i).opaque);
            System.out.println("TamText: "+lista.get(i).tamtext);
            System.out.println("Texto: "+lista.get(i).texto);
            System.out.println("Visible: "+lista.get(i).visible);
            System.out.println("FinID");
        }
    }
    
}
    private boolean TestHex(String value) {
        boolean ret;
        try {
                int t = Integer.parseInt(value, 16);
            ret = true;
        } catch (NumberFormatException e) {
            ret = false;
        }
        return (ret);
    }

        public Color getColor(String col) {
   Color color=Color.LIGHT_GRAY;
   
            switch (col.toLowerCase()) {
    case "black":
        color = Color.BLACK;
        break;
    case "blue":
        color = Color.BLUE;
        break;
    case "cyan":
        color = Color.CYAN;
        break;
    case "darkgray":
        color = Color.DARK_GRAY;
        break;
    case "gray":
        color = Color.GRAY;
        break;
    case "green":
        color = Color.GREEN;
        break;
    case "yellow":
        color = Color.YELLOW;
        break;
    case "lightgray":
        color = Color.LIGHT_GRAY;
        break;
    case "magneta":
        color = Color.MAGENTA;
        break;
    case "orange":
        color = Color.ORANGE;
        break;
    case "pink":
        color = Color.PINK;
        break;
    case "red":
        color = Color.RED;
        break;
    case "white":
        color = Color.WHITE;
        break;
        }
    return color;
    }

    public Color GetColorHex(String colorStr) {
    return new Color(
            Integer.valueOf( colorStr.substring( 1, 3 ), 16 ),
            Integer.valueOf( colorStr.substring( 3, 5 ), 16 ),
            Integer.valueOf( colorStr.substring( 5, 7 ), 16 ) );
}
    
    public boolean BuscarCSS(ArrayList<ListaCSS> lista,String entrada){
    boolean ret=false;
    int cont=0;
    if(!lista.isEmpty()){
        while(cont<lista.size()){
            if(lista.get(cont).ID==entrada||lista.get(cont).GRUPO==entrada){
            ret=true;
            break;
            }
            
            cont++;
        }
        
    }
    
    
    return ret;
    }
}