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
					"select id_usuario,usuario,nombre,apellido,tipo_doc,nro_doc,email,is_adoptante,is_donante,localidad,tipo from usuario where usuario=? and password=?"
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
				p.setTipo(rs.getInt("tipo"));
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
	
	public int newUser(Usuario u) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into usuario(usuario,nombre,apellido,tipo_doc,nro_doc,password,email,is_adoptante,is_donante,localidad,tipo,domicilio) values(?,?,?,?,?,?,?,?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, u.getUsuario());
			stmt.setString(2, u.getNombre());
			stmt.setString(3, u.getApellido());
			stmt.setString(4, "dni");
			stmt.setString(5, u.getNroDoc());
			stmt.setString(6, u.getPassword());
			stmt.setString(7, u.getEmail());
			//stmt.setBoolean(8, u.getAdoptante());
			//stmt.setBoolean(9, u.getDonante());
			stmt.setBoolean(8, true);
			stmt.setBoolean(9, true);
			stmt.setInt(10, u.getLocalidad().getId());
			stmt.setInt(11, u.getTipo());
			stmt.setString(12, u.getDomicilio());
			System.out.println("seteados" + u.toString());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                u.setId(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		System.out.println("id creada " + u.getId());
		return u.getId();
    }
}
