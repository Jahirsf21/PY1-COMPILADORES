import java.io.*;
import java_cup.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Uso: java Main <archivo_entrada>");
            return;
        }
        Reader reader = new BufferedReader(new FileReader(args[0]));
        Lexer lexer = new Lexer(reader);

        while (lexer.next_token().sym != sym.EOF) {}

        if (lexer.getErrores() > 0) {
            System.out.println("Entrada inválida!");
        } else {
            System.out.println("Entrada válida!");
        }
    }
}