package entities;

public class Ong { // No está en uso, reemplazado por vacunación
	private int id_ong;
	private String nombre;
	private String cbu;

	public int getId() {
		return id_ong;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCbu() {
		return cbu;
	}

	public void setId(int id) {
		id_ong = id;
	}

	public void setNombre(String nom) {
		nombre = nom;
	}

	public void setCbu(String c) {
		cbu = c;
	}
}
