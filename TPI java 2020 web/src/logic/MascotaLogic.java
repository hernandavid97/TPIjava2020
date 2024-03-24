package logic;

import java.util.LinkedList;

import data.DataMascota;
import entities.*;

public class MascotaLogic {
	public static LinkedList<Mascota> getAll() {
		LinkedList<Mascota> mascotas = new DataMascota().getAll();
		for (Mascota m : mascotas) {
			LinkedList<Vacunacion> vacunaciones = new LinkedList<Vacunacion>();
			VacunacionLogic vacunacionLogic = new VacunacionLogic();
			vacunaciones = vacunacionLogic.getVacunacionByMascota(m.getId());
			m.setVacunaciones(vacunaciones);
		}

		return mascotas;
	}

	public static Mascota getOne(int id_mascota) {
		Mascota mascota = new DataMascota().getOne(id_mascota);
		LinkedList<Vacunacion> vacunaciones = new LinkedList<Vacunacion>();
		VacunacionLogic vacunacionLogic = new VacunacionLogic();
		vacunaciones = vacunacionLogic.getVacunacionByMascota(id_mascota);
		mascota.setVacunaciones(vacunaciones);
		return mascota;
	}

	public static int insertOne(Mascota m) {
		return new DataMascota().insertOne(m);
	}
}
