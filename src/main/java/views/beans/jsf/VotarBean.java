package views.beans.jsf;

import javax.faces.bean.ManagedBean;

import persistence.jpa.Tema;

@ManagedBean
public class VotarBean {
	private Tema tema = new Tema("test", "test");
	
	private String[] estudios = {"ESO", "Bachiller", "Universitario"};
	private int[] puntuacion = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	private String estudio;
	private int puntos;
	
	public VotarBean() {
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public String getEstudio() {
		return estudio;
	}

	public void setEstudio(String estudio) {
		this.estudio = estudio;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public String[] getEstudios() {
		return estudios;
	}

	public void setEstudios(String[] estudios) {
		this.estudios = estudios;
	}

	public int[] getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(int[] puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	

}
