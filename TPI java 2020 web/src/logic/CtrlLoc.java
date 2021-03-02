package logic;

import java.util.LinkedList;

import data.DataLocalidad;
import entities.Localidad;


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
	
	public String validaBaja(Localidad l) {
		if (dl.getById(l) != null) {
			String b = "";
			try {
			b = dl.bajaLocalidad(l);
			}
			catch (Exception e) {
				System.out.println(e);
				// TODO: handle exception
			}			
			return (b);
		}else return ("Localidad no existe");
	}
	
	public String validaModif(Localidad nueva, Localidad old) {
		if (dl.getById(old) != null) {	
			return (dl.updateLocalidad(nueva, old));
		}else return ("Localidad no existe");
	}
	
}
