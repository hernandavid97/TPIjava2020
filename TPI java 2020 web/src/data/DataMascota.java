package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Mascota;
import entities.Transito;

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
	public Mascota getOne(int id_mascota) {
		Mascota m=null;
		try {

			String consulta = "select * from mascota where id_mascota = ? ";
			PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta);
			stmt.setString(1, Integer.toString(id_mascota));
			ResultSet rs = stmt.executeQuery();

			while(rs.next()) {
				m=new Mascota();
				
				m.setId(rs.getInt("id_mascota"));
				m.setNombre(rs.getString("nombre"));
				m.setTipo(rs.getString("tipo_animal"));
				m.setEdad(rs.getInt("edad"));
				m.setColor(rs.getString("color"));
				m.setImagenes(rs.getString("imagenes"));
				m.setDisponible(rs.getBoolean("is_disponible"));
				
			}
			
			if(rs!=null){rs.close();}
			if(stmt!=null){stmt.close();}
			DbConnector.getInstancia().releaseConn();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}

		return m;
	}
	public int insertOne(Mascota m ){
		int id=-1;
		try {
			
			String consulta = "insert into mascota (nombre, tipo_animal,edad,color,is_disponible,imagenes) values (?, ?,?,?,?,?)";
			PreparedStatement stmt=DbConnector.getInstancia().getConn().prepareStatement(consulta, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, m.getNombre());
			stmt.setString(2, m.getTipo());
			stmt.setString(3, Integer.toString(m.getEdad()));
			stmt.setString(4, m.getColor());
			stmt.setString(5, Integer.toString((m.getDisponible() ? 1 : 0)));
			stmt.setString(6, m.getImagenes());

			
			stmt.executeUpdate();
	        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                id = (int) generatedKeys.getLong(1);
	            }
	            else {
	                throw new SQLException("Creating user failed, no ID obtained.");
	            }
	        }

			
			if(stmt!=null){stmt.close();}
			DbConnector.getInstancia().releaseConn();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}
}
