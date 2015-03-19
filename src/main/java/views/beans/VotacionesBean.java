package views.beans;

import java.io.Serializable;

public class VotacionesBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int puntuacion;
	private int estudios;
	private String ip;
	private String tema;
	private int temaId;
	
	public VotacionesBean() {
	}

	public int getId() {
		return id;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int puntuacion) {
		this.puntuacion = puntuacion;
	}

	public int getEstudios() {
		return estudios;
	}

	public void setEstudios(int estudios) {
		this.estudios = estudios;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}


	
}
