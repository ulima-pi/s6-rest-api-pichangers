package pe.edu.ulima.pichangers.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import pe.edu.ulima.pichangers.model.Alumno;
import pe.edu.ulima.pichangers.model.AlumnoDAO;
import pe.edu.ulima.pichangers.model.Equipo;
import pe.edu.ulima.pichangers.model.EquipoDAO;
import pe.edu.ulima.pichangers.rest.dto.AgregarIntegranteResponse;

@Path("/equipos")
public class EquiposService {
	
	@GET
	@Produces("application/json; charset=UTF-8")
	public List<Equipo> obtenerEquipos() throws ClassNotFoundException, SQLException{
		EquipoDAO equipoDAO = new EquipoDAO();
		return equipoDAO.obtenerEquipos();

	}
	
	@GET
	@Produces("application/json; charset=UTF-8")
	@Path("{id}")
	public Equipo obtener(@PathParam("id") long id) throws ClassNotFoundException, SQLException{
		return new EquipoDAO().obtener(id);
	}
	
	@POST
	@Produces("application/json; charset=UTF-8")
	@Path("{id}/{codigo_alumno}")
	public AgregarIntegranteResponse agregarIntegrante(
			@PathParam("id") long id,
			@PathParam("codigo_alumno") String idAlumno) throws Exception{
		System.out.println("ID:" + id);
		System.out.println("codigo_alumno:" + idAlumno);
		
		EquipoDAO equipoDAO = new EquipoDAO();
		AlumnoDAO alumnoDAO = new AlumnoDAO();
		
		Equipo equipo = equipoDAO.obtener(id);
		
		Alumno alumno = alumnoDAO.obtener(idAlumno);
		
		alumno.setEquipo(equipo);
		
		alumnoDAO.modificar(alumno);
		
		return new AgregarIntegranteResponse("OK");
	}
}
