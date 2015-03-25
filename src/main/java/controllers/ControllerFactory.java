package controllers;

public class ControllerFactory {
	private VotacionesController votacionesController;
	private VotarController votarController;
	private AñadirTemaController añadirTemaController;
	
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
}
