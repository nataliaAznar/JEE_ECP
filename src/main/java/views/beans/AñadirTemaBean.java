package views.beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;

import controllers.A�adirTemaController;

@ManagedBean
public class A�adirTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String pregunta;
	
	private A�adirTemaController controller = this.getControllerFactory().getA�adirTemaController();
	
	public A�adirTemaBean() {
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
