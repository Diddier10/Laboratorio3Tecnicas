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
public class ClienteDTO {
    private String identificacion;
    private String nombres;
    private String direccionContacto;
    private String numeroContacto;
    private List<MascotaDTO> mascotas;  

    
    public ClienteDTO() {
        this.mascotas = new ArrayList<>(); 
    }

    public ClienteDTO(String identificacion, String nombres, String direccionContacto, String numeroContacto) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.direccionContacto = direccionContacto;
        this.numeroContacto = numeroContacto;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    public void setNumeroContacto(String numeroContactos) {
        this.numeroContacto = numeroContactos;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccionContacto() {
        return direccionContacto;
    }

    public void setDireccionContacto(String direccionContacto) {
        this.direccionContacto = direccionContacto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("identificacion=").append(identificacion);
        sb.append(", nombres=").append(nombres);
        sb.append(", direccionContacto=").append(direccionContacto);
        sb.append(", numeroContactos=").append(numeroContacto);
        sb.append('}');
        return sb.toString();
    }

    public List<MascotaDTO> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<MascotaDTO> mascotas) {
        this.mascotas = mascotas;
    }
    
}
