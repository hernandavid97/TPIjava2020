package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Usuario;
import entities.Localidad;

public class DataLocalidad {
	
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
}
