package logic;

import java.util.LinkedList;

import data.DataMascota;
import entities.Localidad;
import entities.Mascota;

public class CtrlMas {
	private DataMascota dm;
	
	public CtrlMas() {
		 dm = new DataMascota();
	}
	
	public String validaBaja(Mascota m) throws Exception {
		if (dm.getOne(m.getId()) != null) {
			String b = "";
			try {
				b = dm.bajaMascota(m);
			}
			catch (Exception e) {
				System.out.println(e);
				throw e;
				// TODO: handle exception
			}			
			return (b);
		}else throw new Exception("Mascota no existe");
	}
	
	public LinkedList<Mascota> getMascotas() {		
		return dm.getAll();
	}
	
	public LinkedList<Mascota> getMascotasByUser(Integer id_usuario) {		
		return dm.getByUser(id_usuario);
	}
	
	public String validaModif(Mascota nueva, Mascota old) {
		if (dm.getOne(old.getId()) != null) {	
			return (dm.updateMascota(nueva, old));
		}else return ("Mascota no existe");
	}
}
