import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Reader reader = new InputStreamReader(System.in);
        Lexer lexer = new Lexer(reader);
        parser p = new parser(lexer);

        p.parse();

        System.out.println("Entrada válida!");
    }
}