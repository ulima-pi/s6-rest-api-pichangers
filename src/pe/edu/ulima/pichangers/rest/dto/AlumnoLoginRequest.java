package pe.edu.ulima.pichangers.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlumnoLoginRequest {
	private String usuario;
	private String password;
	public AlumnoLoginRequest() {
		super();
	}
	public AlumnoLoginRequest(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
