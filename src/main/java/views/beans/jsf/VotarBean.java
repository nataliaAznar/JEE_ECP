package views.beans.jsf;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.VotarController;
import persistence.jpa.Tema;
import views.beans.jsp.ViewBean;

@ManagedBean
public class VotarBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Tema> temas;
	
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
	
	
	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public void update(){
		VotarController votarController = this.getControllerFactory().getVotarController();
		this.temas = votarController.getTemas();
	}

}
