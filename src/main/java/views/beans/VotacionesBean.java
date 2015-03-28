package views.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import controllers.VotacionesController;
import persistence.jpa.Tema;

@ManagedBean
public class VotacionesBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private String[] estudios = {"ESO", "Bachiller", "Universitario"};
	private VotacionesController votacionesController;
	
	public VotacionesBean() {
		super();
		votacionesController = this.getControllerFactory().getVotacionesController();
	}

	public void update() {
		this.temas = votacionesController.getTemas();
    } 

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public double[] getVotacion(int id){
		return  votacionesController.getVotacion(id);
	}

	public String[] getEstudios() {
		return estudios;
	}

	
}
