package logic;

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
		//System.out.println("id en ctrl "+nuevo.getLocalidad().getId());
		if (du.getOne(nuevo) != null) {			
			return (du.updateUsuario(nuevo, old));			
		}else return ("Error al modificar usuario");
	}
}
