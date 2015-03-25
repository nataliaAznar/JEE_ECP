package controllers;

import persistence.jpa.Tema;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class A�adirTemaController {
	private TemaDao daoTema;

	public A�adirTemaController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		this.daoTema = DaoJpaFactory.getFactory().getTemaDao();
	}
	
	public void addTema(String nombre, String pregunta){
		Tema tema = new Tema(nombre, pregunta);
		daoTema.create(tema);
	}

}
