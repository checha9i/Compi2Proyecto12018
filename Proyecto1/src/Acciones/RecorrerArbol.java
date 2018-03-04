/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Analizadores.Lexico;
import Analizadores.Nodo;
import Analizadores.Sintactico;
import Principal.LeerArchivo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.TextAttribute;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author chech
 */


public class RecorrerArbol {
public Font subrayado = new Font("Arial", TextAttribute.UNDERLINE_ON, Font.BOLD);
RecorrerCSS CCSS=new RecorrerCSS();


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
         
               CCSS.AnalizarCCSS(comp,listacss);
               CCSS.MemoriaCSS(listacss);
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
               
      //panel.setLayout(new FlowLayout(FlowLayout.LEFT));                 
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
                                        if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.csspanel(panel,listacss,i);
                               panel.repaint();
                                }else{
                                   System.out.println("No Existe css");}
                               
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                               // System.out.println(grupo);
                                if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.csspanel(panel,listacss,i);
                               panel.repaint();
                                }else{
                                   System.out.println("No Existe css");}
                               
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
                                if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.csstextarea(textarea,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                               
                              //  System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                                //System.out.println(grupo);
                                     if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.csstextarea(textarea,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                               
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
                                   if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.csscajaopcion(cajaopcion,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                               
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //  System.out.println(grupo);
                                        if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.csscajaopcion(cajaopcion,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                               
                                        
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
                                 if(CCSS.BuscarCSS(listacss,id)==true){
                                System.out.println("Existecss");
                                }
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
                                   if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.csslabel(Objeto,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                             //   System.out.println(id);
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                            //    System.out.println(grupo);
                                  if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.csslabel(Objeto,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
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
                                  if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.cssimagen(Objeto3,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                          //      System.out.println(grupo);
                                  if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.cssimagen(Objeto3,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
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
                        File f = new File(path);
                if(f.exists() && !f.isDirectory()) { 
                        Image imagen = new ImageIcon(path).getImage();
                   
                                   Icon icono = new ImageIcon(imagen.getScaledInstance(
                                Objeto3.getWidth(),
                                Objeto3.getHeight(),
                                Image.SCALE_DEFAULT));
    Objeto3.setIcon(icono);
                }else{
                        Image imagen = new ImageIcon("C:\\Users\\chech\\OneDrive\\Documentos\\GitHub\\Compi2Proyecto12018\\Proyecto1\\src\\Iconos\\ImagenNoEncontrada.png").getImage();
                                   Icon icono = new ImageIcon(imagen.getScaledInstance(
                                Objeto3.getWidth(),
                                Objeto3.getHeight(),
                                Image.SCALE_DEFAULT));
    Objeto3.setIcon(icono);
                }
                
                       // System.out.println("Path imagen:"+path);
                        
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
                                if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.cssboton(Boton,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                                
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //  System.out.println(grupo);
                                if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.cssboton(Boton,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                               
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
                    int alto=100,ancho=205,alineado=SwingConstants.CENTER;
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
                                      if(CCSS.BuscarCSS(listacss,id)==true){
                               int i=CCSS.getIndexOfCSS(listacss,id);
                               CCSS.csslabel(Objeto2,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
                                break;
                            case "grupo":
                                grupo=hijo.hijos.get(0).valor;
                              //   System.out.println(grupo);
                                      if(CCSS.BuscarCSS(listacss,grupo)==true){
                               int i=CCSS.getIndexOfCSS(listacss,grupo);
                               CCSS.csslabel(Objeto2,listacss,i);
                               
                                }else{
                                   System.out.println("No Existe css");}
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
                               spinner.setText("0");
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
               
                spinner.addKeyListener(new KeyAdapter() {
public void keyTyped(KeyEvent evt) {
int k=(int)evt.getKeyChar();
if (!(k >= 48 && k <= 57)){
evt.setKeyChar((char)KeyEvent.VK_CLEAR);
JOptionPane.showMessageDialog(null,"No puede ingresar letras!!!","Ventana Error Datos",JOptionPane.ERROR_MESSAGE);
}
}

        });
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

    

}