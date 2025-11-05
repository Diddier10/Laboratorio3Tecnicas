/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

import java.util.List;
import Dao.ClienteDAO;
import Model.ClienteDTO;
import Implement.ClienteDAOFile;
import Model.MascotaDTO;

/**
 *
 * @author asus
 */
public class ClienteNegocio {
    ClienteDAO clienteDAO = new ClienteDAOFile();
    
    public ClienteNegocio(){
        
    }

    public boolean almacenarCliente(ClienteDTO persona) {
        //Validaciones de negocio y se ejecutarán los casos de uso de la aplicación
        if(consultarCliente(persona.getIdentificacion())== null){
            clienteDAO.almacenarCliente(persona);
            return true;
        }
        return false;
    }

    public List<ClienteDTO> listarClientes() {
        return clienteDAO.listarClientes();
    }
    
    public ClienteDTO consultarCliente(String identificacion){
        return clienteDAO.consultarCliente(identificacion);
    }
    
    public boolean eliminarCliente(String identificacion){
        if(consultarCliente(identificacion) != null){
            clienteDAO.eliminarCliente(identificacion);
            return true;
        }
        return false;
    }
    
    public boolean actualizarCliente(ClienteDTO persona){
        if(consultarCliente(persona.getIdentificacion()) != null){
            return clienteDAO.actualizarCliente(persona);
        }
        return false;
    }
     public boolean agregarMascotasACliente(String identificacionCliente, List<MascotaDTO> nuevasMascotas) {
        if (identificacionCliente == null || nuevasMascotas == null) {
            return false;
        }

        ClienteDTO cliente = consultarCliente(identificacionCliente);
        if (cliente == null) {
            return false;
        }

        List<MascotaDTO> mascotasActuales = cliente.getMascotas();
        mascotasActuales.addAll(nuevasMascotas);
        cliente.setMascotas(mascotasActuales);

        return clienteDAO.actualizarCliente(cliente);
    }
}
    

