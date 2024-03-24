package logic;

import entities.*;

import java.util.ArrayList;
import data.DataVacuna;

public class VacunaLogic {

	public static ArrayList<Vacuna> getAll() {
		return new DataVacuna().getAll();
	}

}
