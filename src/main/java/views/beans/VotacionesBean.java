package views.beans;

import java.io.Serializable;
import java.util.List;

import controllers.VotacionesController;
import persistence.jpa.Tema;

public class VotacionesBean extends ViewBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private List<Tema> temas;
	private List<double[]> votaciones;
	
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

	public List<double[]> getVotaciones() {
		return votaciones;
	}

	public void setVotaciones(List<double[]> votaciones) {
		this.votaciones = votaciones;
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

	
}
