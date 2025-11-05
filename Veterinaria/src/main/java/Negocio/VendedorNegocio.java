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
import Dao.VendedorDAO;
import Implement.VendedorDAOFile;
import Model.MascotaDTO;
import Model.VendedorDTO;

public class VendedorNegocio {

    private VendedorDAO vendedorDAO = new VendedorDAOFile();
    
    public VendedorNegocio(){
        
    }

    public boolean almacenarVendedor(VendedorDTO vendedor) {
        //Validaciones de negocio y se ejecutarán los casos de uso de la aplicación
        if(consultarVendedor(vendedor.getIdentificacion())== null){
            vendedorDAO.almacenarVendedor(vendedor);
            return true;
        }
        return false;
    }

    public List<VendedorDTO> listarVendedores() {
        return vendedorDAO.listarVendedores();
    }
    
    public VendedorDTO consultarVendedor(String identificacion){
        return vendedorDAO.consultarVendedor(identificacion);
    }
    
    public boolean eliminarVendedor(String identificacion){
        if(consultarVendedor(identificacion) != null){
            vendedorDAO.eliminarVendedor(identificacion);
            return true;
        }
        return false;
    }
    
    public boolean actualizarVendedor(VendedorDTO vendedor){
        if(consultarVendedor(vendedor.getIdentificacion()) != null){
            return vendedorDAO.actualizarVendedor(vendedor);
        }
        return false;
    }


}
