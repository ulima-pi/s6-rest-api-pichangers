package pe.edu.ulima.pichangers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import pe.edu.ulima.pichangers.model.Alumno;
import pe.edu.ulima.pichangers.model.AlumnoDAO;
import pe.edu.ulima.pichangers.rest.dto.AlumnoLoginRequest;
import pe.edu.ulima.pichangers.rest.dto.AlumnoLoginResponse;

@Path("/alumnos")
public class AlumnosService {
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("login")
	public AlumnoLoginResponse login(AlumnoLoginRequest request){
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		try {
			alumnoDAO.obtener(request.getUsuario(), request.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			return new AlumnoLoginResponse("ERROR: " + e.getMessage());
		}
		return new AlumnoLoginResponse("OK");
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Alumno> obtenerAlumnos(@QueryParam("sin_equipo") String flagEquipo) throws ClassNotFoundException, SQLException{
		
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		if (flagEquipo != null && flagEquipo.equals("true")){
			return alumnoDAO.obtenerAlumnos(true);
		}else{
			return alumnoDAO.obtenerAlumnos(false);
		}
	}
}
