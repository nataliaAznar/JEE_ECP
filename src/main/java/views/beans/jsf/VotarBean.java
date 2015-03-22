package views.beans.jsf;

import javax.faces.bean.ManagedBean;

import persistence.jpa.Tema;

@ManagedBean
public class VotarBean {
	private Tema[] temas;
	
	private String[] estudios = {"ESO", "Bachiller", "Universitario"};
	private int[] puntuacion = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	
	private int length = estudios.length;
	
	private String estudio;
	private int puntos;
	
	public VotarBean() {
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

	public int getLength() {
		return length;
	}
	
	public void update(){
		
	}

}
