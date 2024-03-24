package entities;

import java.util.LinkedList;

public class Mascota {
	private int id_mascota;
	private String nombre;
	private String tipo_animal;
	private String color;
	private int edad;
	private String imagenes;
	private boolean disponible;
	private LinkedList<Vacunacion> vacunaciones;
	
	public int getId() {
		return id_mascota;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getTipo() {
		return tipo_animal;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getColor() {
		return color;
	}
	
	public boolean getDisponible() {
		return disponible;
	}
	
	public String getImagenes() {
		return imagenes;
	}
	
	public void setId(int id) {
		id_mascota = id;
	}
	
	public void setNombre(String nom) {
		nombre = nom;
	}
	
	public void setTipo(String tip) {
		tipo_animal = tip;
	}
	
	public void setEdad(int e) {
		edad = e;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public void setDisponible(boolean d) {
		disponible = d;
	}
	
	public void setImagenes(String i) {
		imagenes = i;
	}

	public LinkedList<Vacunacion> getVacunaciones() {
		return vacunaciones;
	}

	public void setVacunaciones(LinkedList<Vacunacion> vacunaciones) {
		this.vacunaciones = vacunaciones;
	}
	
}
