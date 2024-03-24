package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

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
}
