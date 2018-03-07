/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Analizadores.LexicoCSS;
import Analizadores.Nodo;
import Analizadores.SintacticoCSS;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author Javier
 */
public class RecorrerCSS {
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
                      
            int contformato=0;
            for (Nodo ncss : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                
                switch(ncss.valor){
                   case "formato":
                       /*      for (Nodo formato: ncss.hijos.get(0).hijos) {
                       css.formato[contformato]=formato.valor;
                       contformato++;
                       }*/
                        break;
                    case "letra":
                    String fonts[] =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                        for ( int i = 0; i < fonts.length; i++ ){
                        
                        if(fonts[i].compareTo(ncss.hijos.get(0).valor)==0){
                        css.letra=fonts[i];
                        }
                        }
                        break;
                    case "tamtex":
                        css.tamtext=(int) Math.round(Double.parseDouble(ncss.hijos.get(0).valor));
                        if (css.tamtext<5){
                        css.tamtext=5;
                        }
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
            int contformato2=0;
            for (Nodo ncss : nodoactual.hijos.get(0).hijos.get(0).hijos) {
                
                switch(ncss.valor){
                    case "formato":
                        /*       for (Nodo formato: ncss.hijos.get(0).hijos) {
                        
                        css2.formato[contformato2]=formato.valor;
                        contformato2++;
                        }*/
                        break;
                    case "letra":
                        
                          String fonts[] =GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
                        for ( int i = 0; i < fonts.length; i++ ){
                       
                        if(fonts[i].compareTo(ncss.hijos.get(0).valor)==0){
                        css2.letra=fonts[i];
                        }
                        }
                        break;
                    case "tamtex":
                        
                        css2.tamtext=(int) Math.round(Double.parseDouble(ncss.hijos.get(0).valor));
                        if (css2.tamtext<5){
                        css2.tamtext=5;
                        }
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
            //System.out.println("index: "+lista.get(i).index);
            //System.out.println("Grupo: "+lista.get(i).GRUPO);
            //System.out.println("ID: "+lista.get(i).ID);
            //System.out.println("Alineado: "+lista.get(i).alineado);
            //System.out.println("AutoRedimension: ["+lista.get(i).autoredimension+","+lista.get(i).DirRedimension+"]");
            //System.out.println("Borde: ["+lista.get(i).ColorBorde+","+lista.get(i).ThicknessBorde+","+lista.get(i).curveBorde+"]");
            //System.out.println("ColorText: "+lista.get(i).colortext);
            //System.out.println("FondoElemento: "+lista.get(i).fondoelemento);
            //System.out.println("Letra: "+lista.get(i).letra);
            //System.out.println("Opaque: "+lista.get(i).opaque);
            //System.out.println("TamText: "+lista.get(i).tamtext);
            //System.out.println("Texto: "+lista.get(i).texto);
            //System.out.println("Visible: "+lista.get(i).visible);
            /*  for(int j=0;j<lista.get(i).formato.length;j++){
            //System.out.println("Formato: "+lista.get(i).formato[j]);
            }*/
            //System.out.println("FinID");
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
            if(entrada.compareTo(lista.get(cont).ID)==0||entrada.compareTo(lista.get(cont).GRUPO)==0){
            ret=true;
            }       
            cont++;
        }
        
    }
    
    
    return ret;
    }
    
    public int getIndexOfCSS(ArrayList<ListaCSS> lista,String entrada){
    int ret=0;
    int cont=0;
    if(!lista.isEmpty()){
        while(cont<lista.size()){
            if(entrada.compareTo(lista.get(cont).ID)==0||entrada.compareTo(lista.get(cont).GRUPO)==0){
            ret=cont;
            }       
            cont++;
        }
        
    }
    
    
    return ret;
    }
    
    
    public void csslabel(JLabel label,ArrayList<ListaCSS> lista,int index){
    label.setBorder(BorderFactory.createLineBorder(lista.get(index).ColorBorde, lista.get(index).ThicknessBorde, lista.get(index).curveBorde));
    label.setBackground(lista.get(index).fondoelemento);
    
    
    label.setFont(new Font(lista.get(index).letra, Font.BOLD, lista.get(index).tamtext));
    label.setVisible(lista.get(index).visible);
    label.setOpaque(lista.get(index).opaque);
    if(lista.get(index).texto.compareTo("")!=0){
    label.setText(lista.get(index).texto);
    }
    label.setForeground(lista.get(index).colortext);
    
    }
     public void cssimagen(JLabel label,ArrayList<ListaCSS> lista,int index){
    
    
    
    label.setVisible(lista.get(index).visible);

    
    }
    
       public void cssboton(JButton label,ArrayList<ListaCSS> lista,int index){
    label.setBorder(BorderFactory.createLineBorder(lista.get(index).ColorBorde, lista.get(index).ThicknessBorde, lista.get(index).curveBorde));
    label.setBackground(lista.get(index).fondoelemento);
    if(lista.get(index).alineado.compareTo("izquierda")==0){
    label.setFont(new Font(lista.get(index).letra, Font.BOLD+Font.LAYOUT_LEFT_TO_RIGHT, lista.get(index).tamtext));
    }
    else if(lista.get(index).alineado.compareTo("derecha")==0){
    label.setFont(new Font(lista.get(index).letra, Font.BOLD+Font.LAYOUT_RIGHT_TO_LEFT, lista.get(index).tamtext));
    }
    else if(lista.get(index).alineado.compareTo("centrado")==0){
    label.setFont(new Font(lista.get(index).letra, Font.BOLD+Font.LAYOUT_NO_START_CONTEXT, lista.get(index).tamtext));
    }else {
    label.setFont(new Font(lista.get(index).letra, Font.BOLD, lista.get(index).tamtext));
    }
    
    label.setVisible(lista.get(index).visible);
    label.setOpaque(lista.get(index).opaque);
    if(lista.get(index).texto.compareTo("")!=0){
    label.setText(lista.get(index).texto);
    }
    label.setForeground(lista.get(index).colortext);
    
    }
       
           public void csstextarea(JTextArea label,ArrayList<ListaCSS> lista,int index){
    label.setBorder(BorderFactory.createLineBorder(lista.get(index).ColorBorde, lista.get(index).ThicknessBorde, lista.get(index).curveBorde));
    label.setBackground(lista.get(index).fondoelemento);
    
    
    label.setFont(new Font(lista.get(index).letra, Font.BOLD, lista.get(index).tamtext));
    label.setVisible(lista.get(index).visible);
    label.setOpaque(lista.get(index).opaque);
    if(lista.get(index).texto.compareTo("")!=0){
    label.setText(lista.get(index).texto);
    }
    label.setForeground(lista.get(index).colortext);
    
    }
           
                 public void csscajaopcion(JComboBox label,ArrayList<ListaCSS> lista,int index){
    label.setBorder(BorderFactory.createLineBorder(lista.get(index).ColorBorde, lista.get(index).ThicknessBorde, lista.get(index).curveBorde));
    label.setBackground(lista.get(index).fondoelemento);
    
    
    label.setFont(new Font(lista.get(index).letra, Font.BOLD, lista.get(index).tamtext));
    label.setVisible(lista.get(index).visible);
    label.setOpaque(lista.get(index).opaque);
  
    label.setForeground(lista.get(index).colortext);
    
    }
                 
    public void csspanel(JPanel label,ArrayList<ListaCSS> lista,int index){
    label.setBorder(BorderFactory.createLineBorder(lista.get(index).ColorBorde, lista.get(index).ThicknessBorde, lista.get(index).curveBorde));
    label.setBackground(lista.get(index).fondoelemento);
    label.setFont(new Font(lista.get(index).letra, Font.BOLD, lista.get(index).tamtext));
    label.setVisible(lista.get(index).visible);
    label.setOpaque(lista.get(index).opaque);
    if(lista.get(index).alineado.compareTo("izquierda")==0){
    label.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    else if(lista.get(index).alineado.compareTo("derecha")==0){
    label.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }
    else if(lista.get(index).alineado.compareTo("centrado")==0){
    label.setLayout(new FlowLayout(FlowLayout.CENTER));
    }else {
    label.setLayout(new FlowLayout(FlowLayout.LEADING));
    }
    
    
    label.setForeground(lista.get(index).colortext);
    label.repaint();
    }
                        
}
