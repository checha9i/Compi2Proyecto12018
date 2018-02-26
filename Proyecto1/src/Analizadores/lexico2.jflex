/*----------------------------------------------------------------------------
----------------------------------------- Area de Codigo de Usuario
----------------------------------------------------------------------------*/

//-------------------> Importaciones 
//-------------------> Paquetes 
package Analizadores;
import java_cup.runtime.*;

%%

%{
    //-------------------> Codigo de usuario en sintaxis java
%}


/*----------------------------------------------------------------------------
----------------------------------------- Area de Opciones y Declaraciones
----------------------------------------------------------------------------*/

//-------------------> Directivas
%public
%class LexicoCSS
%cupsym SimbolosCSS
%cup
%char
%column
%full
%ignorecase
%line
%unicode

//-------------------> Expresiones Regulares

digito = [0-9]
entero = {digito}+
decimal = {entero}("."{entero})?
letra = [a-zA-ZÑñ]+
caracter = ['] [^'] [']1
numero = [0-9]+
identificador = {letra}({letra}|{entero}|"_")*
string = "\""~"\""
//-------------------> Estados
%state COMENT_SIMPLE
%state COMENT_MULTI

%%
/*-------------------------------------------------------------------
----------------------------------------- Area de Reglas Lexicas
-------------------------------------------------------------------*/

<YYINITIAL>{

//// SIMBOLOS


"=" {return new Symbol(SimbolosCSS.asignar, yycolumn, yyline, new String(yytext())); }
"(" {return new Symbol(SimbolosCSS.parL, yycolumn, yyline, new String(yytext())); }
")" {return new Symbol(SimbolosCSS.parR, yycolumn, yyline, new String(yytext())); }
"[" {return new Symbol(SimbolosCSS.corchL, yycolumn, yyline, new String(yytext())); }
"]" {return new Symbol(SimbolosCSS.corchR, yycolumn, yyline, new String(yytext())); }
"," {return new Symbol(SimbolosCSS.coma, yycolumn, yyline, new String(yytext())); }
":" { return new Symbol(SimbolosCSS.dosPuntos, yycolumn, yyline, new String(yytext())); }
";" { return new Symbol(SimbolosCSS.puntoComa, yycolumn, yyline, new String(yytext())); }


//// ARITMETICOS

"+" { return new Symbol(SimbolosCSS.mas, yycolumn, yyline, new String(yytext())); }
"-" { return new Symbol(SimbolosCSS.menos, yycolumn, yyline, new String(yytext())); }
"*" { return new Symbol(SimbolosCSS.por, yycolumn, yyline, new String(yytext())); }
"/" { return new Symbol(SimbolosCSS.div, yycolumn, yyline, new String(yytext())); }

//// RESERVADAS

//etiquetas sin atributos css
"grupo" { return new Symbol(SimbolosCSS.grupoe, yycolumn, yyline, new String(yytext())); }
"formato" { return new Symbol(SimbolosCSS.formato, yycolumn, yyline, new String(yytext())); }
"letra" { return new Symbol(SimbolosCSS.letra, yycolumn, yyline, new String(yytext())); }
"tamtex" { return new Symbol(SimbolosCSS.tamtex, yycolumn, yyline, new String(yytext())); }
"tamelemento" { return new Symbol(SimbolosCSS.tamelemento, yycolumn, yyline, new String(yytext())); }
"fondoelemento" { return new Symbol(SimbolosCSS.fondoelemento, yycolumn, yyline, new String(yytext())); }
"selecttextcolor" { return new Symbol(SimbolosCSS.selecttextcolor, yycolumn, yyline, new String(yytext())); }
"colorselect" { return new Symbol(SimbolosCSS.colorselect, yycolumn, yyline, new String(yytext())); }
"idelemento" { return new Symbol(SimbolosCSS.idelemento, yycolumn, yyline, new String(yytext())); }
"mayuscula" { return new Symbol(SimbolosCSS.mayuscula, yycolumn, yyline, new String(yytext())); }
"negrilla" { return new Symbol(SimbolosCSS.negrilla, yycolumn, yyline, new String(yytext())); }
"minuscula" { return new Symbol(SimbolosCSS.minuscula, yycolumn, yyline, new String(yytext())); }
"capital-t" { return new Symbol(SimbolosCSS.capitalt, yycolumn, yyline, new String(yytext())); }
"borde" { return new Symbol(SimbolosCSS.borde, yycolumn, yyline, new String(yytext())); }
"texto" { return new Symbol(SimbolosCSS.texto, yycolumn, yyline, new String(yytext())); }
"visible" { return new Symbol(SimbolosCSS.visible, yycolumn, yyline, new String(yytext())); }
"opaque" { return new Symbol(SimbolosCSS.opaque, yycolumn, yyline, new String(yytext())); }
"colortext" { return new Symbol(SimbolosCSS.colortext, yycolumn, yyline, new String(yytext())); }
"autoredimension" { return new Symbol(SimbolosCSS.autoredimension, yycolumn, yyline, new String(yytext())); }
"alineado" { return new Symbol(SimbolosCSS.alineado, yycolumn, yyline, new String(yytext())); }
"izquierda" { return new Symbol(SimbolosCSS.izquierda, yycolumn, yyline, new String(yytext())); }
"derecha" { return new Symbol(SimbolosCSS.derecha, yycolumn, yyline, new String(yytext())); }
"centrado" { return new Symbol(SimbolosCSS.centrado, yycolumn, yyline, new String(yytext())); }
"justificado" { return new Symbol(SimbolosCSS.justificado, yycolumn, yyline, new String(yytext())); }
"cursiva" { return new Symbol(SimbolosCSS.cursiva, yycolumn, yyline, new String(yytext())); }
"id" { return new Symbol(SimbolosCSS.id, yycolumn, yyline, new String(yytext())); }
"true" { return new Symbol(SimbolosCSS.truebool, yycolumn, yyline, new String(yytext())); }
"false" { return new Symbol(SimbolosCSS.falsebool, yycolumn, yyline, new String(yytext())); }
"vertical" { return new Symbol(SimbolosCSS.vertical, yycolumn, yyline, new String(yytext())); }
"horizontal" { return new Symbol(SimbolosCSS.horizontal, yycolumn, yyline, new String(yytext())); }




//{entero} {return new Symbol(SimbolosCSS.valEntero, yycolumn, yyline, new String(yytext())); }
{decimal} {return new Symbol(SimbolosCSS.valDecimal, yycolumn, yyline, new String(yytext())); }
//{caracter}	{return new Symbol(SimbolosCSS.valCaracter, yycolumn, yyline, new String(yytext())); }
{identificador}	{return new Symbol(SimbolosCSS.identificador, yycolumn, yyline, new String(yytext())); }
{string}        {return new Symbol(SimbolosCSS.stringcad, yycolumn, yyline, new String(yytext()));  }




"//" {yybegin(COMENT_SIMPLE);}
"/*" {yybegin(COMENT_MULTI);}


///// ESPACIOS Y SALTOS DE LINEA

"\r|\n|\r\n" {}
[\t\f] {}
[\r\n] {}
" " {}
[\t] {}
[\r] {}
[\f] {}
[\n] {}

//// ERROR

. { javax.swing.JOptionPane.showMessageDialog(null, "Error Lexico: " + yytext()); }

}

<COMENT_SIMPLE>{
	[\n] { yybegin(YYINITIAL);}
	[^\n] {}
}

<COMENT_MULTI>{
	"*/" {yybegin(YYINITIAL);}
	. {}
}


