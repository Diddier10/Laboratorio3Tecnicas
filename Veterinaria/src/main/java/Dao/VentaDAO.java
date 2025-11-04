/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.VentaDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public interface VentaDAO {
        public boolean almacenarVenta(VentaDTO venta);
	public VentaDTO consultarVenta(String fecha);
	public List<VentaDTO> listarVentas();
	public boolean eliminarVenta(String fecha);
	public boolean actualizarVenta(VentaDTO venta);
    
}
