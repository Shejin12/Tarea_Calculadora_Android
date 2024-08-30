package com.example.calculadora;
import java_cup.runtime.*;
import android.util.Log; 


%%
%class Lexer
%cup
%line
%column
%public

Suma =      "+"
Resta =     "-"
Multi =     "*"
Divisn =    "/"
Par_Opn =   "("
Par_Cls =   ")"

digito = [0-9]
Numero = {digito}+
Decimal = {Numero}"."{Numero}
Espacio = \s*(\r\n|\r|\n)

%{

    private void escribirLog(){
        Log.d("Lexer", "Lexema: " + yytext() + " Linea: "+yyline + " Columna: " + yycolumn);
    }

    private Symbol newSymbol(int tipo, Object contenido){
        escribirLog();
        return new Symbol(tipo, yyline+1, yycolumn +1, contenido);
    }

    private Symbol newSymbol(int tipo){
        escribirLog();
        return new Symbol(tipo, yyline+1, yycolumn+1);
    }


%}

%%

{Numero}   {return newSymbol(sym.NUMEROS, Double.parseDouble(yytext())); }
{Decimal} {return newSymbol(sym.FLOTANTES, Double.parseDouble(yytext()));}
{Suma}   { return newSymbol(sym.SUMA); }
{Resta}  { return newSymbol(sym.RESTA); }
{Multi}  { return newSymbol(sym.MULTI); }
{Divisn} { return newSymbol(sym.DIVISN);}
{Par_Opn} { return newSymbol(sym.PAROPN);}
{Par_Cls} { return newSymbol(sym.PARCLS);}
{Espacio} {}

[^]     {Log.d("ERRLEX", "No se reconoce " + yytext() + " en linea " + yyline + " columna " + yycolumn);}
<<EOF>> { return newSymbol(sym.EOF);}