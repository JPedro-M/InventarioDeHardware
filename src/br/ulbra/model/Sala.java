package br.ulbra.model;

/**
 *
 * @author troll
 */
public class Sala {
    private int id;
    private String sala;
    private String andar;
    private String local;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getAndar() {
        return andar;
    }

    public void setAndar(String andar) {
        this.andar = andar;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "Sala{" + "id=" + id + ", sala=" + sala + ", andar=" + andar + ", local=" + local + '}';
    }
}
