package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.VotarController;
import persistence.jpa.Tema;

public class ElegirTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	VotarController votarController = this.getControllerFactory().getVotarController();
	private List<Tema> temas;
	
	private int idTema;

	public ElegirTemaBean() {
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
		this.temas = votarController.getTemas();
        this.temas.add(0, new Tema(-1, "Elige", ""));
        this.idTema = -1;
    }
	
}
