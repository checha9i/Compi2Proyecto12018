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
%class Lexico
%cupsym Simbolos
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

"=" {return new Symbol(Simbolos.asignar, yycolumn, yyline, new String(yytext())); }
"(" {return new Symbol(Simbolos.parL, yycolumn, yyline, new String(yytext())); }
")" {return new Symbol(Simbolos.parR, yycolumn, yyline, new String(yytext())); }

";" { return new Symbol(Simbolos.puntoComa, yycolumn, yyline, new String(yytext())); }

//// ARITMETICOS

"+" { return new Symbol(Simbolos.mas, yycolumn, yyline, new String(yytext())); }
"-" { return new Symbol(Simbolos.menos, yycolumn, yyline, new String(yytext())); }
"*" { return new Symbol(Simbolos.por, yycolumn, yyline, new String(yytext())); }
"/" { return new Symbol(Simbolos.div, yycolumn, yyline, new String(yytext())); }

//// lOGICOS


//// RELACIONALES

">" { return new Symbol(Simbolos.mayor, yycolumn, yyline, new String(yytext())); }
"<" { return new Symbol(Simbolos.menor, yycolumn, yyline, new String(yytext())); }


//// RESERVADAS

//etiquetas sin atributos css
"chtml" {System.out.println("chtml"); return new Symbol(Simbolos.chtml, yycolumn, yyline, new String(yytext())); }
"fin-chtml" { return new Symbol(Simbolos.finchtml, yycolumn, yyline, new String(yytext())); }
"encabezado" {System.out.println("encabezado"); return new Symbol(Simbolos.encabezado, yycolumn, yyline, new String(yytext())); }
"fin-encabezado" { return new Symbol(Simbolos.finencabezado, yycolumn, yyline, new String(yytext())); }
"cuerpo" {System.out.println("Cuerpo"); return new Symbol(Simbolos.cuerpo, yycolumn, yyline, new String(yytext())); }
"fin-cuerpo" { return new Symbol(Simbolos.fincuerpo, yycolumn, yyline, new String(yytext())); }
"titulo" { return new Symbol(Simbolos.titulo, yycolumn, yyline, new String(yytext())); }
"fin-titulo" { return new Symbol(Simbolos.fintitulo, yycolumn, yyline, new String(yytext())); }
"salto-fin" { return new Symbol(Simbolos.saltofin, yycolumn, yyline, new String(yytext())); }

//etiquetas con atributos

"ccss" { return new Symbol(Simbolos.ccss, yycolumn, yyline, new String(yytext())); }
"fin-ccss" { return new Symbol(Simbolos.finccss, yycolumn, yyline, new String(yytext())); }
"cjs" { return new Symbol(Simbolos.cjs, yycolumn, yyline, new String(yytext())); }
"fin-cjs" { return new Symbol(Simbolos.fincjs, yycolumn, yyline, new String(yytext())); }
"panel" { return new Symbol(Simbolos.panel, yycolumn, yyline, new String(yytext())); }
"fin-panel" { return new Symbol(Simbolos.finpanel, yycolumn, yyline, new String(yytext())); }
"texto" { return new Symbol(Simbolos.texto, yycolumn, yyline, new String(yytext())); }
"fin-texto" { return new Symbol(Simbolos.fintexto, yycolumn, yyline, new String(yytext())); }
"imagen" { return new Symbol(Simbolos.imagen, yycolumn, yyline, new String(yytext())); }
"fin-imagen" { return new Symbol(Simbolos.finimagen, yycolumn, yyline, new String(yytext())); }
"boton" { return new Symbol(Simbolos.boton, yycolumn, yyline, new String(yytext())); }
"fin-boton" { return new Symbol(Simbolos.finboton, yycolumn, yyline, new String(yytext())); }
"enlace" { return new Symbol(Simbolos.enlace, yycolumn, yyline, new String(yytext())); }
"fin-enlace" { return new Symbol(Simbolos.finenlace, yycolumn, yyline, new String(yytext())); }
"tabla" { return new Symbol(Simbolos.tabla, yycolumn, yyline, new String(yytext())); }
"fin-tabla" { return new Symbol(Simbolos.fintabla, yycolumn, yyline, new String(yytext())); }
"texto_a" { return new Symbol(Simbolos.textoa, yycolumn, yyline, new String(yytext())); }
"fin-texto_a" { return new Symbol(Simbolos.fintextoa, yycolumn, yyline, new String(yytext())); }
"caja_texto" { return new Symbol(Simbolos.cajatexto, yycolumn, yyline, new String(yytext())); }
"fin-caja_texto" { return new Symbol(Simbolos.fincajatexto, yycolumn, yyline, new String(yytext())); }
"spinner" { return new Symbol(Simbolos.spinner, yycolumn, yyline, new String(yytext())); }
"fin-spinner" { return new Symbol(Simbolos.finspinner, yycolumn, yyline, new String(yytext())); }
"caja" { return new Symbol(Simbolos.caja, yycolumn, yyline, new String(yytext())); }
"fin-caja" { return new Symbol(Simbolos.fincaja, yycolumn, yyline, new String(yytext())); }
"fil_t" { return new Symbol(Simbolos.fila, yycolumn, yyline, new String(yytext())); }
"fin-fil_t" { return new Symbol(Simbolos.finfila, yycolumn, yyline, new String(yytext())); }
"ct" { return new Symbol(Simbolos.ct, yycolumn, yyline, new String(yytext())); }
"fin-ct" { return new Symbol(Simbolos.finct, yycolumn, yyline, new String(yytext())); }
"cb" { return new Symbol(Simbolos.cb, yycolumn, yyline, new String(yytext())); }
"fin-cb" { return new Symbol(Simbolos.fincb, yycolumn, yyline, new String(yytext())); }
"opcion" { return new Symbol(Simbolos.opcion, yycolumn, yyline, new String(yytext())); }
"fin-opcion" { return new Symbol(Simbolos.finopcion, yycolumn, yyline, new String(yytext())); }


//Parametros
"ruta" { return new Symbol(Simbolos.ruta, yycolumn, yyline, new String(yytext())); }
"click" { return new Symbol(Simbolos.click, yycolumn, yyline, new String(yytext())); }
"id" { return new Symbol(Simbolos.id, yycolumn, yyline, new String(yytext())); }
"valor" { return new Symbol(Simbolos.valor, yycolumn, yyline, new String(yytext())); }
"alto" { return new Symbol(Simbolos.alto, yycolumn, yyline, new String(yytext())); }
"ancho" { return new Symbol(Simbolos.ancho, yycolumn, yyline, new String(yytext())); }
"alineado" { return new Symbol(Simbolos.alineado, yycolumn, yyline, new String(yytext())); }
"grupo" { return new Symbol(Simbolos.grupo, yycolumn, yyline, new String(yytext())); }
"izquierda" { return new Symbol(Simbolos.izquierda, yycolumn, yyline, new String(yytext())); }
"derecha" { return new Symbol(Simbolos.derecha, yycolumn, yyline, new String(yytext())); }
"centrado" { return new Symbol(Simbolos.centrado, yycolumn, yyline, new String(yytext())); }



//{entero} {return new Symbol(Simbolos.valEntero, yycolumn, yyline, new String(yytext())); }
{decimal} {return new Symbol(Simbolos.valDecimal, yycolumn, yyline, new String(yytext())); }
//{caracter}	{return new Symbol(Simbolos.valCaracter, yycolumn, yyline, new String(yytext())); }
{identificador}	{return new Symbol(Simbolos.identificador, yycolumn, yyline, new String(yytext())); }
{string}        {return new Symbol(Simbolos.stringcad, yycolumn, yyline, new String(yytext()));  }

"<//" {yybegin(COMENT_SIMPLE);}
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
	[//>] { yybegin(YYINITIAL);}
	[^\n] {}
}

<COMENT_MULTI>{
	"*/" {yybegin(YYINITIAL);}
	. {}
}


