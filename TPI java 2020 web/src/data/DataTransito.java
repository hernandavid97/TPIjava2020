package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import entities.Transito;
import entities.Usuario;

public class DataTransito {
	public ArrayList<Transito> getAll() {
		ArrayList<Transito> transitos = new ArrayList<Transito>();
		try {
			String consulta = "select * from transito";
			PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Transito t = new Transito();
				
				t.setId(rs.getInt("id_transito"));
				t.setFechaHoraDonacion(rs.getDate("fecha_hora_donacion"));
				t.setFechaHoraAdopcion(rs.getDate("fecha_hora_adopcion"));
				Integer id_mascota=rs.getInt("id_mascota");
				if (id_mascota!=null){
					DataMascota dm=new DataMascota();
					t.setMascota(dm.getOne(id_mascota));
				}
				Integer id_donante=rs.getInt("id_donante");
				if (id_donante!=null){
					DataUsuario du=new DataUsuario();
					Usuario u = new Usuario();
					u.setId(id_donante);
					t.setDonante(du.getOne(u));
				}
				
				transitos.add(t);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			DbConnector.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return transitos;
}
public Transito getOne(int id_transito) {
	Transito t=null;
	try {

		String consulta = "select * from transito where id_transito = ? ";
		PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta);
		stmt.setString(1, Integer.toString(id_transito));
		ResultSet rs = stmt.executeQuery();

		while(rs.next()) {
			t=new Transito();
			
			t.setId(rs.getInt("id_transito"));
			t.setFechaHoraDonacion(rs.getDate("fecha_hora_donacion"));
			t.setFechaHoraAdopcion(rs.getDate("fecha_hora_adopcion"));
			Integer id_mascota=rs.getInt("id_mascota");
			if (id_mascota!=null){
				DataMascota dm=new DataMascota();
				t.setMascota(dm.getOne(id_mascota));
			}
			Integer id_donante=rs.getInt("id_donante");
			if (id_donante!=null){
				DataUsuario du=new DataUsuario();
				Usuario u = new Usuario();
				u.setId(id_donante);
				t.setDonante(du.getOne(u));
			}
		}
		
		if(rs!=null){rs.close();}
		if(stmt!=null){stmt.close();}
		DbConnector.getInstancia().releaseConn();

		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}

	return t;
}
public void deleteOne(int id_transito) {
	try {

		String consulta = "delete from transito where id_transito = ?";
		PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta);
		stmt.setString(1, Integer.toString(id_transito));
		stmt.executeUpdate();
		
		if(stmt!=null){stmt.close();}
		DbConnector.getInstancia().releaseConn();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
}

public void insertOne(Transito t ) {
	try {
		
		String consulta = "insert into transito (id_mascota,id_donante,fecha_hora_donacion, fecha_hora_adopcion) values (?, ?,?,?)";
		PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta);
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		stmt.setString(1, Integer.toString(t.getMascota().getId()));
		stmt.setString(2, Integer.toString(t.getDonante().getId()));
		stmt.setString(3, formatter.format(t.getFechaHoraDonacion()));
		stmt.setString(4, formatter.format(t.getFechaHoraAdopcion()));
	
		stmt.executeUpdate();
		
		if(stmt!=null){stmt.close();}
		DbConnector.getInstancia().releaseConn();
		
	} catch (SQLException e) {
		e.printStackTrace();
	}catch (Exception e) {
		e.printStackTrace();
	}
}
}
