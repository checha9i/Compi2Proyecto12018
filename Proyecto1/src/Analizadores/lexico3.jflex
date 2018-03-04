/*
* Area de imports
**/

package Analizadores;
import java_cup.sym;
import java_cup.runtime.*;
%%

%{ //Codigo de Java
	String cadena = "";
%}

//////////// Expresiones regulares ///////////////////

digito = [0-9]
entero = {digito}+
decimal = {entero}"."{entero}
letra = [a-zA-ZÑñ]+
caracter = ['] [^'] [']
identificador = {letra}({letra}|{digito}|"_")*

////////// Configuraciones ////////////////////////
%class LexicoCJS
%cup
%public
%unicode
%line
%column
%char
%ignorecase
%state CADENA COMENTARIO COMENTARIO_MULTI

%%

/////////// Reservadas /////////////////////////////

<YYINITIAL>{

//// SIMBOLOS

"=" {return new Symbol(SimbolosCJS.asignar, yycolumn, yyline, new String(yytext())); }
"(" {return new Symbol(SimbolosCJS.parL, yycolumn, yyline, new String(yytext())); }
")" {return new Symbol(SimbolosCJS.parR, yycolumn, yyline, new String(yytext())); }
"[" {return new Symbol(SimbolosCJS.corchL, yycolumn, yyline, new String(yytext())); }
"]" {return new Symbol(SimbolosCJS.corchR, yycolumn, yyline, new String(yytext())); }
"{" {return new Symbol(SimbolosCJS.llaveL, yycolumn, yyline, new String(yytext())); }
"}" {return new Symbol(SimbolosCJS.llaveR, yycolumn, yyline, new String(yytext())); }
"," {return new Symbol(SimbolosCJS.coma, yycolumn, yyline, new String(yytext())); }
":" { return new Symbol(SimbolosCJS.dosPuntos, yycolumn, yyline, new String(yytext())); }
"." { return new Symbol(SimbolosCJS.punto, yycolumn, yyline, new String(yytext())); }
";" { return new Symbol(SimbolosCJS.puntoComa, yycolumn, yyline, new String(yytext())); }

//// ARITMETICOS

"+" { return new Symbol(SimbolosCJS.mas, yycolumn, yyline, new String(yytext())); }
"-" { return new Symbol(SimbolosCJS.menos, yycolumn, yyline, new String(yytext())); }
"*" { return new Symbol(SimbolosCJS.por, yycolumn, yyline, new String(yytext())); }
"/" { return new Symbol(SimbolosCJS.div, yycolumn, yyline, new String(yytext())); }
"^" { return new Symbol(SimbolosCJS.potencia, yycolumn, yyline, new String(yytext())); }

//// lOGICOS

"||" { return new Symbol(SimbolosCJS.or, yycolumn, yyline, new String(yytext())); }
"&&" { return new Symbol(SimbolosCJS.and, yycolumn, yyline, new String(yytext())); }
"&|" { return new Symbol(SimbolosCJS.xor, yycolumn, yyline, new String(yytext())); }
"!" { return new Symbol(SimbolosCJS.not, yycolumn, yyline, new String(yytext())); }

//// RELACIONALES

">" { return new Symbol(SimbolosCJS.mayor, yycolumn, yyline, new String(yytext())); }
"<" { return new Symbol(SimbolosCJS.menor, yycolumn, yyline, new String(yytext())); }
">=" { return new Symbol(SimbolosCJS.mayorIgual, yycolumn, yyline, new String(yytext())); }
"<=" { return new Symbol(SimbolosCJS.menorIgual, yycolumn, yyline, new String(yytext())); }
"==" { return new Symbol(SimbolosCJS.igual, yycolumn, yyline, new String(yytext())); }
"!=" { return new Symbol(SimbolosCJS.distinto, yycolumn, yyline, new String(yytext())); }

//// CARECTERES ESPECIALES

"++" { return new Symbol(SimbolosCJS.aumento, yycolumn, yyline, new String(yytext())); }
"--" { return new Symbol(SimbolosCJS.disminucion, yycolumn, yyline, new String(yytext())); }
"verdadero" { return new Symbol(SimbolosCJS.verdadero, yycolumn, yyline, new String(yytext())); }
"falso" { return new Symbol(SimbolosCJS.falso, yycolumn, yyline, new String(yytext())); }

//// RESERVADAS

"DimV" { return new Symbol(SimbolosCJS.var, yycolumn, yyline, new String(yytext())); }
"retornar" { return new Symbol(SimbolosCJS.retornar, yycolumn, yyline, new String(yytext())); }
"mensaje" { return new Symbol(SimbolosCJS.mensaje, yycolumn, yyline, new String(yytext())); }
"documento" { return new Symbol(SimbolosCJS.documento, yycolumn, yyline, new String(yytext())); }
"obtener" { return new Symbol(SimbolosCJS.obtener, yycolumn, yyline, new String(yytext())); }
"setelemento" { return new Symbol(SimbolosCJS.setelemento, yycolumn, yyline, new String(yytext())); }
"observador" { return new Symbol(SimbolosCJS.observador, yycolumn, yyline, new String(yytext())); }


"si" { return new Symbol(SimbolosCJS.si, yycolumn, yyline, new String(yytext())); }
"sino" { return new Symbol(SimbolosCJS.sino, yycolumn, yyline, new String(yytext())); }
"selecciona" { return new Symbol(SimbolosCJS.seleccion, yycolumn, yyline, new String(yytext())); }
"caso" { return new Symbol(SimbolosCJS.caso, yycolumn, yyline, new String(yytext())); }
"defecto" { return new Symbol(SimbolosCJS.defecto, yycolumn, yyline, new String(yytext())); }

"para" { return new Symbol(SimbolosCJS.para, yycolumn, yyline, new String(yytext())); }
"mientras" { return new Symbol(SimbolosCJS.mientras, yycolumn, yyline, new String(yytext())); }
"hacer" { return new Symbol(SimbolosCJS.hacer, yycolumn, yyline, new String(yytext())); }
"detener" { return new Symbol(SimbolosCJS.terminar, yycolumn, yyline, new String(yytext())); }

"funcion" { return new Symbol(SimbolosCJS.funcion, yycolumn, yyline, new String(yytext())); }
"imprimir" { return new Symbol(SimbolosCJS.imprimir, yycolumn, yyline, new String(yytext())); }


{entero} {return new Symbol(SimbolosCJS.valEntero, yycolumn, yyline, new String(yytext())); }
{decimal} {return new Symbol(SimbolosCJS.valDecimal, yycolumn, yyline, new String(yytext())); }
{caracter}	{return new Symbol(SimbolosCJS.valCaracter, yycolumn, yyline, new String(yytext())); }
{identificador}	{return new Symbol(SimbolosCJS.identificador, yycolumn, yyline, new String(yytext())); }

[\"] {yybegin(CADENA);}
"'" {yybegin(COMENTARIO);}
"'/" {yybegin(COMENTARIO_MULTI);}

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

<COMENTARIO>{
	[\n] { yybegin(YYINITIAL);}
	[^\n] {}
}

<COMENTARIO_MULTI>{
	"'" {yybegin(YYINITIAL);}
	. {}
}

<CADENA>{
[\"] 	{ 	String temporal = cadena;
			cadena = "";
            yybegin(YYINITIAL);
            return new Symbol(SimbolosCJS.valCadena, yycolumn, yyline, temporal); 
        }
[^\"] { cadena+=yytext(); }
}