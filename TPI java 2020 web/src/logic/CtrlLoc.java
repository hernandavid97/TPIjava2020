package logic;

import java.util.LinkedList;

import data.DataLocalidad;
import entities.Localidad;
import entities.Usuario;

public class CtrlLoc {
	private DataLocalidad dl;
	
	public CtrlLoc() {
		 dl = new DataLocalidad();
	}
	
	public LinkedList<Localidad> getLocalidades() {		
		return dl.getAll();
	}
	
	public Localidad validaLocalidad(Localidad l) {		
		return dl.getByNombre(l);
	}
	
	
	
	public String validaAlta(Localidad l) {
		if (dl.getByNombre(l) == null) {
			l.setId(dl.newLocalidad(l));		
			return ("Localidad Creada: " + l.toString());
		}else return ("Localidad ya existe");
	}
}
