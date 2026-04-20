import java_cup.runtime.Symbol;
%%

%class Lexer
%unicode
%cup
%line
%column

%%

[0-9]+        { return new java_cup.runtime.Symbol(sym.NUMERO, yytext()); }
[a-zA-Z]+     { return new java_cup.runtime.Symbol(sym.LETRA, yytext()); }
[ \t\n\r]+    { /* ignorar espacios */ }

.             { System.out.println("Error léxico: " + yytext()); }