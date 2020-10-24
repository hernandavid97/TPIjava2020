package logic;

import data.DataUsuario;
import entities.Usuario;

public class Login {
	private DataUsuario du;
	
	public Login() {
		 du=new DataUsuario();
	}
	
	public Usuario validate(Usuario u) {
		/* para hacer más seguro el manejo de passwords este sería un lugar 
		 * adecuado para generar un hash de la password utilizando un cifrado
		 * asimétrico como sha256 y utilizar el hash en lugar de la password en plano 
		 */
		return du.getByUser(u);
	}
	
	public String validaRegistro(Usuario u) {
		if (du.getByUser(u) != null) {
			u.setId(du.newUser(u));		
			return ("Usuario Creado: " + u.toString());
		}else return ("El usuario ya existe, utilice uno diferente");
	}
}
