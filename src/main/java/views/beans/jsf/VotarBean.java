package views.beans.jsf;

import javax.faces.bean.ManagedBean;

import persistence.jpa.Tema;

@ManagedBean
public class VotarBean {
	private Tema tema;
	
	private static String[] estudios = {"ESO", "Bachiller", "Universitario"};
	private static int[] puntuacion = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
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

	public static String[] getEstudios() {
		return estudios;
	}

	public static void setEstudios(String[] estudios) {
		VotarBean.estudios = estudios;
	}

	public static int[] getPuntuacion() {
		return puntuacion;
	}

	public static void setPuntuacion(int[] puntuacion) {
		VotarBean.puntuacion = puntuacion;
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
	
	

}
