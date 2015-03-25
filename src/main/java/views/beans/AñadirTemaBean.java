package views.beans;

import java.io.Serializable;

public class AñadirTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String pregunta;
	
	public AñadirTemaBean() {
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

}
