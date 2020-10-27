package entities;


public class Usuario {
	private int id_usuario;
	private String usuario;
	private String password;
	private String email;
	private String nombre;
	private String apellido;
	private String domicilio;
	private String tipoDoc;
	private String nroDoc;
	private boolean isAdoptante;
	private boolean isDonante;
	private Localidad localidad;
	private int tipo;
	
	@Override
	public String toString() {
		return (id_usuario +" " + usuario+" " + password+" " + email+" " + nombre
				+" " + apellido+" " + domicilio+" " + tipoDoc+" "
				+ nroDoc+" " + isAdoptante+" " + isDonante+" " + localidad + " " + tipo);
	}
	public int getId() {
		return id_usuario;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public String getPassword() {
		return password;
	}
	
	public String getEmail() {
		return	email;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getApellido() {
		return apellido;
	}
	
	public String getDomicilio() {
		return domicilio;
	}
	
	public String getNroDoc() {
		return nroDoc;
	}
	
	public String getTipoDoc() {
		return tipoDoc;
	}
	
	public boolean getAdoptante() {
		return isAdoptante;
	}
	
	public boolean getDonante() {
		return isDonante;
	}
	
	public Localidad getLocalidad() {
		return localidad;
	}
	
	public int getTipo() {
		return tipo;
	}
	
	public void setId(int id) {
		id_usuario = id;
	}
	
	public void setUsuario(String user) {
		 usuario = user;
	}

	public void setPassword(String pw) {
		 password = pw;
	}
	
	public void setEmail(String em) {
			email=em;
	}
	
	public void setNombre(String nom) {
		 nombre=nom;
	}
	
	public void setApellido(String ap) {
		 apellido=ap;
	}
	
	public void setDomicilio(String dom) {
		 domicilio = dom;
	}
	
	public void setNroDoc(String nro) {
		 nroDoc = nro;
	}
	public void setTipoDoc(String tipo) {
		 tipoDoc = tipo;
	}
	
	public void setAdoptante(boolean ia) {
		 isAdoptante = ia;
	}
	
	public void setDonante(boolean isdon) {
		 isDonante = isdon;
	}
	
	public void setLocalidad(Localidad loc) {
		 this.localidad = loc;
	}
	
	public void setTipo(int t) {
		 tipo = t;
	}

}
