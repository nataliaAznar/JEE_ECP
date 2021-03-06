package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import controllers.AņadirTemaController;

@ManagedBean
public class AņadirTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String pregunta;
	
	private AņadirTemaController controller = this.getControllerFactory().getAņadirTemaController();
	
	public AņadirTemaBean() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPregunta() {
		return pregunta;
	}

	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	
	public String process(){
		controller.addTema(nombre, pregunta);
		return "home";
	}

}
