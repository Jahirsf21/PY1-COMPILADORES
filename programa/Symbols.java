public class Symbols {
    private String nombre;
    private String categoria;
    private String tipo;
    private int fila;
    private int columna;

    public Symbols(String nombre, String categoria, String tipo, int fila, int columna) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo = tipo;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getTipo() {
        return tipo;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }


    @Override
    public String toString() {
        return String.format("  %-20s %-12s %-10s %-8d %d", nombre, categoria, tipo, fila, columna);
    } 
}