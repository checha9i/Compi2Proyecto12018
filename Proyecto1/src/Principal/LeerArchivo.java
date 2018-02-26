/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import javax.swing.JTabbedPane;

/**
 *
 * @author chech
 */
public class LeerArchivo {
    
   public String LeerArchivo(String entrada){
       File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
    String contenido="";
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         
       
         archivo = new File (entrada);
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
     

         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
            contenido+=linea+"";
      }catch(Exception e){
         e.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }

      }
return contenido;
   }
   public JTabbedPane pestaña(JTabbedPane salida){
   
       
       
       
       return salida;
   }
   
   }

