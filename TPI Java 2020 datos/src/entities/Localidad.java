package entities;

public class Localidad {
 private String nombre;
 private String provincia;
 private int id_localidad;
 
	 public String getNombre() {
		 return nombre;
	 }
	 
	 public String getProvincia() {
		 return provincia;
	 }
	 
	 public int getId() {
		 return id_localidad;
	 }
	 
	 public void setNombre(String nom) {
		 nombre= nom;
	 }
	 
	 public void setProvincia(String prov) {
		 provincia = prov;
	 }
	 
	 public void setId(int id) {
		 id_localidad = id;
	 }
 
}
