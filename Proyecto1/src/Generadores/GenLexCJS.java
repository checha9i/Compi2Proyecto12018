package Generadores;

import java.io.File;

/**
 *
 * @author Joaquin
 */
public class GenLexCJS 
{
    
    public static void main(String[] args) 
    {
        String path="src\\Analizadores\\lexico3.jflex";
        generarLexer(path);
    }    
    public static void generarLexer(String path)
    {
        File file=new File(path);
        jflex.Main.generate(file);
    } 
    
}
