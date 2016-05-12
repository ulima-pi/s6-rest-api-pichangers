package pe.edu.ulima.pichangers.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO extends ConnectionDAO{
	public Alumno obtener(String codigo, String password) throws Exception{
		Connection conn = conectarse();
		
		PreparedStatement ps = conn.prepareStatement(
				"SELECT * from alumno WHERE codigo=? and password=?");
		ps.setString(1, codigo);
		ps.setString(2, password);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			Alumno alumno =new Alumno(
					rs.getLong("id"), 
					rs.getString("codigo"), 
					rs.getString("nombre")); 
			desconectarse(conn);
			return alumno;
		}else{
			desconectarse(conn);
			throw new Exception("No existe el alumno");
		}
	}
	
	public Alumno obtener(String codigo) throws Exception{
		Connection conn = conectarse();
		
		PreparedStatement ps = conn.prepareStatement(
				"SELECT * from alumno WHERE codigo=?");
		ps.setString(1, codigo);
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			Alumno alumno =new Alumno(
					rs.getLong("id"), 
					rs.getString("codigo"), 
					rs.getString("nombre")); 
			desconectarse(conn);
			return alumno;
		}else{
			desconectarse(conn);
			throw new Exception("No existe el alumno");
		}
	}
	
	public List<Alumno> obtenerAlumnos(boolean sinEquipo) throws ClassNotFoundException, SQLException{
		Connection conn = conectarse();
		PreparedStatement ps ;
		
		if (sinEquipo){
			ps= conn.prepareStatement(
					"SELECT * from alumno WHERE idEquipo=? ");
			ps.setInt(1, 0); // No tiene equipo
		}else{
			ps = conn.prepareStatement(
					"SELECT * from alumno");
		}

		ResultSet rs = ps.executeQuery();
		
		List<Alumno> alumnos = new ArrayList<>();
		while(rs.next()){
			alumnos.add(new Alumno(
					rs.getLong("id"),
					rs.getString("nombre"),
					rs.getString("codigo")));
		}
		
		desconectarse(conn);
		return alumnos;
	}
	
	public void modificar(Alumno alumno) throws SQLException, ClassNotFoundException{
		Connection conn = conectarse();
		
		PreparedStatement ps = conn.prepareStatement(
				"UPDATE alumno SET codigo=?, nombre=?, idEquipo=? WHERE id=?");
		ps.setString(1, alumno.getCodigo());
		ps.setString(2, alumno.getNombre());
		ps.setLong(3, alumno.getEquipo().getId());
		ps.setLong(4,  alumno.getId());
		
		ps.execute();
		
		desconectarse(conn);
	}
}
