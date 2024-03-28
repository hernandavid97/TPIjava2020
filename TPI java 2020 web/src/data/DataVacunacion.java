package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import entities.Localidad;
import entities.Mascota;
import entities.Vacuna;
import entities.Vacunacion;

public class DataVacunacion {
	public LinkedList<Vacunacion> getByMascota(int id_mascota) {
		LinkedList<Vacunacion> vacunaciones = new LinkedList<Vacunacion>();
		try {
			String consulta = "SELECT v.id_vacunacion,v.id_mascota,v.id_vacuna,fecha_vacunacion,vs.titulo "
					+ "FROM vacunacion v " + "INNER JOIN mascota m on v.id_mascota = m.id_mascota "
					+ "INNER JOIN vacuna vs on v.id_vacuna = vs.id_vacuna" + " where v.id_mascota = ?";
			PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(consulta);
			stmt.setInt(1, id_mascota);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vacunacion v = new Vacunacion();
				v.setId_vacunacion(rs.getInt("id_vacunacion"));
				v.setId_mascota(rs.getInt("id_mascota"));
				v.setId_vacuna(rs.getInt("id_vacuna"));
				v.setFecha_vacunacion(rs.getDate("fecha_vacunacion"));
				Vacuna vs = new Vacuna();
				vs.setId(rs.getInt("v.id_vacuna"));
				vs.setTitulo(rs.getString("vs.titulo"));

				v.setVacuna(vs);
				vacunaciones.add(v);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			DbConnector.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacunaciones;
	}
	
	public LinkedList<Vacunacion> getAll() {
		LinkedList<Vacunacion> vacunaciones = new LinkedList<Vacunacion>();
		try {
			String consulta = "SELECT v.id_vacunacion,v.id_mascota,v.id_vacuna,fecha_vacunacion,vs.titulo "
					+ "FROM vacunacion v " + "INNER JOIN mascota m on v.id_mascota = m.id_mascota "
					+ "INNER JOIN vacuna vs on v.id_vacuna = vs.id_vacuna" ;
			PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vacunacion v = new Vacunacion();
				v.setId_vacunacion(rs.getInt("id_vacunacion"));
				v.setId_mascota(rs.getInt("id_mascota"));
				v.setId_vacuna(rs.getInt("id_vacuna"));
				v.setFecha_vacunacion(rs.getDate("fecha_vacunacion"));
				Vacuna vs = new Vacuna();
				vs.setId(rs.getInt("v.id_vacuna"));
				vs.setTitulo(rs.getString("vs.titulo"));

				v.setVacuna(vs);
				vacunaciones.add(v);
			}

			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			}
			DbConnector.getInstancia().releaseConn();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vacunaciones;
	}
	
	public int insertOne(Vacunacion v) throws Exception {
		int id = -1;
		try {

			String consulta = "insert into vacunacion (id_mascota, id_vacuna, fecha_vacunacion) values (?, ?, ?)";
			PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(consulta,
					Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, v.getId_mascota());
			stmt.setInt(2, v.getId_vacuna());
			stmt.setDate(3, new java.sql.Date(v.getFecha_vacunacion().getTime()));			

			stmt.executeUpdate();
			try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
				if (generatedKeys.next()) {
					id = (int) generatedKeys.getLong(1);
				} else {
					throw new SQLException("Creating vacunacion failed, no ID obtained.");
				}
			}

			if (stmt != null) {
				stmt.close();
			}
			DbConnector.getInstancia().releaseConn();

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return id;
	}

	public String bajaVacunacion(Vacunacion v) throws Exception {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			System.out.println("eliminando vacunación id: " + v.getId_vacunacion());
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"delete from vacunacion where id_vacunacion=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, v.getId_vacunacion());
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				v.setId_vacunacion(keyResultSet.getInt(1));
			}

			System.out.println("Vacunación: " + keyResultSet.toString());


		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			throw e;
		} finally {
			try {
				if (keyResultSet != null)
					keyResultSet.close();
				if (stmt != null)
					stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ("Vacunación Borrada");
	}

	public String updateVacunacion(Vacunacion nueva, Vacunacion old) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet keyResultSet = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"update vacunacion set id_mascota=?, id_vacuna=?, fecha_vacunacion=? where id_mascota=?",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, nueva.getId_mascota());
			stmt.setInt(2, nueva.getId_vacuna());
			stmt.setDate(3, (Date) nueva.getFecha_vacunacion());
			stmt.setInt(4, old.getId_vacunacion());
			
			System.out.println("seteados" + nueva.toString());
			stmt.executeUpdate();

			keyResultSet = stmt.getGeneratedKeys();
			if (keyResultSet != null && keyResultSet.next()) {
				nueva.setId_vacunacion(keyResultSet.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				if (keyResultSet != null)
					keyResultSet.close();
				if (stmt != null)
					stmt.close();
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ("Vacunación " + nueva.getId_vacunacion() + " modificada correctamente");
	}
	
	public Vacunacion getOne(int id_vacunacion) {
		Vacunacion v = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = DbConnector.getInstancia().getConn().prepareStatement(
					"select * from vacunacion where id_vacunacion=?");
			stmt.setInt(1, id_vacunacion);
			rs = stmt.executeQuery();
			if (rs != null && rs.next()) {
				v = new Vacunacion();
				v.setId_vacunacion(rs.getInt("id_mascota"));
				v.setId_vacuna(rs.getInt("id_vacuna"));
				v.setFecha_vacunacion(rs.getDate("fecha_vacunación"));	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return v;
	}	


}
