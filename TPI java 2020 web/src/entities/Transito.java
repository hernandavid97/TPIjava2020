package entities;
import java.util.Date;
public class Transito {
	private int id_transito;
	private Date fecha_hora_donacion;
	private Date fecha_hora_adopcion;
	private Usuario donante;
	private Mascota mascota;

	public int getId() {
		return id_transito;
	}
	public void setId(int id) {
		id_transito = id;
	}

	public Date getFechaHoraDonacion() {
		return fecha_hora_donacion;
	}
	public void setFechaHoraDonacion(Date a) {
		fecha_hora_donacion = a;
	}
	public Date getFechaHoraAdopcion() {
		return fecha_hora_adopcion;
	}
	public void setFechaHoraAdopcion(Date a) {
		fecha_hora_adopcion = a;
	}
	public Mascota getMascota() {
		return mascota;
	}
	public void setMascota(Mascota a) {
		mascota = a;
	}
	public Usuario getDonante() {
		return donante;
	}
	public void setDonante(Usuario a) {
		donante = a;
	}
}

