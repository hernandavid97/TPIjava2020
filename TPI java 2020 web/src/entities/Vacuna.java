package entities;

public class Vacuna {
	private int id_vacuna;
	private String titulo;
	private String especie;
	private String descripcion;
	
	public int getId() {
		return id_vacuna;
	}
	public void setId(int id) {
		id_vacuna = id;
	}

	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

}
