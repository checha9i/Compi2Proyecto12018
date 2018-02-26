/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import java.util.ArrayList;


/**
 *
 * @author Javier
 */
public class ListaCSS {
   public int index;
   public String ID;
   public String GRUPO;
   
   public String alineado;
   public String autoredimension;
   public String borde; 
   public String colorselect;
   public String colortext;
   public String fondoelemento;
   public String formato;
   public String idelemento;
   public String letra;
   public Boolean opaque;
   public int tamtext;
   public int[] tamelemento;
   public String texto;
   public Boolean visible;
   
    
    public ListaCSS(int index){
    this.index=index;
   this.ID="";
   this.GRUPO="";
   
   this.alineado="";
   this.autoredimension="";
   this.borde=""; 
   this.colorselect="";
   this.colortext="";
   this.fondoelemento="";
   this.formato="";
   this.idelemento="";
   this.letra="";
   this.opaque=false;
   this.tamtext=5;
   this.tamelemento[0]=5;
   this.tamelemento[1]=5;
   this.texto="";
   this.visible=true;
        
}

    ListaCSS(ArrayList<ListaCSS> lista) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
