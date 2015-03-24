package controllers;

import java.util.List;

import persistence.jpa.Tema;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class VotarController {
	private TemaDao daoTema;

	public VotarController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		this.daoTema = DaoJpaFactory.getFactory().getTemaDao();
	}
	
	public List<Tema> getTemas(){
		return daoTema.findAll();
	}
	
	public void addVoto(int idTema, int estudios, int puntuación, String ip){
		
	}

}
