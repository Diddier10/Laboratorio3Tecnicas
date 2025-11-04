/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.ClienteDTO;
import Negocio.ClienteNegocio;
import View.TablaClientes;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class ClienteControlador {
    ClienteNegocio personaNegocio = new ClienteNegocio();

    public void almacenarCliente(String identificacion, String nombres, String direccion, String numero){
        //Matches verifica que el sting contenga solo los caracteres indicados,
        //por ejemplo letras, números o espacios en blanco
        if((!nombres.matches("[a-zA-Z ]*")) || (!direccion.matches("[a-zA-Z]*")) ){
            datosErroneos("El nombre y el apellido sólo pueden contener letras");
            return;
        }
        if(!identificacion.matches("[0-9]*")){
            datosErroneos("El documento debe ser un número sin puntos ni comas");
            return;
        }

        if(identificacion.equals("") || nombres.equals("")|| direccion.equals("")|| numero.equals("")){
            JOptionPane.showMessageDialog(null,"Debe de completar todos los campos para poder almacenar un estudiante, intentelo de nuevo.");
            return;
        }else{
            ClienteDTO persona = new ClienteDTO(identificacion,nombres,direccion,numero);
            if(personaNegocio.almacenarCliente(persona)==true){
                operacionExitosa("Se ha almacenado el cliente");
            }else{
                if(JOptionPane.showConfirmDialog(null, "La persona ya se encuentra registrada, ¿desea"
                                + " actualizar la información con los datos ingresados?", "Cliente existente",
                        JOptionPane.YES_NO_OPTION) == 0){
                    actualizarCliente(identificacion,nombres,direccion,numero);
                }
            }
            return;
        }
    }
    
    public void consultarCliente(String identificacion){
        //Matches verifica que el sting contenga solo los caracteres indicados,
        //por ejemplo letras, números o espacios en blanco
        if(!identificacion.matches("[0-9]*")){
            datosErroneos("El documento debe ser un número sin puntos ni comas");
            return;
        }
        if(identificacion.equals("")){
            JOptionPane.showMessageDialog(null,"Debe de ingresar un documento.");
            return;
        }
        ClienteDTO cliente = personaNegocio.consultarCliente(identificacion);
        if(cliente == null){
            operacionExitosa("El número de documento ingresado no coincide con ninguno de "
                    + "los documentos registrados");
        }else {
            operacionExitosa("Datos personales:\n\n" + cliente.toString());
        }
    }
    
    public void eliminarCliente(String identificacion){
        //Matches verifica que el sting contenga solo los caracteres indicados,
        //por ejemplo letras, números o espacios en blanco
        if(!identificacion.matches("[0-9]*")){
            datosErroneos("El documento debe ser un número sin puntos ni comas");
            return;
        }
        
        if(personaNegocio.eliminarCliente(identificacion)){
            operacionExitosa("Se ha eliminado el estudiante");
        }else{
            JOptionPane.showMessageDialog(null, "Ningún cliente coincide con el número de documento ingresado",
                    "Cliente no encontrado", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void actualizarCliente(String identificacion, String nombres, String direccion, String numero){
        //Matches verifica que el sting contenga solo los caracteres indicados,
        //por ejemplo letras, números o espacios en blanco
        if((!nombres.matches("[a-zA-Z ]*")) || (!direccion.matches("[a-zA-Z]*"))){
            datosErroneos("El nombre y el apellido sólo pueden contener letras");
            return;        
        }
        if(!identificacion.matches("[0-9]*")){
            datosErroneos("El documento debe ser un número sin puntos ni comas");
            return;
        }
        if(identificacion.equals("") || nombres.equals("")|| direccion.equals("")|| numero.equals("")){
            JOptionPane.showMessageDialog(null,"Debe de completar todos los campos para poder actualizar un estudiante, intentelo de nuevo.");
            return;
        }else {
            ClienteDTO persona = new ClienteDTO(identificacion,nombres,direccion,numero);
            if (personaNegocio.actualizarCliente(persona)) {
                operacionExitosa("Se ha actualizado el estudiante");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido actualizar el cliente\n"
                        + "Por favor verifique si el cliente se encuentra registrado");
            }
        }
    }
    
    public void listarClientes(){
        TablaClientes ventana = new TablaClientes();
        ventana.llenarTabla();
        ventana.setVisible(true);
    }
    
    public void operacionExitosa(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Operación exitosa", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void datosErroneos(String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, "Datos incorrectos", JOptionPane.ERROR_MESSAGE);
    }

}

