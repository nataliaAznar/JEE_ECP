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
	private List<double[]> votaciones;
	private String[] estudios = {"ESO", "Bachiller", "Universitario"};
	
	public VotacionesBean() {
	}

	public void update() {
		VotacionesController votacionesController = this.getControllerFactory().getVotacionesController();
		this.temas = votacionesController.getTemas();
		this.votaciones = votacionesController.getVotaciones();
    } 

	public List<Tema> getTemas() {
		return temas;
	}

	public void setTemas(List<Tema> temas) {
		this.temas = temas;
	}
	
	public double[] getVotacion(int id){
		try{
		return this.votaciones.get(id);
		}
		catch (Exception e){
			double [] empty= {0,0,0,0};
			return empty;
		}
	}

	public String[] getEstudios() {
		return estudios;
	}

	
}
