package pe.edu.ulima.pichangers.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/pichangers";
	protected Connection conectarse() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		return DriverManager.getConnection(URL, "root", "");
	}
	
	protected void desconectarse(Connection conn) throws SQLException{
		conn.close();
	}
}
