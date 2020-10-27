package data;

import java.sql.*;
import java.util.LinkedList;

import entities.Usuario;
import entities.Localidad;


public class DataLocalidad {
	
	public Localidad getByNombre(String nom) {
		Localidad l = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_localidad,nombre_localidad,provincia from localidad where nombre_localidad=?"
					);
			stmt.setString(1, nom);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				l=new Localidad();
				l.setNombre(rs.getNString("nombre_localidad"));
				l.setId(rs.getInt("id_localidad"));
				l.setProvincia(rs.getString("provincia"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return l;
	}
	
	public void setLocalidad(Usuario us) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					  "select localidad.* "
					+ "from localidad "
					+ "inner join usuario "
					+ "on localidad.id_localidad=usuario.localidad "
					+ "where id_usuario=?"
					);
			stmt.setInt(1, us.getId());
			rs= stmt.executeQuery();
			if(rs!=null) {
				while(rs.next()) {
					Localidad l=new Localidad();
					l.setId(rs.getInt("id_localidad"));
					l.setNombre(rs.getString("nombre_localidad"));
					l.setProvincia(rs.getNString("provincia"));
					us.setLocalidad(l);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public LinkedList<Localidad> getAll(){		
		Statement stmt=null;
		ResultSet rs=null;
		LinkedList<Localidad> localidades= new LinkedList<>();
		
		try {
			stmt= DbConnector.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select id_localidad, nombre_localidad, provincia from localidad");
			//intencionalmente no se recupera la password
			if(rs!=null) {
				while(rs.next()) {
					Localidad l=new Localidad();					
					l.setId(rs.getInt("id_localidad"));
					l.setNombre(rs.getString("nombre_localidad"));
					l.setProvincia(rs.getString("provincia"));						
					localidades.add(l);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return localidades;
	}
}
