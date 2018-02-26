package Generadores;

/**
 *
 * @author Joaquin
 */
public class GenSintacCSS 
{
    
    public static void main(String[] args)
    {
        String opciones[] = new String[7]; 
        
        //Seleccionamos la opción de dirección de destino
        opciones[0] = "-destdir";
        
        //Le damos la dirección, Carpeta donde se va a generar el parser.java & el simbolosxxx.java
        opciones[1] = "src\\Analizadores\\";
        
        //Seleccionamos la opción de nombre de archivo simbolos
        opciones[2] = "-symbols"; 
        
         //Le damos el nombre que queremos que tenga
        opciones[3] = "SimbolosCSS";
        
        //Seleccionamos la opcion de clase parser
        opciones[4] = "-parser";         
        //Le damos nombre a esa clase
        opciones[5] = "SintacticoCSS"; 
        
        //Le decimos donde se encuentra el archivo .cup 
        opciones[6] = "src\\Analizadores\\sintactico2.cup"; 
        try 
        {
            java_cup.Main.main(opciones);
        } 
        catch (Exception ex){System.out.print(ex);}        
    }
    
}
