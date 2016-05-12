package pe.edu.ulima.pichangers.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Alumno {
	private long id;
	private String nombre;
	private String codigo;
	private Equipo equipo;
	
	public Alumno() {
		super();
	}

	public Alumno(long id, String nombre, String codigo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	
}
