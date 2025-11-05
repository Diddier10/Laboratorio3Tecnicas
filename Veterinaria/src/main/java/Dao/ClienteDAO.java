/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;
import Model.ClienteDTO;

/**
 *
 * @author asus
 */
public interface ClienteDAO {
    public boolean almacenarCliente(ClienteDTO cliente);
	public ClienteDTO consultarCliente(String identificacion);
	public List<ClienteDTO> listarClientes();
	public boolean eliminarCliente(String identificacion);
	public boolean actualizarCliente(ClienteDTO Cliente);
}
