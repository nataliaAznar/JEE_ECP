package controllers;

public class ControllerFactory {
	private VotacionesController votacionesController;
	public VotacionesController getVotacionesController(){
		if(votacionesController==null){
			votacionesController = new VotacionesController();
		}
		return votacionesController;
	}
}
