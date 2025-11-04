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
import Model.MascotaDTO;
/**
 *
 * @author asus
 */
public class VentaDAOFile implements VentaDAO{
    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String FILE_NAME = "mascota.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoMascota;

    public VentaDAOFile() {
        archivoMascota = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarVenta(VentaDTO venta) {
        StringBuilder sb = new StringBuilder();// Orden del constructor 
            sb.append(venta.getFecha());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(venta.getValorVenta());
            sb.append(DELIMITADOR_ARCHIVO);
            
        try {

            escritorArchivo = new FileWriter(archivoMascota, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);
            escritorBuffer.write(sb.toString());
            escritorBuffer.newLine();
            escritorBuffer.close();
            return true;
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error");
        }
        return false;
    }

    @Override
    public VentaDTO consultarVenta(String fecha) {
        String linea;//define una linea que recibira el registro de la mascota
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(fecha)) {// no va a funcionar 
                    String parametros[] = linea.split(",");
                    return (new VentaDTO(parametros[0],Double.parseDouble(parametros[1])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<VentaDTO> listarVentas() {
        archivoMascota = new File(FILE_NAME);
        String linea;
        List<VentaDTO> ventas = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);
            while ((linea = lectorBuffer.readLine()) != null) {
                String parametros[] = linea.split(",");
                ventas.add(new VentaDTO(parametros[0],Double.parseDouble(parametros[1])));                         
            }
            return ventas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean eliminarVenta(String fecha) {
        String linea;
        archivoMascota = new File(FILE_NAME);
        File archivoTemporal = new File("temporal.txt");

        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            escritorArchivo = new FileWriter(archivoTemporal, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(fecha)) {
                    System.out.println("coincide");
                    escritorBuffer.write("");
                } else {
                    escritorBuffer.write(linea);
                    escritorBuffer.newLine();
                }
            }
            escritorBuffer.close();
            lectorBuffer.close();

            escritorBuffer = new BufferedWriter(new FileWriter(archivoMascota));
            lectorBuffer = new BufferedReader(new FileReader(archivoTemporal));
            while ((linea = lectorBuffer.readLine()) != null) {
                escritorBuffer.write(linea);
                escritorBuffer.newLine();
            }
            escritorBuffer.close();
            lectorBuffer.close();
            System.out.println(archivoTemporal.delete());
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (null != lectorArchivo) {
                    lectorArchivo.close();
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        return false;
    }

    @Override
    public boolean actualizarVenta(VentaDTO venta) {
        archivoMascota = new File(FILE_NAME);
        String linea;
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(venta.getFecha())) {
                    lectorBuffer.close();
                    eliminarVenta(venta.getFecha());
                    almacenarVenta(venta);
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}

    

