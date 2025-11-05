/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.List;
import Dao.VentaDAO;
import Model.VentaDTO;
import Implement.VentaDAOFile;

/**
 *
 * @author asus
 */
public class VentaNegocio {
    VentaDAO ventaDAO = new VentaDAOFile();
    
    public VentaNegocio(){
        
    }

    public boolean almacenarVenta(VentaDTO venta) {
        //Validaciones de negocio y se ejecutarán los casos de uso de la aplicación
        if(consultarVenta(venta.getFecha())== null){
            ventaDAO.almacenarVenta(venta);
            return true;
        }
        return false;
    }

    public List<VentaDTO> listarVentas() {
        return ventaDAO.listarVentas();
    }
    
    public VentaDTO consultarVenta(String fecha){
        return ventaDAO.consultarVenta(fecha);
    }
    
    public boolean eliminarVenta(String fecha){
        if(consultarVenta(fecha) != null){
            ventaDAO.eliminarVenta(fecha);
            return true;
        }
        return false;
    }
}
    
    
    

