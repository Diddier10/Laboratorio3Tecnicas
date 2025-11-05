/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implement;

/**
 *
 * @author asus
 */
import java.util.List;
import java.util.Scanner;
import java.io.*;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import Model.MascotaDTO;
import Dao.MascotaDAO;

public class MascotaDAOFile implements MascotaDAO {

    private static final String DELIMITADOR_ARCHIVO = ",";
    private static final String FILE_NAME = "mascota.txt";
    private BufferedWriter escritorBuffer;
    private BufferedReader lectorBuffer;
    private FileWriter escritorArchivo;
    private FileReader lectorArchivo;
    private File archivoMascota;

    public MascotaDAOFile() {
        archivoMascota = new File(FILE_NAME);
    }

    @Override
    public boolean almacenarMascota(MascotaDTO mascota) {
        StringBuilder sb = new StringBuilder();// Orden del constructor 
            sb.append(mascota.getNombre());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getRaza());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getEdad());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getTipo());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getId());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getPeso());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getFechaIngreso());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getLugarOrigen());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getGenero());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.getPrecio());
            sb.append(DELIMITADOR_ARCHIVO);
            sb.append(mascota.isEstadoAdopcion());
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
    public MascotaDTO consultarMascota(String id) {
        String linea;//define una linea que recibira el registro de la mascota
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(id)) {// no va a funcionar 
                    String parametros[] = linea.split(",");
                    return (new MascotaDTO(parametros[0], parametros[1],
                            Integer.parseInt(parametros[2]),parametros[3], parametros[4],
                            Double.parseDouble(parametros[5]),parametros[6],parametros[7],
                            parametros[8].charAt(0), Double.parseDouble(parametros[9]),
                            Boolean.parseBoolean(parametros[10])));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<MascotaDTO> listarMascotas() {
        archivoMascota = new File(FILE_NAME);
        String linea;
        List<MascotaDTO> mascotas = new ArrayList<>();
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);
            while ((linea = lectorBuffer.readLine()) != null) {
                String parametros[] = linea.split(",");
                mascotas.add(new MascotaDTO(parametros[0], parametros[1],
                            Integer.parseInt(parametros[2]),parametros[3], parametros[4],
                            Double.parseDouble(parametros[5]),parametros[6],parametros[7],
                            parametros[8].charAt(0), Double.parseDouble(parametros[9]),
                            Boolean.parseBoolean(parametros[10])));
            }
            return mascotas;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean eliminarMascota(String id) {
        String linea;
        archivoMascota = new File(FILE_NAME);
        File archivoTemporal = new File("temporal.txt");

        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            escritorArchivo = new FileWriter(archivoTemporal, true);
            escritorBuffer = new BufferedWriter(escritorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(id)) {
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
    public boolean actualizarMascota(MascotaDTO mascota) {
        archivoMascota = new File(FILE_NAME);
        String linea;
        try {
            lectorArchivo = new FileReader(archivoMascota);
            lectorBuffer = new BufferedReader(lectorArchivo);

            while ((linea = lectorBuffer.readLine()) != null) {
                if (linea.substring(0, linea.indexOf(",")).equals(mascota.getId())) {
                    lectorBuffer.close();
                    eliminarMascota(mascota.getId());
                    almacenarMascota(mascota);
                    return true;
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
