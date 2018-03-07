/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Analizadores.Nodo;
import Acciones.Valor;
import java.util.HashMap;
import java.util.Hashtable;

/**
 *
 * @author Javier
 */
public class EjecutarCJS {
    
   HashMap<String, Valor> simbolos= new HashMap<String, Valor>();
   
   public void EjecutarCJS(Nodo nodoactual, HashMap<String,Valor> simbolos){
       switch(nodoactual.valor){
           
           case "Ambito":
               
               for (Nodo hijo : nodoactual.hijos) {
                   this.EjecutarCJS(hijo, simbolos);
               }
               break;
               
           case "VARIABLE":
               String var=nodoactual.hijos.get(0).valor;
               String valor="";
               
               if(contadorhijos(nodoactual.hijos.get(1))>1){
                   valor=Operacion(nodoactual.hijos.get(1));
                   //logica
               }else if(contadorhijos(nodoactual.hijos.get(1).hijos.get(0))>1){
                   //Relacional
                   valor=Operacion(nodoactual.hijos.get(1).hijos.get(0));
               }else if(contadorhijos(nodoactual.hijos.get(1).hijos.get(0).hijos.get(0))>1){
                   //Aritmetica
                   valor=Operacion(nodoactual.hijos.get(1).hijos.get(0).hijos.get(0));
               }else{
                   //Valor
                   valor=Operacion(nodoactual.hijos.get(1).hijos.get(0).hijos.get(0).hijos.get(0));
               }
               
               break;
               
               
      
       }
       
   }

    public String Operacion(Nodo actual){
        String valor="";
        String Operador="";
        switch(actual.hijos.get(1).valor){
            case "MAS":
                
                break;
            case "MENOS":
                
                break;
            
        }
       
        
        
    return valor;
    }
    
    public int contadorhijos(Nodo actual){
        int cont=0;
        for(Nodo hijo: actual.hijos){
            cont++;
        }
        return cont;
    }
    
}


