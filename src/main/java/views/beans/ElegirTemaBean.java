package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.VotarController;
import persistence.jpa.Tema;

public class ElegirTemaBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	VotarController votarController = this.getControllerFactory().getVotarController();
	private List<Tema> temas;

	public ElegirTemaBean() {
		super();
	}

	public List<Tema> getTemas() {
		return temas;
	}
	
    public void update() {
		this.temas = votarController.getTemas();
        this.temas.add(0, new Tema(-1, "Elige", ""));
    }
	
}
