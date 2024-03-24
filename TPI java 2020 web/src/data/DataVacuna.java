package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Vacuna;

public class DataVacuna {
	public ArrayList<Vacuna> getAll() {
		ArrayList<Vacuna> vacunas = new ArrayList<Vacuna>();
		try {
			String consulta = "select * from vacuna";
			PreparedStatement stmt = DbConnector.getInstancia().getConn().prepareStatement(consulta);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Vacuna v = new Vacuna();

				v.setId(rs.getInt("id_vacuna"));
				v.setTitulo(rs.getString("titulo"));
				v.setEspecie(rs.getString("especie"));
				v.setDescripcion(rs.getString("descripcion"));

				vacunas.add(v);
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
		return vacunas;
	}

}
