/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Acciones;

import Analizadores.Nodo;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class ListaCSS {
    public int id;
    public String ID_Grupo;
    public ArrayList<String> CSS;
    public ArrayList<ListaCSS> lista;
    
    public ListaCSS()
    {        
        
        
    }
    
    public ListaCSS(int val,String CSS)
    {
        this.id = val;
        this.ID_Grupo = ID_Grupo;
        this.CSS = new ArrayList<String>();
        this.lista = new ArrayList<ListaCSS>();
    
    }
    


}
