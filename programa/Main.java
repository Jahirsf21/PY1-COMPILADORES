import java.io.*;
import java_cup.runtime.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Uso: java Main <archivo_entrada>");
            return;
        }
        String archivo_tokens = "resultado/archivo_tokens.txt";
        try (
            Reader reader = new BufferedReader(new FileReader(args[0]));
            PrintWriter writer = new PrintWriter(new FileWriter(archivo_tokens))
        ) {
            Lexer lexer = new Lexer(reader);
            Symbol token;

            while ((token = lexer.next_token()).sym != sym.EOF) {
                String nombre_token = sym.terminalNames[token.sym];
                String lexema = (token.value != null) ? token.value.toString() : "";
                writer.println("Token: " + nombre_token + ", Lexema: " + lexema);
            }
            
            if (lexer.getErrores() > 0) {
                System.out.println("Entrada invalida");   
            }
            System.out.println("Entrada válida");

        } catch (IOException e) {
            System.err.println("Error al leer el archivo de entrada o escribir el de salida.");
            e.printStackTrace();
        }
    }
}