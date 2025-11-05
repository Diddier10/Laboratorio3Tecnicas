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
import Model.AccesorioDTO;
import Dao.AccesorioDAO;

/**
 *
 * @author asus
 */
public class AccesorioDAOFile implements AccesorioDAO{
    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String FILE_NAME = "mascota.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoMascota;

    public AccesorioDAOFile() {
        archivoMascota = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarAccesorio(AccesorioDTO accesorio) {
        StringBuilder sb = new StringBuilder();
            sb.append(accesorio.getTipo());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(accesorio.getPrecio());
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
    public AccesorioDTO consultarAccesorio(String tipo) {
        String linea;//define una linea que recibira el registro de la mascota
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(tipo)) {// no va a funcionar 
                    String parametros[] = linea.split(",");
                    return (new AccesorioDTO(parametros[0], Double.parseDouble(parametros[1])));          
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<AccesorioDTO> listarAccesorios() {
        archivoMascota = new File(FILE_NAME);
        String linea;
        List<AccesorioDTO> accesorios = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);
            while ((linea = lectorBuffer.readLine()) != null) {
                String parametros[] = linea.split(",");
                accesorios.add(new AccesorioDTO(parametros[0],Double.parseDouble(parametros[1])));                        
            }
            return accesorios;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean eliminarAccesorio(String tipo) {
        String linea;
        archivoMascota = new File(FILE_NAME);
        File archivoTemporal = new File("temporal.txt");

        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            escritorArchivo = new FileWriter(archivoTemporal, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(tipo)) {
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
    public boolean actualizarAccesorio(AccesorioDTO accesorio) {
        archivoMascota = new File(FILE_NAME);
        String linea;
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(accesorio.getTipo())) {
                    lectorBuffer.close();
                    eliminarAccesorio(accesorio.getTipo());
                    almacenarAccesorio(accesorio);
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
    

