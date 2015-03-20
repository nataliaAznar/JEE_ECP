package controllers;

import java.util.ArrayList;
import java.util.List;

import persistence.jpa.Tema;
import persistence.jpa.Voto;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class VotacionesController {
	private TemaDao daoTema;
	private VotoDao daoVoto;
	
	public VotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoJpaFactory.getFactory().getTemaDao();
		daoVoto = DaoJpaFactory.getFactory().getVotoDao();
	}

	public List<Tema> getTemas(){
		return daoTema.findAll();
	}
	
	public void getVotaciones(){
		List<Voto> votos = daoVoto.findAll();
		List<Voto> votaciones = new ArrayList<Voto>();
		for(Voto voto: votos){
			
		}
		
	}

}
