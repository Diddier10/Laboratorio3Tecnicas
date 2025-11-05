/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;

import Model.MascotaDTO;
import java.util.List;

/**
 *
 * @author asus
 */
public interface MascotaDAO {
	public boolean almacenarMascota(MascotaDTO mascota);
	public MascotaDTO consultarMascota(String id);
	public List<MascotaDTO> listarMascotas();
	public boolean eliminarMascota(String id);//depende de la venta sin RESOLVER
	public boolean actualizarMascota(MascotaDTO mascota);
}
