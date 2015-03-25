package controllers;

public class ControllerFactory {
	private VotacionesController votacionesController;
	private VotarController votarController;
	private A�adirTemaController a�adirTemaController;
	
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
	
	public A�adirTemaController getA�adirTemaController(){
		if( a�adirTemaController == null)
			a�adirTemaController = new A�adirTemaController();
		return a�adirTemaController;
	}
}
