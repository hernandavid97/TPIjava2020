package logic;

import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;

import data.DataTransito;
import data.DataVacunacion;
import entities.Mascota;
import entities.Transito;
import entities.Usuario;
import entities.Vacuna;
import entities.Vacunacion;

public class VacunacionLogic {
	private DataVacunacion dv;

	public VacunacionLogic() {
		dv = new DataVacunacion();
	}

	public LinkedList<Vacunacion> getVacunacionByMascota(Integer id_mascota) {
		return dv.getByMascota(id_mascota);
	}
	
	public LinkedList<Vacunacion> getAll() {
		return dv.getAll();
	}
	
	public String validaBaja(Vacunacion v) throws Exception {
		System.out.println("test");
		System.out.println(dv.getOne(v.getId_vacunacion()));
		if (dv.getOne(v.getId_vacunacion()) != null) {
			String b = "";
			try {
				b = dv.bajaVacunacion(v);
			} catch (Exception e) {
				System.out.println(e);
				throw e;
				// TODO: handle exception
			}
			return (b);
		} else
			throw new Exception("Vacunacion no existe");
	}
	
	public String validaModif(Vacunacion nueva, Vacunacion old) throws Exception {
		try {
			if (dv.getOne(old.getId_vacunacion()) != null) {
				return (dv.updateVacunacion(nueva, old));
			} else
				return ("Vacunación no existe");			
		} catch (SQLException e) {
			throw new Exception("No pudo modificarse la vacunación");
		}
	}
	
	public String insertOne(Vacunacion vacunacion) throws Exception {
		try {
			if (dv.getOne(vacunacion.getId_vacunacion()) == null) {
				vacunacion.setId_vacunacion(dv.insertOne(vacunacion));
				return ("Vacunacion Creada: " + vacunacion.getId_vacunacion());
			} else
				throw new Exception("Vacunacion ya existe");
		} catch (Exception e) {
			throw e;
		}
	}
}
