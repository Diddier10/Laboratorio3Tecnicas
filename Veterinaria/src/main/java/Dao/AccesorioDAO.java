/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.AccesorioDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public interface AccesorioDAO {
    public boolean almacenarAccesorio( AccesorioDTO accesorio);
	public AccesorioDTO consultarAccesorio(String tipo);
	public List<AccesorioDTO> listarAccesorios();
	public boolean eliminarAccesorio(String tipo);
	public boolean actualizarAccesorio(AccesorioDTO accesorio);
    
}
