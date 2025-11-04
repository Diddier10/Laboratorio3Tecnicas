/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author asus
 */
public class VentaDTO {
    private String fecha;
    private double valorVenta;
    

    public VentaDTO() {
    }

    public VentaDTO(String fecha, double valorVenta) {
        this.fecha = fecha;
        this.valorVenta = valorVenta;
    }

    public double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(double valorVenta) {
        this.valorVenta = valorVenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Venta{");
        sb.append("fecha=").append(fecha);
        sb.append(", valorVenta=").append(valorVenta);
        sb.append('}');
        return sb.toString();
    }
    
    
}
