/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class VentaDTO {
    private String fecha;
    private double precio;
    private ClienteDTO cliente;           
    private VendedorDTO vendedor;         
    private List<MascotaDTO> mascotas;    
    private List<AccesorioDTO> accesorios;

    public VentaDTO() {
        this.mascotas = new ArrayList<>();
        this.accesorios = new ArrayList<>();
    }

    public VentaDTO(String fecha, double precio, ClienteDTO cliente, VendedorDTO vendedor, 
                    List<MascotaDTO> mascotas, List<AccesorioDTO> accesorios) {
        this.fecha = fecha;
        this.precio = precio;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.mascotas = mascotas != null ? mascotas : new ArrayList<>();
        this.accesorios = accesorios != null ? accesorios : new ArrayList<>();
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public VendedorDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedorDTO vendedor) {
        this.vendedor = vendedor;
    }

    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas != null ? mascotas : new ArrayList<>();
    }

    public List<AccesorioDTO> getAccesorios() {
        return accesorios;
    }

    public void setAccesorios(List<AccesorioDTO> accesorios) {
        this.accesorios = accesorios != null ? accesorios : new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("VentaDTO{");
        sb.append("fecha=").append(fecha);
        sb.append(", precio=").append(precio);
        sb.append(", cliente=").append(cliente != null ? cliente.getNombres() : "null");
        sb.append(", vendedor=").append(vendedor != null ? vendedor.getNombres() : "null");
        sb.append(", mascotas=[");
        for (MascotaDTO mascota : mascotas) {
            sb.append(mascota.getNombre()).append(", ");
        }
        if (!mascotas.isEmpty()) {
            sb.setLength(sb.length() - 2); 
        }
        sb.append("], accesorios=[");
        for (AccesorioDTO accesorio : accesorios) {
            sb.append(accesorio.getTipo()).append(", ");
        }
        if (!accesorios.isEmpty()) {
            sb.setLength(sb.length() - 2); 
        }
        sb.append("]}");
        return sb.toString();
    }
}