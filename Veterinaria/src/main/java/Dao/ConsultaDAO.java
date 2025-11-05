/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.ConsultaDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public interface ConsultaDAO {
    public boolean almacenarConsulta( ConsultaDTO consulta);
	public ConsultaDTO consultarConsulta(String fecha);
	public List<ConsultaDTO> listarConsultas();
	public boolean eliminarConsulta(String fecha);
	public boolean actualizarConsulta(ConsultaDTO consulta);
    
}
