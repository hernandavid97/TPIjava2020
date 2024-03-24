package entities;

import java.util.Date;

public class Vacunacion {
	private int id_vacunacion;
	private int id_vacuna;
	private int id_mascota;
	private String especie;
	private Date fecha_vacunacion;
	private Vacuna vacuna;

	public int getId_vacunacion() {
		return id_vacunacion;
	}

	public void setId_vacunacion(int id_vacunacion) {
		this.id_vacunacion = id_vacunacion;
	}

	public int getId_vacuna() {
		return id_vacuna;
	}

	public void setId_vacuna(int id_vacuna) {
		this.id_vacuna = id_vacuna;
	}

	public int getId_mascota() {
		return id_mascota;
	}

	public void setId_mascota(int id_mascota) {
		this.id_mascota = id_mascota;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public Date getFecha_vacunacion() {
		return fecha_vacunacion;
	}

	public void setFecha_vacunacion(Date fecha_vacunacion) {
		this.fecha_vacunacion = fecha_vacunacion;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

}
