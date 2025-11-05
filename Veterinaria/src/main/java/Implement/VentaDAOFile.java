/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implement;

import java.util.List;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Model.VentaDTO;
import Dao.VentaDAO;
import Model.AccesorioDTO;
import Model.ClienteDTO;
import Model.MascotaDTO;
import Model.VendedorDTO;
/**
 *
 * @author asus
 */

public class VentaDAOFile implements VentaDAO {
    private static final String DELIMITADOR_ARCHIVO = ";;";
    private static final String DELIMITADOR_LISTA = ",";
    private static final String FILE_NAME = "ventas.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoVentas;

    public VentaDAOFile() {
        archivoVentas = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarVenta(VentaDTO venta) {
        StringBuilder sb = new StringBuilder();
        sb.append(venta.getFecha());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(venta.getPrecio());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(venta.getCliente().getNombres());
        sb.append(DELIMITADOR_ARCHIVO);
        sb.append(venta.getVendedor().getNombres());
        sb.append(DELIMITADOR_ARCHIVO);
        List<MascotaDTO> mascotas = venta.getMascotas();
        for (MascotaDTO mascota : mascotas) {
            sb.append(mascota.getNombre()).append(DELIMITADOR_LISTA);
        }
        sb.append(DELIMITADOR_ARCHIVO);
        List<AccesorioDTO> accesorios = venta.getAccesorios();
        for (AccesorioDTO accesorio : accesorios) {
            sb.append(accesorio.getTipo()).append(DELIMITADOR_LISTA);
        }
        sb.append(DELIMITADOR_ARCHIVO);
            
        try {
            escritorArchivo = new FileWriter(archivoVentas, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al almacenar la venta: " + e.getMessage());
        }
        return false;
    }

    @Override
    public VentaDTO consultarVenta(String fecha) {
        String linea;
        try {
            lectorArchivo = new FileReader(archivoVentas);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR_ARCHIVO);
                if (partes[0].equals(fecha)) {
                    ClienteDTO cliente = new ClienteDTO();
                    cliente.setNombres(partes[2]);

                    VendedorDTO vendedor = new VendedorDTO();
                    vendedor.setNombres(partes[3]);

                    List<MascotaDTO> mascotas = new ArrayList<>();
                    if (!partes[4].isEmpty()) {
                        String[] mascotasNombres = partes[4].split(DELIMITADOR_LISTA);
                        for (String nombre : mascotasNombres) {
                            if (!nombre.isEmpty()) {
                                MascotaDTO mascota = new MascotaDTO();
                                mascota.setNombre(nombre);
                                mascotas.add(mascota);
                            }
                        }
                    }

                    List<AccesorioDTO> accesorios = new ArrayList<>();
                    if (!partes[5].isEmpty()) {
                        String[] accesoriosTipos = partes[5].split(DELIMITADOR_LISTA);
                        for (String tipo : accesoriosTipos) {
                            if (!tipo.isEmpty()) {
                                AccesorioDTO accesorio = new AccesorioDTO();
                                accesorio.setTipo(tipo);
                                accesorios.add(accesorio);
                            }
                        }
                    }

                    return new VentaDTO(
                        partes[0],                    
                        Double.parseDouble(partes[1]), 
                        cliente,
                        vendedor,
                        mascotas,
                        accesorios
                    );
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al consultar la venta: " + e.getMessage());
        } finally {
            try {
                if (lectorBuffer != null) {
                    lectorBuffer.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo");
            }
        }
        return null;
    }

    @Override
    public List<VentaDTO> listarVentas() {
        List<VentaDTO> ventas = new ArrayList<>();
        String linea;
        
        try {
            lectorArchivo = new FileReader(archivoVentas);
            lectorBuffer = new BufferedReader(lectorArchivo);
            
            while ((linea = lectorBuffer.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR_ARCHIVO);
              
                ClienteDTO cliente = new ClienteDTO();
                cliente.setNombres(partes[2]);
                
                VendedorDTO vendedor = new VendedorDTO();
                vendedor.setNombres(partes[3]);
                
                List<MascotaDTO> mascotas = new ArrayList<>();
                if (!partes[4].isEmpty()) {
                    for (String nombre : partes[4].split(DELIMITADOR_LISTA)) {
                        if (!nombre.isEmpty()) {
                            MascotaDTO mascota = new MascotaDTO();
                            mascota.setNombre(nombre);
                            mascotas.add(mascota);
                        }
                    }
                }
                List<AccesorioDTO> accesorios = new ArrayList<>();
                if (!partes[5].isEmpty()) {
                    for (String tipo : partes[5].split(DELIMITADOR_LISTA)) {
                        if (!tipo.isEmpty()) {
                            AccesorioDTO accesorio = new AccesorioDTO();
                            accesorio.setTipo(tipo);
                            accesorios.add(accesorio);
                        }
                    }
                }

                ventas.add(new VentaDTO(
                    partes[0],                    
                    Double.parseDouble(partes[1]), 
                    cliente,
                    vendedor,
                    mascotas,
                    accesorios
                ));
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al listar las ventas: " + e.getMessage());
        } finally {
            try {
                if (lectorBuffer != null) {
                    lectorBuffer.close();
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error al cerrar el archivo");
            }
        }
        return ventas;
    }

    @Override
    public boolean eliminarVenta(String fecha) {
        File archivoTemporal = new File("temporal.txt");
        boolean encontrado = false;

        try {
            lectorArchivo = new FileReader(archivoVentas);
            lectorBuffer = new BufferedReader(lectorArchivo);

            escritorArchivo = new FileWriter(archivoTemporal, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);

            String linea;
            while ((linea = lectorBuffer.readLine()) != null) {
                String[] partes = linea.split(DELIMITADOR_ARCHIVO);
                if (!partes[0].equals(fecha)) {
                    escritorBuffer.write(linea);
                    escritorBuffer.newLine();
                } else {
                    encontrado = true;
                }
            }
            
            escritorBuffer.close();
            lectorBuffer.close();

            if (encontrado) {
                return archivoVentas.delete() && archivoTemporal.renameTo(archivoVentas);
            }
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar la venta: " + e.getMessage());
        } finally {
            archivoTemporal.delete();
        }
        return false;
    }

    @Override
    public boolean actualizarVenta(VentaDTO venta) {
        if (eliminarVenta(venta.getFecha())) {
            return almacenarVenta(venta);
        }
        return false;
    }
}

    

