package br.ulbra.model;

/**
 *
 * @author troll
 */
public class Categoria {
    private int id;
    private String categoria;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return getCategoria();
    }
}
