package logic;

import entities.*;

import java.util.ArrayList;
import data.DataVacuna;

public class VacunaLogic {
	private DataVacuna dv;

	public VacunaLogic() {
		dv = new DataVacuna();
	}

	public static ArrayList<Vacuna> getAll() {
		return new DataVacuna().getAll();
	}
	
	public static ArrayList<Vacuna> getByEspecie(String especie) {
		return new DataVacuna().getByEspecie(especie);
	}

	public static int altaVacuna(Vacuna v) {
		return new DataVacuna().altaVacuna(v);
	}

	public boolean validaVacuna(int id_vacuna) {
		Vacuna vac = new DataVacuna().getById(id_vacuna);
		if (vac == null) {
			return false;
		}
		return true;
	}

	public String validaBaja(Vacuna v) throws Exception {
		int id = v.getId();
		if (dv.getById(id) != null) {
			String b = "";
			try {
				b = dv.bajaVacuna(v);
			} catch (Exception e) {
				System.out.println(e);
				throw e;
				// TODO: handle exception
			}
			return (b);
		} else
			return ("Vacuna no existe");
	}

	public String validaModif(Vacuna nueva, Vacuna old) {
		if (dv.getById(old.getId()) != null) {
			return (dv.updateVacuna(nueva, old));
		} else
			return ("Vacuna no existe");
	}
}
