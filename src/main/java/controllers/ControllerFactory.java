package controllers;

public class ControllerFactory {
	private VotacionesController votacionesController;
	private VotarController votarController;
	private AņadirTemaController aņadirTemaController;
	
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
	
	public AņadirTemaController getAņadirTemaController(){
		if( aņadirTemaController == null)
			aņadirTemaController = new AņadirTemaController();
		return aņadirTemaController;
	}
}
