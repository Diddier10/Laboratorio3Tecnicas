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



import Dao.MascotaDAO;
import Implement.MascotaDAOFile;
import Model.MascotaDTO;

public class MascotaNegocio {

    private MascotaDAO mascotaDAO = new MascotaDAOFile();
    
    public MascotaNegocio(){
        
    }

    public boolean almacenarMascota(MascotaDTO mascota) {
        //Validaciones de negocio y se ejecutarán los casos de uso de la aplicación
        if(consultarMascota(mascota.getId())== null){
            mascotaDAO.almacenarMascota(mascota);
            return true;
        }
        return false;
    }

    public List<MascotaDTO> listarMascotas() {
        return mascotaDAO.listarMascotas();
    }
    
    public MascotaDTO consultarMascota(String id){
        return mascotaDAO.consultarMascota(id);
    }
    
    public boolean eliminarMascota(String id){
        if(consultarMascota(id) != null){
            mascotaDAO.eliminarMascota(id);
            return true;
        }
        return false;
    }
    
    public boolean actualizarMascota(MascotaDTO mascota){
        if(consultarMascota(mascota.getId()) != null){
            return mascotaDAO.actualizarMascota(mascota);
        }
        return false;
    }


}
