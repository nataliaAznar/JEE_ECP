package controllers;

import java.util.List;

import persistence.jpa.Tema;
import persistence.jpa.Voto;
import persistence.models.daos.DaoFactory;
import persistence.models.daos.TemaDao;
import persistence.models.daos.VotoDao;
import persistence.models.daos.jpa.DaoJpaFactory;

public class VotarController {
	private TemaDao daoTema;
	private VotoDao daoVoto;

	public VotarController() {
		DaoFactory.setFactory(new DaoJpaFactory());
		this.daoTema = DaoJpaFactory.getFactory().getTemaDao();
		this.daoVoto = DaoJpaFactory.getFactory().getVotoDao();
	}
	
	public List<Tema> getTemas(){
		return daoTema.findAll();
	}
	
	public void addVoto(int idTema, int estudios, int puntuacion, String ip){
		Tema tema = daoTema.read(idTema);
		Voto voto = new Voto(puntuacion, estudios, ip, tema);
		daoVoto.create(voto);
	}

}
