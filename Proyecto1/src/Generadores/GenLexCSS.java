package Generadores;

import java.io.File;

/**
 *
 * @author Joaquin
 */
public class GenLexCSS 
{
    
    public static void main(String[] args) 
    {
        String path="src\\Analizadores\\lexico2.jflex";
        generarLexer(path);
    }    
    public static void generarLexer(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
    
}
