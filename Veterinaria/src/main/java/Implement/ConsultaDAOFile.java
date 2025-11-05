/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implement;

/**
 *
 * @author asus
 */
import Dao.ConsultaDAO;
import Model.ConsultaDTO;
import java.util.List;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Model.MascotaDTO;


public class ConsultaDAOFile implements ConsultaDAO {

    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String FILE_NAME = "mascota.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoMascota;

    public ConsultaDAOFile() {
        archivoMascota = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarConsulta(ConsultaDTO consulta) {
        StringBuilder sb = new StringBuilder();// Orden del constructor 
            sb.append(consulta.getFecha());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(consulta.getSintomas());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(consulta.getTratamiento());
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
    public ConsultaDTO consultarConsulta(String fecha) {
        String linea;//define una linea que recibira el registro de la mascota
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(fecha)) {// no va a funcionar 
                    String parametros[] = linea.split(",");
                    return (new ConsultaDTO(parametros[0], parametros[1],parametros[2]
                            ));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<ConsultaDTO> listarConsultas() {
        archivoMascota = new File(FILE_NAME);
        String linea;
        List<ConsultaDTO> consultas = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);
            while ((linea = lectorBuffer.readLine()) != null) {
                String parametros[] = linea.split(",");
                consultas.add(new ConsultaDTO(parametros[0], parametros[1],
                            (parametros[2])));
            }
            return consultas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean eliminarConsulta(String fecha) {
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
    public boolean actualizarConsulta(ConsultaDTO consulta) {
        archivoMascota = new File(FILE_NAME);
        String linea;
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(consulta.getFecha())) {
                    lectorBuffer.close();
                    eliminarConsulta(consulta.getFecha());
                    almacenarConsulta(consulta);
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
