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



import Dao.AccesorioDAO;
import Implement.AccesorioDAOFile;
import Model.AccesorioDTO;

public class AccesorioNegocio {

    private AccesorioDAO accesorioDAO = new AccesorioDAOFile();
    
    public AccesorioNegocio(){
        
    }

    public boolean almacenarAccesorio(AccesorioDTO accesorio) {
        //Validaciones de negocio y se ejecutarán los casos de uso de la aplicación
        if(consultarAccesorio(accesorio.getTipo())== null){
            accesorioDAO.almacenarAccesorio(accesorio);
            return true;
        }
        return false;
    }

    public List<AccesorioDTO> listarAccesorios() {
        return accesorioDAO.listarAccesorios();
    }
    
    public AccesorioDTO consultarAccesorio(String tipo){
        return accesorioDAO.consultarAccesorio(tipo);
    }
    
    public boolean eliminarAccesorio(String tipo){
        if(consultarAccesorio(tipo) != null){
            accesorioDAO.eliminarAccesorio(tipo);
            return true;
        }
        return false;
    }
    
    public boolean actualizarAccesorio(AccesorioDTO accesorio){
        if(consultarAccesorio(accesorio.getTipo()) != null){
            return accesorioDAO.actualizarAccesorio(accesorio);
        }
        return false;
    }


}
