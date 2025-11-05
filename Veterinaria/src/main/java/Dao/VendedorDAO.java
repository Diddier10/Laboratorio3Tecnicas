/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import java.util.List;
import Model.VendedorDTO;


/**
 *
 * @author asus
 */
public interface VendedorDAO {
    public boolean almacenarVendedor(VendedorDTO vendedor);
	public VendedorDTO consultarVendedor(String identificacion);
	public List<VendedorDTO> listarVendedores();
	public boolean eliminarVendedor(String identificacion);
	public boolean actualizarVendedor(VendedorDTO vendedor);
    
}
