package logic;
import java.util.ArrayList;
import data.DataMascota;
import entities.*;

public class MascotaLogic {
	public static ArrayList<Mascota> getAll(){
		return new DataMascota().getAll();
	}
}
