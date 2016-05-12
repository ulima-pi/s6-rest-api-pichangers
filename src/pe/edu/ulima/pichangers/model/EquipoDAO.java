package pe.edu.ulima.pichangers.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EquipoDAO extends ConnectionDAO{
	public List<Equipo> obtenerEquipos() throws SQLException, ClassNotFoundException{
		Connection conn = conectarse();
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * from equipo");
		
		List<Equipo> equipos =  new ArrayList<>();
		while(rs.next()){
			equipos.add(new Equipo(
					rs.getLong("id"),
					rs.getString("nombre"),
					rs.getString("urlFoto"),
					rs.getInt("partidosGanados"),
					rs.getInt("partidosPerdidos")));
		}
		desconectarse(conn);

		return equipos;
	}
	
	public Equipo obtener(long id) throws ClassNotFoundException, SQLException{
		Connection conn = conectarse();
		
		PreparedStatement ps = conn.prepareStatement(
				"SELECT * from equipo WHERE id=? ");
		ps.setLong(1, id); // No tiene equipo
		
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()){
			Equipo equipo = new Equipo(
					rs.getLong("id"),
					rs.getString("nombre"),
					rs.getString("urlFoto"),
					rs.getInt("partidosGanados"),
					rs.getInt("partidosPerdidos"));
			desconectarse(conn);
			return equipo;
		}else{
			desconectarse(conn);
			return null;
		}
	}
}
