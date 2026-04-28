import java.util.ArrayList;

/**
 * Clase Scope, representa el alcance o scope de un bloque de código, como una función, un bloque if, etc.
 * Contiene una lista de símbolos (variables, funciones, etc.) que están declarados dentro de ese scope, así como referencias al scope padre y a los scopes hijos.
 */
public class Scope {
    private String nombre; 
    private ArrayList<Symbols> simbolos;

    private Scope padre;
    private ArrayList<Scope> hijos;

    /**
     * Crea un nuevo scope con el nombre dado y el scope padre asociado.
     * @param nombre El nombre del scope
     * @param padre El scope padre al que pertenece este scope, puede ser null si es el scope global
     */
    public Scope(String nombre, Scope padre) {
        this.nombre = nombre;
        this.simbolos = new ArrayList<Symbols>();
        this.padre = padre;
        this.hijos = new ArrayList<Scope>();
    }

    /**
     * Obtiene el nombre del scope.
     * @return El nombre del scope
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del scope.
     * @param nombre El nombre del scope
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de símbolos del scope.
     * @return La lista de símbolos del scope
     */
    public ArrayList<Symbols> getSimbolos() {
        return simbolos;
    }


    /**
     * Establece la lista de símbolos del scope.
     * @param simbolos La lista de símbolos del scope
     */
    public void setSymbols(ArrayList<Symbols> simbolos) {
        this.simbolos = simbolos;
    }

    /**
     * Obtiene el scope padre.
     * @return El scope padre
     */
    public Scope getPadre() {
        return padre;
    }

    /**
     * Establece el scope padre.
     * @param padre El scope padre
     */
    public void setPadre(Scope padre) {
        this.padre = padre;
    }

    /**
     * Obtiene la lista de scopes hijos.
     * @return La lista de scopes hijos
     */
    public ArrayList<Scope> getHijos() {
        return hijos;
    }

    /**
     * Establece la lista de scopes hijos.
     * @param hijos La lista de scopes hijos
     */
    public void setHijos(ArrayList<Scope> hijos) {
        this.hijos = hijos;
    }
}