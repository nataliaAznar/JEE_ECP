package views.beans;

import java.io.Serializable;
import java.util.List;

import persistence.jpa.Tema;
import controllers.EliminarTemaController;

public class AutenticarseBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private EliminarTemaController eliminarTemaController = new EliminarTemaController();
	
	private String error = "";
	
	public AutenticarseBean() {
	}

	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController;
	}

	public void setEliminarTemaController(
			EliminarTemaController eliminarTemaController) {
		this.eliminarTemaController = eliminarTemaController;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
	

}
