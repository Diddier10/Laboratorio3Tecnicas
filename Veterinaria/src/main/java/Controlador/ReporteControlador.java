/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;
import Model.*;
import Negocio.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author asus
 */

public class ReporteControlador {
    private ClienteNegocio clienteNegocio;
    private MascotaNegocio mascotaNegocio;

    public ReporteControlador() {
        this.clienteNegocio = new ClienteNegocio();
        this.mascotaNegocio = new MascotaNegocio();
    }

    public DefaultTableModel generarReporte(String tipoReporte, String identificacion) {
        if (identificacion == null || identificacion.trim().isEmpty()) {
            datosErroneos("La identificación es obligatoria");
            return null;
        }

        switch (tipoReporte) {
            case "Por clientes":
                return generarReportePorCliente(identificacion);
            case "Por mascotas":
                return generarReportePorMascota(identificacion);
            default:
                datosErroneos("Tipo de reporte no válido");
                return null;
        }
    }

    private DefaultTableModel generarReportePorCliente(String identificacion) {
        ClienteDTO cliente = clienteNegocio.consultarCliente(identificacion);
        if (cliente == null) {
            datosErroneos("No se encontró el cliente");
            return null;
        }

        List<MascotaDTO> mascotas = cliente.getMascotas();
        if (mascotas == null || mascotas.isEmpty()) {
            mostrarMensaje("El cliente no tiene mascotas registradas", "Reporte de Mascotas");
            return null;
        }

        String[] columnNames = {
            "Nombre", "Raza", "Edad", "Tipo", "ID", "Peso", 
            "Fecha Ingreso", "Lugar Origen", "Género", "Precio", "Estado Adopción"
        };
        
        DefaultTableModel modelo = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (MascotaDTO mascota : mascotas) {
            Object[] fila = {
                mascota.getNombre(),
                mascota.getRaza(),
                mascota.getEdad(),
                mascota.getTipo(),
                mascota.getId(),
                mascota.getPeso(),
                mascota.getFechaIngreso(),
                mascota.getLugarOrigen(),
                mascota.getGenero(),
                mascota.getPrecio(),
                mascota.isEstadoAdopcion()
            };
            modelo.addRow(fila);
        }

        return modelo;
    }

    private DefaultTableModel generarReportePorMascota(String id) {
        // Implementación para el reporte por mascota
        // Lo implementaremos cuando lo necesites
        return null;
    }

    private void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    private void datosErroneos(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }
}