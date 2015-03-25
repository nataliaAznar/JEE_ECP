package controllers;

import java.util.List;

import persistence.jpa.Tema;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class EliminarTemaController {
	private TemaDao daoTema;

	public EliminarTemaController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		this.daoTema = DaoJpaFactory.getFactory().getTemaDao();
	}

	public List<Tema> getTemas(){
		return daoTema.findAll();
	}
	
	public void deleteTema(int id){
		daoTema.deleteById(id);
	}
	

}
