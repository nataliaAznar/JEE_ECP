package controllers;

public class ControllerFactory {
	private VotacionesController votacionesController;
	private VotarController votarController;
	
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
}
