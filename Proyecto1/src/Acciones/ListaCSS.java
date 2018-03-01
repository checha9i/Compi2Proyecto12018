/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.BorderFactory;


/**
 *
 * @author Javier
 */
public class ListaCSS {
   public int index;
   public String ID;
   public String GRUPO;
   public String alineado;
   public boolean autoredimension;
   public String DirRedimension;
   public Color  ColorBorde; 
   public int ThicknessBorde;
   public boolean curveBorde;
   public Color colortext;
   public Color fondoelemento;
   public String[] formato;
   public String letra;
   public Boolean opaque;
   public int tamtext;
   public String texto;
   public Boolean visible;
   
    
    public ListaCSS(int index){
    this.index=index;
  this.autoredimension=false;
  this.DirRedimension="Vertical";
    this.ID="";
   this.GRUPO="";
  this.fondoelemento=Color.lightGray;
   this.alineado="";
   this.ColorBorde=Color.black;
   this.ThicknessBorde=1;
   this.curveBorde=false;
   this.colortext=Color.black;
   
   this.letra="Arial";
   this.opaque=true;
   this.tamtext=5;
   this.texto="";
   this.visible=true;
       
}

   


}
