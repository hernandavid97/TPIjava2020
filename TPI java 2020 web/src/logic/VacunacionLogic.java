package logic;

import java.util.LinkedList;

import data.DataVacunacion;
import entities.Vacunacion;

public class VacunacionLogic {
	private DataVacunacion dv;
	
	public VacunacionLogic() {
		 dv = new DataVacunacion();
	}
	
	public LinkedList<Vacunacion> getVacunacionByMascota(Integer id_mascota) {		
		return dv.getByMascota(id_mascota);
	}
}
