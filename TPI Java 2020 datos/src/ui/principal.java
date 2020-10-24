package ui;


import java.util.Scanner;

import data.DataLocalidad;
import entities.Localidad;
import entities.Usuario;
import logic.Login;

public class principal {
	static Scanner s=null;
	static Login ctrlLogin = new Login();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = registro();
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
	
	private static Usuario registro() {
		s = new Scanner(System.in);
		Usuario u=new Usuario();
		DataLocalidad dl = new DataLocalidad();
		Localidad l = new Localidad();
		System.out.print("Nombre de usuario: ");
		u.setUsuario(s.nextLine());
		System.out.print("password: ");
		u.setPassword(s.nextLine());
		System.out.print("email: ");
		u.setEmail(s.nextLine());
		System.out.print("Nombre: ");
		u.setNombre(s.nextLine());
		System.out.print("Apellido: ");
		u.setApellido(s.nextLine());
		System.out.print("Domicilio: ");
		u.setDomicilio(s.nextLine());
		System.out.print("tipo de documento: ");
		u.setTipoDoc(s.nextLine());
		System.out.print("Nro de documento: ");
		u.setNroDoc(s.nextLine());
		u.setAdoptante(true);
		u.setDonante(true);
		System.out.print("Localidad: ");
		l = dl.getByNombre(s.nextLine());
		u.setLocalidad(l);
		
		System.out.println(ctrlLogin.validaRegistro(u));
		
		return u;
	}
	

}
