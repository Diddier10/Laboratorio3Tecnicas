/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.VentaDTO;
import Negocio.VentaNegocio;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class VentaControlador {

    VentaNegocio ventaNegocio = new VentaNegocio();

    public void almacenarVenta(String fecha,double ){
        //Matches verifica que el sting contenga solo los caracteres indicados,
        //por ejemplo letras, números o espacios en blanco
        if((!nombre.matches("[a-zA-Z ]*")) || (!raza.matches("[a-zA-Z]*"))|| 
            (!tipo.matches("[a-zA-Z]*")) ){
            datosErroneos("El nombre y la raza sólo pueden contener letras");
            return;
        }
        if (Character.toUpperCase(genero) != 'M' && Character.toUpperCase(genero) != 'F') {
            datosErroneos("Marcar F o M");
        }
        if(!id.matches("[0-9]*")){
            datosErroneos("El documento debe ser un número sin puntos ni comas");
            return;
        }

        if (nombre.equals("") || raza.equals("") || tipo.equals("")
                || id.equals("") || fechaIngreso.equals("") || lugarOrigen.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos de texto obligatorios de la mascota. Inténtelo de nuevo.");
            return;
        }else{
            MascotaDTO mascota = new MascotaDTO(nombre,raza,edad,tipo,id,peso,fechaIngreso,
                                  lugarOrigen,genero,precio,estadoAdopcion);
            if(mascotaNegocio.almacenarMascota(mascota)==true){
                operacionExitosa("Se ha almacenado la mascota");
            }else{
                if(JOptionPane.showConfirmDialog(null, "La mascota ya se encuentra registrada, ¿desea"
                                + " actualizar la información con los datos ingresados?", "Mascota existente",
                        JOptionPane.YES_NO_OPTION) == 0){
                    actualizarMascota(nombre,raza,edad,tipo,id,peso,fechaIngreso,
                                  lugarOrigen,genero,precio,estadoAdopcion);
                }
            }
            return;
        }
    }
     
    public void actualizarMascota(String nombre,String raza,int edad,String tipo,String id,double peso,String fechaIngreso,
                                  String lugarOrigen,char genero,double precio,boolean estadoAdopcion){
        //Matches verifica que el sting contenga solo los caracteres indicados,
        //por ejemplo letras, números o espacios en blanco
        if((!nombre.matches("[a-zA-Z ]*")) || (!raza.matches("[a-zA-Z]*"))|| 
            (!tipo.matches("[a-zA-Z]*")) ){
            datosErroneos("El nombre y la raza sólo pueden contener letras");
            return;
        }
        if (Character.toUpperCase(genero) != 'M' && Character.toUpperCase(genero) != 'F') {
            datosErroneos(" El genero se debe marcar F o M");
        }
        if(!id.matches("[0-9]*")){
            datosErroneos("El documento debe ser un número sin puntos ni comas");
            return;
        }

        if (nombre.equals("") || raza.equals("") || tipo.equals("")
                || id.equals("") || fechaIngreso.equals("") || lugarOrigen.equals("")) {
            JOptionPane.showMessageDialog(null, "Debe completar todos los campos de texto obligatorios de la mascota. Inténtelo de nuevo.");
            return;
        }else {
            MascotaDTO mascota = new MascotaDTO(nombre,raza,edad,tipo,id,peso,fechaIngreso,
                                  lugarOrigen,genero,precio,estadoAdopcion);
            if (mascotaNegocio.actualizarMascota(mascota)) {
                operacionExitosa("Se ha actualizado la mascota");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar la mascota\n"
                        + "Por favor verifique si la mascota se encuentra registrado");
            }
        }
    }
    
    public void operacionExitosa(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void datosErroneos(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
    }

}