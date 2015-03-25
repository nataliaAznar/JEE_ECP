package views.beans;

import java.io.Serializable;
import java.util.List;

import persistence.jpa.Tema;
import controllers.EliminarTemaController;

public class AutenticarseBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private EliminarTemaController eliminarTemaController = new EliminarTemaController();
	
	private List<Tema> temas;
	private int idTema;
	
	public AutenticarseBean() {
	}

	public EliminarTemaController getEliminarTemaController() {
		return eliminarTemaController;
	}

	public void setEliminarTemaController(
			EliminarTemaController eliminarTemaController) {
		this.eliminarTemaController = eliminarTemaController;
	}

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}

	public int getIdTema() {
		return idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}
	
	public void update() {
		this.temas = eliminarTemaController.getTemas();
        this.temas.add(0, new Tema(-1, "Elige", ""));
        this.idTema = -1;
    }

}
