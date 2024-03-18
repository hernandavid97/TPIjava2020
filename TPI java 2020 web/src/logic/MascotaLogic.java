package logic;
import java.util.LinkedList;

import data.DataMascota;
import entities.*;

public class MascotaLogic {
	public static LinkedList<Mascota> getAll(){
		return new DataMascota().getAll();
	}
	public static Mascota getOne(int id_mascota){
		return new  DataMascota().getOne(id_mascota);
	}
	public static int insertOne(Mascota m) {
		return new DataMascota().insertOne(m);
	}
}
