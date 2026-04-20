import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Uso: java Main <archivo_entrada>");
            return;
        }
        Reader reader = new BufferedReader(new FileReader(args[0]));
        Lexer lexer = new Lexer(reader);
        parser p = new parser(lexer);
        try {
            p.parse();
        } catch (Exception e) {
            System.out.println("Error de sintaxis: " + e.getMessage());
            System.exit(1);
        }   
        if (lexer.getErrores() > 0) {
            System.out.println("Entrada invalida!");
            System.exit(1);
        }
        System.out.println("Entrada válida!");
    }
}