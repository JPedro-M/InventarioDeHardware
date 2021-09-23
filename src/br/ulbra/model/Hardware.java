package br.ulbra.model;

/**
 *
 * @author troll
 */
public class Hardware {
    private int id;
    private String hardware;
    private String modelo;
    private String estado;
    private String data;
    private double preco;
    private String caracteristica;
    private Categoria categoria;
    private Marca marca;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHardware() {
        return hardware;
    }

    public void setHardware(String hardware) {
        this.hardware = hardware;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    @Override
    public String toString() {
        return "Hardware{" + "id=" + id + ", hardware=" + hardware + ", modelo=" + modelo + ", estado=" + estado + ", data=" + data + ", preco=" + preco + ", caracteristica=" + caracteristica + ", categoria=" + categoria + ", marca=" + marca + '}';
    }
    
}
