import java_cup.runtime.Symbol;
%%

%class Lexer
%unicode
%cup
%line
%column
%{
    private int errores = 0;
    public int getErrores() { return errores; }
%}

%%

[0-9]+        { return new java_cup.runtime.Symbol(sym.NUMERO, yytext()); }
[a-z]+     { return new java_cup.runtime.Symbol(sym.LETRA, yytext()); }
[ \t\n\r]+    { /* ignorar espacios */ }

.             { errores++; System.out.println("Error léxico: " + yytext()); }