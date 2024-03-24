package logic;

import entities.*;

import java.util.ArrayList;

import data.DataMascota;
import data.DataVacuna;

public class VacunaLogic {

	public static ArrayList<Vacuna> getAll() {
		return new DataVacuna().getAll();
	}

	public static int altaVacuna(Vacuna v) {
		return new DataVacuna().altaVacuna(v);
	}

	public boolean validaVacuna(int id_vacuna ) {
		Vacuna vac = new DataVacuna().getById(id_vacuna);
		System.out.print(vac);
		if (vac == null) {
			return false;
		}
		return true;
	}

}
