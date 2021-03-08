package logic;
import entities.*;

import java.util.ArrayList;

import data.DataTransito;
public class TransitoLogic {
	
	public static ArrayList<Transito> getAll(){
		return new DataTransito().getAll();
	}
	
	public static void insertOne(Transito transito, Mascota mascota, Usuario donante) {
		mascota.setId(MascotaLogic.insertOne(mascota));
		transito.setMascota(mascota);
		transito.setDonante(donante);
		DataTransito a=new DataTransito();
		a.insertOne(transito);
	} 
	
	public static void adopcion(int id_transito, int id_adoptante) {
		DataTransito a=new DataTransito();
		a.adopcion(id_transito, id_adoptante);
	} 
}
