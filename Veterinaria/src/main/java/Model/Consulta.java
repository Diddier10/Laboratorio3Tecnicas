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
public class Consulta {
    private Date fecha;
    private String sintomas;
    private String tratamiento;

    public Consulta() {
    }

    public Consulta(Date fecha, String sintomas, String tratamiento) {
        this.fecha = fecha;
        this.sintomas = sintomas;
        this.tratamiento = tratamiento;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getSintomas() {
        return sintomas;
    }

    public void setSintomas(String sintomas) {
        this.sintomas = sintomas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consulta{");
        sb.append("fecha=").append(fecha);
        sb.append(", sintomas=").append(sintomas);
        sb.append(", tratamiento=").append(tratamiento);
        sb.append('}');
        return sb.toString();
    }
    
    
}
