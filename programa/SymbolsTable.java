import java.util.ArrayList;

/**
 * Clase SymbolsTable, representa la tabla de símbolos que contiene los scopes de las funciones y los bloques de código, así como los símbolos declarados en cada scope.
 * Permite abrir y cerrar scopes, agregar símbolos a los scopes actuales, e imprimir la tabla de símbolos.
 * Cada scope tiene un nombre, una lista de símbolos, una referencia al scope padre y una lista de scopes hijos. Cada símbolo tiene un nombre, categoría, tipo y posición (fila y columna) en el código fuente.
 */
public class SymbolsTable {
    private ArrayList<Scope> funciones;
    private Scope scope_actual;

    /**
     * Constructor de la clase SymbolsTable, inicializa la lista de funciones y el scope actual como null.
     */
    public SymbolsTable() {
        this.funciones = new ArrayList<Scope>();
        this.scope_actual = null;
    }

    /**
     * Abre un nuevo scope para una función.
     * @param nombre El nombre de la función
     */
    public void abrir_scope_funcion(String nombre) {
        Scope nueva_funcion = new Scope(nombre, null);
        funciones.add(nueva_funcion);
        scope_actual = nueva_funcion;
    }

    /**
     * Abre un nuevo scope para un bloque de código.
     * @param nombre El nombre del bloque
     */
    public void abrir_scope(String nombre) {
        if (scope_actual != null) {
            Scope nuevo_bloque = new Scope(nombre, scope_actual);
            scope_actual.getHijos().add(nuevo_bloque);
            scope_actual = nuevo_bloque;
        }
    }

    /**
     * Cierra el scope actual.
     */
    public void cerrar_scope() {
        if (scope_actual != null && scope_actual.getPadre() != null) {
            scope_actual = scope_actual.getPadre();
        } else {
            scope_actual = null;
        }
    }

    /**
     * Agrega un nuevo símbolo al scope actual.
     * @param s El símbolo a agregar
     */
    public void agregar_simbolo(Symbols s) {
        if (scope_actual != null) {
            scope_actual.getSimbolos().add(s);
        }
    }

    /**
     * Imprime la tabla de símbolos.
     * Muestra cada scope con su nombre y los símbolos declarados en ese scope, con su nombre, categoría, tipo y posición (fila y columna).
     */
    public void imprimir_tabla() {
        for (Scope funcion : funciones) {
            imprimir_scope(funcion, 0);
            System.out.println();
        }
    }

    /**
     * Método recursivo para imprimir un scope y sus hijos, con indentación para mostrar la jerarquía de los scopes.
     * @param actual El scope actual a imprimir
     */
    private void imprimir_scope(Scope actual, int nivel) {
        String indent = "  ".repeat(nivel);
        String prefijo = (nivel == 0) ? "Scope: [" : "└── Scope: [";
        System.out.println(indent + prefijo + actual.getNombre() + "]");

        for (Symbols s : actual.getSimbolos()) {
            System.out.println(indent + "  ├── " + s.toString());
        }
        for (Scope hijo : actual.getHijos()) {
            imprimir_scope(hijo, nivel + 1);
        }
    }
}