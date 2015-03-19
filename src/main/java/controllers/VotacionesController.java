package controllers;

import java.util.List;

import persistence.jpa.Tema;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class VotacionesController {
	private TemaDao daoTema;
	
	public VotacionesController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		daoTema = DaoJpaFactory.getFactory().getTemaDao();
	}

	public List<Tema> getTemas(){
		return daoTema.findAll();
	}

}
