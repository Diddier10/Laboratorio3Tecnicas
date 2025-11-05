/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model.AccesorioDTO;
import Model.ClienteDTO;
import Model.MascotaDTO;
import Model.VendedorDTO;
import Model.VentaDTO;
import Negocio.AccesorioNegocio;
import Negocio.ClienteNegocio;
import Negocio.MascotaNegocio;
import Negocio.VendedorNegocio;
import Negocio.VentaNegocio;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author asus
 */
public class VentaControlador {
    private VentaNegocio ventaNegocio;
    private MascotaNegocio mascotaNegocio;
    private ClienteNegocio clienteNegocio;
    private VendedorNegocio vendedorNegocio;

    public VentaControlador() {
        this.ventaNegocio = new VentaNegocio();
        this.mascotaNegocio = new MascotaNegocio();
        this.clienteNegocio = new ClienteNegocio();
        this.vendedorNegocio = new VendedorNegocio();
    }

    public void almacenarVenta(String fecha, double precio, String clienteId, 
                             String vendedorId, List<String> mascotasIds, 
                             List<String> tiposAccesorios) {
        
        if (fecha.isEmpty() || clienteId.isEmpty() || vendedorId.isEmpty()) {
            datosErroneos("Todos los campos son obligatorios");
            return;
        }

        if (precio <= 0) {
            datosErroneos("El precio debe ser mayor a 0");
            return;
        }   

        ClienteDTO cliente = clienteNegocio.consultarCliente(clienteId);
        if (cliente == null) {
            datosErroneos("Cliente no encontrado");
            return;
        }

        VendedorDTO vendedor = vendedorNegocio.consultarVendedor(vendedorId);
        if (vendedor == null) {
            datosErroneos("Vendedor no encontrado");
            return;
        }

        List<MascotaDTO> mascotas = new ArrayList<>();
        for (String mascotaId : mascotasIds) {
            MascotaDTO mascota = mascotaNegocio.consultarMascota(mascotaId);
            if (mascota == null) {
                datosErroneos("Mascota con ID " + mascotaId + " no encontrada");
                return;
            }
            if (mascota.isEstadoAdopcion()) {
                datosErroneos("La mascota " + mascota.getNombre() + " ya está vendida");
                return;
            }
            mascotas.add(mascota);
        }
        List<AccesorioDTO> accesorios = new ArrayList<>();
        for (String tipo : tiposAccesorios) {
            AccesorioDTO accesorio = new AccesorioDTO();
            accesorio.setTipo(tipo);
            accesorios.add(accesorio);
        }

        VentaDTO venta = new VentaDTO(fecha, precio, cliente, vendedor, mascotas, accesorios);

        if (ventaNegocio.almacenarVenta(venta)) {
            for (MascotaDTO mascota : mascotas) {
                mascota.setEstadoAdopcion(true);
                mascotaNegocio.actualizarMascota(mascota);
            }
            
            
            clienteNegocio.agregarMascotasACliente(clienteId, mascotas);
            
            operacionExitosa("Venta registrada exitosamente");
        } else {
            datosErroneos("Error al registrar la venta. La fecha ya existe");
        }
    }

    public void operacionExitosa(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Operación exitosa", 
                                    JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void datosErroneos(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Datos incorrectos", 
                                    JOptionPane.ERROR_MESSAGE);
    }
}

    