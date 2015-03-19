package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.VotacionesController;
import persistence.jpa.Tema;

public class VotacionesBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	
	public VotacionesBean() {
	}

	public void update() {
		VotacionesController votacionesController = this.getControllerFactory().getVotacionesController();
		this.temas = votacionesController.getTemas();
		System.out.println(this.temas);
    }

	
}
