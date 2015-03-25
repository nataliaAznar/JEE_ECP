package controllers;

public class ControllerFactory {
	private VotacionesController votacionesController;
	private VotarController votarController;
	private AñadirTemaController añadirTemaController;
	private EliminarTemaController eliminarTemaController;
	
	public VotacionesController getVotacionesController(){
		if(votacionesController==null){
			votacionesController = new VotacionesController();
		}
		return votacionesController;
	}
	
	public VotarController getVotarController(){
		if(votarController == null)
			votarController = new VotarController();
		return votarController;
	}
	
	public AñadirTemaController getAñadirTemaController(){
		if( añadirTemaController == null)
			añadirTemaController = new AñadirTemaController();
		return añadirTemaController;
	}
	
	public EliminarTemaController getEliminarTemaController(){
		if( eliminarTemaController == null)
			eliminarTemaController = new EliminarTemaController();
		return eliminarTemaController;
	}
}
