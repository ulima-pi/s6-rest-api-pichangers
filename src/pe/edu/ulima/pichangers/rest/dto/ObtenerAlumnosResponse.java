package pe.edu.ulima.pichangers.rest.dto;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import pe.edu.ulima.pichangers.model.Alumno;

@XmlRootElement
public class ObtenerAlumnosResponse extends ArrayList<Alumno>{

	private static final long serialVersionUID = -2482579906936023359L;

}
