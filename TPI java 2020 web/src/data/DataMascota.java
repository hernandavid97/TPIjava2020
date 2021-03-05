package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Mascota;

public class DataMascota {
	public ArrayList<Mascota> getAll() {
		ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
		try {
			String consulta = "select * from mascota";
			PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Mascota m = new Mascota();
				
				m.setId(rs.getInt("id_mascota"));
				m.setNombre(rs.getString("nombre"));
				m.setTipo(rs.getString("tipo_animal"));
				m.setEdad(rs.getInt("edad"));
				m.setColor(rs.getString("color"));
				m.setImagenes(rs.getString("imagenes"));
				m.setDisponible(rs.getBoolean("is_disponible"));
				
				mascotas.add(m);
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			DbConnector.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return mascotas;
	}
}
