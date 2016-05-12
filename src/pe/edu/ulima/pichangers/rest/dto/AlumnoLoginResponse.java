package pe.edu.ulima.pichangers.rest.dto;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AlumnoLoginResponse {
	private String msg;

	public AlumnoLoginResponse() {
		super();
	}

	public AlumnoLoginResponse(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
