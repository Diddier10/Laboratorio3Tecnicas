/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author asus
 */
public class MascotaDTO {
    private String nombre;
    private String raza;
    private int edad;
    private String tipo;
    private String id;
    private double peso;
    private String fechaIngreso;
    private String lugarOrigen;
    private char genero;
    private double precio;
    private boolean estadoAdopcion;

    public MascotaDTO() {
    }

    public MascotaDTO(String nombre, String raza, int edad, String tipo, String id, double peso, String fechaIngreso, String lugarOrigen, char genero, double precio, boolean estadoAdopcion) {
        this.nombre = nombre;
        this.raza = raza;
        this.edad = edad;
        this.tipo = tipo;
        this.id = id;
        this.peso = peso;
        this.fechaIngreso = fechaIngreso;
        this.lugarOrigen = lugarOrigen;
        this.genero = genero;
        this.precio = precio;
        this.estadoAdopcion = estadoAdopcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getLugarOrigen() {
        return lugarOrigen;
    }

    public void setLugarOrigen(String lugarOrigen) {
        this.lugarOrigen = lugarOrigen;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstadoAdopcion() {
        return estadoAdopcion;
    }

    public void setEstadoAdopcion(boolean estadoAdopcion) {
        this.estadoAdopcion = estadoAdopcion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MascotaDTO{");
        sb.append("nombre=").append(nombre);
        sb.append(", raza=").append(raza);
        sb.append(", edad=").append(edad);
        sb.append(", tipo=").append(tipo);
        sb.append(", id=").append(id);
        sb.append(", peso=").append(peso);
        sb.append(", fechaIngreso=").append(fechaIngreso);
        sb.append(", lugarOrigen=").append(lugarOrigen);
        sb.append(", genero=").append(genero);
        sb.append(", precio=").append(precio);
        sb.append(", estadoAdopcion=").append(estadoAdopcion);
        sb.append('}');
        return sb.toString();
    }
  
    
    
}
