package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import entities.Localidad;
import entities.Mascota;
import entities.Transito;

public class DataMascota {
	public LinkedList<Mascota> getAll() {
		LinkedList<Mascota> mascotas = new LinkedList<Mascota>();
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
	public LinkedList<Mascota> getByUser(int id_usuario) {
		System.out.println(id_usuario);
		LinkedList<Mascota> mascotas = new LinkedList<Mascota>();
		try {
			String consulta = "select m.id_mascota, nombre, tipo_animal, edad, color, is_disponible, imagenes "
					+ "from mascota m "
					+ "inner join transito t on m.id_mascota = t.id_mascota "
					+ "where id_donante = ?";
			PreparedStatement stmt  = DbConnector.getInstancia().getConn().prepareStatement(consulta);
			stmt.setInt(1, id_usuario);
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
	public String bajaMascota(Mascota m) throws Exception {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			System.out.println("eliminando mascota id: " + m.toString());
			stmt = DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from transito where id_mascota=? && isnull(id_adoptante)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, m.getId());			
			stmt.executeUpdate();
			
			keyResultSet = stmt.getGeneratedKeys();
			System.out.println("Transitos: " + keyResultSet.toString());
            if(keyResultSet != null && keyResultSet.next()){
                m.setId(keyResultSet.getInt(1));
            }
            
            stmt.close();
            keyResultSet.close();
            
            stmt = DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from mascota where id_mascota=?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, m.getId());			
			stmt.executeUpdate();
			
			System.out.println("Mascota: " + keyResultSet.toString());

			keyResultSet = stmt.getGeneratedKeys();
            if(keyResultSet != null && keyResultSet.next()){
                m.setId(keyResultSet.getInt(1));
            }
            
		}  catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            if(e.getMessage().contains("foreign key constraint fails")) {
            	throw new Exception("No se pueden eliminar macotas que ya han sido adoptadas");            	
            }
            throw e;
		} finally {
            try {
                if(keyResultSet != null)
                	keyResultSet.close();
                if(stmt != null)
                	stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();            	
            }
		}
		System.out.println("id mascota borrada " + m.getId());
		String r = String.valueOf(m.getId());
		return ("Mascota "+ r + " Borrada");
    }
	public String updateMascota(Mascota nueva, Mascota old) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update mascota set nombre=?, tipo_animal=?, edad=?, color=?, imagenes=? where id_mascota=?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, nueva.getNombre());
			stmt.setString(2, nueva.getTipo());
			stmt.setInt(3, nueva.getEdad());
			stmt.setString(4, nueva.getColor());
			stmt.setString(5, nueva.getImagenes());
			stmt.setInt(6, old.getId());
			System.out.println("seteados" + nueva.toString());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                nueva.setId(keyResultSet.getInt(1));                
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
            return ("Error: "+ e);
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		return("Macota " + old.getId() + " modificada correctamente");
    }
}
