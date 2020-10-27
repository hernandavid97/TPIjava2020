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
	
	
	
//	public String validaRegistro(Usuario u) {
//		if (du.getByUser(u) == null) {
//			u.setId(du.newUser(u));		
//			return ("Usuario Creado: " + u.toString());
//		}else return ("El usuario ya existe, utilice uno diferente");
//	}
}
