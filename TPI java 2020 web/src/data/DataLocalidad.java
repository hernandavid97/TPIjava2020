package data;

import java.sql.*;
import java.util.LinkedList;

import data.DbConnector;
import entities.Usuario;
import entities.Localidad;


public class DataLocalidad {
	
	public Localidad getByNombre(Localidad u) {
		Localidad l = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_localidad,nombre_localidad,provincia from localidad where nombre_localidad=?"
					);
			stmt.setString(1, u.getNombre());
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
	
	public Localidad getById(Localidad u) {
		Localidad l = null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"select id_localidad,nombre_localidad,provincia from localidad where id_localidad=?"
					);
			stmt.setInt(1, u.getId());
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
	
	public int newLocalidad(Localidad l) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into localidad(nombre_localidad, provincia) values(?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, l.getNombre());
			stmt.setString(2, l.getProvincia());
			System.out.println("seteados" + l.toString());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                l.setId(keyResultSet.getInt(1));
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
		System.out.println("id creada " + l.getId());
		return l.getId();
    }
	
	public String bajaLocalidad(Localidad l) throws Exception {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"delete from localidad where id_localidad=?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setInt(1, l.getId());			
			System.out.println("seteados" + l.toString());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                l.setId(keyResultSet.getInt(1));
            }

			
		}  catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            throw new Exception("Ha ocurrido un error al dar de baja la localidad, no pueden eliminar localidades activas");
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();            	
            }
		}
		System.out.println("id borrada " + l.getId());
		String r = String.valueOf(l.getId());
		return ("Localidad "+ r + " Borrada");
    }
	
	public String updateLocalidad(Localidad nueva, Localidad old) {
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"update localidad set nombre_localidad=?, provincia=? where id_localidad=?",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, nueva.getNombre());
			stmt.setString(2, nueva.getProvincia());
			stmt.setInt(3, old.getId());
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
		return("Localidad " + old.getId() + " modificada correctamente");
    }
}
