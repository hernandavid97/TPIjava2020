package logic;

import java.util.ArrayList;

import data.DataUsuario;
import entities.Usuario;

public class Login {
	private DataUsuario du;
	
	public Login() {
		 du=new DataUsuario();
	}
	
	public Usuario validate(Usuario u) {		
		return du.getByUser(u);
	}
	
	public String validaRegistro(Usuario u) {
		if (du.getByUser(u) == null) {
			u.setId(du.newUser(u));		
			return ("Usuario Creado: " + u.toString());
		}else return ("El usuario ya existe, utilice uno diferente");
	}
	
	public String validaModif(Usuario nuevo, Usuario old) {
		if (du.getOne(nuevo) != null) {			
			return (du.updateUsuario(nuevo, old));			
		}else return ("Error al modificar usuario");
	}
	
	public String validaBaja(Usuario old) {
		if (du.getOne(old) != null) {			
			return (du.bajaUsuario(old, old));			
		}else return ("Error al borrar usuario");
	}
	
	public static ArrayList<Usuario> getAll(){
		return new DataUsuario().getAll();
	}
	
}
