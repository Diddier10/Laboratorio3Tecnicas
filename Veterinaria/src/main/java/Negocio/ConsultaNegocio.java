/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author asus
 */
import java.util.List;



import Dao.ConsultaDAO;
import Implement.ConsultaDAOFile;
import Model.ConsultaDTO;
import java.util.ArrayList;

public class ConsultaNegocio {

    private ConsultaDAO consultaDAO = new ConsultaDAOFile();
    
    public ConsultaNegocio(){
        
    }

    public boolean almacenarConsulta(ConsultaDTO consulta) {
        //Validaciones de negocio y se ejecutarán los casos de uso de la aplicación
        if(consultarConsulta(consulta.getFecha())== null){
            consultaDAO.almacenarConsulta(consulta);
            return true;
        }
        return false;
    }

    public List<ConsultaDTO> listarConsultas() {
        return consultaDAO.listarConsultas();
    }
    
    public ConsultaDTO consultarConsulta(String fecha){
        return consultaDAO.consultarConsulta(fecha);
    }
    
    public boolean eliminarConsulta(String fecha){
        if(consultarConsulta(fecha) != null){
            consultaDAO.eliminarConsulta(fecha);
            return true;
        }
        return false;
    }
    
    public boolean actualizarConsulta(ConsultaDTO consulta){
        if(consultarConsulta(consulta.getFecha()) != null){
            return consultaDAO.actualizarConsulta(consulta);
        }
        return false;
    }
    public List<ConsultaDTO> obtenerConsultasPorMascota(String idMascota) {
        if (idMascota == null || idMascota.trim().isEmpty()) {
            return new ArrayList<>();
        }

        List<ConsultaDTO> todasLasConsultas = consultaDAO.listarConsultas();
        List<ConsultaDTO> consultasMascota = new ArrayList<>();

        for (ConsultaDTO consulta : todasLasConsultas) {
            if (consulta.getFecha().equals(idMascota)) {
                consultasMascota.add(consulta);
            }
        }

        return consultasMascota;
    }

}
