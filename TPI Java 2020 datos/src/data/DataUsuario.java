package data;


import java.sql.*;

import entities.Usuario;

public class DataUsuario {

	public Usuario getByUser(Usuario u) {
		DataLocalidad dl=new DataLocalidad();
		Usuario p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_usuario,usuario,nombre,apellido,tipo_doc,nro_doc,email,is_adoptante,is_donante,localidad from usuario where usuario=? and password=?"
					);
			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getPassword());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				p=new Usuario();
				p.setNroDoc("nro_doc");
				p.setTipoDoc("tipo_doc");
				p.setId(rs.getInt("id_usuario"));
				p.setUsuario(rs.getNString("usuario"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));	
				p.setEmail(rs.getString("email"));
				p.setDomicilio("domicilio");
				p.setDonante(rs.getBoolean("is_donante"));
				p.setAdoptante(rs.getBoolean("is_adoptante"));
				dl.setLocalidad(u);

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
		
		return p;
	}
}
