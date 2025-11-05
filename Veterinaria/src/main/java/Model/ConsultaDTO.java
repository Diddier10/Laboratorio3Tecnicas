/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author asus
 */
public class ConsultaDTO {
    private String fecha;
    private String sintomas;
    private String tratamiento;

    public ConsultaDTO() {
    }

    public ConsultaDTO(String fecha, String sintomas, String tratamiento) {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
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
