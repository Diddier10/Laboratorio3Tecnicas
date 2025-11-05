/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author asus
 */
public class AccesorioDTO {
    private String tipo;
    private double precio;

    public AccesorioDTO() {
    }

    public AccesorioDTO(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Accesorio{");
        sb.append("tipo=").append(tipo);
        sb.append(", precio=").append(precio);
        sb.append('}');
        return sb.toString();
    }
    
}
