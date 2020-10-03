package ui;


import java.util.Scanner;

import entities.Usuario;
import logic.Login;

public class principal {
	static Scanner s=null;
	static Login ctrlLogin = new Login();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = login();
		System.out.println("Bienvenido "+ u.getNombre()+" " + u.getApellido());
	}
	
	private static Usuario login() {
		s = new Scanner(System.in);
		Usuario u=new Usuario();
		
		System.out.print("Nombre de usuario: ");
		u.setUsuario(s.nextLine());
		System.out.print("password: ");
		u.setPassword(s.nextLine());		
		u=ctrlLogin.validate(u);
		
		return u;
	}

}
